(* $Id *)

Parameter E : Set.
Parameter a b : E.
Parameter P : E -> Prop.
Axiom eq : a = b.

Lemma ex1 : P(b) -> P(a).
Proof.
  intro.
  rewrite eq.
  assumption.
Qed.

Lemma ex2 : P(a) -> P(b).
  intro.
  rewrite <- eq.
(* rewrite eq in H. *)
  assumption.
Qed.

Open Scope type_scope.

Section Iso_axioms.

Variables A B C : Set.

Axiom Com : A * B = B * A.
Axiom Ass : A * (B * C) = A * B * C.
Axiom Cur : (A * B -> C) = (A -> B -> C).
Axiom Dis : (A -> B * C) = (A -> B) * (A -> C).
Axiom P_unit : A * unit = A.
Axiom AR_unit : (A -> unit) = unit.
Axiom AL_unit : (unit -> A) = A.

End Iso_axioms.

Lemma iso1 : forall A B : Set, A * (B -> unit) = A.
Proof.
  intros.
  rewrite AR_unit.
  rewrite P_unit.
  reflexivity.
Qed.

Ltac remove_unit :=
  repeat
    rewrite P_unit || rewrite AR_unit || rewrite AL_unit.
    
Lemma iso2 : forall A B : Set, A * (B -> unit) = A.
Proof.
  intros.
  remove_unit.
  reflexivity.
Qed.

Ltac remove_unit2 :=
  intros;
  (repeat
    rewrite P_unit || rewrite AR_unit || rewrite AL_unit);
  reflexivity.
    
Lemma iso3 : forall A B : Set, A * (B -> unit) = A.
Proof.
  remove_unit2.
Qed.

Ltac remove_unit3 :=
  intros;
  repeat
    match goal with
    | |- context[?A * unit] => rewrite P_unit
    | |- context[?A -> unit] => rewrite AR_unit
    | |- context[unit -> ?A] => rewrite AL_unit
    end.

Lemma iso4 : forall A B : Set, A * (B -> unit) = A.
Proof.
  remove_unit3.
  reflexivity.
Qed.
    
Lemma isos_ex1 : forall A B:Set,
A * unit * B = B * (unit * A).
Proof.
  intros.
  rewrite Ass.
  rewrite P_unit.
  rewrite P_unit.
  rewrite Com.
  reflexivity.
Qed.

Lemma isos_ex2 : forall A B C:Set,
(A * unit -> B * (C * unit)) =
(A * unit -> (C -> unit) * C) * (unit -> A -> B).
Proof.
  intros.
  rewrite P_unit.
  rewrite P_unit.
  rewrite AR_unit.
  rewrite AL_unit.
  rewrite (Com unit).
  rewrite P_unit.
  rewrite Com.
  rewrite <- Dis.
  reflexivity.
Qed.

Section Peano.

Parameter N : Set.
Parameter o : N.
Parameter s : N -> N.
Parameters plus mult : N -> N -> N.
Variables x y : N.
Axiom ax1 : ~((s x) = o).
Axiom ax2 : exists z, ~(x = o) -> (s z) = x.
Axiom ax3 : (s x) = (s y) -> x = y.
Axiom ax4 : (plus x o) = x.
Axiom ax5 : (plus x (s y)) = s (plus x y).
Axiom ax6 : (mult x o) = o.
Axiom ax7 : (mult x (s y)) = (plus (mult x y) x).

End Peano.

Lemma pea1 : (plus (s o) (s (s o))) = (s (s (s o))).
Proof.
  rewrite ax5.
  rewrite ax5.
  rewrite ax4.
  reflexivity.
Qed.

Lemma pea2 : (plus (s (s o)) (s (s o))) = (s (s (s (s o)))).
Proof.
  rewrite ax5.
  rewrite ax5.
  rewrite ax4.
  reflexivity.
Qed.

Lemma pea3 : (mult (s (s o)) (s (s o))) = (s (s (s (s o)))).
Proof.
  rewrite ax7.
  rewrite ax7.
  rewrite ax6.
  rewrite ax5.
  rewrite ax5.
  rewrite ax5.
  rewrite ax5.
  rewrite ax4.
  rewrite ax4.
  reflexivity.
Qed.

Ltac auto_peano :=
  (repeat
    rewrite ax7 || rewrite ax6 || rewrite ax5 || rewrite ax4);
  reflexivity.

Lemma pea2bis : (plus (s (s o)) (s (s o))) = (s (s (s (s o)))).
Proof.
  auto_peano.
Qed.

Lemma pea3bis : (mult (s (s o)) (s (s o))) = (s (s (s (s o)))).
Proof.
  auto_peano.
Qed.

Hint Rewrite ax4 ax5 ax6 ax7 : peano.

Lemma pea2ter : (plus (s (s o)) (s (s o))) = (s (s (s (s o)))).
Proof.
  autorewrite with peano using (try reflexivity).
Qed.

Lemma pea3ter : (mult (s (s o)) (s (s o))) = (s (s (s (s o)))).
Proof.
  autorewrite with peano using (try reflexivity).
Qed.






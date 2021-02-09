(* Propositional Logic *)

Parameters A B : Prop.

Goal A -> A.
Proof.
  intro.
  assumption.
Save prop1.

Print prop1.
Check prop1.

Lemma prop2 : (A -> B) -> A -> B.
Proof.
  intros.
  apply H.
  assumption.
Qed.

Lemma prop2b : (A -> B) -> A -> B.
Proof.
  intros.
  apply (H H0).
Qed.

Lemma prop3 : A /\ B -> A.
Proof.
  intros.
  elim H.
  clear H.
  intros.
  assumption.
Qed.

Lemma prop3b : A /\ B -> A.
Proof.
  intro.
  elim H; intros.
  assumption.
Qed.

Lemma prop4 : A -> B -> A /\ B.
Proof.
  intros.
  split.
  assumption.
  assumption.
Qed.

Lemma prop4b : A -> B -> A /\ B.
Proof.
  intros.
  split; assumption.
Qed.

Lemma prop5 : A \/ B -> B \/ A.
Proof.
  intro.
  elim H.
  intro.
  right.
  assumption.
  intro.
  left.
  assumption.
Qed.

Lemma prop5b : A \/ B -> B \/ A.
Proof. 
  intro.
  elim H; intro; [right | left]; assumption.
Qed.

(* ~A = A -> False *)

Print not.

Lemma prop7 : A -> ~A -> False.
Proof.
  intros.
  unfold not in H0.
  apply (H0 H).
Qed.

Print iff.

Lemma prop8 : A <-> B -> B <-> A.
Proof.
  unfold iff.
  intro.
  elim H; intros; clear H.
  split; assumption.
Qed.

(* Exo du cours *)

Lemma exo1 : A -> B -> A.
Proof.
  intros.
  assumption.
Qed.

Parameters C : Prop.

Lemma exo2 : (A -> B -> C) -> (A -> B) -> A -> C.
Proof.
  intros.
  apply H.
  assumption.
  apply H0.
  assumption.
Qed.

Lemma exo2b : (A -> B -> C) -> (A -> B) -> A -> C.
Proof.
  intros.
  apply (H H1 (H0 H1)).
Qed.

Lemma exo3 : A /\ B -> B.
Proof.
  intros.
  elim H.
  clear H.
  intros.
  assumption.
Qed.

Lemma exo4 : B -> A \/ B.
Proof.
  intros.
  right.
  assumption.
Qed.


Lemma exo5 : (A \/ B) -> (A -> C) -> (B -> C) -> C.
Proof.
  intros.
  elim H; assumption.
Qed.

Lemma exo6 : A -> False -> ~A.
Proof.
  intros.
  auto.
Qed.

Lemma exo7 : False -> A.
Proof.
  intros.
  elimtype False.
  assumption.
Qed.

Lemma exo8 : (A <-> B) -> A -> B.
Proof.
  intros.
  elim H.
  intros.
  apply H1.
  assumption.
Qed.


Lemma exo9 : (A <-> B) -> B -> A.
Proof.
  intros.
  elim H.
  intros.
  apply H2.
  assumption.
Qed.

Lemma exo10 : (A -> B) -> (B -> A) -> (A <-> B).
Proof.
  intros.
  split.
  assumption.
  assumption.
Qed.

(* First-Order Logic *) 

Parameter E : Set.
Parameter a : E.
Parameter P : E -> Prop.
Parameter Q : E -> Prop.
(*
Lemma fol1 : forall x : E, (P x) -> (P x).
Lemma fol2 : (forall x : E, (P x)) -> (P a).
Lemma fol3 : (
*)

(* Exo du slide 16 à faire *)

(* pour le 6 *)
Require Export Classical.
Check NNPP.

(* ~~A = ~A -> False *)

(*
Goal A.
Proof.
apply NNPP.
intro.

Goal B.
apply NNPP.
red.
*)


Lemma fol1 : forall x, P(x) -> (exists y, P(y) \/ Q(y)).
Proof.
  intros.
  exists x.
  left.
  assumption.
Qed.

(*
Lemma fol2 : (exists x, P(x) \/ Q(x)) -> ((exists x, P(x)) \/ (exists x, Q(x))).
Proof.
  intro.
  elim H.
  intro.
  intro.
  (*diverge*)
  right.
  exists x.
  elim H0.
  intro.
  2 : {
  intro.
  assumption.
  }
Qed.
*)

Lemma fol3 : ((forall x, P(x)) /\ (forall x, Q(x))) -> (forall x, P(x) /\ Q(x)).
Proof.
  intro.
  elim H.
  intros.
  split.
  apply (H0 x).
  apply (H1 x).
Qed.

Lemma fol4 : (forall x, P(x) /\ Q(x)) -> (forall x, P(x)) /\ (forall x, Q(x)).
Proof.
  intros.
  split.
  intro.
  2: {
  intro.
  apply (H x).
  }
  apply (H x).
Qed.

Lemma fol5 : (forall x, ~P(x)) -> ~(exists x, P(x)).
Proof.
  intro.
  intro.
  elim H0.
  intros.
  apply (H x).
  assumption.
Qed.

(*
Lemma fol6 : ~(forall x, P(x)) -> (exists x, ~P(x)).
Proof.
  intro.
  apply NNPP.
  red.
  intro.
  elimtype False.
  apply H.
  intro.
  apply NNPP.
  intro.
  elim H1.
  assumption.
Qed.
*)
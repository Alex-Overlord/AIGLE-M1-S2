(* Propositional Logic *)

Parameters A B : Prop.

(* First-Order Logic *) 

Parameter E : Set.
Parameter a : E.
Parameter P : E -> Prop.
Parameter Q : E -> Prop.

(* Exercice 1 *)

Lemma exo1a : (forall x, (P x) -> (Q x)) -> (exists x, (P x)) -> (exists x, (Q x)).
Proof.
  intros.
  elim H0.
  intros.
  exists x.
  apply H.
  assumption.
Qed.

(*
Lemma exo1b : (exists x, (P x) /\ (Q x)) -> (exists x, (P x)) /\ (exists x, (Q x)).
Proof.
  intros.
  elim H.
  intros.
  elim H0.
*)

(* Exercice 2 *)


Fixpoint eq_nat n m : Prop :=
match n, m with
  | O, O => True
  | O, S _ => False
  | S _, O => False
  | S n1, S m1 => eq_nat n1 m1
end.

Require Import FunInd.
Functional Scheme eq_ind := Induction for eq_nat Sort Prop.


Lemma ex2a : forall (n : nat), eq_nat n n.
Proof.
  intro.
(*  functional induction (eq_nat n n) using eq_ind. *)
  induction n.
  simpl..
  
  
 
(* Exercice 3 *)

Require Import Arith.
Require Import Omega.
Require Export List.
Open Scope list_scope.
Import ListNotations.

Inductive is_rev : list nat -> list nat -> Prop :=
  | is_rev_nil : is_rev nil nil
  | is_rev_cons : forall (n : nat) (l1 l2 v : list nat), 
    is_rev l1 l1 -> v = l2 ++ [n] -> is_rev (n::l1) v
  | is_rev_sym : forall (l1 l2 : list nat), is_rev l1 l2 -> is_rev l2 l1.

Lemma exo3 : is_rev [1; 2; 3] [3; 2; 1].
Proof.
  apply (is_rev_sym).
  (*
Qed.
  *)
  


















(*

Démontrer les propositions suivantes en déduction naturelle et en extraire
les termes correspondants en λ-calcul simplement typé :

1) A ⇒ B ⇒ A;

2) (A ⇒ B ⇒ C) ⇒ (A ⇒ B) ⇒ A ⇒ C.


1. A ⇒ B ⇒ A

--------- ax
A, B ⊢ A
--------- I
A ⊢ B ⇒ A
------------- I
⊢ A ⇒ (B ⇒ A)

Traduction :

(x, iA) ∈ (x, iA), (y, iB)
-------------------------- Var
(x, iA), (y, iB) ⊢ x : iA
------------------------- Fun
(x, iA) ⊢ λ y : iB → iA
---------------------------------------- Fun
⊢ λ x : iA. λ y : iB. x : iA → (iB → iA)


2. (A ⇒ B ⇒ C) ⇒ (A ⇒ B) ⇒ A ⇒ C

------------- ax   ----- ax   --------- ax  ----- ax
Γ ⊢ A ⇒ B ⇒ C      Γ ⇒ A      Γ ⊢ A ⇒ B     Γ ⊢ A
------------------------ E    ------------------- E
Γ ⊢ B ⇒ C                     Γ ⇒ B
----------------------------------- E
Γ = A ⇒ (B ⇒ C), A ⇒ B, A ⊢ C
----------------------------- I
A ⇒ (B ⇒ C), A ⇒ B ⊢ A ⇒ C
------------------------------- I
A ⇒ (B ⇒ C) ⊢ (A ⇒ B) ⇒ (A ⇒ C)
------------------------------------- I
⊢ (A ⇒ (B ⇒ C)) ⇒ ((A ⇒ B) ⇒ (A ⇒ C))

Traduction :


(x, iA → ...) ∈ Γ           (z, iA) ∈ Γ        (y, iA → iB) ∈ Γ        (z, iA) ∈ Γ
-------------------- Var    ----------- Var    ---------------- Var    ----------- Var 
Γ ⊢ x : iA → iB → iC        Γ ⊢ z : iA         Γ ⊢ y : iA → iB         Γ ⊢ z : iA
-------------------------------------- App   ------------------------------------ App
Γ ⊢ x z : iB → iC                            Γ ⊢ y z : iB
----------------------------------------------------------------- App
Γ = (x, iA → (iB → iC)), (y, iA → iB), (z, iA) ⊢ (x z) (y z) : iC
-------------------------------------------------------------------- Fun
(x, iA → (iB → iC)), (y, iA → iB) ⊢ λz : iA. (x z) (y z) : (iA → iC)
---------------------------------------------------------------------------------- Fun
(x, iA → (iB → iC)) ⊢ λy : iA → iB. λz : iA. (x z) (y z) : ((iA ⇒ iB) → (iA → iC))
------------------------------------------------------------------------------------------ Fun
⊢ Γ x : iA → (iB → iC). Γ y : iA. (x z) (y z) : (iA → (iB → iC)) → ((iA → iB) → (iA ⇒ iC))

Exemple :

(A ⇒ B) ⇒ (A ⇒ B)    

λx : iA → iB. λy : iA. x y
λx : iA → iB. x

*)

Require Extraction.

Lemma eq_nat : forall n m : nat, {n = m} + {n <> m}.
Proof.
  (* decide equality *)
  induction n; induction m; intros.
  left.
  reflexivity.
  right.
  discriminate.
  right.
  discriminate.
  elim (IHn m); intro.
  left.
  auto.
  right.
  auto.
Defined.

Recursive Extraction eq_nat.

Inductive is_fact : nat -> nat -> Prop :=
| is_fact_0 : is_fact 0 1
| is_fact_S : forall n v : nat, is_fact n v -> is_fact (S n) ((S n) * v).

Lemma fact : forall n : nat, { v : nat | is_fact n v }.
Proof.
  induction n.
  exists 1.
  apply is_fact_0.
  elim IHn; intros.
  exists ((S n) * x).
  apply is_fact_S.
  assumption.
Defined.

Recursive Extraction fact.










# Exercise 1 — Discover the Code & Rough Size  
_Repo 1: jay-bank_

## Objective  
Pour chaque classe suivante, ouvrir le fichier dans IntelliJ et utiliser le plugin **CK Metrics** pour relever :  
- **LOC** (Lines of Code)  
- **NOM** (Number of Methods)  
- Une **courte description** de la responsabilité de la classe  

Les classes à analyser :  
- `Bank`  
- `BankAccount`  
- `Person`  
- `BankAccountApp`  

---

## Metrics Summary

### Bank
| Metric | Value |
|--------|--------|
| **LOC (approx.)** |413 |
| **NOM** |14 |
| **Short description of responsibility** |Gère la liste des comptes bancaires, les opérations globales de la banque et la logique métier associée.|

---

### BankAccount
| Metric | Value |
|--------|--------|
| **LOC (approx.)** |462 |
| **NOM** |20 |
| **Short description of responsibility** |Représente un compte bancaire individuel et implémente les opérations principales : dépôts, retraits, transferts, gestion du solde.|

---

### Person
| Metric | Value |
|--------|--------|
| **LOC (approx.)** |325 |
| **NOM** |23 |
| **Short description of responsibility** | Modélise une personne, ses informations et ses interactions avec les comptes bancaires associés. |

---

### BankAccountApp
| Metric | Value |
|--------|--------|
| **LOC (approx.)** |491 |
| **NOM** |2 |
| **Short description of responsibility** |Point d’entrée de l’application : initialise les objets, orchestre les interactions et exécute le scénario principal.|

---

## Final Question  
**Do you feel each class’s size roughly matches its responsibility?**  
Globalement, les tailles semblent plutôt élevées pour des classes censées représenter des choses simples (Bank, BankAccount, Person). Cela veut probablement dire un manque de séparation entre différentes parties du code dans des classes qui devraient rester plus légères. En particulier, `BankAccountApp` est très longue malgré seulement deux méthodes qui pourraient être découpé. En résumé, la taille ne correspond pas vraiment à une bonne répartition des responsabilités, et un refactoring serait bien pour améliorer la lisibilité et la maintenabilité du code.

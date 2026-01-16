# Exercise 4 — SonarQube: Static Analysis & Quick Fixes  
_Repo 1: jay-bank_

## Issues sélectionnées

### 1. Refactor this method to reduce its Cognitive Complexity  
- **Rule:** `java:S3776`(Cognitive Complexity of methods should not be too high)  
- **File and line:** `BankAccountApp.java:20`  
- **Explication :** La méthode dépasse largement la complexité autorisée (125 vs 15). Cela indique une logique trop dense, difficile à lire et à maintenir. Elle devrait être découpée en sous-méthodes.

### 2. Replace this literal with a constant ("Account doesn't exist")  
- **Rule:** `java:S1192` (String literals should not be duplicated)  
- **File and line:** `BankAccountApp.java:139`  
- **Explication :** Le message "Account doesn't exist" est dupliqué 4 fois. Cela nuit à la maintenabilité et augmente le risque d’erreurs. Une constante permettrait de centraliser ce message.

### 3. Use try-with-resources instead of traditional try  
- **Rule:** `java:S2093`(Try-with-resources should be used)  
- **File and line:** `BankAccount.java:162`  
- **Explication :** Le bloc `try` n’utilise pas la syntaxe `try-with-resources`, ce qui peut entraîner des fuites de ressources si le fichier n’est pas correctement fermé.

---

##  Corrections effectuées

-  **Issue 2 corrigée** : le message "Account doesn't exist" a été remplacé par une constante `ACCOUNT_NOT_FOUND_MSG`.  
-  **Issue 3 corrigée** : le bloc `try` dans `BankAccount.java` a été converti en `try-with-resources`.

---

##  Vérification après analyse

Après avoir relancé SonarLint sur le projet (même scope):

- Les deux problèmes corrigés **ont disparu** de la liste des issues.  
- La méthode complexe dans `BankAccountApp.java` reste signalée, car elle nécessite un refactoring plus conséquent.

---

##  Corrélation avec WMC / CBO

Les classes avec des **WMC élevés** (comme `BankAccountApp` et `Person`) présentent effectivement **plus d’issues SonarLint**.
Cela confirme que les métriques CK (WMC, CBO, LCOM) sont de bons indicateurs de dette technique.  
Les classes plus simples comme `ACHService` ont peu ou pas d’issues.  
Il existe donc un **lien clair** entre complexité et problèmes détectés par SonarLint.


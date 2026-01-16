# Exercise 3 — CK Metrics Across Classes: Who Looks “Smelly”?
## Objective 
Analyser plusieurs classes du projet en utilisant CK Metrics et identifier celles qui présentent des signes de “code smell”.

_Repo 1: jay-bank_

## CK Metrics Table

| Classe          | LOC | WMC | CBO | LCOM | Notes rapides |
|-----------------|-----|-----|-----|------|----------------|
| **Bank**        | 413 | 14  | 4   | 0    |Plusieurs responsabilités, logique dispersée |
| **BankAccount** | 462 | 20  | 3   | 44   | Classe volumineuse, beaucoup d’attributs et de logique métier |
| **Person**      | 325 | 23  | 3   | 79   | Très faible cohésion, beaucoup de méthodes |

---

## Answers

### **1. Which class has the highest WMC?**
 **Person (WMC = 23)**

### **2. Which class has the highest CBO?**
 **Bank (CBO = 4)**

### **3. Considering WMC + CBO + LCOM together, which class is the most worrying for future maintenance, and why?**

###  Comparatif cumulé des métriques WMC + CBO + LCOM

| Classe          | WMC | CBO | LCOM | Total (WMC + CBO + LCOM) |
|-----------------|-----|-----|------|---------------------------|
| **Bank**        | 14  | 4   | 0    | **18**                    |
| **BankAccount** | 20  | 3   | 44   | **67**                    |
| **Person**      | 23  | 3   | 79   | **105**                   |

---

**Person** est la classe la plus préoccupante :  
- Elle possède le **WMC le plus élevé (23)** → beaucoup de méthodes, complexité importante  
- Elle présente un **LCOM très élevé (79)** → cohésion extrêmement faible, les méthodes ne travaillent pas ensemble  

Cette combinaison indique une construction assez fragile et un risque élevé d’introduire des bugs quand on fera des modifications dans le futur.

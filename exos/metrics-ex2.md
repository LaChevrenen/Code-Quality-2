# Exercise 2 — Cyclomatic Complexity on a Key Method  
_Repo 1: jay-bank_

## Objective  
Analyser la complexité cyclomatique d’une méthode non triviale dans `BankAccount` (ex: `depositMoney`, `withdrawMoney`, etc.).

---

## Selected Method

- **Method name:** `withdrawMoney`
- **Cyclomatic Complexity(of the file)** 33  
- **WMC (Weighted Methods per Class):** 20

---

## Decision Points (annotated in the method)

Méthode originale annotée :

```java
public boolean withdrawMoney(double withdrawAmount) {
    if ( // decision point 1
        withdrawAmount >= (double)0.0F 
        && this.balance >= withdrawAmount 
        && withdrawAmount < this.withdrawLimit 
        && withdrawAmount + this.amountWithdrawn <= this.withdrawLimit
    ) {
        this.balance -= withdrawAmount;
        this.success = true;
        this.amountWithdrawn += withdrawAmount;
    } else { // decision point 2
        this.success = false;
    }

    return this.success;
}
```
### Nombre de points de décision identifiés :
- **if → 1**  
- **else → 1**

**Total visible : 2 decision points**  
**Complexité cyclomatique mesurée : 5**

---

### Refactoring Proposal (3–5 sentences)

La méthode `withdrawMoney` regroupe plusieurs règles métier dans une seule condition complexe, ce qui nuit à la lisibilité et augmente fortement la complexité cyclomatique.  
Un bon refactoring serait d’extraire chaque vérification dans une méthode dédiée, par exemple : `isPositiveAmount()`, `hasSufficientBalance()`, `isUnderWithdrawLimit()`...  
Ensuite, une méthode comme `canWithdraw(withdrawAmount)` pourrait centraliser ces validations et simplifier le `if` principal. Tout cela réduirait significativement sa complexité.

---

### Bonus (optional)

Pour le bonus, j’ai appliqué le refactoring proposé en extrayant les vérifications dans des méthodes dédiées.  
La méthode `withdrawMoney` devient plus courte et plus lisible, tandis que la logique métier est répartie.

Exemple de refactoring :

```java
private boolean isPositiveAmount(double amount) { // decision point
    return amount >= 0.0;
}

private boolean hasSufficientBalance(double amount) { // decision point
    return this.balance >= amount;
}

private boolean isUnderWithdrawLimit(double amount) { // decision point
    return amount < this.withdrawLimit;
}

private boolean respectsDailyLimit(double amount) { // decision point
    return amount + this.amountWithdrawn <= this.withdrawLimit;
}

private boolean canWithdraw(double amount) { // decision point
    return isPositiveAmount(amount)
        && hasSufficientBalance(amount)
        && isUnderWithdrawLimit(amount)
        && respectsDailyLimit(amount);
}

public boolean withdrawMoney(double withdrawAmount) {
    if (canWithdraw(withdrawAmount)) { // decision point
        this.balance -= withdrawAmount;
        this.amountWithdrawn += withdrawAmount;
        return true;
    }
    return false;
}
```
### Conclusion sur la complexité après refactoring

Après refactoring, la méthode `withdrawMoney` voit sa complexité cyclomatique passer de **5 à 2**.  
Cette réduction est due au déplacement des différentes règles métier dans des méthodes dédiées.  
La logique est désormais mieux répartie, plus lisible et plus facile à tester.  
Même si la complexité totale de la classe augmente légèrement, la complexité locale de `withdrawMoney` est nettement réduite, ce qui améliore la maintenabilité du code.

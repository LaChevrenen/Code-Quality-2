# Exercise 7 — Maven Lifecycle Exploration

## Ajout des dépendances de test
Dans le `pom.xml`, j’ai ajouté JUnit 4 ainsi que le plugin Surefire pour exécuter les tests :

- Dépendance : `junit:junit:4.13.2`
- Scope : `test`
- Plugin : `maven-surefire-plugin` (version 3.2.5)

Maven a automatiquement téléchargé les dépendances après sauvegarde du fichier.

---

## Commande : mvn clean
**Phases exécutées :**
- clean

**Effet :**
- Supprime entièrement le dossier `target/`

**Nouveaux fichiers dans target/ :**
- Aucun (le dossier est supprimé)

---

## Commande : mvn test
**Phases exécutées :**
- validate  
- compile  
- test-compile  
- test  

**Nouveaux fichiers dans target/ :**
- `classes/` → compilation du code source  
- `test-classes/` → compilation des tests  
- `surefire-reports/` → résultats d’exécution des tests  

---

## Commande : mvn package
**Phases exécutées :**
- validate  
- compile  
- test-compile  
- test  
- package  

**Nouveaux fichiers dans target/ :**
- Tout ce qui est généré par `mvn test`
- **+ un fichier JAR** :  
  `bank-application-1.0-SNAPSHOT.jar`

---

## Commande : mvn verify
**Phases exécutées :**
- validate  
- compile  
- test-compile  
- test  
- package  
- verify  

**Hypothèse sur verify :**  
`verify` ajoute des vérifications supplémentaires après la création du JAR (intégrité, cohérence, plugins de validation).  
Il ne génère pas de nouveaux fichiers, mais confirme que le build est prêt pour installation ou déploiement.


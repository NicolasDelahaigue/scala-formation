# Store

Ce projet a pour but d'aborder les basiques de scala à travers l'api d'un magasin en ligne.\
Nous partirons d'une simple méthode `addProduct` et nous la ferons évoluer étape par étape jusqu'à obtenir une fonctionnalité complète.

Vous y verrez différentes notions classiques comme les variables, les fonctions, les classes et objets.\
Ainsi que des notions plus propres à scala comme les Option, Either et sealed trait.

Pour ce projet nous allons utiliser la stack suivante :
- H2 (base de données)
- Doobie (librairie de requête de base de données)
- Flyway (librairie de migration de base de données)
- Cats Effect (librairie de gestion des effets de bord)
- Tapir (librairie de routage HTTP et génération de documentation OpenAPI)
- Circe (librairie de gestion encodage/décodage en JSON)

## Setup

Lors de ce développement nous utiliserons Intellij.

Configuration du poste :
- Utiliser l'IDE IntelliJ Community
- Importer le projet en tant que projet sbt
- Installer le plugins Scala

Déroulement :
- Pour chaque exercice, faites un `git checkout` sur le numéro de l'exercice. (i.e `git checkout Exercice1`)
- Si vous souhaitez voir la solution vous pouvez aller sur l'exercice suivant.
- À chaque nouvel exercice vous trouverez les consignes dans le fichier `Exercices.md` situé dans les sources du dossier `domain`
- Pour lancer le projet faites un `sbt run` dans votre terminal et accédez au lien http://localhost:8080/swagger.
- Commençons : `git checkout Exercice1`

## Crédits
Merci à Ekowerra pour son travail sur le projet [simple-bank](https://github.com/Ekowerra/simple-bank) dont je me suis inspiré.
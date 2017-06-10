# EverNoteLike-MongoDB
Projet Java en lien avec une base de données MongoDB pour réaliser un EverNote like

## Pré-requis

* Vous devez avoir maven installé sur votre poste.
* Une connexion internet pour que maven puisse téléchargé les librairies nécessaires

## Etapes préliminaire

* Vous trouverez un (très) petit jeu d'essai dans src/main/resources. Vous pouvez importez les fichiers "users.json" et "notes.json" pour avoir un jeu d'essai. Il est recommandé d'importer au moins le fichier "users.json" car l'application ne gère pas la création d'utilisateur.
* Vérifiez dans le fichier config.properties que la chaîne de connexion soit valide pour votre serveur MongoDB. Les propriétés database.name et collection.*.name sont a modifier seulement si vous avez changé le nom de la base de données ou des collections pour les utilisateurs et les notes.

## Lancement de l'application

Utilisez "mvn verify" dans votre invité de commande préféré.

Si vous avez importez les 2 fichiers json, vous pouvez utilisez les identifiants suivants:
* michel@test.fr / test => pour avoir des note
* cedric@test.fr / test => pour avoir un compte vide
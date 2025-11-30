
### Projet POO Donjon & Dragon

Projet réalisé à l’IUT Robert Schuman – Université de Strasbourg, dans le cadre du Projet POO – Java : Développement d’un jeu Donjons & Dragons.

Ce projet a été développé en binôme sur une durée totale de 5 semaines, comprenant des séances encadrées, tutorées, ainsi que du travail personnel.

Objectif du projet

Développer une application Java simulant une version simplifiée du jeu Donjons & Dragons :

Jeu au tour par tour

Plusieurs joueurs face à des monstres contrôlés par le Maître du Jeu

Progression à travers trois donjons successifs

Défaite si un seul joueur meurt

Victoire si tous les monstres d’un donjon sont éliminés


**Le projet inclut** :

Système de création de personnages

Gestion détaillée des races, classes, équipements et caractéristiques

Génération et gestion des donjons

Système de combat complet

Ordre d’initiative, actions par tour (déplacement, attaque, ramassage…)

Affichage ASCII du donjon

Gestion de l’inventaire et des équipements


## Structure du dépôt

```
POO-Java-jeu-Donjons-Dragons/
│
├── README.md
├── Phase_2.md
├── src/
│   ├── Main.java
│   ├── affichage/
│   ├── donjon/
│   ├── jouable/
│   ├── objet/
│   ├── partie/
│   └── stats/
├── tests/
│   ├── donjon/
│   └── jouable/
└── uml/
    ├── semaine1.puml
    ├── semaine2.puml
    └── ...

```
Tous les fichiers Java se trouvent dans src/ et les diagrammes UML hebdomadaires dans uml/.


---

## Création d'un personnage

Chaque personnage possède :

* un **nom**
* une **race** (Humain, Nain, Elfe, Halfelin)
* une **classe** (Guerrier, Clerc, Magicien, Roublard)
* des **caractéristiques** : points de vie, force, dextérité, vitesse, initiative
* un **inventaire** d'armes et armures
* une **arme** et **armure** équipées

### Caractéristiques de base

* PV : fixés par la classe
* Les autres stats = `4d4 + 3 + bonus de race`


## Les équipements

### Armures

### Armes

---

## Les monstres

Un monstre possède :

* une espèce
* un numéro (si plusieurs identiques)
* une attaque (portée, dégâts)
* PV, vitesse, force, dextérité, CA
* initiative

Les monstres **n’ont pas d'équipement**.

---

## Déroulement d’un donjon

### Mise en place

Le Maître du Jeu :

* génère un donjon rectangulaire (15 à 25 cases)
* place obstacles, équipements, joueurs, monstres
* crée les monstres
* explique le contexte
* lance l’initiative via `1d20 + bonus`

Une configuration par défaut est fournie.

### Tour par tour

Chaque entité (joueur ou monstre) dispose de **3 actions** parmi :

* S’équiper
* Se déplacer
* Attaquer
* Ramasser un équipement

### Déplacements

Distance = `vitesse / 3` cases.

### Attaque

* Jet : `1d20 + (Dex si distance / Force si CàC)`
* Succès si ≥ classe d’armure de la cible
* Dégâts : jet du dé associé à l’arme

### Fin d’un donjon

* Défaite si un joueur meurt
* Victoire si tous les monstres sont éliminés
* En cas de victoire : PV restaurés + passage au donjon suivant

---

## ️ Exemple d’affichage ASCII

Le programme affiche :

* la liste des entités avec leurs PV
* la carte du donjon
* les équipements, obstacles, positions
* le détail du tour en cours

(Le visuel original est plus long et non reproduit ici, mais **toutes les informations sont présentes dans le jeu**.)

---

## Fin du jeu

À la fin des trois donjons :

* **"Vous avez gagné"**
* ou **"Vous avez perdu"**, avec la cause affichée.

---

## Tests

Le dossier `tests/` contient :

* tests unitaires sur les donjons
* tests des classes jouables (personnages)

---

## UML

Chaque semaine :

* un fichier UML `semaineX.puml` mis à jour
* diagramme complet

---

## Conseils suivis durant le projet

* Développement progressif
* Commits réguliers
* Conception modulaire

---

## Équipe

Projet réalisé en binôme :

* **Maxence Flieller**
* **Maxime Malys**

Durée totale : **5 semaines**

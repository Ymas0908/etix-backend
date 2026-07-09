# TickUp-Subs

> Service backend développé avec **Java** et **Spring Boot** suivant les principes de l'architecture hexagonale. Il centralise la gestion des utilisateurs, de l'authentification et des autorisations de l'écosystème TickUp.

---

# Présentation

**TickUp-Subs** est le service responsable de la gestion des utilisateurs de la plateforme **TickUp**.

Il expose un ensemble d'API REST permettant aux différentes applications de l'écosystème de gérer l'authentification, les comptes utilisateurs, les rôles ainsi que les autorisations.

Ce service est partagé par :

* **TickUp App**, l'application mobile destinée aux participants.
* **TickUp Scan**, l'application mobile utilisée par les agents de contrôle pour scanner et valider les tickets lors des événements.

Grâce à une architecture hexagonale, le projet garantit une forte séparation entre le domaine métier et les aspects techniques, facilitant ainsi les évolutions, les tests et la maintenance.

---

# Responsabilités

Le service prend en charge les fonctionnalités suivantes :

* Authentification des utilisateurs
* Gestion des comptes utilisateurs
* Gestion des rôles
* Gestion des profils
* Activation et désactivation des comptes
* Réinitialisation des mots de passe
* Validation des accès aux différentes applications
* Exposition d'API REST sécurisées

---

# Stack technique

| Élément                 | Technologie                   |
| ----------------------- | ----------------------------- |
| Langage                 | Java 17                       |
| Framework               | Spring Boot 3.x               |
| Architecture            | Hexagonale (Ports & Adapters) |
| Build                   | Maven                         |
| Sécurité                | Spring Security               |
| Authentification        | JWT                           |
| Base de données         | MariaDB 
| ORM                     | Spring Data JPA / Hibernate   |
| Documentation API       | OpenAPI / Swagger             |
| Gestion des dépendances | Maven                         |

---

# Prérequis

Avant de lancer le projet, assurez-vous de disposer des outils suivants :

* JDK 21 ou supérieur
* Maven 3.9+
* MariaDB
* IntelliJ IDEA ou Visual Studio Code
* Git

---



# Architecture de l'écosystème

TickUp-Subs est le service central chargé de la gestion des utilisateurs.

```text
                     TickUp-Subs
          (Gestion des utilisateurs)
                    │
        ┌───────────┴───────────┐
        │                       │
        ▼                       ▼
   TickUp App              TickUp Scan
 Application mobile      Application mobile de contrôle
     des participants      des tickets des participants
```

Les deux applications utilisent le même système d'authentification et les mêmes données utilisateurs.

---

# Principes de l'architecture hexagonale

Le projet est organisé autour des principes suivants :

* Le domaine métier est indépendant des frameworks.
* Les cas d'utilisation sont isolés des technologies externes.
* Les bases de données sont considérées comme des adaptateurs.
* Les API REST constituent des adaptateurs entrants.
* Les services externes sont intégrés via des ports.
* Les dépendances pointent toujours vers le domaine métier.

Cette organisation facilite :

* les tests unitaires ;
* la maintenance ;
* les évolutions fonctionnelles ;
* le remplacement d'une technologie sans impacter le métier.

---

# Applications consommatrices

Les API exposées par TickUp-Subs sont utilisées par :

| Application     | Utilisation                                                                                               |
| --------------- | --------------------------------------------------------------------------------------------------------- |
| **TickUp App**  | Authentification, gestion du profil utilisateur et accès aux fonctionnalités de l'application.            |
| **TickUp Scan** | Authentification des agents de contrôle et gestion des autorisations nécessaires au contrôle des tickets. |

---

# Objectif

L'objectif de **TickUp-Subs** est de fournir un service d'identité unique pour l'ensemble de l'écosystème TickUp en centralisant la gestion des utilisateurs, des rôles et des autorisations, tout en garantissant une architecture robuste, sécurisée et facilement évolutive.

---

# Auteur

Projet développé par Samuel Kébé.

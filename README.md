# TransLogiCo - Partie 1 : Modélisation avec le Pattern Factory et le Pattern Stratégie

## Contexte
Dans cette première partie, nous mettons en place la base du système d’expédition TransLogiCo pour gérer différents transporteurs et leurs méthodes de calcul des frais. Le design est pensé pour être extensible et flexible, permettant ainsi de facilement ajouter ou modifier des transporteurs et leurs stratégies de calcul.

Pour atteindre cet objectif, nous utilisons **deux patterns de conception** :
1. **Pattern Factory** pour créer dynamiquement des transporteurs en fonction du type sélectionné.
2. **Pattern Stratégie** pour permettre de définir et de changer dynamiquement la manière de calcul des frais.

## Modélisation

### Classes et Interfaces
Les principales classes et interfaces de cette partie sont :

1. **`TypeTrans` (Enum)** :
   - **Description** : Un `enum` qui définit les types de transporteurs disponibles : `STANDARD`, `EXPRESS`, et `ECO`.
   - **Raison du choix** : Utiliser un `enum` permet de référencer facilement les types de transporteurs sans erreur, augmentant la lisibilité du code.

2. **Interface `CalculerFrais`** :
   - **Description** : Une interface pour les classes de calcul des frais, avec une méthode `calcul(poids, distance)`.
   - **Raison du choix** : Fournit une base commune pour les stratégies de calcul, permettant de définir plusieurs manières de calcul des frais en gardant le code modulaire.

3. **Classes de calcul des frais (`CStandard`, `CExpress`, `CEco`)** :
   - **Description** : Chaque classe implémente l’interface `CalculerFrais` avec sa propre logique de calcul :
     - `CStandard` : 1,5 € par km + 0,2 € par kg.
     - `CExpress` : 2,5 € par km + 0,5 € par kg.
     - `CEco` : 1 € par km + 0,1 € par kg.
   - **Raison du choix** : En définissant chaque stratégie de calcul dans une classe, il devient facile de modifier ou d’ajouter de nouvelles stratégies sans impacter les autres parties du code.

4. **Classe abstraite `Transporteur`** :
   - **Attributs et méthodes** :
     - `manierCalcul` : Un attribut de type `CalculerFrais` pour la stratégie de calcul actuelle.
     - `createTrans(TypeTrans type)` : Méthode de création qui renvoie une instance du type de transporteur voulu.
     - `setCalcul(CalculerFrais calcul)` : Définit la stratégie de calcul des frais.
     - `calculerFrais(double poids, double distance)` : Calcule les frais avec la stratégie actuelle.
   - **Raison du choix** : En centralisant les méthodes dans `Transporteur`, on isole la logique de création et de calcul des frais, permettant d’ajouter des transporteurs ou des stratégies de calcul avec un minimum de modifications.

5. **Classes concrètes de transporteurs (`Standard`, `Express`, `Eco`)** :
   - **Description** : Ces classes héritent de `Transporteur` et définissent leur stratégie de calcul par défaut.
   - **Raison du choix** : Chaque transporteur est configuré avec sa stratégie de calcul respective dès sa création, facilitant l’ajout de nouveaux transporteurs.

## Choix de conception

### Utilisation du Pattern Factory
Le **pattern Factory** est implémenté dans la méthode `createTrans` de la classe `Transporteur`, permettant de créer un transporteur en fonction du type donné (`TypeTrans`). Ce design facilite l’ajout de nouveaux transporteurs sans impact majeur sur la structure.

### Utilisation du Pattern Stratégie
Le **pattern Stratégie** permet de définir la manière de calcul des frais, chaque transporteur utilisant une stratégie spécifique définie par `CalculerFrais`. La flexibilité de `setCalcul()` permet de changer de stratégie en temps réel, sans modifier le reste du code.

## Exemple d’utilisation
Exemple d’utilisation pour créer un transporteur et calculer les frais d’expédition :

Placez cette version modifiée dans un repository nommé **Partie2**.

---

## Partie 3 : Simplification de l'Interface pour les Utilisateurs (Façade)

### Nouvelle Exigence

Pour faciliter l’utilisation du système, les utilisateurs finaux de TransLogiCo demandent une interface simplifiée pour la gestion des transporteurs et des calculs de frais.

### Objectifs

1. **Façade** : Implémenter une classe `FacadeExpedition` pour simplifier l’interaction avec le système. Cette classe devra fournir des méthodes pour :
   - Ajouter un transporteur (via `TransporteurFactory`).
   - Calculer les frais d'expédition en utilisant un transporteur spécifique.
   - Changer la stratégie de calcul.
2. **Simplification de l'Interface Utilisateur** : `FacadeExpedition` doit servir de point d’entrée principal pour les utilisateurs de TransLogiCo, masquant la complexité des interactions entre les transporteurs et les stratégies.

Placez cette version finale dans un repository nommé **Partie3**.

---

## Structure des repository

- **Partie1/** : Mise en place initiale du système avec les patterns Factory et Stratégie.
- **Partie2/** : Extension avec le pattern Adaptateur pour intégrer un transporteur externe.
- **Partie3/** : Ajout du pattern Façade pour simplifier l’interface utilisateur.

---

## Exigences et Objectifs Techniques

1. **Pattern Factory** : Facilite l'instanciation des transporteurs internes de manière centralisée.
2. **Pattern Stratégie** : Permet de changer dynamiquement le calcul des frais.
3. **Pattern Adaptateur** : Intègre des transporteurs externes sans modifier la structure existante.
4. **Pattern Façade** : Fournit une interface simplifiée pour l’utilisateur.

Chaque partie doit démontrer une maîtrise des Design Patterns et respecter les principes de modularité et de flexibilité. Assurez-vous que chaque dossier GitHub contient le code correspondant, bien structuré et documenté.

---

Bonne chance et merci de suivre les évolutions de ce projet ! 🎉

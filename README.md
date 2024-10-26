# Design-Patterns-en-Pratique
Ce repository contient des implémentations pratiques de divers Design Patterns (patrons de conception), en commençant par la conception et l'intégration progressive de nouvelles fonctionnalités à travers des patterns comme l'Adaptateur, la Méthode de Factory, la Stratégie, la Façade..

# TransLogiCo - Système de Calcul de Frais d'Expédition

## Contexte Général

Votre entreprise de logistique, **TransLogiCo**, souhaite optimiser le calcul des frais d’expédition de colis avec un système flexible et évolutif. Le service R&D a décidé d'implémenter une architecture de calcul de frais qui puisse s'adapter aux différents types de transporteurs et stratégies de tarification, tout en permettant d’intégrer facilement des transporteurs externes. Ce projet est structuré en trois parties, correspondant à l'évolution des exigences de l’entreprise.

---

## Partie 1 : Mise en place du Système de Calcul de Frais d'Expédition (Factory & Stratégie)

### Contexte

TransLogiCo démarre avec trois types de transporteurs internes : **Standard**, **Express**, et **Économique**. Chaque transporteur a une méthode spécifique de calcul des frais :
- **Standard** : 1,5 € par kilomètre + 0,2 € par kilo.
- **Express** : 2,5 € par kilomètre + 0,5 € par kilo.
- **Économique (Eco)** : 1 € par kilomètre + 0,1 € par kilo.

Le système doit permettre de définir dynamiquement le calcul des frais de chaque transporteur en utilisant des stratégies différentes.

### Objectifs

1. **Interface Transporteur** : Créer une interface `Transporteur` avec une méthode pour définir dynamiquement la stratégie de calcul utilisée.
2. **Stratégie de Calcul** : Créer une interface `CalculerFrais` pour définir les stratégies de calcul, ainsi que trois classes concrètes (`CStandard`, `CExpress`, `CEco`) correspondant aux méthodes de calcul de chaque type de transporteur.
3. **Factory** : Développer une classe `TransporteurFactory` qui génère les instances de transporteurs en fonction du type (Standard, Express, Eco).
4. **Calculateur de Frais** : Ajouter à `Transporteur` la possibilité de changer la stratégie de calcul à l’aide de `CalculNormal` et `CalculPromo` (qui applique une réduction de 10%).

Placez cette première version dans un dossier nommé **Partie1**.

---

## Partie 2 : Intégration de Transporteurs Externes (Adaptateur)

### Nouvelle Exigence

L’équipe commerciale de TransLogiCo conclut qu’il serait stratégique d’offrir des options de livraison avec des transporteurs externes. L’entreprise souhaite intégrer un transporteur externe nommé **ExterShip**, qui possède une méthode `getTarif(double poids, double distance)` pour calculer les frais.

### Objectifs

1. **Adaptateur** : Utiliser un pattern Adaptateur pour intégrer ExterShip sans modifier la structure existante. Créer une classe `AdaptateurTransporteurExterne` qui implémente `CalculerFrais` et redirige les appels vers la méthode `getTarif()` d'ExterShip.
2. **Mise à jour de la Factory** : Modifier `TransporteurFactory` pour inclure ce nouveau transporteur externe via l’adaptateur.
3. **Intégration Transparente** : Assurez-vous que le système permet d'utiliser ExterShip de manière transparente, comme s'il s'agissait d'un transporteur interne.

Placez cette version modifiée dans un dossier nommé **Partie2**.

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

Placez cette version finale dans un dossier nommé **Partie3**.

---

## Structure des Dossiers

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

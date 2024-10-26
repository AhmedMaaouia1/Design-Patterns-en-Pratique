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

```java
public class Main {
    public static void main(String[] args) {
        // Créer un transporteur de type STANDARD
        Transporteur transporteur = Transporteur.createTrans(TypeTrans.STANDARD);

        // Calculer les frais d'expédition
        double frais = transporteur.calculerFrais(10.0, 100.0);
        System.out.println("Frais d'expédition : " + frais);
    }
}

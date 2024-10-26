# Design-Patterns-en-Pratique
Ce repository contient des implémentations pratiques de divers Design Patterns (patrons de conception), en commençant par la conception et l'intégration progressive de nouvelles fonctionnalités à travers des patterns comme l'Adaptateur, la Méthode de Factory, la Stratégie, la Façade..


## Contexte :
Dans votre entreprise de logistique, vous devez développer un système pour calculer les frais d'expédition de colis. Ce système doit être extensible et permettre d'utiliser plusieurs transporteurs, chacun ayant sa propre méthode de calcul des frais.

## Exercice :
### Étape 1 : Conception (30%)
#### Question 1 : 
Concevez une interface appelée Transporteur avec une méthode calculerFrais(double poids, double distance).
#### Question 2 : 
Concevez trois classes concrètes :
TransporteurStandard : Les frais sont calculés à raison de 1,5 € par kilomètre + 0,2 € par kilo.
TransporteurExpress : Les frais sont calculés à 2,5 € par kilomètre + 0,5 € par kilo.
TransporteurEco : Les frais sont calculés à 1 € par kilomètre + 0,1 € par kilo.
#### Question 3 : 
Créez une classe de factory TransporteurFactory qui permettra de créer des instances de transporteurs en fonction d'un type donné (Standard, Express, Eco).
Expliquez brièvement la conception, les relations entre les classes et les interfaces, et pourquoi votre conception est flexible pour intégrer de futurs transporteurs.
#### Question 4 : 
Créez une classe CalculateurFrais qui utilise la méthode de factory pour obtenir un transporteur et calculer les frais d'expédition. Cette classe devra inclure une méthode pour définir le transporteur utilisé et une méthode calculer(double poids, double distance).
### Étape 2 : Utilisation du pattern Stratégie (30%)
#### Question 5 : 
Ajoutez une fonctionnalité à la classe CalculateurFrais qui permet de changer dynamiquement la stratégie de calcul des frais. Créez une interface StrategieCalcul avec une méthode calculer(double poids, double distance).
Créez deux stratégies concrètes : CalculNormal (qui utilise les transporteurs existants) et CalculPromo (qui applique une remise de 10% sur les frais calculés).
Intégrez cette fonctionnalité dans la classe CalculateurFrais.
### Étape 3 : Utilisation du pattern Façade (20%)
#### Question 6 : 
Créez une classe FacadeExpedition qui simplifie l'utilisation de votre système d'expédition. Cette classe devrait fournir des méthodes simples pour :
Ajouter un transporteur.
Calculer les frais d'expédition en utilisant un transporteur spécifique.
Changer la stratégie de calcul des frais.

#### Étape 4 : Utilisation du pattern Adaptateur (20%)
#### Question 7 : 
Votre entreprise souhaite intégrer un transporteur externe, nommé TransporteurExterne, qui possède une méthode getTarif(double poids, double distance) pour renvoyer les frais.
Créez une classe adaptatrice AdaptateurTransporteurExterne qui implémente l'interface Transporteur et adapte l'utilisation de TransporteurExterne.
Modifiez la classe FacadeExpedition pour inclure ce nouveau transporteur externe via l'adaptateur.

## Attentes :

#### Pour la conception, décrivez clairement les classes, les interfaces et les relations entre elles. Expliquez comment chaque pattern est utilisé et pourquoi votre conception est extensible.
#### Pour l'implémentation, assurez-vous que le code est bien structuré, lisible et suit les principes de modularité.
#### Pour le pattern Adaptateur, montrez comment vous intégrez un système externe sans modifier le système existant.

## Bonne chance !

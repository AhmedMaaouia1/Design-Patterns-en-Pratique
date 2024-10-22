# Design-Patterns-en-Pratique
Ce repository contient des implémentations pratiques de divers Design Patterns (patrons de conception), en commençant par la conception et l'intégration progressive de nouvelles fonctionnalités à travers des patterns comme l'Adaptateur, la Méthode de Factory, la Stratégie, la Façade..


## Contexte :
Vous travaillez dans une entreprise de logistique et devez développer un système qui calcule les frais d'expédition en fonction du transporteur choisi. Chaque transporteur a ses propres règles pour calculer ces frais selon le poids du colis et la distance à parcourir.

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
Créez une classe CalculateurFrais qui permet de choisir un transporteur et de calculer les frais en fonction de celui-ci. Cette classe devra inclure une méthode pour définir le transporteur utilisé et une méthode calculer(double poids, double distance) pour calculer les frais.
Expliquez brièvement la conception, les relations entre les classes et les interfaces, et pourquoi votre conception est flexible pour intégrer de futurs transporteurs.

### Étape 2 : Implémentation (40%)
#### Question 4 : 
Implémentez en Java l'interface Transporteur ainsi que les trois classes concrètes TransporteurStandard, TransporteurExpress, et TransporteurEco.
#### Question 5 : 
Implémentez la classe CalculateurFrais avec la possibilité de définir dynamiquement le transporteur et de calculer les frais d'expédition.
### Étape 3 : Utilisation du pattern Adaptateur (30%)
#### Question 6 : 
Votre entreprise souhaite utiliser un transporteur externe, nommé TransporteurExterne, qui possède déjà son propre système pour calculer les frais d'expédition. Ce transporteur utilise une méthode getTarif(double poids, double distance) pour renvoyer les frais.

Créez une classe adaptatrice AdaptateurTransporteurExterne qui implémente l'interface Transporteur et adapte l'utilisation de TransporteurExterne à votre système.

Modifiez votre classe CalculateurFrais pour qu'elle puisse utiliser ce nouveau transporteur externe à travers l'adaptateur, et montrez comment l'intégrer dans le calcul des frais.

## Attentes :

#### Pour la conception, je m'attends à voir une représentation claire des classes et des méthodes avec des explications sur la manière dont elles interagissent.
#### Pour l'implémentation, assurez-vous que le code est bien structuré, extensible, et suit les principes d'encapsulation et de modularité.
#### Pour l'adaptateur, l'intégration doit démontrer comment un système externe peut être intégré sans modifier l'existant, grâce au pattern Adaptateur.

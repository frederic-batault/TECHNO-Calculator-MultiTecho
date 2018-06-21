# TECHNO-Calculator-MultiTecho
Différentes applications avec les mêmes fonctionnalités et des technologies différentes



Fonctionalités:
- effectuer une opération mathématique entre deux nombres entrés par l'utilisateur
- l'opération est choisie par l'utilisateur parmi l'addition, la soustraction, la multiplication et la division
- pour la division, en cas de vivision par zero, le resultat est remplacé par un message d'erreur
- un bouton permet d'enregistrer le dernier résultat (en base de donnée)
- un autre bouton permet de rappeller la valeur enregistrée, selon les applications:
    - soit l'utilisateur peut choisir si la valeur récupérée est écrite comme nombre de départ pour un nouveau calcul avec une position au choix
    - soit la valeur rappelée est affichée dans un champ dédié
    - soit la valeur rappelée est inscrite dans la zone d'affichage du resultat du calcul



Applications:

- "angular-calculatrice"
partie front implémentant les fonctionnalités
les traitements doivent être effectués par un web-service
> blocage: dans le service, le consommation du web-service ne fonctionne pas

- "SpringMVC-Spring-SansJPA"
application avec SpringMVC en front, SpringCore pour la couche de service et les beans
Il n'y a pas d'accès à la base de données, une classe permet de fournir des faux services de dao
> fonctionelle

- "Struts-Maven-Spring-SansJPA"
application avec Struts en front, SpringCore pour la couche de service et les beans
Il n'y a pas d'accès à la base de données, une classe permet de fournir des faux services de dao
> blocage: problème d'écriture des propriétés de la bean d'action à partir des données obtenues du formulaire

- "Struts-Maven-SansDao"
application avec Struts en front
Il n'y a pas d'accès à la base de données, une classe permet de fournir des faux services de dao
> blocage:

- "WebService-Maven-Dao"
application web-service REST avec une Dao classique (sans jpa)
> fonctionelle

- "WebService-Maven-Dao-Spring"
application web-service REST avec Spring pour la gestion des beans et avec une dao par Spring-Jpa
> fonctionelle

- "WebService-Maven-Spring-SansJPA"
application web-service REST avec Spring pour la gestion des beans
Il n'y a pas d'accès à la base de données, une classe permet de fournir des faux services de dao
Classe service de calcul réalisée sous plusieurs formes : classique, avec classes internes locales, avec classes anonymes, avec expressions Lambda
> fonctionelle, voir le read-me dédié

# Spring Data avec JPA

Spring Data est un projet Spring qui a pour objectif de simplifier l’interaction avec différents systèmes de stockage de données : qu’il s’agisse d’une base de données relationnelle, d’une base de données NoSQL, d’un système Big Data ou encore d’une API Web.

Le principe de Spring Data est de simplifier le travail des développeurs en prenant en charge l’implémentation des méthodes d’accès à ces systèmes. Pour cela, Spring Data fournit des interfaces par défaut mais définit aussi une convention de nommage des méthodes d’accès pour nous permettre d’exprimer la requête à réaliser.

> [!NOTE]
> Il existe différents modules `Spring Data`. ``Spring Data JDBC`` est un module qui permet de faciliter l'implémentation des repo basés sur JDBC. Le choix du module dépend du projet. ``Spring Data JDBC`` possède un mapping simple, sans ORM, une gestion des relations manuelle, permet un gain en performance, et a pour objectif la simplicité/prédictibilité, là ou ``Spring Data JPA`` a pour object l'abstraction maximale.
Il existe aussi ``Spring Data MongoDB`` et beaucoup d'autres ...
# Spring Data avec JPA

Spring Data est un projet Spring qui a pour objectif de simplifier l’interaction avec différents systèmes de stockage de données : qu’il s’agisse d’une base de données relationnelle, d’une base de données NoSQL, d’un système Big Data ou encore d’une API Web.

Le principe de Spring Data est de simplifier le travail des développeurs en prenant en charge l’implémentation des méthodes d’accès à ces systèmes. Pour cela, Spring Data fournit des interfaces par défaut mais définit aussi une convention de nommage des méthodes d’accès pour nous permettre d’exprimer la requête à réaliser.


## Notion de repository

Spring Data s’organise autour de la notion de repository. Il fournit une interface marqueur générique ``Repository<T, ID>``. Le type ``T`` correspond au type de l’objet géré par le repository. Le type ``ID`` correspond au type de la clé d’un objet.

L’interface ``CrudRepository<T, ID>`` hérite de ``Repository<T, ID>`` et fournit un ensemble d’opérations élémentaires pour la manipulation des objets.


## Spring Data JPA

Le projet Spring Data est en fait un regroupement de modules fournissant chacun la possibilité de configurer et d’injecter une implémentation d’un repository pour un type de systèmes de données.

Spring Data JPA est le module qui nous permet d’interagir avec une base de données relationnelles en représentant les objets du domaine métier sous la forme d’entités JPA.

Spring Data JPA fournit l’interface ``JpaRepository<T, ID>`` qui hérite de ``CrudRepository<T, ID>`` et qui fournit un ensemble de méthodes plus spécifiquement adaptées pour interagir avec une base de données relationnelle.

Pour définir un repository, il suffit de créer une interface qui hérite d’une des interfaces ci-dessus. Nous allons voir que Spring Data JPA va prendre en charge, à l’exécution, la création d’une classe implémentant cette interface. JpaRepository<T, ID> 

```java
public interface UserRepository extends JpaRepository<User, Long> { }
```

> [!NOTE]
> Notez que l’interface ne porte aucune annotation. ``UserRepository`` ne peut pas servir à déclarer un composant Spring puisqu’il s’agit simplement d’une interface.


> [!NOTE]
> Il existe différents modules `Spring Data`. ``Spring Data JDBC`` est un module qui permet de faciliter l'implémentation des repo basés sur JDBC. Le choix du module dépend du projet. ``Spring Data JDBC`` possède un mapping simple, sans ORM, une gestion des relations manuelle, permet un gain en performance, et a pour objectif la simplicité/prédictibilité, là ou ``Spring Data JPA`` a pour object l'abstraction maximale.
Il existe aussi ``Spring Data MongoDB`` et beaucoup d'autres ...

## Intégration des repositories

Selon que vous utilisiez ou non Spring Boot, l’intégration du support des repositories dans votre application va se faire de manière légèrement différente.

### Intégration dans une application Spring Boot

Spring Data JPA est automatiquement inclus et configuré si vous ajoutez le support à JPA. Consultez le chapitre Spring DAO pour voir comment faire.

Par défaut, Spring Data JPA va utiliser le package de la classe portant l’annotation ``@SpringBootApplication`` comme le package de base. Cela signifie, qu’il va rechercher les interfaces de repositories dans ce package et tous ses sous-packages.

Si vous voulez changer le comportement par défaut, vous pouvez utiliser l’annotation ``@EnableJpaRepositories`` décrite pour l’intégration dans une application sans Spring Boot.

## Injection des repositories

À l’initialisation du contexte d’application, Spring Data JPA va rechercher à partir du ou des packages de base (en incluant leurs sous-packages) toutes les interfaces de répositories, c’est-à-dire toutes les interfaces héritant directement ou indirectement de l’interface ``Repository<T, ID>``. Pour chacune de ces interfaces, Spring Data JPA va fournir une classe d’implémentation et créer un bean portant le même nom que l’interface.

Pour utiliser une interface repository dans une application, il suffit d’injecter un bean du type de l’interface.


```java
@Repository
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Transactional
  public void doSomething(long id) {
    long nbUser = userRepository.count();
    boolean exists = userRepository.existsById(id);

    // ..
  }

}
```

```java
```
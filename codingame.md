1 . Quel annotation peut on utiliser pour injecter un bean spring ?
@Autowired,  @Qualifier & @Ressource
@Qualifier : c’est une annotation utilisée lorsqu’on a plusieurs classes qui implémentent une interface, 
et on veux faire l’injection des dépendances en utilisant cet interface.
L’annotation @Resource : on peut dire qu’elle s’agit d’une fusion entre l’annotation @Autowired et @Qualifier,

2. Comment declarer un endpoint REST ?
RESTful Web Service

3. Un bean annoté Lazy est initialisé à la demande et non au demarrage du conteneur

4. bootstrap.yml est chargé de charger les proprietée de configiration de source externe et Il n’est utilisé / nécessaire que si vous utilisez Spring Cloud et que la configuration de votre application est stockée sur un serveur de configuration distant (par exemple, Spring Cloud Config Server).
il est chargé avant application.yml

5. Qu'est ce que l'inversion de controle IOC
Le conteneur IOC est au cœur du framework Spring. 
Il est responsable d’instancier, configurer et assembler les objets, gérer leur cycle de vie complet de la création jusqu’à la destruction. 
Il utilise l’injection de dépendance (DI) pour gérer les éléments qui composent une application.

Il existe deux types de conteneurs IOC :
BeanFactory : Interface qui existe dans la package org.springframework.beans.factory.BeanFactory
ApplicationContext : Interface qui existe dans la package org.springframework.context.ApplicationContext

Différence entre BeanFactory & ApplicationContext :
BeanFactory et ApplicationContext sont des interfaces qui agissent comme des conteneurs IoC.

L’interface ApplicationContext est construite au-dessus de l’interface BeanFactory. Il ajoute quelques fonctionnalités supplémentaires que BeanFactory tels que l’intégration simple avec l’AOP de Spring, la couche application contexte spécifique (par exemple WebApplicationContext) pour les applications Web. Il est donc préférable d’utiliser ApplicationContext que BeanFactory.
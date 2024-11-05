# Projet Kata - Calcul de Taxes

L'objectif est de calculer les taxes sur des produits spécifiques, en prenant en compte différentes règles fiscales, et de générer une facture détaillée.

## Table des matières

- [Description](#description)
- [Instructions d'exécution](#instructions-dexécution)
- [Améliorations possibles](#améliorations-possibles)

---

## Description

L'application calcule les taxes applicables sur différents produits en respectant les règles suivantes :

1. Une taxe de 10 % est appliquée sur chaque produit, sauf pour les livres, la nourriture et les médicaments, qui sont exemptés.
2. Une taxe additionnelle de 5 % est appliquée aux produits importés, sans exception.
3. Les montants des taxes sont arrondis aux 5 centimes supérieurs.

L'application affiche ensuite la facture détaillée pour chaque commande, comprenant :
- Le prix TTC de chaque produit
- Le montant total des taxes
- Le montant total de la commande

## Instructions d'exécution

1. **Compiler le projet** : Utiliser Maven pour compiler les sources :
   ```bash
   mvn clean install
   ```
2. **Exécuter l'application** : Lancer l'application principale pour générer une facture exemple.
3. **Exécuter les tests** : Les tests sont dans le dossier `src/test/java`. Exécuter les tests unitaires avec Maven :
   ```bash
   mvn test
   ```

## Améliorations possibles

1. **Créer des interfaces génériques pour les entrées et sorties** : Actuellement, les produits et les taxes sont renseignés en dur dans le code et la facture ne s'affiche uniquement via la console. Il faudrait créer des interface pour pouvoir modifier le comportement des entrées et sorties plus facilement (utiliser des bases de données, des fichiers, etc).
2. **Extension des catégories de produits** : Actuellement les catégories n'existent pas vraiment. Si on veut ajouter des produits, il n'est pas indiqué explicitement s'ils seront taxé à 10% supplémentaire ou non. Il faudrait créer des catégorie et indiquer en entrée lesquelles sont concernées par la taxe.
3. **Gérer des exceptions** : Actuellement il n'y a pas de gestion en cas de produit en quantité ou prix négatif par exemple. Il faudrait donc gérer ce genre d'erreur afin d'éviter le plantage total de l'application

---

## Auteurs

Développé par ROUVILLE Quentin.
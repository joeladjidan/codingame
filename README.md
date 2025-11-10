# Projet Codingame — Utilitaires et démos Java

Ce dépôt contient plusieurs petites classes Java (Java 17) implémentant des exercices et fonctions utilitaires, chacune accompagnée d'un `main` autonome pour démonstration.

Prérequis
- Java 17 (JDK)
- Maven

Compilation
-----------
Pour compiler le projet :

```bash
mvn -DskipTests compile
```

Exécution des démos
-------------------
Les classes se trouvent dans le package `org.joeladjidan.codingame`. 
Après compilation, exécutez-les depuis le répertoire racine du projet avec :

```bash
java -cp target/classes org.joeladjidan.codingame.<ClassName>
```

Exemples utiles (avec captures de sortie)
----------------------------------------
- `SequenceJoin` — calcule le point de jonction de deux suites définies par `next(n) = n + sumDigits(n)`.

  Commande :

  ```bash
  java -cp target/classes org.joeladjidan.codingame.SequenceJoin
  ```

  Sortie (exemple capturé) :

  ```text
  computeJoinPoint(471, 480) = 519
  computeJoinPoint(34, 41) = 41
  computeJoinPoint(1, 1) = 1
  computeJoinPoint(2, 3) = -1 (no join or invalid input)
  computeJoinPoint(119, 120) = -1 (no join or invalid input)
  ```

  Voir la section "Algorithme et complexité" plus bas pour une explication détaillée.

- `SumRange` / `RangeSummer` — somme les entiers compris dans l'intervalle [10, 100] dans un tableau.

  Commande :

  ```bash
  java -cp target/classes org.joeladjidan.codingame.SumRange
  ```

  Sortie (exemple capturé) :

  ```text
  sumRange(a1) = 0 (attendu 0)
  sumRange(a2) = 160 (attendu 160)
  sumRange(a3) = 121 (attendu 121)
  sumRange(a4) = 0 (attendu 0)
  sumRange(a5) = 220 (attendu 220)
  ```

- `A` et `IsFooDemo` — méthode utilitaire `A.isFoo(String)` (retourne `true` si la chaîne est exactement `"foo"`).

  Commande :

  ```bash
  java -cp target/classes org.joeladjidan.codingame.IsFooDemo
  ```

  Sortie (exemple capturé) :

  ```text
  isFoo(null) = false
  isFoo() = false
  isFoo(foo) = true
  isFoo(Foo) = false
  isFoo( foo ) = false
  isFoo(foobar) = false
  isFoo(foo) = true
  ```

- `AFunction` — fonction `a(i, j)` qui retourne `true` si `i == 1` ou `j == 1` ou `i + j == 1`.

  Commande :

  ```bash
  java -cp target/classes org.joeladjidan.codingame.AFunction
  ```

  Sortie (exemple capturé) :

  ```text
  a(1, 5) => true
  a(2, 3) => false
  a(-3, 4) => true
  a(0, 1) => true
  a(0, 0) => false
  a(-1, 2) => true
  ```

- `ConvertToIntegers` — équivalent Java de la fonction JavaScript `convertToIntegers()` qui parse un tableau de chaînes en entiers (utilise `Integer.parseInt`).

  Commande :

  ```bash
  java -cp target/classes org.joeladjidan.codingame.ConvertToIntegers
  ```

  Sortie (exemple capturé) :

  ```text
  Input = [4, 7, 12]
  Output = [4, 7, 12]
  Empty -> []
  Negatives -> [-1, 0, 100]
  ```

- `DayGains` — implémentation de l'exercice du buffet (méthode `computeDayGains(nbSeats, payingGuests, guestMovements)` et un `main` d'exemple).

  Commande :

  ```bash
  java -cp target/classes org.joeladjidan.codingame.DayGains
  ```

  Sortie (exemple capturé) :

  ```text
  Gains de la journée (exemple) = $80
  ```

Bonnes pratiques et notes
------------------------
- Les classes utilitaires sont dans `src/main/java/org/joeladjidan/codingame`.
- Les méthodes de démonstration (`main`) affichent des cas simples ; adaptez les entrées ou écrivez des tests unitaires pour des jeux de données supplémentaires.
- La méthode `SequenceJoin.computeJoinPoint` marque la trajectoire d'une suite dans un `BitSet` avec une limite de 20_000_000 (conforme à l'énoncé). Elle renvoie `-1` si aucune jonction n'a été trouvée dans ces limites ou si les entrées sont hors bornes.

Algorithme et complexité — `SequenceJoin`
---------------------------------------

But
: Trouver la première valeur commune (point de jonction) entre les deux suites définies par :

  next(n) = n + sumDigits(n)

Propriétés utiles
- next(n) > n pour n > 0 (la suite est strictement croissante).
- La valeur de next(n) est au plus n + 9 * d où d est le nombre de chiffres de n (croissance modérée).

Approche utilisée
1. On fixe une limite explicite LIMIT = 20_000_000 (conforme à l'énoncé).
2. On parcourt la trajectoire de `s1` en calculant `v = next(v)` et on marque chaque valeur rencontrée dans un `BitSet` (index = valeur rencontrée).
   - On arrête si `v >= LIMIT` ou si la valeur a déjà été marquée (détection d'un cycle improbable dans les bornes considérées).
3. Ensuite on parcourt la trajectoire de `s2` ; pour chaque valeur `v` on vérifie si `visited.get(v)` est vrai :
   - Si oui -> `v` est le premier point de jonction (on le retourne).
   - Sinon on continue jusqu'à `v >= LIMIT`.
4. Si aucune valeur commune n'est trouvée < LIMIT, on retourne `-1`.

Complexité
- Temps : O(L1 + L2) où L1 est le nombre d'itérations pour parcourir la trajectoire de `s1` jusqu'à la jonction ou la limite, et L2 est le nombre d'itérations pour `s2` jusqu'à la jonction ou la limite. Dans le pire cas, L1 + L2 est borné par le nombre d'entiers < LIMIT (20M), donc le temps est O(LIMIT) dans le pire cas.
- Mémoire : O(LIMIT) bits pour le `BitSet` (soit environ LIMIT/8 octets). Pour LIMIT = 20_000_000, c'est ~2.5 Mo, ce qui est faible et acceptable pour ce problème.

Alternatives
- Méthode "deux pointeurs" : avancer alternativement la plus petite des deux valeurs (a = next(a) si a < b sinon b = next(b)) jusqu'à égalité. Cette approche est simple et fonctionne dans la plupart des cas. Toutefois elle peut être plus lente en pratique si les trajectoires sont longues et ne permet pas de détecter facilement une absence de jonction sous une borne stricte sans contrôles supplémentaires.
- Stocker la trajectoire de `s2` au lieu de `s1` : symétrique ; on choisit `s1` arbitrairement.

Pourquoi BitSet ?
- Le `BitSet` est compact et offre un accès O(1) pour marquer et tester la présence d'une valeur. 
- Il permet d'identifier rapidement le premier point de jonction sans avoir à parcourir de nombreuses valeurs plusieurs fois.

Dépannage
---------
- Si la méthode retourne `-1`, vérifiez que `s1` et `s2` respectent 0 < s < 20_000_000. Si oui, il est possible que la jonction soit au-delà de la limite ou que l'entrée soit particulière.

Désirez-vous que j'ajoute :
- des tests JUnit couvrant `SequenceJoin` (happy path + limites + cas invalides) ;
- une version alternative implémentant la stratégie deux-pointeurs et une comparaison de performance ;
- des captures de sortie pour d'autres jeux de données que vous voudriez mettre en README ?

---

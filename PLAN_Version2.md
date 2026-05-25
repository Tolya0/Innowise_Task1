# План выполнения 2 части (по шагам)

## Шаг 1. Исправить CustomArray
Файл: `src/main/java/org/kurylin/apptask/entity/CustomArray.java`

Сделать:
- добавить поля `id` и `name`
- реализовать `ArrayObservable`
- добавить список observers
- добавить методы `attach`, `detach`, `notifyObservers`
- вызвать `notifyObservers()` в `setArray()`
- добавить `getId()` и `getName()`
- обновить `equals/hashCode/toString` чтобы учитывались id + name + array
- null‑защита: если array == null → создать пустой массив

---

## Шаг 2. Создать пакет observer
Путь: `src/main/java/org/kurylin/apptask/observer`

Создать:
- `ArrayObservable`
- `ArrayObserver`

В `observer/impl`:
- `ArrayObserverImpl`
  - пересчитывает min/max/sum/avg через ArrayServiceImpl
  - кладёт статистику в Warehouse

---

## Шаг 3. Создать пакет warehouse
Путь: `src/main/java/org/kurylin/apptask/warehouse`

Создать:
- `ArrayStats` (min, max, sum, avg)
- `Warehouse` (Singleton, Map<id, ArrayStats>)
- Warehouse НЕ implements Observer

---

## Шаг 4. Создать пакет repository
Путь: `src/main/java/org/kurylin/apptask/repository`

Создать:
- `ArrayRepository` (add/remove/query/sort)

В `repository/impl`:
- `ArrayRepositoryImpl` (Singleton, List<CustomArray>)

---

## Шаг 5. Создать пакет specification
Путь: `src/main/java/org/kurylin/apptask/specification`

Создать:
- `ArraySpecification` (functional interface)

В `specification/impl` создать:
- `IdSpecification`
- `NameEqualsSpecification`
- `NameContainsSpecification`
- `NameStartsWithSpecification`
- `SumGreaterThan / SumLessThan / SumEquals`
- `AverageGreaterThan / AverageLessThan / AverageEquals`
- `MaxGreaterThan / MaxLessThan / MaxEquals`
- `MinGreaterThan / MinLessThan / MinEquals`
- `SizeGreaterThan / SizeLessThan / SizeEquals`

---

## Шаг 6. Создать пакет comparator
Путь: `src/main/java/org/kurylin/apptask/comparator`

Создать:
- `ArrayIdComparator`
- `ArrayNameComparator`
- `ArrayFirstElementComparator`
- `ArraySizeComparator`

---

## Шаг 7. Минимальный Main (только демонстрация)
Файл: `src/main/java/org/kurylin/Main.java`

Сделать:
- создать 2 массива `CustomArray(id/name/array)`
- создать `ArrayObserverImpl` и attach к массивам
- добавить массивы в `ArrayRepositoryImpl`
- выполнить `query` (например SumGreaterThanSpecification)
- выполнить `sort` (например ArrayIdComparator)
- вызвать `setArray(...)` чтобы проверить обновление Warehouse

Main нужен только для демонстрации, основная проверка — тестами.

---

## Шаг 8. Тесты (JUnit)

Путь: `src/test/java/org/kurylin/apptask`

### 8.1. Тесты для CustomArray
- проверка генерации id и name
- проверка notifyObservers при setArray

### 8.2. Тесты для Warehouse
- put/get/remove
- корректность stats после обновления массива

### 8.3. Тесты для Repository
- add/remove
- query по спецификациям
- sort по компараторам

### 8.4. Тесты для Specification
- sum/avg/max/min/size (<, >, =)
- name equals/contains/startsWith

### 8.5. Тесты для Comparator
- сортировка по id/name/first element/size

---

## Шаг 9. Финальная проверка
- все тесты проходят
- при изменении массива Warehouse обновляется
- спецификации фильтруют корректно
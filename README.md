## Temas que estudei neste repositório

- [Programação Imperativa](#programação-imperativa)
- [Programação Funcional](#programação-funcional)
- [Expressões Lambda](#expressões-lambda)
    - [Sintaxe Lambda](#sintaxe-da-lambda)
    - [Usos das expressões lambda](#usos-das-expressões-lambda)
- [Interfaces Funcionais](#interfaces-funcionais)
- [Runnable](#runnable)
- [Interfaces Funcionais](#interfaces-funcionais)
- [Consumer](#consumer)
    - [Conceitos Teóricos](#conceitos-teóricos)
    - [Usos no método foreach](#usos-no-método-foreach)
    - [Aplicações Práticas](#aplicações-práticas)
    - [Estrutura do Código](#estrutura-do-código)
    - [Métodos](#métodos)
    - [Método Principal](#método-principal)
- [BiConsumer](#biconsumer)
    - [Objetivo](#objetivo)
    - [Conceitos Teóricos](#conceitos-teóricos-biconsumer)
    - [Estrutura do Código](#estrutura-do-código-biconsumer)
    - [Métodos](#métodos-biconsumer)
    - [Método Principal](#método-principal-biconsumer)
- [Predicate](#predicate)
    - [Usos do Predicate](#usos-do-predicate)
- [A expressão direta é um Predicate](#a-expressão-direta-é-um-predicate)
- [Quando usar Predicados Definidos versus Expressões Diretas](#quando-usar-predicados-definidos-versus-expressões-diretas)
- [BiPredicate](#bipredicate)
- [Function\<T, R>](#functiont-r)
- [BiFunction em Java](#bifunction-em-java)
- [BiFunction e Streams](#bifunction-e-streams)
- [UnaryOperator](#unaryoperator)
- [BinaryOperator](#binaryoperator)
- [Method Reference](#method-reference)
- [Constructor Reference](#constructor-reference)
- [Lambda Local Variables](#lambda-e-variáveis-locais)
- [Introdução à Streams API](#introdução-à-streams-api)
    - [Stream Operation - map()](#stream-operation---map)
    - [Stream Operation - flatMap()](#stream-operation---flatmap)
    - [Stream Operation - distinct(), count(), sorted()](#stream-operation---distinct-count-sorted)
    - [Stream Operation - Customized sort using comparator](#stream-operation---customized-sort-using-comparator)
    - [Stream Operation - filter()](#stream-operation---filter)
    - [Stream Operation - reduce()](#stream-operation---reduce)
    - [Stream Operation - Map + Filter + Reduce Pattern](#stream-operation---map--filter--reduce-pattern)
    - [Stream Operation - max() using reduce() function](#stream-operation---max-using-reduce-function)
    - [Stream Operation - min() using reduce() function](#stream-operation---min-using-reduce-function)
    - [Stream Operation - limit() and skip()](#stream-operation---limit-and-skip)
    - [Stream Operation - allMatch(), anyMatch and noneMatch()](#stream-operation---allmatch-anymatch-and-nonematch)
    - [Stream Operation - findAny() and findFirst()](#stream-operation---findany-and-findfirst)

- [Comparação: Collections vs. Streams](#comparação-collections-vs-streams)
- [Debugando Streams](#debugando-streams)
- [](#)

### Programação Imperativa

- **Foco no "como"**: Define passo a passo como as operações devem ser realizadas.
- **Mutabilidade do objeto**: Modifica diretamente o estado de objetos para alcançar um objetivo.
- **Detalhamento das etapas**: Escrevemos código descrevendo o que precisa ser feito em cada passo.
- **Relacionamento com POO**: É o estilo predominante na Programação Orientada a Objetos clássica.

```java
List<Integer> quantities = Arrays.asList(10, 20, 15, 30);
int total = 0;
for(
int quantity :quantities){
total +=quantity;
}
        System.out.

println("Total de produtos: "+total);

```

### Programação Funcional

- **Imutabilidade**: Trabalha com objetos imutáveis, reduzindo efeitos colaterais.
- **Código conciso e legível**: Usa funções e métodos como elementos principais.
- **Foco no "o que"**: Concentra-se no resultado desejado, não no processo para obtê-lo.
- **Exemplo prático**:

```java
List<Integer> quantities = Arrays.asList(10, 20, 15, 30);
int total = quantities.stream().mapToInt(Integer::intValue).sum();
System.out.

println("Total de produtos: "+total);
```

- **Comparação com SQL**: Assim como em SQL, declaramos o que queremos obter, sem detalhar como alcançar isso.
- **Aproveitamento de bibliotecas**: Faz uso extensivo de funções e ferramentas já disponíveis.
- **Estilo declarativo**: Está alinhada ao paradigma de programação declarativa.

### **Expressões Lambda**

As expressões lambda são equivalentes a funções (ou métodos) sem um nome, também conhecidas como **funções anônimas**.
Elas possuem todas as características de um método tradicional, como:

- **Parâmetros**: Permitem a entrada de valores.
- **Corpo do método**: Contêm a lógica a ser executada.
- **Tipo de retorno**: Podem retornar valores como qualquer outro método.

Diferentemente de métodos normais, lambdas não estão vinculadas a uma classe específica. Elas podem ser atribuídas a
variáveis e até mesmo passadas como argumentos.

### **Sintaxe da Lambda**

A estrutura básica de uma expressão lambda é:

```java
(parametros)->{
corpo da
função }
```  

Exemplo vazio:

```java
()->{}
```  

---

### **Usos das Expressões Lambda**

O principal objetivo das lambdas é implementar **interfaces funcionais** (também chamadas de **SAM interfaces**), que
possuem **apenas um método abstrato**. Essas interfaces são marcadas com a anotação `@FunctionalInterface`.

## Interfaces funcionais

Uma interface funcional é uma ‘interface’ que tem **apenas** um método abstrato. isso significa que lea foi projetada
para
representar **uma única funcionalidade**. Em Java, essas interfaces são frequentemente usadas para suportar expressões
lambda e métodos de referência.

Exemplo simples de 'interface' funcional:

```java

@FunctionalInterface
interface Operacao {
    int executar(int a, int b);
}
```

Quando utilizamos uma **expressão lambda**, estamos implementando o método abstrato daquela interface funcional de forma
concisa, sem precisarmso escrever toda a estrutura de uma classe ou em método anônimo.

Exemplo simples de uso:

```java
public class Main() {
    public static void main(String[] args) {
        // Atribuindo uma lambda à interface funcional
        Operacao soma = (a, b) -> (a + b);
        Operacao multiplicacao = (a, b) -> (a * b);

        // Utilizando o método abstrato da interface funcional
        System.out.println("Soma: " + soma.executar(5, 3)); // resultado "Soma : 8)
        System.out.println("Multiplicação: " + multiplicacao.executar(5, 3)); // resultado "Multiplicação: 8)
    }
}
```

#### Como a lambda funciona aqui?

1. A lambda `(a,b) -> (a + b)` está "implementando" o método abstrato `executar(int a, int b)` da interface funcional
   Operacao
2. Quando chamamos `soma.executar(5,3)`, o Java entende que ele deve usar a lógica definida na lambda `(a,b) -> (a+b)`

**Exemplos de interfaces funcionais comuns**:

- `Comparator`
- `Runnable`

## Runnable

Exemplos antes e depois do Java 8

Antes:

```java
        Runnable runnable = new Runnable() {
    @Override
    public void run() {
        System.out.println("Inside Runnable");
    }
};

        new

Thread(runnable).

start();
```

depois:

```java
Runnable runnable = () -> System.out.println("Inside Runnable");
    new

Thread(runnable).

start();
```

Lembrando que quando é apenas uma declaração podemos utilizar sem as {}, Ex:

```java
 Runnable runnable = () -> System.out.println("Inside Runnable");
```

Mais que uma declaração precisamos das chames

```java
Runnable runnable = () -> {
    System.out.println("Inside Runnable");
    System.out.println("Inside Runnable");
};
```

As lambdas oferecem uma forma mais concisa e legível de implementar essas interfaces, tornando o código mais enxuto e
fácil de entender.

### Interfaces funcionais

## Consumer:

Demonstrar como:

1. Definir consumidores personalizados para executar ações específicas em objetos.
2. Encadear consumidores usando o método `andThen` para realizar operações sequenciais.
3. Filtrar elementos de uma coleção com base em condições específicas antes de aplicar consumidores.

### Conceitos Teóricos

### Interface `Consumer`

A interface funcional `Consumer<T>` é usada para definir operações que processam um único argumento sem retornar
valores. É frequentemente empregada em APIs de coleção, como no método `forEach`, para realizar ações sobre elementos de
forma declarativa.

- **Método funcional:** `void accept(T t)`
    - Recebe um argumento do tipo `T` e executa uma ação definida no corpo da implementação.

- **Encadeamento:** O método padrão `andThen` permite compor dois consumidores, executando ambos na sequência sobre o
  mesmo argumento.
  ```java
  default Consumer<T> andThen(Consumer<? super T> after) {
      Objects.requireNonNull(after);
      return (T t) -> { accept(t); after.accept(t); };
  }
  ```

### Uso no Método `forEach`

O método `forEach` é uma operação terminal fornecida pelas coleções e streams em Java. Ele aceita um `Consumer` e
executa a ação definida sobre cada elemento da coleção ou stream.

```java
void forEach(Consumer<? super T> action);
```

### Aplicações Práticas

- **Impressão de valores.**
- **Modificação de elementos.**
- **Registros de log ou operações auxiliares.**

### Estrutura do Código

```java
public static List<Student> studentList = StudentDataBase.getAllStudents();
public static Consumer<Student> consumerStudentName = (student) -> System.out.println(student.getName());
public static Consumer<Student> consumerStudentActivities = (student) -> System.out.println(student.getActivities());
```

- **`studentList`**: Uma lista de objetos do tipo `Student`, representando uma coleção a ser processada.
- **Consumidores:**
    - `consumerStudentName`: Imprime o nome do estudante.
    - `consumerStudentActivities`: Imprime as atividades do estudante.

### Métodos

#### `printName`

Aplica o consumidor `consumerStudentName` para imprimir o nome de todos os estudantes.

```java
public static void printName() {
    studentList.forEach(consumerStudentName);
}
```

#### `printNameAndActivities`

Encadeia os consumidores `consumerStudentName` e `consumerStudentActivities` para imprimir nome e atividades de cada
estudante.

```java
public static void printNameAndActivities() {
    studentList.forEach(consumerStudentName.andThen(consumerStudentActivities));
}
```

#### `printNameAndActivitiesWithFilter`

Filtra estudantes com base em condições específicas (nível >= 3 e GPA >= 4) e, em seguida, aplica os consumidores
encadeados.

```java
public static void printNameAndActivitiesWithFilter() {
    studentList.forEach(student -> {
        if (student.getGradeLevel() >= 3 && student.getGpa() >= 4) {
            consumerStudentName.andThen(consumerStudentActivities).accept(student);
        }
    });
}
```

### Método Principal

Demonstra o uso de um consumidor simples, além de executar os métodos definidos para ilustrar as funcionalidades
implementadas.

```java
public static void main(String[] args) {
    Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
    c1.accept("java8");

    printName();
    printNameAndActivities();
    printNameAndActivitiesWithFilter();
}
```

## BiConsumer:

Este exemplo explora o uso da interface funcional `BiConsumer` do Java 8, que faz parte do pacote `java.util.function`.
A interface `BiConsumer` representa uma operação que aceita dois argumentos de entrada e não retorna nenhum resultado.
Este exemplo demonstra como usar `BiConsumer` para processar pares de valores e realizar operações personalizadas.

### Objetivo

Demonstrar como:

1. Definir consumidores personalizados que operam sobre dois argumentos.
2. Encadear operações usando o método `andThen`.
3. Utilizar `BiConsumer` em cenários práticos como manipulação de dados de objetos complexos.

### Conceitos Teóricos Biconsumer

### Interface `BiConsumer`

A interface funcional `BiConsumer<T, U>` é usada para definir operações que processam dois argumentos sem retornar
valores. Assim como `Consumer`, ela é frequentemente utilizada em operações onde múltiplos valores precisam ser
processados simultaneamente.

- **Método funcional:** `void accept(T t, U u)`
    - Recebe dois argumentos do tipo `T` e `U` e executa a ação definida na implementação.

- **Encadeamento:** O método padrão `andThen` permite compor dois `BiConsumers`, executando ambos na sequência sobre os
  mesmos argumentos.
  ```java
  default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
      Objects.requireNonNull(after);
      return (t, u) -> {
          accept(t, u);
          after.accept(t, u);
      };
  }
  ```

### Estrutura do Código Biconsumer

- **`listStudent`**: Uma lista de objetos do tipo `Student`, representando os dados a serem processados.
- **Exemplos de `BiConsumer`**:
    - Operações matemáticas simples como multiplicação e divisão.
    - Processamento de dados de estudantes (nome e atividades).

### Métodos Biconsumer

#### `printUserNameAndUserActivities`

Usa um `BiConsumer` para processar e imprimir o nome e as atividades de cada estudante.

```java
    public static void printUserNameAndUserActivities() {
    BiConsumer<String, List<String>> studentNameAndActivities = (studentName, studentActivities) -> {
        System.out.println("Student name: " + studentName + ", " + "Student Activities: " + studentActivities);
    };

    /*forEach espera um Consumer
     *
     * BiConsumer precisa de dois parâmetros
     * O lambda '(student) -> studentNameAndActivities.accept(student.getName(), student.getActivities())' funciona como
     * um adaptador, pegando um Student e extraindo os dois argumentos necessários para o BiConsumer
     *
     * */
    listStudent.forEach((student) -> studentNameAndActivities.accept(student.getName(), student.getActivities()));
}
```

### Método Principal Biconsumer

Demonstra o uso de `BiConsumer` em diferentes contextos:

1. Operações básicas de texto com dois argumentos.
2. Operações matemáticas como multiplicação e divisão, com tratamento de erro (divisão por zero).
3. Aplicação de `BiConsumer` para processar dados de estudantes.

```java
public static void main(String[] args) {

    BiConsumer<String, String> biConsumer = (a, b) -> {
        System.out.println("a : " + a + ", b: " + b);
    };

    biConsumer.accept("Java 8", "JAVA!");

    BiConsumer<Double, Double> biconsumerMultiplication = (a, b) -> {
        System.out.println(a + " x " + b + " = " + a * b);
    };
    biconsumerMultiplication.accept(2.0, 3.0);

    BiConsumer<Double, Double> biconsumerDivision = (a, b) -> {
        if (b == 0) {
            System.out.println("Division by 0 not allowed");
        } else {
            System.out.println(a + " / " + b + " = " + a / b);
        }
    };

    biconsumerMultiplication.andThen(biconsumerDivision).accept(3.0, 9.0);

    printUserNameAndUserActivities();
}
```

## Predicate

A interface `Predicate` em Java é usada para representar uma função que avalia um argumento e retorna um valor booleano.
Ela é amplamente utilizada com streams e coleções para filtragem e composição lógica.

### Usos do `Predicate`

#### 1. **Definido previamente (uso indireto)**

Os predicados podem ser definidos como variáveis estáticas ou locais e reutilizados em várias partes do código. Veja um
exemplo:

```java
import com.technical.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    static Predicate<Student> studentPredicateGrade = student -> student.getGradeLevel() >= 3;
    static Predicate<Student> studentPredicateGPA = student -> student.getGpa() >= 4;
    static List<Student> listOfStudents = new ArrayList<>();

    public static void main(String[] args) {
        listOfStudents.stream()
                .filter(studentPredicateGrade.and(studentPredicateGPA)) // utilizando os Predicate definidos anterioremente
                .forEach(student -> System.out.println("Students with grade >= 3 AND GPA >= 4: " + student));
    }
}
```

- **Vantagens**:
    - Reutilização: Pode ser usado em diferentes partes do código.
    - Composição: Permite combinar predicados com os métodos `and`, `or` ou `negate`.

#### 2. **Usado diretamente (expressão inline)**

Podemos usar expressões lambda diretamente no método `filter`:

```java
import com.technical.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    static List<Student> listOfStudents = new ArrayList<>();

    public static void main(String[] args) {
        listOfStudents.stream()
                .filter(student -> student.getGradeLevel() >= 3 && student.getGpa() >= 4) // Expressão direta
                .forEach(student -> System.out.println("Students with grade >= 3 AND GPA >= 4: " + student));
    }
}
```

- **Vantagens**:
    - Simplicidade: Ideal para condições que serão usadas uma única vez.
    - Legibilidade local: O código fica direto e fácil de entender.

### **A expressão direta é um `Predicate`?**

Sim! Uma expressão lambda como `student -> student.getGradeLevel() >= 3 && student.getGpa() >= 4` é considerada um
`Predicate`. Isso porque ela:

- Recebe um único argumento (`Student`).
- Retorna um valor booleano.
- Atende à assinatura funcional da interface `Predicate<T>`.

Em Java, expressões lambda podem ser usadas onde interfaces funcionais são esperadas, como no método `filter`, que
aceita um `Predicate<T>`.

---

### **Quando usar predicados definidos versus expressões diretas?**

#### Use **predicados definidos** quando:

1. **Reutilização:** Usaremos a mesma lógica em várias partes do código.
2. **Composição:** Combinações complexas de condições são necessárias.
   ```java
   Predicate<Student> complexCondition = studentPredicateGrade.and(studentPredicateGPA).or(studentStartsWithJ);
   ```

#### Use **expressões diretas** quando:

1. **Simplicidade:** A condição será usada uma única vez.
2. **Legibilidade local:** O código é curto e simples.

## BiPredicate

A interface `BiPredicate` em Java faz parte do pacote `java.util.function` e é utilizada para representar uma função que
avalia dois argumentos e retorna um valor booleano.

## Assinatura da Interface

```java

@FunctionalInterface
public interface BiPredicate<T, U> {
    boolean test(T t, U u);

    default BiPredicate<T, U> and(BiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other);
        return (t, u) -> test(t, u) && other.test(t, u);
    }

    default BiPredicate<T, U> or(BiPredicate<? super T, ? super U> other) {
        Objects.requireNonNull(other);
        return (t, u) -> test(t, u) || other.test(t, u);
    }

    default BiPredicate<T, U> negate() {
        return (t, u) -> !test(t, u);
    }
}
```

## Características Principais

- **Dois argumentos:** Aceita dois argumentos de tipos genéricos `T` e `U`.
- **Retorno booleano:** Sempre retorna um valor booleano com base na lógica definida.
- **Métodos padrão:** Fornece métodos para combinar lógicas com `and`, `or` e `negate`.
- **Interface funcional:** Pode ser usado com expressões lambda ou referências de método.

## Exemplo de Uso

### Exemplo 1: Verificar se a soma de dois números é maior que um limite

```java
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> isSumGreaterThan = (a, b) -> (a + b) > 10;

        System.out.println(isSumGreaterThan.test(5, 6)); // true
        System.out.println(isSumGreaterThan.test(4, 4)); // false
    }
}
```

### Exemplo 2: Comparar strings ignorando maiúsculas e minúsculas

```java
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        BiPredicate<String, String> areEqualIgnoreCase = (s1, s2) -> s1.equalsIgnoreCase(s2);

        System.out.println(areEqualIgnoreCase.test("Hello", "hello")); // true
        System.out.println(areEqualIgnoreCase.test("Java", "Python")); // false
    }
}
```

### Exemplo 3: Compondo Predicados

```java
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> isSumGreaterThan10 = (a, b) -> (a + b) > 10;
        BiPredicate<Integer, Integer> areBothPositive = (a, b) -> a > 0 && b > 0;

        BiPredicate<Integer, Integer> combinedPredicate = isSumGreaterThan10.and(areBothPositive);

        System.out.println(combinedPredicate.test(5, 6)); // true
        System.out.println(combinedPredicate.test(-5, 6)); // false
    }
}
```

### Exemplo 4: Usando `BiPredicate` em uma Stream

#### Definindo o `BiPredicate` separadamente

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int threshold = 3;

        BiPredicate<Integer, Integer> isGreaterThanThreshold = (num, th) -> num > th;

        numbers.stream()
                .filter(num -> isGreaterThanThreshold.test(num, threshold))
                .forEach(num -> System.out.println("Number greater than " + threshold + ": " + num));
    }
}
```

#### Usando o `BiPredicate` diretamente na Stream

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int threshold = 3;

        numbers.stream()
                .filter(num -> (num > threshold)) // BiPredicate em linha
                .forEach(num -> System.out.println("Number greater than " + threshold + ": " + num));
    }
}
```

## Quando Usar

- Quando precisamos de uma lógica que envolve **dois argumentos** e retorna um valor booleano.
- Ao combinar ou reutilizar condições complexas em streams, ou outras operações funcionais.

## Diferença entre `Predicate` e `BiPredicate`

| Característica       | Predicate                               | BiPredicate                      |
|----------------------|-----------------------------------------|----------------------------------|
| Número de argumentos | 1                                       | 2                                |
| Uso típico           | Filtragem ou teste de um único elemento | Teste que envolve dois elementos |

### Exemplo Comparativo

**Predicate:**

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.

println(isEven.test(4)); // true
```

**BiPredicate:**

```java
BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
System.out.

println(isSumEven.test(3, 5)); // true
```

## Function\<T, R>

A interface `Function<T, R>` em Java faz parte do pacote `java.util.function` e é usada para representar uma função que
aceita um único argumento do tipo `T` e retorna um resultado do tipo `R`.

## Assinatura da Interface

```java

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);

    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
```

## Características Principais

- **Um argumento e um resultado:** Recebe um argumento de tipo `T` e retorna um resultado de tipo `R`.
- **Métodos padrão:** Permite a composição de funções com os métodos `compose` e `andThen`.
- **Método estático:** O método `identity` retorna uma função que simplesmente devolve o mesmo valor que recebe.
- **Interface funcional:** Pode ser usada com expressões lambda ou referências de método.

## Exemplos de Uso

### Exemplo 1: Converter String para Inteiro

```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> stringToInteger = Integer::valueOf;

        System.out.println(stringToInteger.apply("123")); // 123
    }
}
```

### Exemplo 2: Obter o comprimento de uma String

```java
Fuunnction<String, Integer> stringLength = String::length;

        System.out.

println(stringLength.apply("Hello")); // 5
        }
        }
```

### Exemplo 3: Compor Funções

```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> stringToInteger = Integer::valueOf;
        Function<Integer, Integer> square = x -> x * x;

        Function<String, Integer> squareOfStringNumber = stringToInteger.andThen(square);

        System.out.println(squareOfStringNumber.apply("4")); // 16
    }
}
```

### Exemplo 4: Identidade

```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, String> identityFunction = Function.identity();

        System.out.println(identityFunction.apply("Hello")); // Hello
    }
}
```

## Quando Usar

- **Transformações:** Quando precisamos converter ou mapear um valor de um tipo para outro.
- **Composições:** Para combinar múltiplas funções em uma sequência lógica.

## Diferença entre `Function`, `BiFunction` e Outras Interfaces Relacionadas

| Interface             | Número de argumentos | Tipo de Retorno |
|-----------------------|----------------------|-----------------|
| `Function<T, R>`      | 1                    | R               |
| `BiFunction<T, U, R>` | 2                    | R               |
| `UnaryOperator<T>`    | 1                    | T (mesmo tipo)  |
| `Predicate<T>`        | 1                    | boolean         |

### Exemplo Comparativo

**Function:**

```java
Function<String, Integer> stringToLength = String::length;
System.out.

println(stringToLength.apply("Java")); // 4
```

**BiFunction:**

```java
BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
System.out.

println(multiply.apply(3, 5)); // 15
```

**UnaryOperator:**

```java
UnaryOperator<Integer> square = x -> x * x;
System.out.

println(square.apply(5)); // 25
```

## BiFunction em Java

A interface `BiFunction<T, U, R>` em Java faz parte do pacote `java.util.function` e é usada para representar uma função
que aceita dois argumentos, do tipo `T` e `U`, e retorna um resultado do tipo `R`. Essa interface é especialmente útil
quando se trabalha com operações que exigem dois parâmetros de entrada.

## Definição

```java

@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);

    default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }

    static <T, U> BiFunction<T, U, Boolean> andThen(Predicate<? super R> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.test(apply(t, u));
    }
}
```

- **`apply(T t, U u)`**: Método que aplica a função, recebendo dois parâmetros e retornando um resultado.
- **`andThen(Function<? super R, ? extends V> after)`**: Método que permite compor a função com outra função após a
  execução.

## Características

- **Dois argumentos e um resultado:** Recebe dois argumentos de tipos `T` e `U`, e retorna um valor de tipo `R`.
- **Método `andThen`**: Permite encadear uma função após a execução da função original.
- **Interface funcional**: Pode ser usada com expressões lambda ou referências de método.

## Exemplos de Uso

### Exemplo 1: Somar Dois Números

```java
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        System.out.println(add.apply(5, 3)); // 8
    }
}
```

### Exemplo 2: Concatenar Duas Strings

```java
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + s2;

        System.out.println(concatenate.apply("Hello, ", "World!")); // Hello, World!
    }
}
```

### Exemplo 3: Compor Funções com `andThen`

```java
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toString = (x) -> "Resultado: " + x;

        BiFunction<Integer, Integer, String> multiplyAndConvert = multiply.andThen(toString);

        System.out.println(multiplyAndConvert.apply(3, 5)); // Resultado: 15
    }
}
```

## BiFunction e Streams

A interface `BiFunction` também pode ser usada em conjunto com a API de Streams para realizar operações que envolvem
dois argumentos. Ela pode ser útil, por exemplo, ao combinar dois elementos de um stream.

### Exemplo 1: Reduzir Dois Fluxos em Um Valor Comum

Imagine que temos dois fluxos de inteiros e queremos somá-los em um único valor:

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        int sum = Stream.iterate(0, i -> i + 1)
                .limit(Math.min(list1.size(), list2.size()))
                .map(i -> add.apply(list1.get(i), list2.get(i)))
                .reduce(0, Integer::sum);

        System.out.println(sum); // 21
    }
}
```

### Exemplo 2: Combinação de Valores em Um `Map`

Se tivermos dois fluxos e quiser combinar os valores de ambos em um mapa, podemos usar `BiFunction` com a operação de
redução:

```java
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> keys = Stream.of("A", "B", "C");
        Stream<Integer> values = Stream.of(1, 2, 3);

        BiFunction<String, Integer, String> combine = (key, value) -> key + value;

        Map<String, String> map = Stream
                .zip(keys, values, combine)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(map); // {A=1, B=2, C=3}
    }
}
```

## Comparação com Outras Interfaces

| Interface             | Número de argumentos | Tipo de Retorno |
|-----------------------|----------------------|-----------------|
| `BiFunction<T, U, R>` | 2                    | R               |
| `Function<T, R>`      | 1                    | R               |
| `UnaryOperator<T>`    | 1                    | T               |
| `Predicate<T>`        | 1                    | boolean         |

# UnaryOperator

A interface `UnaryOperator<T>` é uma especialização de `Function<T, T>`. Ela é usada quando precisamos aplicar uma
operação num valor e retornar o mesmo tipo. Em outras palavras, tanto o tipo de entrada quanto o tipo de saída são do
tipo `T`.

## Definição

```java

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
    T apply(T t);
}
```

- **`apply(T t)`**: Método que aplica a função no parâmetro `t` e retorna um resultado do mesmo tipo `T`.

## Características

- **Mesma entrada e saída:** A principal característica do `UnaryOperator` é que ele recebe um parâmetro do tipo `T` e
  retorna um resultado do mesmo tipo.
- **Especialização de `Function`**: `UnaryOperator` é uma subinterface de `Function`, mas com a conveniência de
  trabalhar com o mesmo tipo para entrada e saída.
- **Interface funcional**: Pode ser usada com expressões lambda ou referências de método.

## Exemplos de Uso

### Exemplo 1: Elevar um Número ao Quadrado

```java
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = x -> x * x;

        System.out.println(square.apply(5)); // 25
    }
}
```

### Exemplo 2: Converter uma String para Maiúsculas

```java
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<String> toUpperCase = str -> str.toUpperCase();

        System.out.println(toUpperCase.apply("hello")); // HELLO
    }
}
```

### Exemplo 3: Aplicar um Operador de Identidade

O método `identity()` retorna uma função que apenas retorna o valor recebido, sem alterações.

```java
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<String> identity = UnaryOperator.identity();

        System.out.println(identity.apply("Java")); // Java
    }
}
```

### Exemplo 4: Usando `UnaryOperator` com Streams

Se tivermos uma lista de inteiros e quiser aplicar uma transformação (como multiplicar por 2), podemos usar
`UnaryOperator` em combinação com Streams.

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        UnaryOperator<Integer> doubleValue = x -> x * 2;

        List<Integer> doubledNumbers = numbers.stream()
                .map(doubleValue)
                .collect(Collectors.toList());

        System.out.println(doubledNumbers); // [2, 4, 6, 8, 10]
    }
}
```

## Comparação com Outras Interfaces

| Interface             | Número de argumentos | Tipo de Retorno |
|-----------------------|----------------------|-----------------|
| `UnaryOperator<T>`    | 1                    | T               |
| `Function<T, R>`      | 1                    | R               |
| `BiFunction<T, U, R>` | 2                    | R               |
| `Predicate<T>`        | 1                    | boolean         |

`UnaryOperator<T>` é útil quando desejamos aplicar uma transformação ou operação sobre um valor de tipo `T` e obter o
mesmo tipo `T` como resultado. Sua simplicidade e foco em tipos homogêneos (mesmo tipo de entrada e saída) tornam essa
interface funcional bastante prática para várias operações.

## BinaryOperator

A interface `BinaryOperator<T>` é uma especialização de `BiFunction<T, T, T>`. Ela é usada quando precisamos aplicar
uma operação em **dois valores do mesmo tipo** e retornar um valor também do mesmo tipo. Em outras palavras, tanto os
parâmetros de entrada quanto o resultado são do tipo `T`.

## Definição

```java

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    T apply(T t1, T t2);
}
```

- **`apply(T t1, T t2)`**: Método que aplica a operação nos dois parâmetros `t1` e `t2`, ambos do tipo `T`, e retorna um
  resultado do mesmo tipo `T`.

## Características

- **Dois argumentos e um resultado:** Ambos os parâmetros são do tipo `T`, e o resultado também será do tipo `T`.
- **Especialização de `BiFunction`**: `BinaryOperator` é uma subinterface de `BiFunction`, mas com a conveniência de
  trabalhar com o mesmo tipo para ambos os parâmetros e o resultado.
- **Interface funcional**: Pode ser usada com expressões lambda ou referências de método.

## Exemplos de Uso

### Exemplo 1: Somar Dois Números

Aqui, a operação é a soma de dois números inteiros:

```java
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (a, b) -> a + b;

        System.out.println(add.apply(5, 3)); // 8
    }
}
```

### Exemplo 2: Subtrair Dois Números

Aqui, a operação é a subtração de dois números inteiros:

```java
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> subtract = (a, b) -> a - b;

        System.out.println(subtract.apply(10, 4)); // 6
    }
}
```

### Exemplo 3: Multiplicar Dois Números

Aqui, a operação é a multiplicação de dois números inteiros:

```java
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        System.out.println(multiply.apply(6, 7)); // 42
    }
}
```

### Exemplo 4: Dividir Dois Números (Evitar Divisão por Zero)

Neste exemplo, realizamos uma divisão e garantimos que não ocorra divisão por zero:

```java
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> divide = (a, b) -> b != 0 ? a / b : 0;

        System.out.println(divide.apply(10, 2)); // 5
        System.out.println(divide.apply(10, 0)); // 0 (divisão por zero)
    }
}
```

### Exemplo 5: Concatenar Duas Strings

Neste exemplo, concatenamos duas strings usando `BinaryOperator`:

```java
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<String> concatenate = (s1, s2) -> s1 + s2;

        System.out.println(concatenate.apply("Hello, ", "World!")); // Hello, World!
    }
}
```

### Exemplo 6: Determinar o Máximo de Dois Valores

Aqui, usamos o `BinaryOperator` para encontrar o maior valor entre dois números:

```java
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;

        System.out.println(max.apply(10, 20)); // 20
        System.out.println(max.apply(30, 25)); // 30
    }
}
```

### Exemplo 7: Determinar o Mínimo de Dois Valores

Neste exemplo, usamos `BinaryOperator` para encontrar o menor valor entre dois números:

```java
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> min = (a, b) -> a < b ? a : b;

        System.out.println(min.apply(15, 25)); // 15
        System.out.println(min.apply(10, 5));  // 5
    }
}
```

## Exemplos com Streams

Agora, vamos ver alguns exemplos de como usar `BinaryOperator` em conjunto com Streams.

### Exemplo 1: Encontrar o Máximo de Uma Lista de Números

Aqui, usamos o `reduce` para aplicar a operação de encontrar o máximo em uma lista de números:

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;

        Integer maxNumber = numbers.stream()
                .reduce(max)
                .orElseThrow(() -> new RuntimeException("Lista está vazia"));

        System.out.println(maxNumber); // 5
    }
}
```

### Exemplo 2: Soma de Todos os Elementos de Uma Lista

Aqui, usamos o `reduce` para somar todos os números de uma lista:

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        BinaryOperator<Integer> sum = (a, b) -> a + b;

        Integer totalSum = numbers.stream()
                .reduce(sum)
                .orElse(0);

        System.out.println(totalSum); // 15
    }
}
```

### Exemplo 3: Combinar Elementos em um `Map`

Neste exemplo, usamos `BinaryOperator` para combinar elementos de duas listas em um `Map`:

```java
import java.util.*;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        List<String> keys = Arrays.asList("A", "B", "C");
        List<Integer> values = Arrays.asList(1, 2, 3);

        BinaryOperator<Integer> sum = (a, b) -> a + b;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.merge(keys.get(i), values.get(i), sum);
        }

        System.out.println(map); // {A=1, B=2, C=3}
    }
}
```

## Comparação com Outras Interfaces

| Interface             | Número de argumentos | Tipo de Retorno |
|-----------------------|----------------------|-----------------|
| `BinaryOperator<T>`   | 2                    | T               |
| `BiFunction<T, U, R>` | 2                    | R               |
| `UnaryOperator<T>`    | 1                    | T               |
| `Function<T, R>`      | 1                    | R               |

`BinaryOperator<T>` é útil quando precisamos aplicar uma operação sobre dois valores do mesmo tipo e obter um
resultado do mesmo tipo. A simplicidade e a especialização dessa interface tornam-na ideal para muitas operações
matemáticas, lógicas ou de combinação de elementos. Além disso, seu uso com Streams permite realizar operações
eficientes e concisas em coleções de dados.

# Method Reference

Disponível como parte do Java 8, seu propósito é simplificar a implementação de interfaces funcionais.
Um atalho para escrever expressões Lambda, referindo-se diretamente a um método de uma classe.

### Sintaxe

```java
ClassName::instance-methodName
ClassName::static-methodName
Instance::methodName
```

### Quando usar Method Reference

Method References são úteis quando uma expressão lambda apenas chama um método existente sem adicionar lógica extra.

#### Exemplo com Lambda

```java
Function<String, String> toUpperCaseLambda = (string) -> string.toUpperCase();
```

#### Com Method Reference

```java
Function<String, String> toUpperCaseMethodReference = String::toUpperCase;
```

### Quando Method Reference não é aplicável

Se a expressão lambda envolve lógica adicional, Method Reference não pode ser usada. Por exemplo:

```java
Predicate<Student> studentPredicate = (student) -> student.getGradeLevel() >= 3;
```

Neste caso, precisamos usar a expressão lambda porque a lógica compara a nota com um valor.

---

# Constructor Reference

Constructor References permitem criar objetos usando uma sintaxe simplificada e também fazem parte do Java 8.
Eles funcionam como um atalho para chamar o construtor de uma classe.

### Sintaxe

```java
ClassName::new
```

### Exemplo Básico

#### Com Lambda

```java
Supplier<Student> studentSupplier = () -> new Student();
```

#### Com Constructor Reference

```java
Supplier<Student> studentSupplier = Student::new; // Construtor vazio deve existir
```

### Exemplos Inválidos

- **Erro de compilação**:

```java
Student student = Student::new; // Inválido, não usamos Supplier
```

- **Construtor vazio ausente**:

```java
Supplier<Student> studentSupplier = Student::new; // Necessita de um construtor vazio
```

### Exemplo Completo

```java
package com.technical.constructorreference;

import com.technical.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    static Supplier<Student> studentSupplier = Student::new; // Construtor vazio deve existir

    static Function<String, Student> studentFunction = Student::new;

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());
        System.out.println(studentFunction.apply("ABDEFG"));
    }
}
```

### Quando usar Constructor Reference

- Quando precisamso instanciar objetos repetidamente e um construtor adequado está disponível.
- Ideal para trabalhar com coleções ou APIs de processamento em lotes.

# Lambda e Variáveis locais

O que é uma variável local?

- Qualquer variável que é declarada dentro de um método é chamada de variável local
- Lambdas possuem algumas restrições em uso de variáveis locais:
    - Não é permitido o uso do mesmo nome de variável local de parametros da lambda e denrto do corpo da lambda
    - Não é permitido re-atribuir um valor à uma variável local
- Sem restrições em variáveis de instâncias

# Introdução à Streams API

A **Streams API** foi introduzida no **Java 8** com o objetivo de facilitar o processamento de dados em coleções e
outros tipos de fontes, como arrays e entradas/saídas (E/S). Ela permite realizar operações de forma declarativa, com
suporte para processamento paralelo, sem a complexidade de gerenciar threads manualmente.

## O que é uma Stream?

Uma **Stream** é uma sequência de elementos que pode ser criada a partir de coleções, arrays ou outros recursos de E/S.
Com Streams, podemos realizar operações de transformação e filtragem de dados de maneira eficiente e concisa.

Por exemplo, considere o seguinte código:

```java
import java.util.Arrays;
import java.util.List;

public class ExemploStream {

    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Marcos", "Aline", "Olívia");

        // Criando uma Stream de Strings
        nomes.stream();

        // Criando uma Stream paralela
        nomes.stream().parallel();
    }
}
```

## Operações em Streams

As Streams permitem realizar operações de forma **sequencial** ou **paralela**. Elas suportam dois tipos principais de
operações:

- **Operações intermediárias**: Transformam ou filtram os dados da Stream e retornam outra Stream. Exemplos: `filter`,
  `map`, `sorted`.
- **Operações terminais**: Finalizam a Stream e produzem um resultado. Exemplos: `collect`, `forEach`, `reduce`.

### Exemplo de uso com operações intermediárias e terminais:

```java
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class ExemploOperacoes {
    public static void main(String[] args) {
        // Suponha que temos uma lista de estudantes
        List<Student> listaEstudantes = StudentDataBase.getAllStudents();

        // Predicados para filtrar os estudantes
        Predicate<Student> filtroNota = estudante -> estudante.getGradeLevel() >= 3;
        Predicate<Student> filtroGpa = estudante -> estudante.getGpa() >= 3.9;

        // Processando a lista de estudantes com Streams
        Map<String, List<String>> mapaEstudantes = listaEstudantes.stream()
                .filter(filtroGpa) // Operação intermediária
                .filter(filtroNota) // Operação intermediária
                .collect(Collectors.toMap(
                        Student::getName,
                        Student::getActivities)); // Operação terminal

        System.out.println(mapaEstudantes);
    }
}
```

### Pontos importantes sobre Streams:

1. **Imutabilidade**: As Streams não alteram as fontes de dados originais; elas produzem novos resultados.
2. **Lazy Evaluation**: As operações intermediárias são avaliadas apenas quando uma operação terminal é chamada.
3. **Paralelismo Simplificado**: Usando `parallelStream()`, é possível processar os dados em paralelo, aproveitando
   melhor os recursos da CPU.

Com essa abordagem, podemos realizar transformações complexas de dados de forma clara e eficiente.

### Stream Operation - map()

O método `.map()` é usado para transformar ou converter elementos de uma Stream de um tipo para outro. Ele aplica uma
função (representada por uma `Function<T, R>`) a cada elemento da Stream, retornando uma nova Stream com os elementos
transformados.

- **Não confunda o método `.map()` da Stream API com a interface de coleção `Map<K, V>`**, pois eles têm propósitos
  diferentes.

#### Exemplo Explicado

No exemplo abaixo, o objetivo é obter uma lista e um conjunto (`Set`) de nomes de estudantes convertidos para letras
maiúsculas.

```java
package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapExample {

    // Coleção de estudantes
    public static List<Student> students = StudentDataBase.getAllStudents();

    // Retorna uma lista de nomes de estudantes em letras maiúsculas
    public static List<String> getStudentNamesList() {
        return students.stream()
                .map(Student::getName) // Transforma cada Student em seu nome (String)
                .map(String::toUpperCase) // Converte o nome para letras maiúsculas
                .toList(); // Converte a Stream para uma lista
    }

    // Retorna um conjunto de nomes de estudantes em letras maiúsculas
    public static Set<String> getStudentNamesSet() {
        return students.stream()
                .map(Student::getName) // Transforma cada Student em seu nome
                .map(String::toUpperCase) // Converte o nome para letras maiúsculas
                .collect(Collectors.toSet()); // Coleta os elementos em um Set
    }

    public static void main(String[] args) {
        // Imprime os nomes em formato de lista
        System.out.println(getStudentNamesList());
        System.out.println("\n");

        // Imprime os nomes em formato de conjunto
        System.out.println(getStudentNamesSet());
    }
}
```

#### Explicação Passo a Passo

1. **Uso do `.map(Student::getName)`**:

- Extrai os nomes dos estudantes (`String`) a partir dos objetos `Student`.

2. **Uso do `.map(String::toUpperCase)`**:

- Converte os nomes para letras maiúsculas.

3. **Transformação Final**:

- `.toList()`: Cria uma lista (`List`) a partir da Stream.
- `.collect(Collectors.toSet())`: Cria um conjunto (`Set`) a partir da Stream.

---

#### Principais Pontos sobre `.map()`

1. **Transformação dos Dados**:

- `.map()` sempre retorna uma nova Stream contendo os elementos transformados.

2. **Função Necessária**:

- O método `.map()` recebe uma função (`Function<T, R>`) que define como transformar os elementos.

3. **Encadeamento**:

- O `.map()` pode ser usado em sequência para aplicar várias transformações.

4. **Uso Comum**:

- Converter tipos de objetos.
- Modificar dados (como converter strings para letras maiúsculas, arredondar números, etc.).

### Stream Operation - flatMap()

#### Principais Pontos sobre `.flatMap()`

O método `.flatMap()` transforma cada elemento de uma Stream em outra Stream, e então "achata" todas essas Streams em
uma única Stream contínua de elementos.

#### Diferença entre `.map()` e `.flatMap()`:

1. **`.map()`**:
    - Transforma elementos de uma Stream em outro tipo, mas a estrutura original (ex.: `Stream<List<String>>`) permanece
      inalterada.
2. **`.flatMap()`**:
    - "Achata" múltiplos elementos de uma estrutura composta, como `Stream<List<String>>`, em uma única sequência
      linear (`Stream<String>`).

---

#### Contexto Comum de Uso:

- Trabalhar com estruturas aninhadas, como listas ou arrays dentro de uma Stream.
- Exemplo: Transformar uma `Stream<List<String>>` em uma `Stream<String>`.

---

#### Exemplo Explicado: `.flatMap()`

**Objetivo**: Coletar todas as atividades dos estudantes (`List<String>`) em uma lista única, eliminando a estrutura
aninhada.

```java
package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;

public class StreamsFlatMapExample {

    public static List<String> studentActivities() {

        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Transforma cada Student em sua lista de atividades: Stream<List<String>>
                .flatMap(List::stream) // "Achata" todas as listas em uma única Stream<String>
                .toList(); // Coleta os elementos em uma lista
    }

    public static void main(String[] args) {

        // Exibe todas as atividades em uma lista linear
        System.out.println(studentActivities());
    }
}
```

---

#### Explicação Passo a Passo:

1. **Uso do `.map(Student::getActivities)`**:

- Cada estudante é transformado em sua lista de atividades (`Stream<List<String>>`).

2. **Uso do `.flatMap(List::stream)`**:

- Cada lista de atividades é "achatada" para criar uma única `Stream<String>` com todas as atividades individuais.

3. **Uso do `.toList()`**:

- Coleta os elementos resultantes em uma `List<String>`.

---

#### Saída do Exemplo:

Se tivermos estudantes com as seguintes atividades:

```java
Estudante 1:["Futebol","Leitura"]
Estudante 2:["Caminhada","Xadrez"]
Estudante 3:["Corrida","Música"]
```

A saída será:

```java
[Futebol,Leitura,Caminhada,Xadrez,Corrida,Música]
```

---

### Benefícios de `.flatMap()`:

1. **Desaninha Estruturas**:

- Ideal para trabalhar com Streams que contêm listas, arrays ou coleções.

2. **Flexibilidade**:

- Permite processar dados em formato complexo de forma simples e linear.

3. **Compatibilidade**:

- Transforma coleções compostas em sequências simples que podem ser processadas com outros métodos da Stream API.

### Stream Operation - distinct(), count(), sorted()

#### Descrição

A operação `.distinct()` remove duplicatas de uma `Stream`, resultando em uma sequência de elementos únicos. Quando
combinada com `.count()`, podemos determinar a quantidade de elementos distintos. Já a operação `.sorted()` organiza os
elementos da `Stream` em ordem natural ou conforme um comparador especificado.

#### Diferença no Uso de `.distinct()` com e sem `.map()` / `.flatMap()`:

- Sem `.map()` e `.flatMap()`:
    - A operação `distinct()` é aplicada diretamente na `Stream<Student>`. A contagem é baseada no número de objetos
      `Student` únicos, dependendo do método `equals()` e `hashCode()` da classe `Student`.

- Com `.map()` e `.flatMap()`:
    - Primeiro, transformamos a `Stream<Student>` em uma `Stream<String>` contendo as atividades. A operação
      `distinct()` então remove duplicatas de atividades, resultando em uma contagem baseada nas atividades únicas.

#### Exemplo de Código

```java
package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;

public class StreamsFlatMapDistinctCountAndSortedExample {

    public static List<String> returnStudentActivities() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .toList();
    }

    public static Long returnActivitiesCount() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static List<String> returnActivitieSorted() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .toList();
    }

    public static void main(String[] args) {
        System.out.println("Atividades: " + returnStudentActivities());
        System.out.println("Contagem de atividades não repetidas: " + returnActivitiesCount());
        System.out.println("Atividades organizadas (sorted): " + returnActivitieSorted());
    }
}
```

#### Explicação do Código

1. **`returnStudentActivities`**:

- Cria uma lista contendo todas as atividades únicas extraídas dos estudantes.

2. **`returnActivitiesCount`**:

- Conta o número de atividades únicas, aplicando `distinct()` após extrair as atividades com `.map()` e `flatMap()`.

3. **`returnActivitieSorted`**:

- Retorna uma lista de atividades organizadas em ordem alfabética usando `.sorted()` e remove duplicatas com
  `.distinct()`.

#### Saída Esperada

Com base nos dados fictícios:

```java
Atividades:[swimming,basketball,volleyball,gymnastics,soccer,aerobics,dancing,football,baseball]
Contagem de
atividades não
repetidas:9

Atividades organizadas(sorted):[aerobics,basketball,baseball,dancing,football,gymnastics,soccer,swimming,volleyball]
```

#### Dúvida Resolvida: Por que a contagem muda sem `.map()` e `.flatMap()`?

- **Sem `.map()` e `.flatMap()`**:
    - `distinct()` é aplicado diretamente na `Stream<Student>`, considerando estudantes únicos com base em seus
      atributos.
- **Com `.map()` e `.flatMap()`**:
    - A `Stream<Student>` é transformada em uma `Stream<String>` contendo atividades. `distinct()` remove duplicatas com
      base nas atividades, resultando em uma contagem diferente.

### Stream Operation - Customized sort using Comparator

#### Descrição

A operação `.sorted()` em Streams permite organizar elementos de acordo com uma ordem definida. Utilizando a classe
`Comparator`, podemos personalizar essa ordenação, seja por um único critério ou aplicando ordens reversas.

#### Exemplos de Ordenação Personalizada

1. **Ordenação por Nome**:

- Utilizamos `Comparator.comparing` para ordenar os estudantes alfabeticamente com base no nome.

   ```java
   public static List<Student> sortedStudentsByName() {
    return StudentDataBase.getAllStudents().stream()
            .sorted(Comparator.comparing(Student::getName))
            .toList();
}
   ```

2. **Ordenação por GPA**:

- Ordena os estudantes pelo GPA (Grade Point Average) em ordem crescente.

   ```java
   public static List<Student> studentsSortedByGpa() {
    return StudentDataBase.getAllStudents().stream()
            .sorted(Comparator.comparing(Student::getGpa))
            .toList();
}
   ```

3. **Ordenação Reversa por Nome**:

- Combina `Comparator.comparing` com `.reversed()` para inverter a ordem de classificação por nome.

   ```java
   public static List<Student> studentListSortedReversedByGpa() {
    return StudentDataBase.getAllStudents().stream()
            .sorted(Comparator.comparing(Student::getName).reversed())
            .toList();
}
   ```

#### Explicação do Código

1. **`Comparator.comparing`**:
    - Utiliza um método de referência para comparar um atributo específico dos objetos na Stream.

2. **`Comparator.reversed()`**:
    - Inverte a ordem natural definida pelo `Comparator` original.

#### Saída Esperada

Com base em dados fictícios, a saída pode ser:

```java
Students sorted
by name:
        [

Student {
    name = 'Aline'
},

Student {
    name = 'Marcos'
},

Student {
    name = 'Olivia'
},...]

Students sorted
by GPA:
        [

Student {
    name = 'Marcos', gpa = 3.2
},

Student {
    name = 'Aline', gpa = 3.5
},...]

Students sorted
by GPA
Reversed:
        [

Student {
    name = 'Olivia', gpa = 4.0
},

Student {
    name = 'Aline', gpa = 3.5
},...]
```

#### Pontos-Chave:

- Ordenações personalizadas ajudam a organizar os dados conforme critérios de negócio.
- `Comparator` é flexível e permite composição com métodos como `.reversed()` e `.thenComparing()` para critérios
  adicionais.
- O uso de Streams evita a necessidade de manipulação manual de listas para ordenação, tornando o código mais conciso e
  legível.

### Stream Operation - filter()

#### Descrição

O método `.filter()` é utilizado para processar elementos de uma Stream que atendam a um critério específico, definido
através de um `Predicate`. Ele realiza uma operação de filtragem que retorna uma Stream contendo apenas os elementos que
satisfazem o predicado fornecido.

#### Características

1. **Input**:

- O `.filter()` aceita como argumento um `Predicate<T>`, uma interface funcional que avalia cada elemento e retorna um
  valor booleano.

2. **Comportamento**:

- A operação é intermediária, ou seja, pode ser encadeada com outras operações.
- A filtragem não modifica os elementos da Stream original, apenas determina quais serão incluídos na nova Stream.

3. **Exemplo**:
   Filtrando estudantes do gênero feminino e com GPA maior ou igual a 4.
   ```java
   public static Predicate<Student> femaleStudents = (student -> student.getGender().equalsIgnoreCase("female"));
   public static Predicate<Student> gpaGreaterThanFour = (student -> student.getGpa() >= 4);

   public static List<Student> getAllFemaleStudents() {
       return StudentDataBase.getAllStudents().stream() // Stream<Student>
               .filter(femaleStudents.and(gpaGreaterThanFour)) // Filtra apenas estudantes que são mulheres e com GPA >= 4
               .toList(); // Converte para uma lista
   }
   ```

4. **Chaining**:
    - O `.filter()` pode ser encadeado com outros filtros para aplicar vários critérios ao mesmo tempo.
   ```java
   .filter(femaleStudents)
   .filter(gpaGreaterThanFour)
   ```

#### Saída Esperada

Com base em uma base de dados fictícia de estudantes:

```plaintext
Student{name='Aline', gender='female', gpa=4.2}
Student{name='Olivia', gender='female', gpa=4.5}
```

#### Pontos-Técnicos Importantes

1. **Avaliação Lazy**:

- O `.filter()` é avaliado de forma lazy, ou seja, os elementos são processados apenas quando uma operação terminal é
  invocada.

2. **Eficiência**:

- Como as Streams utilizam pipelines, o `.filter()` processa um elemento por vez, o que pode melhorar a eficiência em
  grandes coleções.

3. **Predicados Combinados**:

- O `.filter()` pode utilizar múltiplos predicados combinados com os métodos `.and()`, `.or()` e `.negate()` para criar
  critérios complexos de filtragem.

   ```java
   femaleStudents.and(gpaGreaterThanFour);
   femaleStudents.

or(gpaGreaterThanFour);
   femaleStudents.

negate();
   ```

#### Quando Utilizar?

- Ao trabalhar com coleções ou dados em que é necessário extrair apenas um subconjunto baseado em regras lógicas claras.

#### Benefícios

- Simplifica a lógica de filtragem.
- Reduz o uso de loops explicitamente definidos.
- Melhora a legibilidade e manutenção do código.

### Stream Operation - reduce()

É uma operação terminal. Utilizada para reduzir os conteúdos de uma stream para um único valor

Recebe dois parametros como um input
Primeiro parametro - default ou valor inicial
Segundo parametro - BinaryOperator<T>

package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    // O resultado da soma de todos os números

    public static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    //public static BiFunction<Integer, Integer, Integer> sum = ((a,b) -> a * b);

    public static Integer performMultiplicationWithIdentity(List<Integer> numbers) {
        return numbers.stream()
                .reduce(numbers.getFirst(), (a, b) -> a * b);  // primeiro parâmetro da função é o valor que começará ex, .reduce(10, (a,b) -> a+b)  10,1,2,3,4,5,6
        // a = valor inicial. b = valor da coleção. 1,2,3,4,5,6
    }

    public static Optional<Integer> performMultiplicationWithOutIdentity(List<Integer> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a * b);
    }

    public static Optional<Student> getStudentWithHighestGpa() {
        return StudentDataBase.getAllStudents().stream()
                .reduce(((student, student2)
                        -> (student.getGpa() > student2.getGpa()) ? student : student2));
    }


    public static void main(String[] args) {

        Optional<Integer> resultWithOutIdentity = performMultiplicationWithOutIdentity(numbers);

        System.out.println("Resultado Optional.isPresent(): " + resultWithOutIdentity.isPresent());
        System.out.println("Resultado Optional.get: " + resultWithOutIdentity.get());

        System.out.println("A multiplicação de " + numbers + " é " + performMultiplicationWithIdentity(numbers));
        System.out.println("A multiplicação de " + numbers + " sem o 'Identity<T> é " + resultWithOutIdentity);
        System.out.println("Estudante com o maior GPA é:  " + getStudentWithHighestGpa().get());

    }

}

### Stream Operation - Map + Filter + Reduce Pattern

### Stream Operation - max() using reduce() function

No Java 8, a API de Streams introduziu operações funcionais que permitem processar coleções de maneira declarativa.
Entre essas operações, a função `reduce()` é utilizada para agregar os elementos de um stream em um único valor. Embora
existam métodos específicos como `max()` e `min()` para encontrar o maior e o menor valor em um stream, também podemos
implementar essa funcionalidade utilizando `reduce()`.

## Implementação de `max()` com `reduce()`

Para encontrar o valor máximo em uma lista de inteiros usando `reduce()`, podemos definir uma função que compara dois
elementos e retorna o maior entre eles.

```java
public static Optional<Integer> maxValueOptional(List<Integer> integerList) {
    return integerList.stream()
            .reduce((currentMax, nextElement) -> currentMax > nextElement ? currentMax : nextElement);
}
```

Explicação:

Stream: Iniciamos um stream a partir da lista de inteiros.

Reduce: Aplicamos a função reduce() que recebe um BinaryOperator. Este operador compara o valor máximo atual (
currentMax) com o próximo elemento (nextElement) e retorna o maior dos dois.

Resultado: O resultado é um Optional<Integer> que contém o valor máximo, caso exista.

### Stream Operation - min() using reduce() function

De maneira semelhante, podemos encontrar o valor mínimo em uma lista de inteiros utilizando reduce().

```java
public static Optional<Integer> minValueOptional(List<Integer> integerList) {
    return integerList.stream()
            .reduce((currentMin, nextElement) -> currentMin < nextElement ? currentMin : nextElement);
}
```

Explicação:

Stream: Iniciamos um stream a partir da lista de inteiros.

Reduce: Aplicamos a função reduce() com um BinaryOperator que compara o valor mínimo atual (currentMin) com o próximo
elemento (nextElement) e retorna o menor dos dois.

Resultado: O resultado é um Optional<Integer> que contém o valor mínimo, caso exista.

#### Considerações sobre o Uso de Identidade

A função reduce() possui uma sobrecarga que aceita um valor de identidade. Este valor serve como ponto de partida e
identidade para a operação de redução. No entanto, ao procurar o valor máximo ou mínimo, é importante escolher um valor
de identidade apropriado.

Por exemplo, ao buscar o valor mínimo, poderíamos usar Integer.MAX_VALUE como identidade:

```java
public static int minValueWithIdentity(List<Integer> integerList) {
    return integerList.stream()
            .reduce(Integer.MAX_VALUE, (currentMin, nextElement) -> currentMin < nextElement ? currentMin : nextElement);
}

```
### Stream Operation - limit() and skip()

As operações `limit()` e `skip()` ajudam a criar uma sub-stream que processa apenas parte dos elementos da stream original.

#### limit(n)
A operação `limit(n)` restringe o número de elementos processados na stream para no máximo `n`. Ou seja, só os `n` primeiros elementos são considerados nas operações subsequentes.

- **Exemplo**: Se tivermos uma stream com 10 elementos e aplicarmos `.limit(5)`, apenas os primeiros cinco elementos serão processados.

#### skip(n)
A operação `skip(n)` ignora os primeiros `n` elementos da stream e processa apenas os restantes. Essa é uma forma útil de "pular" um conjunto inicial de dados.

- **Exemplo**: Se tivermos uma stream com 10 elementos e aplicarmos `.skip(3)`, os três primeiros elementos serão ignorados, e as operações subsequentes serão realizadas nos sete elementos restantes.

#### Exemplo de Implementação em Java

```java
package com.technical.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitSkipExample {

    public static Optional<Integer> sumLimit(List<Integer> integerList) {
        return integerList.stream()
                .limit(2) // Limita a stream aos dois primeiros elementos
                .reduce(Integer::sum); // Soma os elementos restantes
    }

    public static Optional<Integer> sumSkip(List<Integer> integerList) {
        return integerList.stream()
                .skip(2) // Pula os dois primeiros elementos
                .reduce(Integer::sum); // Soma os elementos restantes
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);

        System.out.println("Sum limit: " + sumLimit(integerList));
        // Saída: Optional[13] (soma dos dois primeiros elementos: 6 + 7)

        System.out.println("Sum skip: " + sumSkip(integerList));
        // Saída: Optional[27] (soma dos elementos após os dois primeiros: 8 + 9 + 10)
    }
}
```

#### Saída do Programa
```plaintext
Sum limit: Optional[13]
Sum skip: Optional[27]
```

#### Explicação
1. **`limit(2)`**: Reduz a stream original às duas primeiras entradas (6 e 7). Essas entradas são somadas e o resultado é retornado como `Optional[13]`.

2. **`skip(2)`**: Ignora as duas primeiras entradas (6 e 7) da stream original. As entradas restantes (8, 9 e 10) são somadas, resultando em `Optional[27]`.

Essas operações são úteis para manipulação de streams, permitindo filtrar ou dividir dados de forma eficiente. Elas podem ser combinadas com outras operações como `map`, `filter` e `reduce` para criar pipelines de processamento mais complexos.



### Stream Operation - allMatch(), anyMatch and noneMatch()

### Stream Operation - findAny() and findFirst()

# Comparação: Collections vs. Streams

## Collections

1. **Modificáveis**: Permitem adicionar ou modificar elementos a qualquer momento.

- Exemplo: `list.add(<element>)`

2. **Acesso em qualquer ordem**: Os elementos podem ser acessados em qualquer ordem, dependendo do tipo de coleção.

- Exemplo: `list.get(4)`

3. **Construção antecipada (Eager Construction)**: As coleções são preenchidas antecipadamente com os valores. É
   necessário popular a coleção antes de manipulá-la.
4. **Iteração múltipla**: É possível iterar sobre os elementos "n" vezes.
5. **Iteração externa**: A responsabilidade pela iteração recai no código do cliente.

- Exemplo: Usando `for` ou `while`.

---

## Streams

1. **Imutáveis**: Não permitem adicionar ou modificar elementos. A Stream representa um conjunto fixo de dados.
2. **Acesso sequencial**: Os elementos só podem ser acessados em sequência.
3. **Construção sob demanda (Lazy Construction)**: As Streams só realizam operações quando necessário (avaliação
   preguiçosa).
4. **Iteração única**: As Streams só podem ser consumidas uma vez. Tentativas subsequentes resultam em erro.
5. **Iteração interna**: A Stream gerencia automaticamente a iteração sobre os elementos.

---

## Exemplo: Diferenças entre Collections e Streams

```java
package com.technical.streams;

import java.util.ArrayList;

public class CollectionsVsStream {

    public static void main(String[] args) {

        // Exemplo com Collection (ArrayList)
        ArrayList<String> names = new ArrayList<>();
        names.add("Aline");
        names.add("Marcos");
        names.add("Olivia");

        names.remove(0); // Modificando a coleção
        System.out.println(names);

        names.add("Peter");

        // Iteração múltipla permitida
        for (String name : names) {
            System.out.println(name);
        }

        for (String name : names) {
            System.out.println(name);
        }

        // Exemplo com Stream
        var nameStream = names.stream();

        // Consumindo a Stream (Primeira iteração)
        nameStream.forEach(System.out::println);

        // Tentando consumir a Stream novamente (Erro)
        try {
            nameStream.forEach(System.out::println); // Lança IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("Erro: A Stream já foi consumida!");
        }
    }
}
```

## Debugando Streams

Streams são projetadas para serem processadas de forma "lazy" (sob demanda) e muitas vezes não possuem um estado
explícito
para inspeção. No entanto, existem técnicas para facilitar o debug de Streams em Java. Aqui estão algumas estratégias:

---

### 1. **Uso do `peek`**

O método `peek` permite inspecionar os elementos da Stream em diferentes estágios sem modificar os dados. É ideal para
fins de debug.

Adicione chamadas de `peek` entre as operações intermediárias para observar os elementos:

```java
Map<String, List<String>> studentMap = students.stream()
        .peek(student -> System.out.println("Original: " + student))
        .filter(gradeLevelGreaterThanThree)
        .peek(student -> System.out.println("Após gradeLevelGreaterThanThree: " + student))
        .filter(GpaGreaterThanThreeDotNine)
        .peek(student -> System.out.println("Após GpaGreaterThanThreeDotNine: " + student))
        .collect(Collectors.toMap(Student::getName, Student::getActivities));

System.out.

println(studentMap);
```

---

### 2. **Adicionar Logs**

Outra abordagem é adicionar logs nos predicados ou funções lambda utilizadas nas operações da Stream. Por exemplo:

```java
static Predicate<Student> gradeLevelGreaterThanThree = student -> {
    boolean result = student.getGradeLevel() >= 3;
    System.out.println("Verificando gradeLevel >= 3 para " + student.getName() + ": " + result);
    return result;
};

static Predicate<Student> GpaGreaterThanThreeDotNine = student -> {
    boolean result = student.getGpa() >= 3.9;
    System.out.println("Verificando GPA >= 3.9 para " + student.getName() + ": " + result);
    return result;
};
```

---

### 3. **Utilizar Ferramentas de Depuração (IDE)**

A maioria das IDEs modernas, como IntelliJ IDEA ou Eclipse, oferece suporte ao debug de Streams com:

- **Breakpoints Condicionais**: Podemos adicionar breakpoints em lambdas ou operações específicas para inspecionar os
  dados.
- **Expression Evaluation**: Durante o debug, avalie expressões para ver os resultados de operações intermediárias.

---

### 4. **Converter em Estruturas Intermediárias**

Se o debug direto for complicado, uma abordagem alternativa é dividir as operações da Stream em etapas intermediárias e
salvar os resultados em coleções temporárias para inspecionar os dados.

```java
List<Student> filteredByGrade = students.stream()
        .filter(gradeLevelGreaterThanThree)
        .collect(Collectors.toList());

System.out.

println("Após filtro de gradeLevel >= 3: "+filteredByGrade);

List<Student> filteredByGpa = filteredByGrade.stream()
        .filter(GpaGreaterThanThreeDotNine)
        .collect(Collectors.toList());

System.out.

println("Após filtro de GPA >= 3.9: "+filteredByGpa);

Map<String, List<String>> studentMap = filteredByGpa.stream()
        .collect(Collectors.toMap(Student::getName, Student::getActivities));

System.out.

println(studentMap);
```

---

### 5. **Uso de Bibliotecas de Debug**

Existem bibliotecas como [StreamEx](https://github.com/amaembo/streamex) que estendem as funcionalidades das Streams e
adicionam métodos úteis para debug.

---

### Resumo

Para debug de Streams:

1. Use `peek` para inspecionar elementos.
2. Adicione logs em predicados ou lambdas.
3. Aproveite as ferramentas de depuração da IDE.
4. Divida as operações em etapas intermediárias para inspecionar resultados.
5. Considere bibliotecas externas para debug avançado.

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

#### **Sintaxe da Lambda**

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

#### Interfaces funcionais

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

        new Thread(runnable).start();
```

depois:
```java
Runnable runnable = () -> System.out.println("Inside Runnable");
    new Thread(runnable).start();
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


### Interfaces funcionais no Java8

## Consumer:

## Objetivo

Demonstrar como:

1. Definir consumidores personalizados para executar ações específicas em objetos.
2. Encadear consumidores usando o método `andThen` para realizar operações sequenciais.
3. Filtrar elementos de uma coleção com base em condições específicas antes de aplicar consumidores.

## Conceitos Teóricos

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

## Estrutura do Código

### Definições Importantes

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

## Objetivo

Demonstrar como:

1. Definir consumidores personalizados que operam sobre dois argumentos.
2. Encadear operações usando o método `andThen`.
3. Utilizar `BiConsumer` em cenários práticos como manipulação de dados de objetos complexos.

## Conceitos Teóricos

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

## Estrutura do Código

### Definições Importantes

- **`listStudent`**: Uma lista de objetos do tipo `Student`, representando os dados a serem processados.
- **Exemplos de `BiConsumer`**:
    - Operações matemáticas simples como multiplicação e divisão.
    - Processamento de dados de estudantes (nome e atividades).

### Métodos

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

### Método Principal

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

Você pode usar expressões lambda diretamente no método `filter`:
 
```java
import com.technical.data.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
 
  static List<Student> listOfStudents = new ArrayList<>();

  public static void main(String[] args) {
    listOfStudents.stream()
            .filter(student ->student.getGradeLevel() >=3 && student.getGpa() >=4) // Expressão direta
            .forEach(student ->System.out.println("Students with grade >= 3 AND GPA >= 4: "+student));
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

1. **Reutilização:** Você usará a mesma lógica em várias partes do código.
2. **Composição:** Combinações complexas de condições são necessárias.
   ```java
   Predicate<Student> complexCondition = studentPredicateGrade.and(studentPredicateGPA).or(studentStartsWithJ);
   ```

#### Use **expressões diretas** quando:

1. **Simplicidade:** A condição será usada uma única vez.
2. **Legibilidade local:** O código é curto e simples.

## BiPredicate

A interface `BiPredicate` em Java faz parte do pacote `java.util.function` e é utilizada para representar uma função que avalia dois argumentos e retorna um valor booleano.

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
- Quando você precisa de uma lógica que envolve **dois argumentos** e retorna um valor booleano.
- Ao combinar ou reutilizar condições complexas em streams ou outras operações funcionais.

## Diferença entre `Predicate` e `BiPredicate`
| Característica        | Predicate         | BiPredicate       |
|-----------------------|-------------------|-------------------|
| Número de argumentos | 1                 | 2                 |
| Uso típico            | Filtragem ou teste de um único elemento | Teste que envolve dois elementos |

### Exemplo Comparativo
**Predicate:**
```java
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(4)); // true
```

**BiPredicate:**
```java
BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
System.out.println(isSumEven.test(3, 5)); // true
```

## Function\<T, R>

A interface `Function<T, R>` em Java faz parte do pacote `java.util.function` e é usada para representar uma função que aceita um único argumento do tipo `T` e retorna um resultado do tipo `R`.

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

        System.out.println(stringLength.apply("Hello")); // 5
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
| --------------------- | -------------------- | --------------- |
| `Function<T, R>`      | 1                    | R               |
| `BiFunction<T, U, R>` | 2                    | R               |
| `UnaryOperator<T>`    | 1                    | T (mesmo tipo)  |
| `Predicate<T>`        | 1                    | boolean         |

### Exemplo Comparativo

**Function:**

```java
Function<String, Integer> stringToLength = String::length;
System.out.println(stringToLength.apply("Java")); // 4
```

**BiFunction:**

```java
BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
System.out.println(multiply.apply(3, 5)); // 15
```

**UnaryOperator:**

```java
UnaryOperator<Integer> square = x -> x * x;
System.out.println(square.apply(5)); // 25
```



Function - BiFunction, UnaryOperator, BinaryOperator

Aqui está uma versão mais organizada e melhorada das descrições:

---

### Programação Imperativa
- **Foco no "como"**: Define passo a passo como as operações devem ser realizadas.
- **Mutabilidade do objeto**: Modifica diretamente o estado de objetos para alcançar um objetivo.
- **Detalhamento das etapas**: Escrevemos código descrevendo o que precisa ser feito em cada passo.
- **Relacionamento com POO**: É o estilo predominante na Programação Orientada a Objetos clássica.


```java
List<Integer> quantities = Arrays.asList(10, 20, 15, 30);
int total = 0;
for (int quantity : quantities) {
    total += quantity;
}
System.out.println("Total de produtos: " + total);

```

### Programação Funcional
- **Imutabilidade**: Trabalha com objetos imutáveis, reduzindo efeitos colaterais.
- **Código conciso e legível**: Usa funções e métodos como elementos principais.
- **Foco no "o que"**: Concentra-se no resultado desejado, não no processo para obtê-lo.
- **Exemplo prático**:
  ```java
  Function<String, String> addSomeString = (name) -> name.toUpperCase().concat("default");
  ```  
- **Comparação com SQL**: Assim como em SQL, declaramos o que queremos obter, sem detalhar como alcançar isso.
- **Aproveitamento de bibliotecas**: Faz uso extensivo de funções e ferramentas já disponíveis.
- **Estilo declarativo**: Está alinhada ao paradigma de programação declarativa.

```java
List<Integer> quantities = Arrays.asList(10, 20, 15, 30);
int total = quantities.stream().mapToInt(Integer::intValue).sum();
System.out.println("Total de produtos: " + total);
```


### **Expressões Lambda**

As expressões lambda são equivalentes a funções (ou métodos) sem um nome, também conhecidas como **funções anônimas**. Elas possuem todas as características de um método tradicional, como:
- **Parâmetros**: Permitem a entrada de valores.
- **Corpo do método**: Contêm a lógica a ser executada.
- **Tipo de retorno**: Podem retornar valores como qualquer outro método.

Diferentemente de métodos normais, lambdas não estão vinculadas a uma classe específica. Elas podem ser atribuídas a variáveis e até mesmo passadas como argumentos.

#### **Sintaxe da Lambda**
A estrutura básica de uma expressão lambda é:
```java
(parametros) -> { corpo da função }
```  
Exemplo vazio:
```java
() -> {}
```  

---

### **Usos das Expressões Lambda**

O principal objetivo das lambdas é implementar **interfaces funcionais** (também chamadas de **SAM interfaces**), que possuem **apenas um método abstrato**. Essas interfaces são marcadas com a anotação `@FunctionalInterface`.

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
System.out.println("Inside Runnable")
System.out.println("Inside Runnable")
};
```

As lambdas oferecem uma forma mais concisa e legível de implementar essas interfaces, tornando o código mais enxuto e fácil de entender.

### Interfaces funcionais 
Existem desde o java 1.8

A "interface" funcional (SAM) é uma "interface" que tem apenas um método abstrato

Ex 
@FunctionalInterface:
Essa anotação foi introduzida como parte do JDK 1.8.
Anotação opcional para sinalizar que a "interface" é uma "Interface" Funcional

### Interfaces funcionais no Java8

Consumer - BiConsumer
Predicate - BiPredicate
Function - BiFunction, UnaryOperator, BinaryOperator

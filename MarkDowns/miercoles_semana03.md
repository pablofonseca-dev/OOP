# Semana 03 Miércoles 05 de Febrero

Lo que se obtiene del proceso de abstracción son conceptos.

Esos conceptos se pueden representar de diferentes maneras.
En UML esa manera de representar los conceptos se llama
Modelo Conceptual.

La teoría dice que esos conceptos pueden tener características,
relaciones y operaciones.

En la programación orientada a objetos hay elementos
que se podrán utilizar para representar las características y
las operaciones.

## Forma en la que se extrae el modelo conceptual, NO elementos de Software.
1. Identificar los sustantivos (cosas, personas).
2. Identificar los verbos.
3. Representar las relaciones.

**Por ejemplo con el proyecto Laboratorios, se logró extraer estos elementos.**

1. Laboratorios
2. Cursos
3. Estudiantes

Se deben poner todas las relaciones posibles entre los elementos, pero antes hay que meterlos en cajitas.

Relaciones por ejemplo:

* Un estudiante está matriculado a un curso.
* Un curso es impartido a un laboratorio.
* Un estudiante va a un laboratorio.
* Un laboratorio está asignado a un curso.

Se pueden tener relaciones dobles, por ejemplo entre laboratorio y curso.

Las relaciones tienen cardinalidad, por ejemplo uno o muchos estudiantes pueden estar matriculados en uno o muchos cursos.

Un laboratorio está asignado a un curso, solo porque la regla la indicamos desde el inicio.

El modelo conceptual puede tener muchos coneptos.

El modelo conceptual nos hace entender el problema. Si no se hace
un modelo conceptual, se deben tener muy claras las relaciones entre los elementos.

El proceso de virtualización de esos elementos consiste en
representarlos de una manera virtual en forma de código, se necesita representar cada uno de esos elementos en código. El
paradigma de la programación orientada a objetos se basa en objetos. Muchos de los objetos que se representan en software
son parte de los conceptos originales, es decir, es parte del dominio del problema, pero otro no, por lo que no habría que virtualizarlos.

Los objetos representan la virtualización de los conceptos que se identificaron en el proceso de abstracción.

El modelo conceptual sirve para que se entienda el problema, solo para hablar el idioma del cliente.

Si yo tengo una forma simple de representar un mouse, se podrá identificar cómo se comporta el mouse fácilmente.

La programación orientada a objetos revolucionó el código.

Los objetos son todos aquellos elementos del proceso de abstracción que se van a programar.

Las dos cosas principales que tienen cualquier objeto son:

1. Atributos.
2. Comportamiento.

Las relaciones es la manera en la que un objeto interactúa con otro. Las relaciones no son características de los objetos, las relaciones existen porque los objetos pueden hacer algo.

Las relaciones vienen en funcion de lo que esa persona o cosa puede hacer, por ende no es una característica de los objetos.

Por ejemplo

Objeto persona

Características de un objeto persona

* Tamaño
* Nombre
* Edad
* Sexo

Acciones de un objeto personas

* Correr
* Brincar
* Bailar

Todas esas características son relevantes para nosotros.

Se concluye que un objeto puede tener atributos o características, y tiene métodos o acciones.

En el paradigma de la programación orientada a objetos el término rutina no existe, lo que se conoció como rutinas en el paradigma estructurado es lo que en POO se conoce como métodos. Y los atributos y características son similares en cuanto a su representación a las variables.

Los atributos deben tener un nombre y un tipo de dato.

Cuando se logra identificar los objetos aún no se sabe cómo representarlos en forma virtual.

Cómo se hace para representar un objeto

La representación de los objetos se basa en una plantilla o molde, receta, etc.

Por ejemplo uno de esos moldes crea rombos de galleta, entonces se pueden crear N rombos, todos esos rombos son iguales, ya que el molde sigue siendo el mismo.

Para poder crear un objeto se necesita un molde, ese molde en el paradigma de programación orientada a objetos se conoce como **Clase**.

La clase es la representación del molde con el que se crearán los objetos de manera virtual.

Se pueden crear tantas galletas basadas en el molde como yo quiera, igual puedo crear tantos objetos de la clase Laboratorio como yo quiera.

Los atributos serán compartidos por todos los objetos, el
valor específico de cada uno de esos atributos será propio del
objeto creado.

Si un atributo es lo mismo que una variable tendrá su propia anatomía, lo que cambia es el valor que tiene cada uno para cada objeto.

Cada clon o copia es lo que se conoce como Instancia.

Una instancia es una copia del objeto en memoria con una posición en memoria distinta. Dentro de esa posición en memoria
están los atributos propios de cada objeto instanciado.

Con esto se completa el proceso de virtualización.

**Toda clase es un objeto .java**

Por estándar los nombres de las clases empiezan en mayúscula.

No pueden tener un nombre plural.

Una de las características de las clases es que son los tipos
de datos desarrollados por el programador.

Lo más adecuado para introducir un curso de programación orientada a objetos es el proceso de abstracción, por eso se vio de primero en la clase.

Leer la parte 1.5 del libro.

# Miércoles 12 de Febrero del 2020 Semana 04

## Vimos Que: 

Constructor es público, tiene el nombre de la clase, no tiene tipo de dato de retorno.

Por el momento hay dos tipos de constructores, el constructor por defecto o constructor vacío y el constructor que inicializa todos los atributos.  

La firma de un método está dada por su nombre. El método tiene un identificador único que está dado por su número de parámetros y por el nombre del método. 

A la facilidad que tiene una clase de tener múltiples métodos con identidades exactas pero variadas se conoce como sobrecarga de métodos. 

To String es un método que se usa para retornar la información de la clase. 

Los atributos son las características de un objeto. 

Hay una regla que indica que esas características solo las puede ver y cambiar el objeto mismo. 

Esa regla debe ser implementada por el programador mediante los identificadores o modificadores de acceso. 

Los identificadores de acceso son tres palabras reservadas: Public, Private y Protected. 

Public: Cualquier clase puede establecer alteraciones sobre ese atributo. 

Protected: Mientras que estén dentro del mismo directorio otra clase puede hacerle cambios. 

Private: Lo que se recomienda, indica que solo el objeto puede hacer alteraciones respectivas ante sus atributos. 

Acomplamiento: Cuando tengo una clase que provee un servicio que tiene métodos que pueden ser utilizados por otra clase. Se indica que las clases
están altamente acompladas si cuando se hace un cambio en una se debe hacer varios cambios en la otra, entre clase servidor y cliente por ejemplo. 
Un buen diseño trata prevenir el alto acomplamiento. 

## Material Nuevo: 

### Tratamiento de Validaciones 

Cuando se hace una librería las validaciones de todos los datos van en la capa lógica de negocios. 

Cuando es un todo esto puede ir en la UI, es lo más preferible, ya que con una UI presente se puede filtrar todos los datos válidos para enviarlos a la CL. 

La UI valida la calidad de los datos al ingresar información. 

Pero si se desea hacer una validación que registre inicios de sesión con fechas dinámicas, eso se haría en la CL, ya que es una validación de la lógica de negocio. 

### Abstracción 

Busca encontrar los elementos esenciales de un problema para convertirlos en objetos virtuales. 

En un problema se pueden plantear conceptos relevante, pero no todos deben virtualizarse, por eso se debe hacer una elección formal.

Un objeto tiene la particularidad de que tiene una identificación única, incluso en memoria. 

Objeto = Estado + Comportamiento + Identidad. 

Así como un objeto tiene una visualización externa también tienen una visualización interna, que es aquello que está oculto y que muy posiblemente los demás objetos no conocen del mismo. 

Ese aspecto interno del objeto se conoce como tal, aspecto interno. 

Aspecto externo es todo aquello que en una clase es Public, y aspecto interno es todo aquello Private. 

El estado de un objeto tiene la peculiaridad de que pueden cambiar, porque los atributos tienen un valor. Por ejemplo el estado inicial del objeto puede ser nulo y se le puede
asignar un nuevo estado, incluso en memoria el estado puede ir cambiando. 

Todo lo que un objeto a nivel interno está declarado como Public (es decir, otros objetos lo pueden ver) se conoce como Interface. 

La interface de un objeto viene dada por los métodos o atributos Public que ese objeto puede tener, los objetos se comunican entre sí gracias a las interfaces. 

Si yo tengo un objeto control remoto, el objeto se comunica con el televisor, enviandole el canal o la acción que desea ejecutar. Ambos objetos se están comunicando entre sí. 

Cuando se registra un estudiante en un arreglo, la capa de presentación solo le envía la petición a la CL. 

El proceso de comunicación es exactamente el mismo que el de un proceso de comunicación en la vida real. 

Existe un objeto destinatario y el nombre del mensaje que describe la tarea a realizar. 

UML es un estándar que se utiliza para la diagramación de soluciones. 

Ya hemos visto un elemento de UML, se llama Modelo Conceptual. 

Este modelo tenía una serie de cajitas con un nombre (el nombre de un concepto a virtualizar), la descripción de la relación y una cardinalidad entre distintos objetos. 

Hay otro artefacto que tiene UML para representar dichos problemas, se llama Concepto de Clase. 

Es un rectángulo que está constituido de tres partes: El nombre de la clase (Siempre en mayúscula), luego se indican los atributos y luego los métodos. 

Ejemplo

Laboratorio 

* -capacidad: int
* -nombre: String
* -curso: String 
* -código: String 

* +Laboratorio()
* +Laboratorio(capacidad: int, nombre: String, curso: String, codigo: String);
* +getCapacidad(): int
* +setCapacidad(cap: int): int
* +toString(): String 

"+" Significa Public
"-" Significa Private 
"#" Significa Protected

Cuando aparece en UML por ejemplo: unTV: Televisor, significa que hay una instancia llamada unTV y que pertenece a la clase Televisor. 

En todas las clases, la primera letra de cada palabra debe ir obligatoriamente en Mayúscula. Los métodos son diferentes en cuanto a nomenclatura, la primera letra de la primer palabra 
va en minúscula, las demás letras de las otras palabras van en mayúscula. 

Hay un constructor que tiene el nombre de la clase que no recibe parámetros.
Y hay un constructor que inicializa todo, cada uno de estos métodos deben indicarse en Laboratorio. 

Todo eso con getters y setters y demás debe indicarse en el UML. 

El estado significa que los valores de los atributos de cada instancia sea diferente. 

### Controllers 
A partir de hoy, la UI no declara objetos de la capa lógica de negocio. El BufferedReader, el PrintStream sí, pero objetos de tipo Laboratorio , estudiante o curso 
Aún no se ha dicho que no se pueden crear objetos, no obstante no se debe por al acoplamiento, no se puede declarar un objeto de tipo laboratorio en la UI. 

La arquitectura de ahora va a tener mínimo tres grandes clases: La UI.java, LogicLayer.java y vamos a tener otra clase a la que le llamaremos Controller.java

**Función de un Controller**
La función del controller es únicamente recibir datos de la UI, generar los objetos y pasarlos a la CL. O, tomar los datos de la UI, pasarlos a la CL y que la CL genere los objetos. 

De momento el Controller lo que hará es que si hay un laboratorio, el Controller tendrá un método para registrar laboratorio que le enviará la información a la CL. 

La clase main va a tener que contener siempre el controlador, siempre tendrá que ser estática. 

Todos los métodos del archivo Controller y de la CL se declara Public y no son estáticos. Son Public para que puedan ser usados por el controlador. 

En la UI todo es estático porque el main es estático y eso limita todo. Por el momento esa es la respuesta. 

El otro problema que tenemos es la persistencia en arreglos. Los arreglos son muy tiezos, por lo que se empezará a utilizar estructuras 

más flexibles. 

Aparte de los paquetes de Java, hay otras partes que se conocen como Frameworks. Los FrameWorks son un conjunto de funcionalidades que ofrece un proveedor, que no 

es muy variado, sino que es muy específico. Hay para base de datos, para enviar Emails y hay uno en particular que se llama JCF Java Collection Framework. JCF es el conjunto de
funcionalidades con los cuales Java le permite a los programadores trabajar con sus clases que son más completas que un arreglo, cumplen con el mismo objetivo, almacenar datos temporales 
en memoria. 

La idea de JCF es que ahí están todas las clases relacionadas con colecciones. Una coleccion es una estructura que permite almacenar objetos de una clase en particular. 

El Framework no solo contiene clases, sino que tiene interfaces que define lo que la colección puede hacer. 

Lo que varía entre colecciones es la estructura que está detrás. 

Una pila, un treemap, están las listas que se comportan parecidas a una pila o una cola. Dependiendo de la estructura con la que se esté trabajando, así se usará una Collection de JCF 
en particular. 

Un Array tiene el problema de que es de Tamaño fijo, para solucionar esto existen las colecciones. 

La principal ventaja es que su tamaño es dinámico, es una caja negra en cuanto a eso. 

Cada una va a tener una funcionalidad específica, las colecciones son estructuras especializadas. 

Cada una collection tiene sus ventajas y sus desventajas. 

Un JSON es una colección, trabaja con la estructura de clave valor, el LocalStorage es otra estructura de clave valor. 

La interface colection tiene tres elementos, los sets, las listas y las colas. 

El vector ya no se usa, pero pertenece a las Listas. 

Nosotros nos centraremos en las listas. Las listas tienen estas características: 

1. Presentan una secuencia de elementos ordenados por su ingreso
2. Todos los elementos de esa lista pueden ser insertados, removidos o accedidos. 
3. Problema: Cuando se listan aparecen segun su orden interno, no pueden ordenarse, no tienen esa funcionalidad automática, hay que programarla. 

En JAVA todo son punteros. 

Las listas tienen el problema de que permiten elementos con el mismo valor. 

Cada elementos en una lista tiene un índice, de forma que el primer elemento va a estar en la posición cero, el segundo en la posición uno y así sucesivamente. 

Un stack o pila es similar a una pila de libros o de platos, es una estructura en la que se colocan las cosas de manera que el primer elemento queda de último y así sucesivamente. 

Las listas o colas no trabajan de esa manera, en una cola el primer elemento que se ingresó de primero es el que entra de primero. 

El arraylist tiene la capacidad de que uno no tiene que indicarle el tamaño que tiene. Tiene un algoritmo completo para modificar su tamaño dinámicamente. 

La estructura de almacenamiento detrás de un ArrayList es un Array, solo que el Framework saca un nuevo Array por cada elemento agregado. 

Con un array list no se tiene que preocupar si superamos la cantidad de valores indicados al inicio, ya que es dinámico. 

Con Java util se puede acceder a los array lists. 

Se declaran así: 

```java
 ArrayList<String> nombres;
 nombres = new ArrayList<>();
```

Se importa con java.util.ArrayList;

Para agregar elementos al arreglo se utiliza el método add. 

### Otros métodos del Array List

.size()  

.trimToSize() Se debe usar solo si se está seguro que no se le va a agregar más elementos. 

.get() Retorna el elemento en la posición indicada. 

.set() Modifica el elemento en la posición indicada. 

.remove() Elimina el elemento en el array list con una posición indicada. 

Un detalle importante de las listas es que permiten elementos repetidos, todas ellas los permiten. 

En los exámenes, nosotros no permitimos elementos repetidos, es una evaluación. Por lo tanto, para verificar si un elemento está repetido 
o no se debe recorrer todo el array list que valide si el elemento existe o no, esto se debe desarrollar manualmente desde ya. 


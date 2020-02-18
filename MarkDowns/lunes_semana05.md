#Lunes 17 de Febrero del 2020 Semana 05

**El taller será de 12:00 M.D a 14:00 P.M**

En JAVA FX, por cada vista se crea un Controller, que escucha constantemente las acciones en la vista.  

Dentro del Controller se llama a Logic Layer. 

JavaFX incluye el formulario en FXML y el Controller, donde se capturan todos los eventos. 

Uno debe hacer cada Form para cada vista. 

Si se va a hacer un SELECT, UPDATE o DELETE la base de datos, la aplicación de JAVAFX debe usar el Controller para enviar estas peticiones a la lógica. 

Los objetos debería poder comunicarse entre sí, relacionarse. Los objetos por medio de mensajes pueden asumir responsabilidades y puede pedir o solicitar

información a otro objeto sin mayor problema, lo que se trata de manejar en la programación orientada a objetos es que lo esencial son las responsabilidades del 

objeto y tratar de hacer la codificación lo más simple posible. 

Hasta el momento se han visto relaciones entre objetos solo por cuestiones de arquitectura, entre UI, controller y logic layer, se comunican porque así la arquitectura lo demanda. 

La relación que hay entre diferentes capas es una relación de uso, una clase le pide a otra que le de un servicio porque esta lo ocupa. 

La UI ocupa mostrarle al usuario la lista de estudiantes, por ende debe pedirle al Controller que le de estos datos (no le importa como lo hace), solo se los pide, es decir, 

para la UI no sabe que el Controller le necesita pedir a la LogicLayer que le procese esos datos. 

La organización de aplicaciones en Java tiene la enorme ventaja que uno puede poner lo que uno quiera siempre y cuando cumpla con una serie de normas específicas. 

Cuando se documenta el código, lo más importante para el desarrollador es el primer principio y es que todo debe de ser claro, en cuanto a nomenclatura. 

Para que la aplicación se pueda conectar a una base de datos se necesita una conexión, esa conexión está representada dentro de un objeto, pero tiene el problema de que la Clase 

connection existe en Oracle, en Microsoft y en Java, el problema es que no se le puede poner a la clase el mismo nombre, por ende las tres no pueden tener como nombre la clase Connection, 

a nivel de documentación esto es complicado, para resolver este problema se usan los paquetes (packages). 

##¿Cómo funcionan los paquetes?

En la orientación a objetos los paquetes son una divisón o un cajón donde adentro hay más cajones y dentro pueden haber más y así sucesivamente.

Al final de los paquetes hay archivos .java, .class. Para la nomeclatura, en cada paquete puede haber una clase connection, de esa manera, se pueden meter las clases metidas 

en gavetas. Esto necesita una ruta que conyebe hasta la clase Connection de cada paquete. Básicamente es un árbol jerárquico. Lo que se tiene aquí es un grupo de clases que son afines, las 

clases afines se pueden poner en un paquete. Se puede basar en arquitectura, en funcionalidad, etc para poner los paquetes. 

##¿Cómo hago para utilizar una clase que use otra clase de un paquete? 

Para extraer esa clase se debe usar la palabra reservada *import*

```java
	import java.io.*
``` 

Quiere decir que importe del paquete de Java y de su paquete IO, absolutamente todo lo que tiene por dentro. 

Cada paquete es un directorio en el disco duro. 

Cuando se crea un paquete se crea un directorio, y si tiene un paquete adentro se crea otro directorio dentro de este y así sucesivamente. 

Se usarán los paquetes para representar la arquitectura. Esto significa que nosotros vamos a tener los siguientes paquetes en nuestra aplicación: 

1. El paquete UI (User Interface), dentro de ese paquete estará el main.java 
2. El paquete TL (Transfer Layer), dentro de este paquete estarán los controllers, todos. 
3. El paquete BL (Business Layer), dentro de este estarán todos los objetos. 
4. El paquete DL (Data Layer), dentro de este estará los Array List. 

Por estándar el dominio de la Universidad es: ucenfotec.ac.cr, por ende será cr.ac.ucenfotec.

*cr.ac.ucenfotec.UI
*cr.ac.ucenfotec.BL
*cr.ac.ucenfotec.DL
*cr.ac.ucenfotec.TL

La siguiente parte de la clase se basa con el tema de: 

Repasar la arquitectura e introducir el tema de relaciones entre objetos. 

**El examen llega hasta herencia: Asociación, Composición, Agregación y Herencia.**

A nivel práctico, cuando hablamos entre relaciones entre objetos, lo que hablamos es de crear un atributo de una clase en otra clase. Un curso debe asociarse con una carrera, entonces, 
se crea un atributo carrera dentro de la clase curso. 


Una arquitectura es un conjunto de componentes, similar a lo que hacer un arquitecto de casa, un plano. En la parte de Software la arquitectura se divide en dos partes, la que se relaciona 

con la lógica, separar la UI y la Lógica por ejemplo, luego está la arquitectura física, es cuando tengo diferentes elementos en computadoras físicamente separadas, servers físicos por ejemplo. 

A nivel de arquitectura física y lógica la división es muy similar, la arquitectura física es 0% distribuida porque tendremos el IDE en la máquina, en la mayoría de los casos 

tendremos un servidor local y la UI va a estar localmente también. Cuando se presente el proyecto se tendrá un ícono que al darle click se abrirá una interfaz para ver los videos, para 

que la aplicación trabaje se tendrá que instalar el software en cada ordenador manualmente con el executer. Esto es 0% distribuido. 

La arquitectura parcialmente distribuida se usa en lugares con poco presupuesto, no les importa mucho la cuestión de la seguridad, significa que uno de los elementos no están en la misma 

computadora, en Proyecto I el cliente (el navegador) y el Browser están en el mismo ordenador, pero la Data Base de Mongo DB está en otra máquina, en un server de la compañía Mongo. 

100% distribuida es cuando estamos en la casa con la portátil, y tenemos cada componente en un ordenador distinto, es decir, el servidor web en un computador, 

el servidor de base de datos en otra y la base de datos en ota. 

Los microservicios son como se dice, pequeñas unidades de código y esas pequeñas unidades de código están instalados en servidores distintos, cuando se conecta a un servicio puede llamar  a 

otro servicio y así consecutivamente, eso se ve en apps como Netflix, es lo que hace posible la fucnción Streaming, las películas viajan de diferentes conexiones. Cuando se ve un video en 

YouTube hay veces que se queda en Pause, esto es porque la ejecución del video es más rápido que la carga del mismo, en Netflix esto no sucede, a menos de que haya un problema de Streaming, 

Netflix trabaja con particiones de paquetes y la unión de ellos forman un todo. Los pedazos de código o Microservices están en diferentes máquinas, a lo cuales se les pueden realizar peticiones. 

**En componentes se verá esto.**

Nosotros usaremos una arquitecura monolítica. 

A nivel de arquitectura lógica existen tres arquitecturas: 

Monolítica: El código no está separado por componentes, sino que es una sola aplicación, por lo que todas las operaciones se llevan a cabo en una sola computadora. 

Cliente-Servidor: Surge cuando los motores de base de datos empiezan a crecer y la tecnología de redes se empieza a desarrollar. 

Multi-Capas: Se separa la capa de aplicación, la UI y la lógica. 

Va a llegar un momento donde la BL o capa lógica la vamos a separar en una capa adicional, que se llamará acceso a datos, esto se usará para complementar las funciones de acceso a la base 

de datos. 

Entonces la capa de acceso a datos solo se encargará de pedir los datos al respositorio de datos en MySQL o SQL Server. 

Para el examen nos hace falta un tema de estructuramiento: En este momento se está manejando un solo proyecto, Para el examen la UI se necesitará sacar la UI en otro proyecto. 

A nivel de materia nos hace falta las relaciones entre objetos. 

Para acceder a la base de datos hay que cumplir ciertos factores de arquitectura. Eso no significa que no se pueda experimentar con conexiones directas, JAVA FX y jugar con las 

conexiones a la base de datos. No obstante, se deberá cambiar la arquitectura por obligación. Aquellas personas que quieran trabajar con la base de datos del proyecto lo puede hacer 

desde ya. 

La parte de base de datos no es lo complicado del proyecto, lo complicado del proyecto es la Interfaz Gráfica. 

## Clases : Repaso

Vimos que UML es el estándar que usaremos, se usará el modelo conceptual, diagramas de secuencia y paquetes. 

Se puede crear una clase curso que tenga un código de tipo String o un entero para la base de datos y un atributo de tipo Carrera que se llama tmpCarrera, es un tipo de dato
como cualquier otro. 

En el examen, cuando se empiece a ver relaciones entre objetos se pedirá un diagrama de clases. Dos clases o más con relaciones entre ellas es un diagrama de clases, solo se usará

para la lógica de negocio, nunca aplicará para los controllers y demás. No se debe incluir los controller ni la CL. 

**Por estándar los atributos se ponen de primero en la clase, luego los constructores, los gets y sets, el to string y luego todo lo demás. Los imports se ponen de primero todos los import de java, de segundo los imports nuestros.** 

Los miembros de la clase son los que representan su estado y pueden cambiar a lo largo del tiempo, pueden ser atributos. 

Atributos public son visibles para todaas las clases, para todos los paquetes y clases en ellos. 

Protected hace que las clases sean privadas para todas las clases fuera de ese paquete, pero no para las que están en el mismo. 

Private hace que la clase solo pueda modificar y visualizar sus valores, otras pueden verlos en el mismo paquete pero deberán pedir una petición a esa clase. 

Las constantes se declaran siempre Public, palabra reservada *final*, tipo de dato y el nombre va en mayúscula. Es Public porque igual una constante no podrá modificarse nunca en ejecución. 

Una clase debe tener los métodos que permiten modificar sus atributos. Gets, sets, estos fomentan el concepto del encapsulamiento. Por medio de los identificadores de acceso y los métodos 

gets y sets se fomenta el encapsulamiento. 

No todos los atributos deben tener un método de acceso. 

Las constantes no tienen métodos de acceso, ya que por definición son estáticas. 

Los constructores deben tener el mismo nombre de la clase, deben ser public, pueden recibir parámetros así como cualquier otro método. 

La sobrecarga de métodos permite que una clase tengan dos o más métodos similares, siempre y cuando su firma sea distinta. 

Cuando se trata de un constructor, por defecto: Entero: cero, Punto flotante o Real: cero, Boolean: False, String, arreglo y matriz: null.

La modularidad es un concepto que se cumple con la abstracción de paquetes. 

Los objetos pueden relacionarse de tres formas, algunas personas dice que son cuatro.

Agregación y composición son formas específicas de la asociación, por eso hay personas que dicen que no deberían existir. 

Dependencia es una relación donde la clase A necesita algo de la clase B, es una relación muy usada, especialmente a nivel de arquitectura. Básicamente, 
se genera declarando una variable del tipo de un objeto en otra clase. 

La dependencia normalmente genera una relación de uso muy particular. La forma más usada de dependencia es la asociación. Se definirá primero agregación o composición, si no es ninguna de esas, 

se descartará entre el resto. 

Una de las características de las relaciones entre objetos es que UML tiene formas distintas de representar cada una. 

Asociación: 

Profesor y Libro, conceptualmente no hay ninguna relación entre ellos, un libro es un objeto y un profesor es una persona que da clases. No se puede decir que un libro y un profesor 

siempre van a existir de una manera específica. Pero sí que se puede relacionar un profesor siendo el autor de un libro.

Profesor y Curso.

Curso y Nota. 

Curso y Carrera. 

Jugador y Equipo. 

Yo puedo a un jugador preguntarle cuál es su equipo, ya que pertenece a un equipo y por ende tendrá un atributo equipo. 
Esto es una relación de uso. Ninguno de los objetos se conectan, son independientes.

Si se tiene en el main una variable de tipo profesor y una de tipo libro. Se puede hacer: El autor del libro es: profesor.getNombre().

Eso no es lo mismo que poner: 

Profesor{
	libro l; 
	public Libro getLibro(...);
	public void setLibro(libro){
		...
	}
}  
  
Esto no es una relación de uso, es una asociación. Aquí los objetos sí que se conectan, porque el libro es una característica del profesor. 

Una asociación lo que tiene es una relación entre dos objetos, donde se da la mayoría de veces por el dominio de un problema. 

Por ejemplo: El caso del paciente y el médico, en el dominio del problema donde se comenta que de un hospital de la caja, un paciente es una persona. Cuando se habla 
del dominio del problema de una veterinaria, el paciente será un animal. En una aplicación para manejo de veterinaria, el doctor puede tener un paciente (que en este caso es una mascota), 
pero puede ser dueño del paciente. En el caso de un hospital de la caja, un doctor va a tener un paciente asignado pero, no será dueño de un paciente, si acaso será familiar. 

**El tipo de relación puede cambiar según el tipo de problema que esté tratando de resolver.**

Computadora y Empleado. 

Son dos elementos totalmente distintos, objetos diferentes. No se relacionan salvo por el que cuando el empleado llega a trabajar se asocia a una computadora. Si esa computadora se manda 
a reparar la gente de TI sabrá quién es el empleado que la adminitra. 

El enlace entre ambos es lo que los une mediante una línea, esta línea se conoce así, como enlace. Sin esa línea serían dos clases por aparte. El objeto computadora 

puede transmitirle mensajes al objeto empleado mediante los métodos públicos. Se puede saber cuál es el número de serie de la computadora asignada a un empleado. 

El mensaje siempre va a ser un método. 

El enlace no tiene una terminación de flecha en ningún punto. 

La asociación normalmente sí que tiene cardinalidad. Así se lee que una computadora está asignada a un empleado. computadora--->empleado. 

Se puede representar. Normalmente las relaciones se hacen de izquierda a derecha. Es lo mismo decir que una persona es empleada por una empresa, 
una empresa emplea a una persona. 

La multiplicidad se indica con uno (1), muchos (*) y uno a muchos (1.. *)

Hay veces en que la relación es un concepto por sí mismo, por lo tanto se crea una clase nueva. Cuándo me interesa a mí saber la clase empleo? 

Cuando ocupo saber la fecha de inicio y la fecha de fin de la relación. 

Se puede poner la fecha de inicio en una persona, pero para nivel de trabajo sería la fecha de inicio del trabajo, no fecha de inicio de vida. Por ende, eso debe de hacerse en una clase nueva, la clase empleo, 

esa clase tendrá una fecha de inicio y una fecha de fin. 

No importa como leamos, siempre y cuando se use correctamente la nomenclatura, en la asociación es muy importante la flecha porque es donde se va a programar. 

Si yo pongo una fecha apuntando hacia el servidor, entonces el atributo estará en el cliente. El cliente le pedirá siempre al servidor la información, por lo tanto, 

siempre el atributo va en el cliente, no al servidor. En UML nunca se pone el atributo de la clase, el atributo está implicito en larelación. Cuando se programe esto, el atributo responsable

de tipo empleado va a estar en la computadora. 

En la computadora habrán dos métodos de acceso de la máquina: 

setResponsable 
Y 
setResponsable 

Otro ejemplo de asociación 
------------------------------ 
serie: String                |
marca: String 				 |
responsable: Empleado        |
''''''''''''''''''''''       |
setResponsable()             |
getResponsable(): Empleado   | 
getNomResponsable(): String  | 
------------------------------

Toda relación de multiplicidad se relaciona con una Collection. La computadora en este caso tendría un ArrayList de responsables. 

No tiene sentido que una computadora tenga un empleado, y que el empleado tenga un atributo de tipo de computadora. 

El próximo miercoles empezamos con la programación de este concepto. 






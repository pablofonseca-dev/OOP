# Lunes 10 de febrero Semana 04 

La semana pasada: 

Se identificaron los Conceptos de un problema.  

Estudiante
Courso 
Laboratorio

Después se realizó el modelo conceptual 

Estudiante pertenece a uno o muchos cursos, etc. 

También vimos que tenemos un dominio del problema, que 
está representado en el modelo conceptual, y que en ese dominio
del problema lo que hicimos fue identificar conceptos. Luego se decidió
cuáles conceptos se deben virtualizar en código. 

Un objeto tiene atributos o características y además puede
realizar acciones que están representadas por lo que se conoce como métodos. 

Al final definimos un objeto como una representación de lo que queremos hacer, 
tanto en la vida real como en virtual, esa representación se crea por medio de
una plantilla, con el objetivo de que todos sean iguales, esa plantilla
a nivel de código en POO es una clase. 

En JAVA y en otros lenguajes de programación se usa la palabra resevada class 
para representar uno o varios objetos. 

Hay objetos en un programa que solo están relacionados con la lógica de negocio, 
otros solo están relacionados con la parte estructural, por ejemplo la 
capa lógica. Todo junto forma el paradigma de la orientación a objetos. 

Incluirémos clases puente. 

Ventajas de la programación orientada a objetos

* Desarollo más rápido.
* Aumento de calidad.
* Mantenimiento más sencillo.
* Parecida con la forma humana de pensar, naturalidad.
* El proceso de entendimiento es mucho más rápido que el proceso de 
entendimiento de la forma estructurada. Hay ciertas partes de la orientación
a objetos que son bastante lógicas. 

Mejoras de usar una notación estándar

* Mayor rigor en la especificación.
* Mejores condiciones para realizar la validación.
* Mejores condiciones para realizar la automatización.
* Documentar las decisiones que se han tomado. 
  
  Cómo se hace la integración a objetos en un programa que tiene varios?
  
  Hay que entender cómo se comporta un objeto y para ello hay que asimilarlo
  a un objeto de la vida real, todo objeto tiene características, esas 
  características son únicas de cada objeto. Es decir, cada objeto parecido
  tiene esas características en común, pero cada uno tiene sus propios valores. 
  
  Cada objeto que representa una clase en memoria es una instancia. 
  
  Lo primero que debemos entender es que las características son únicas de cada uno. 
  
  La teoría de OOP dice que todo objeto tiene la obligación de conocer toda la información 
  relevante de sus características y solamente ese objeto puede modificar esa información. 
  
  En los programas sí se pueden cambiar, el único detalle es que solo las instancias puedan 
  cambiar sus características. 
  
  Esto se logra con la asignación de dichas funcionalidades en su plantilla. 
  
  Los atributos tienen un tipo de dato, un nombre y un valor, ese valor puede cambiar. 
  
  Un objeto puede solicitarle a otro que cambie sus valores, sin embargo no puede cambiarselos directamente. 
  
  ## Cómo se hace para garantizar que el programa cumpla con ello?
  
  Para eso existe lo que se conoce como *Modificadores de acceso*
  
  **Modificadores de acceso**
  Es aquello que me permite a mí ocultar o mostrar información a un grupo de objetos relacionados. 
  
  Un objeto no tiene por qué ver los atributos de otro objeto. 
  
  El identificador de acceso por defecto es una opción llamada *protected*, siempre que no esté definido es protected. 
  
  Protected tiene 2 características 
  
  1. Para todos los archivos que estén en el mismo directorio de la computadora, lo que es protected es
  como si fuera público, por eso es que el main puede ver esas propiedades de otros objetos. 
  2. Se verá más adelante
  
  *Public* es la otra opción 
  
  El identificador Public hace que el objeto sea visible para todo el directorio, para todos los archivos y para 
  todos los directorios, por lo que podrán ser modificados y vistos desde cualquier parte. 
  
  El otro es el identificador *Private*
  *Private* hace que no aparezca, están total y completamente protegido, solo el objeto podrá cambiar los 
  valores de sus atributos y verlos también. 
  
  La orientación a objetos dice que todos los objetos deben tener una manera de proteger sus propias características. 
  
  Si yo tengo un atributo que está privado, cómo hago entonces desde el main para modificarlo? 
  
  Para poder tener acceso a esos atributos existe una opción que se llama getters y setters, en C# se llama 
  properties. A esos métodos se les conoce como métodos de acceso. Los métodos de acceso sirve para que otro
  objeto le pida a otro objeto que cambie su valor. Sin los métodos de acceso un objeto no puede saer los valores 
  de otro objeto, menos modificarlos. Por cada atributo que yo tengo se debe crear un método de acceso para 
  mostrar la información y un método de acceso para modificar la información. 
  
  
  Los métodos de acceso no pueden ser ni protected ni privados, deben ser public. 
  
  El set se encarga de asignarle el valor al atributo. 
  
  En ningún momento se indica que se debe reservar la palabra reservada static en un objeto. No se utilizará 
  en los objetos creados por ahora. 
  
  Cuando se crean librerías es muy común que la use un tercero, por ende todos los datos deben ser privados, solo 
  así uno se garantiza que el código no pueda ser manipulado de forma malintencionada. 
  
  El paradigma de la orientación a objetos dice que los atributos por fuerza deben ser mínimo protected. Pero 
  en cuanto a los métodos si pueden ser *public*.
  
  En el caso de las validaciones, no es de mala práctica hacerlas en los gets por ejemplo, no obstante, si el 
  código es muy extenso, se debería de crear un método único que la haga dentro del objeto, este método 
  puede retornar un mensaje que diga si el valor pasó la validación o no. Si no pasó la validación 
  la UI se debe encarga de saber qué hacer en dicho caso. 
  
  En el caso de concatenar los datos por ejemplo, eso lo debería hacer cada objeto. 
  
  Existe un método que retorna un String con la información de cada instancia, ese método se llama toString, 
  convierte todos los atributos en un String. 
  
  Tres formas de hacer un string. 
  
  1. Usando los gets.
  2. Usando un string que concatena las propiedades. 
  3. Usando el IDE. 
  
  Encapulsamiento es la técnica que tienen los objetos de ocultar su información. 
  
  Concepto de orientación a objetos Acoplamiento. 
  
  Mide que tan fuerte es la dependencia entre el objeto a y el objeto b. 
  
  El nivel óptimo es bajo acoplamiento. 
  
  Si los objetos estuvieran en la capa de presentación (main) se hubiera tenido que hacer cambios, 
  sin embargo, el main tiene un nivel óptimo de acomplamiento. 
  
  La ventaja que tiene la capa de presentación es que a la capa lógica solo le tiene que pasar una serie de parámetros. 
  
  Conforme va pasando el curso se aprenderá a hacer las cosas poco acopladas en todo sentido. 
  
  Cuando no se inicializan los valores de los atributos estos quedan inicializados en sus valores por defecto. 
  
  En el caso de objetos, matrices y Strings se inicializan en *null*. 
  
  Valores primitivos reales se inicializan en 0.
  
  Los valores de los atributos no se deberían inicializar directamente en el atributo, es de mala práctica. 
  
  Solo se pueden inicializar las variables estátitas y las constantes, nada más. 
  
  Se debe usar un método particular para inicializar un objeto. Este método se llama *Constructor*.
  
  El constructor es el método que se utiliza para inicializar los atributos de un objeto.
  
  Cómo se diferencia un constructor? 
  
  Como se usa para inicializar un objeto, por definición es público. Hay patrones que tienen 
  constructores privados, pero eso se utilizará en programación en patrones. 
  
  Por definición (en nuestro caso) el constructor deberá ser público siempre. 
  
  Un constructor no tiene un tipo de retorno, ni tampoco es void.
   
  Un constructor debe llamarse igual que la clase. 
  
  Cómo se hace para llamar a un constructor? 
  
  Es sencillo, se crea una instancia. 
  
  **Ejemplo**
  
  ```java
  Laboratorio l;
  l = new Laboratorio();
  ``` 
  
  Un constructor que no recibe parámetros es conocido en la gerga común como Constructor por defecto, principalmente
  se usa para inicializar el objeto con valores por defecto. 
  
  Si no se incluye ningún constructor a la clase, Java se encargará de crear un Constructor por defecto, simplemente 
  para que el programa no tire un **NullPointerException**.
  
  Los objetos pueden tener objetos dentros, un laboratorio podrá tener una variable curso de tipo curso. Por ende es indispensable 
  usar un constructor por defecto. 
  
  Uno objeto puede tener más de un constructor. 
  
  Un objeto debe tener 10 constructores? 
  
  Sí, pero no es de buena práctica, ya que la documentación se complicaría demasiado. 
  
  La recomendación es crear un constructor por defecto y otro que inicialice todos los objetos. Si se necesita
  un constructor adicional se puede hacer pero que nada más sea uno adicional, no muchos. Luego, si se necesita 
  agregar algo más se puede manipular con getters y setters. Si esto no se sigue se terminará creando una cantidad 
  ilógica de constructores. 
  
  No se puede tener dos constructores que tengan el mismo número de argumentos, con el mismo nombre y del mismo tipo, 
  ya que violaría la firma del método. 
  
  La propiedad que tiene un objeto para crear métodos con distinta firma se le conoce como sobre-carga de métodos. 
  
  **Conceptos clave del día de hoy**
  
  1. Encapsulamiento.
  2. Acoplamiento.
  3. Identificadores de acceso. 
  4. Métodos de acceso. 
  5. Constructores. 
  6. Sobrecarga de Constructores.
  
  Estudiante
  
  Nombre 
  Primer Apellido 
  Segundo Apellido 
  Identificación 
  Género 
  Edad ya no va a existir, se usará la fecha de nacimiento y el cálculo se hará dentro del objeto, se usará 
  LocalDate o LocalDateTime. 
  El estudiante es becado? 
  
  Curso
  
  Código 
  Nombre 
  Cantidad de créditos
  
  Se debe cambiar toda la arquitectura con las nueva. 
   
  
  
   

Asociación 
Agregación
Composición 
Herencia

Asociación se da cuando hay relación de dependencia o de uso. Se tiene un objeto servidor y un objeto cliente. Por ejemplo la UI y el Controller y el Controller con la Capa Lógica. 

Agregación y Composición son un tipo de asociación. 
Efectivamente hay alguien que le ofrece un servicio a otro alguien. El único detalle es la forma de dicha relación. 
Cuando se utiliza asociación la relación es 100% conceptual a nivel del dominio del problema. 
Se sabe que un vehículo tiene un dueño, que una propiedad tiene un dueño, etc. 
Hay casos específicos donde existe una relación llamada todo o parte. 
En esta relación hay algo que está conformado por cosas. 
Uno forma parte del otro.
Por ejemplo, un motor y un vehículo. 
El motor está dentro del vehículo y también le provee servicios al vehículo. 
En este caso la relación es todo o parte y es una relación de contención, donde uno está contenido en otro. 
En muchos casos la contención es física, por ende es sencillo de comprender. 
Otro ejemplo de contención física: Un procesador está dentro de una computadora. 
Una diferencia clave entre agregación y composición es la dependencia, o lo que se conoce mejor como la vida de objetos. 
La vida del objeto es el tiempo en que ese objeto está en memoria, un objeto estará en memoria hasta que alguien lo deje de utilizar, 
cuando se deja de utilizar el objeto deja de existir en memoria. 
La vida de los objetos determina si se habla de una agregación o de una composición. 
Si se tiene una persona por ejemplo y dentro de esta persona hay un corazón, hay una relación todo o parte. 
Si la persona desaparece, el objeto que está dentro desaparece también, el nivel de dependencia es muy elevado. 
Cuando en la relación de los objetos, deja de existir la parte cuando el todo deja de existir se está hablando de una composición. 
La composición se da cuando la parte muere cuando el todo también muere. 
Si la capa lógica no existe por ejemplo, el controlador no va a poder hacer nada, pero, el controlador puede estar en memoria cuando la capa lógica no está en memoria. 
Cuando la parte sigue existiendo a pesar de que el todo ha muerto se considera oficialmente una asociación. 
Ejemplo un curso no tiene una asociación con un profesor, tiene una agregación, el profesor puede existir cuando el curso no existe. 
El curso y el tema del curso son una composición, porque en el momento de que el curso muere el tema también. 
Cuando hay exclusividad hay agregación. 
Cuando se está haciendo el análisis se debe determinar primero si la relación es una relación todo o parte.
Si hay una relación o parte y hay exclusividad y hay alta dependencia es composición. 
Si es una relación es todo o parte y no hay exclusividad y no hay una dependencia en la vida del objeto entonces es una agregación. 
Y si ninguna de estas normas se cumple entonces es una asociación. 

*Tradicionalmente el número de serie del vehículo está asignado al motor, para evitar cualquier tipo de complicación. Esto es una regla de negocio.*

Tarea terminar el proyecto de hoy, mejorar la optimización del código fuente del proyecto de Empleado Computadora. Se pasará a la pizarra a presentar. 

 


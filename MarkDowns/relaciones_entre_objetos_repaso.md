# Asociación 

Es la más común, se utiliza para representar dependencia semántica. 

Un ejemplo de asociación podría ser: “Una mascota pertenece a una persona”.


*En una agregación o composición la clave es que hay algo que 
está conformado por cosas*

*Por ejemplo:*

Un auto y un motor, un hospital se conforma de pacientes, una escuela
se conforma de alumnos, una carrera está conformada por cursos, una carrera está conformada por cursos. Un autor se conforma por su libro. Donde hay un todo y sus partes. 

Pongamos el todo como un imán y sus partes pequeños imanes. Si 
esto es válido entonces se califica como una relación de contención, o 
también llamada TODO-Parte

Si yo digo relación entre persona y mascota, no puedo decir que una persona se conforma por una mascota, porque no es cierto. En este caso es una asociación. Ya que una mascota puede pertenecer NO CONFORMAR a una persona. 

# Agregación

Es una representación jerárquica qu indica que un objeto y las partes componen es objeto. Es decir, representa relaciones en las que UN OBJETO ES PARTE DEL OTRO o bien UN OBJETO ESTÁ CONFORMADO POR EL OTRO, pero aún 
así debe tener existencia en sí mismo. 

*Por ejemplo:* 

Las mesas están conformadas por tablas de madera y tornillos. O también,
las tablas de madera y los tornillos son parte de una mesa. 

Un libro forma parte de un Autor, o el autor se conforma por sus libros. 

# Composición

Similar a la agregación, representa una relación jerárquica entre un objeto y las partes que lo componen, pero de una forma más fuerte. En este caso, los elementos que forman parte no tienen sentido de existir cuando el todo no existe. Es decir, cuando el elemento que contiene los otros desaparece, deben desaparecer todos ya que NO TIENE SENTIDO por sí mismos sino que dependen del elemento que componen. Además, suelen tener los mismos tiempos de vida. Los componentes no se comparten entre varios elementos, esta es otra diferencia de la agregación. 

*Ejemplo:* 

Un vuelo de una compañía aerea está compuesto por pasajeros, que es lo mismo que decir que un pasajero está asignado a un vuelo. 


# Diferencia entre agregación y composición

La diferencia es más que todo semántica, por lo que a veces no está del todo definida. 

La composición tiene un acoplamiento más estricto que la agregación y definitivamente implica contención. El requisito básico es que, si una clase de objetos (llamado "contenedor") se compone de otros objetos (llamados "elementos"), entonces los elementos aparecerán y también serán destruidos como un efecto secundario de crear o destruir el contenedor. Sería raro que un elemento no se declare como privado. Un ejemplo podría ser el nombre y la dirección del cliente. Un cliente sin nombre o dirección no tiene valor. Por la misma razón, cuando se destruye el cliente, no tiene sentido mantener el nombre y la dirección. Pero si hay otros clientes que viven en esa dirección es diferente. 

# Dependencia 

Se utiliza este tipo de relación para representar que una clase requiere de otra para ofreser sus funcionalidades, así de simple. Se indica con línea punteada y flecha. 

# Interfaces

Es una entidad que declara una serie de atributos, funciones y obligaciones. Es una especia de contrato donde toda instancia asociada a una interfaz debe de implementar los servicios que indica aquella interfaz. 

Dado a que únicamente son declaraciones no pueden ser instanciadas. 

Las interfaces se asocian a clases. Una asociación entre una clase y una interfaz representa que esa clase cumple con el contrato que indica la interfaz, es decir, incluye aquellas funciones y atributos que indica la intefaz. 

Su representación es similar a las clases, pero indicando arriba la palabra <<interface>>
https://diagramasuml.com/diagrama-de-clases/

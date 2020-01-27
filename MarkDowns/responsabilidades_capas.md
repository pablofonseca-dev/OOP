# Las matrices y los arreglos son similares

* Tienen un tamaño fijo
* Almacenan más de un valor
* Almacenan un solo tipo de datos 
* Tienen indices 
* Se manejan por referencia

Las matrices a diferencia de los arreglos sí ocupan coordenadas, 
se necesita el eje x y y para conseguir la posición exacta de un valor. 

Una matriz es un arreglo de arreglos, que tiene filas y columnas. 

Para recorrer una matriz se recorre de cada fila cada columna.

**Existen 5 Formas básicas para recorrer una matriz:**

1. Recorrerla completamente. 
2. Recorrer solo una fila específica. 
3. Recorrer solo una columna específica. 
4. Recorrer la matriz en diagonal. 
5. Recorrerla a la inversa. 

Las matríces no son dinámicas, por ende cuando se inicializa se debe indicar 
cuál es la fila y cuál es la columna. 

Se puede hacer una variante de ese ejercicio. Por ejemplo se puede calcular la 
nota de un examen. Se tiene un arreglo donde se tiene las notas de los examenes, 
y otro arreglo donde se tiene el nombre del estudiante. Lo único es que en vez 
de solicitar la nota del examen se deberá calcular la nota. Para ello se tendrá una matriz, se llamará preguntas y tendrá 5 filas, donde se registrarán los puntos totales por pregunta. En la primera columna se obtendrá.

## Notas de N Capas y Abstracción  

Método main es monolítico, es decir el código va incluído en uno solo

Abstracción del programa, diversos propósitos por módulos. 

Asignación de responsabilidades. 

Se separa la estructura en pedazos.

La interfáz gráfica, se encarga del renderizado de la información, tomar datos. 

La lógica, se encarga de tres responsabilidades: 

1. Lógica de Negocio: Registrar la nota, recorrer el arreglo, registrar el estudiante, validar si el estudiante existe. 
2. Transporte o Intermediación: Envía los datos a la capa lógica, y la capa lógica los tiene que procesar. 
3. Sirve de almacenamiento de datos. No solo procesa, sino que despues de procesar almacena la información obtenida de una caja negra. 

## Requisitos para trabajar en capas

1. Tener un archivo UI.java, contiene objetos IO como BufferedReader y PrintStream. 
2. Tener un archivo que se llame capa lógica o lógica con extensión .java, aquí se tendrán las matrices, los arreglos y las rutinas. 

Ambos archivos deben estar en el mismo directorio, para que ambos puedan comunicarse. 
Se comunican mediante el nombre del archivo, por ejemplo logica.<etc>

**Un royecto en IntelliJ es igual a un grupo de archivos .java**


**Arquitectura** define cómo algo está organizado. Yo puedo organizar de diversas maneras la arquitectura de una aplicación. 








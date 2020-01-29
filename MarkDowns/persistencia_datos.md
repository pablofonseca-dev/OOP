# Persistencia de datos

## Persistencia de datos en memoria
El recolector de basura se encarga de eliminar datos no utilizados en ejecución.

Por ejemplo cuando se cambia la dirección de memoria de un arreglo, en ese caso los datos apuntados inicialmente 
se borran de memoria para no cargar la RAM. Eso lo hace un recolector de basura. 

## Persistencia de datos en archivos

Cuando la información se carga en un archivo de texto, en ese caso los datos quedarán almacenados hasta
que el archivo sea eliminado o bien, hasta que el programa reciba la instrucción de borrar ciertos archivos específicos. 

No es muy factible porque cada vez que el programa termina su ejecución se debe ingresar otra vez la información. 

**Tipos de extensiones comúnes**

* .json
* .properties
* .ini
* .txt
* .word 
* .xlsx 

Cada una de estas extensiones tienen su estructura. 

Para leer un **.txt** se conoce que cada línea nueva es un registro, o bien, que cada dato separado por coma es un 
*registro nuevo*. 

La persistencia en texto es relativamente simple, en el curso se explica en una o dos clases como máximo.

Los archivos de texto hablan un lenguaje, en este caso es texto, puros Strings. 
 

## Persistencia de datos en base de datos

Las bases de datos son programas que tienen los datos en archivos con un formato específico (NOSQL como MongoDB) y hay otras que 
manejan el paradigma de entidad relación, que son aquellas donde los datos están distribuidos en tablas. 

Hay otro tipo de base de datos que son las orientadas a objetos, que guardan la información como objetos dentro de ellas. 

Las bases de datos utilizan las estructuras de datos que permiten estructurar de manera eficiente la información. 

Dan metodologías para optimizar las búsquedas de datos, esto lo incorpora el motor de base de datos. 

Requieren de librerías adicionales para poder conectarse a la base de datos. 

Las bases de datos relacionales no entienden texto o Strings, sino SQL. 

Se necesita una libería que traduzca el texto a SQL. 

**Este es el orden que se va a implementar en el curso**

Los datos tienen que estar en un elemento por aparte, no se pueden tener en cualquier lugar, para que la transición sea más sencilla. 

En memoria las estructuras que vamos a utilizar de momento es arreglos y matrices. Cuando se empiece a ver objetos se verán elementos como
ArrayList y TreeMap. Estas estructuras representarán la base de datos y se ubicarán en la capa lógica. 

La persistencia va a tener su propio archivo, la capa lógica y la UI también. 

Para poder trabajar con las N Capas siempre se aplicará el concepto de **responsabilidad**, cada capa va a representar una responsabilidad específica. 

**De momento se manejarán dos capas**


1. La capa de UI. 
2. La capa lógica: Servirá para procesar información y también de momento servirá de capa de persistencia. 

**La primera letra del nombre va en mayúscula siempre, la de cada palabra.** 

Ejemplo: *CapaLogica.java*

**Información del nuevo asistente**

1. Nombre: 		Tracy Mora
2. E-mail: 		tmora@ucenfotec.ac.cr
3. Teléfono Celular: 	83290700

















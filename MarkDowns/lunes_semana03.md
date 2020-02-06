# Semana 03 Lunes 03 de Febrero. 

## Tarea:

1. Relacionado con arreglos, debido a las Collections.
2. Listar y registrar laboratorios
3. Listar y registrar estudiantes

## Null, lidiar con los valores por referencia.

Como los datos son los que indican el valor de las aplicaciones, es muy importante que los datos no estén expuestos,
hablando de datos en general.

Acceder directamente a las variables de la CL no es buena prática, porque el código externo puede manipular esa información,
incluso sin querer hacer un daño en específico.

Lo que se puede hacer es que la capa lógica le saque una copia al arreglo y lo retorne, o bien, que generes su propio string de datos.

Otra solución es ajustar en la capa lógica un arreglo de una manera efeciva y con un text formatting que retorna un String con los datos.

Se creará un arreglo nuevo en una rutina en la CL.

## Proceso de abstracción

Se toman los elementos del dominio de un problema y los extrae en forma de lista, para saber las características y el comportamiento que esos
elementos tiene.

Requiere identificar los elementos importantes.  

Nada que tenga que ver con la resolución del problema forma parte del dominio del problema.

Cuando se tiene un problema lo relevante es todo aquello que tiene que ver con la resolución del problema.

Todos los elementos relacionados con la solución directa no forman parte de la resolución.

Se deben identificar

* Sustantivos
* Verbos
* Adjetivos

1. Las cosas que forman parte del dominio del problema
2. Sus características
3. Y sus acciones.

Si se realiza una lista de cada una de ellas se puede finalizar con un buen proceso de abstracción.

**El objetivo de la POO es virtualizar el problema que se trata de resolver, es decir, intenta crear todos los elementos que solucionan un problema en elementos virtuales de Software.**

**El problema del paradigma estructurado es que es un paradigma tieso.**


## Para agregar parámetros ilimitados

```java

public static void <name>(String...args){}

```

*"Args"* es un objeto que dependiendo de su tipo de dato se almacenará en una colección de ese mismo. En el caso de tener diferentes valores,
se puede crear una collection de tipo **Object**.

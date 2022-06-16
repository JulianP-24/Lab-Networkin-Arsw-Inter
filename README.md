# Tarea ARSW Inter (HttpServer que lee imagenes, js, css y html)

## Autor
Julian Adolfo Peña Marin

## Descripcion
La aplicacion es un servidor http, que devuelve archivos con extensiones css que son archivos de estilo, extensiones "js" que son archivos javascript, extensiones "html" que muestra como tal una pagina web y una imagen.

## Documentacion
Para obtener la documentacion del proyecto, con el siguiente comando se puede generar:

```
    mvn javadoc:javadoc
```

## Como Correrlo
Primero se debe clonar el repositorio, para esto puede utilizar el siguiente comando de git, con la url del repositorio que se quiere clonar, como se muestra a continuación

```
    git clone https://github.com/JulianP-24/Lab-Networkin-Arsw-Inter.git
```

Una vez clonado para generar el JAR, debe poner el siguiente comando

```
    mvn package
```

Despues puede correrlo con el siguiente comando, ubicandose en la carpeta raiz
```
    java -cp "./target/classes/" edu.escuelaing.arsw.app.TareaHttpServerBrowser.httpServerBrowser
```

Otra forma para correrlo, ya generado el JAR, es con el siguiente comando

```
    java -cp "target/LabNetworkinArswInter-1.0-SNAPSHOT.jar" edu.escuelaing.arsw.app.TareaHttpServerBrowser.httpServerBrowser
```

## Funcionamiento de la aplicacion
Para verificar el funcionamiento, lo que se hace es poner a correr el programa con cualquiera de los comandos mencionados anteriormente. Una vez este corriendo podremos acceder a la ruta con los archivos que queremos que devuelva. La ruta es la siguiente

```
    http://localhost:35001/"Archivo que se quiere buscar"
```
Donde 
 * 35001 es el puerto por el que corre la aplicacion

Para devolver una imagen, se ingresa a la siguiente ruta

```
    http://localhost:35001/valorant.jpg
```
Como resultado se obtiene la imagen:

![](img/img1.png)

Para devolver una archivo js, se ingresa a la siguiente ruta

```
    http://localhost:35001/index.js
```
Como resultado se obtiene la imagen:

![](img/img2.png)

Para devolver una archivo css, se ingresa a la siguiente ruta

```
    http://localhost:35001/style.js
```
Como resultado se obtiene la imagen:

![](img/img3.png)

Para devolver una archivo html, se ingresa a la siguiente ruta

```
    http://localhost:35001/index.html
```
Como resultado se obtiene la imagen:

![](img/img4.png)

## Diagrama de Clases
A continuacion se presenta el diagrama de clases de la arquitectura para la tarea propuesta

![](img/diagramaClases.png)

Como se puede observar la arquitectura se encuentra dentro de tres paquetes, el primero de ellos es el paquete con nombre app, el cual es el principal y en donde estan contenidos los otros dos, el segundo paquete es el que tiene como nombre TareaHttpServerBrowser, el cual tiene la clase principal y otro paquete de nombre Reader. En la clase principal se tiene el metodo main , que es donde esta la implementacion del servidor y en donde verifica la extension del archivo que le llega al path, una vez verificado llama a uno de los metodos de la clase que esta en el paquete Reader para obtener el resultado correcto.

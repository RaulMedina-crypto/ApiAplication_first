This looks like a great start for your e-commerce project API! Before we dive into the explanation, I spotted a tiny bug in your code that you might want to fix.

In `ProductoService.java`, inside the `actualizarProducto` method, look at this line:

```java
if(descripcion != null) producto.setDescripcion(nombre); // ⚠️ It says 'nombre' instead of 'descripcion'

```

It should be `producto.setDescripcion(descripcion);`. Make sure to correct that so your descriptions update properly!

---

Here is a complete, structured breakdown of your files, their purpose, and their logic blocks in Spanish so you can easily adapt this into your `README.md` or technical documentation.

## 🛠️ Arquitectura del Proyecto (Spring Boot REST API)

Este proyecto sigue la arquitectura de capas típica de una aplicación web, separando las responsabilidades de los datos (**Model**), la lógica de negocio (**Service**) y los puntos de acceso HTTP (**Controller**).

---

### 1. `ApiApplication.java`

* **Propósito:** Es el punto de entrada principal de la aplicación.
* **Bloques de Lógica:**
* `@SpringBootApplication`: Esta anotación activa la configuración automática de Spring Boot, el escaneo de componentes (para encontrar controladores y servicios) y permite que el proyecto se ejecute de forma autónoma.
* `main(String[] args)`: Método estándar de Java que arranca el framework usando `SpringApplication.run()`, inicializando el servidor embebido (Tomcat) y el contexto de la aplicación.



---

### 2. `Producto.java`

* **Propósito:** Representa el Modelo (Entity/POJO) de los datos de un producto dentro de la aplicación. Define qué atributos tiene un producto.
* **Bloques de Lógica:**
* `public static Long total = 0L;`: Un contador estático a nivel de clase para simular de forma temporal una base de datos autoincrementable.
* `Constructor con parámetros`: Incrementa el `total` y asigna ese valor como el `id` único de cada producto en el momento de su creación.
* `Constructor vacío`: Requisito indispensable para tecnologías como JPA/Hibernate, permitiendo que Spring instancie el objeto de forma genérica.
* `Getters y Setters`: Métodos públicos estándar para encapsular, acceder y modificar las propiedades privadas del producto.
* `toString()`: Sobrescribe el método nativo para representar el producto en formato de texto limpio, útil para depuración (*debugging*).



---

### 3. `ProductoService.java`

* **Propósito:** Capa de Servicio. Aquí reside la lógica de negocio y la manipulación de los datos (CRUD). Como no usa base de datos persistente en esta etapa, emula el almacenamiento en memoria.
* **Bloques de Lógica:**
* `@Service`: Indica a Spring que esta clase contiene la lógica de negocio y debe ser registrada como un componente administrado (Bean).
* `ArrayList<Producto> lista`: Estructura en memoria donde se guardan temporalmente los productos.
* `Constructor ProductoService()`: Actúa como un semillero de datos (*data seeding*), precargando una lista fija de 10 productos escolares para realizar pruebas de inmediato.
* `getProductos()`: Retorna la lista completa de artículos.
* `getProducto(Long id)`: Recorre la lista buscando un producto cuyo ID coincida con el solicitado. Lo retorna o devuelve `null`.
* `deleteProducto(Long id)`: Busca el producto por ID, lo remueve del `ArrayList` y retorna el producto eliminado.
* `crearProducto(Producto producto)`: Agrega un nuevo objeto `Producto` enviado desde el controlador a la lista.
* `actualizarProducto(...)`: Busca el producto por su ID y realiza modificaciones condicionales. Solo actualiza los campos si los parámetros recibidos no son nulos (`!= null`).



---

### 4. `ProductoController.java`

* **Propósito:** Capa de Controlador REST. Expone los puntos de acceso (endpoints) HTTP para interactuar con la aplicación externamente.
* **Bloques de Lógica:**
* `@RestController`: Combina `@Controller` y `@ResponseBody`. Le dice a Spring que las respuestas de los métodos serán convertidas automáticamente a JSON.
* `@RequestMapping(path = "/api/productos/")`: Define la ruta base para todos los endpoints de este controlador.
* `@Autowired (Constructor)`: Aplica la Inyección de Dependencias. Spring busca el componente `ProductoService` y se lo provee al controlador automáticamente.
* `@GetMapping`: Maneja peticiones HTTP GET a `/api/productos/` para listar todo el catálogo.
* `@GetMapping("{productoId}")`: Usa una variable de ruta (`@PathVariable`) para buscar un producto específico por su ID.
* `@DeleteMapping(path="{productoId}")`: Escucha peticiones DELETE en la ruta para remover un elemento usando su ID.
* `@PostMapping`: Recibe un cuerpo JSON en la petición (`@RequestBody`), lo mapea a un objeto `Producto` y lo envía al servicio para crearlo.
* `@PutMapping(path="{productoId}")`: Permite actualizar parcialmente un producto pasando su ID por la URL y los datos modificados mediante parámetros de consulta (`@RequestParam`).



---
Método,Endpoint,Descripción,Parámetros / Cuerpo
GET,/api/productos/,Obtiene la lista completa de productos escolares.,Ninguno
GET,/api/productos/{productoId},Obtiene los detalles de un producto específico mediante su ID.,productoId (Variable de ruta)
POST,/api/productos/,Registra un nuevo producto en el sistema.,Cuerpo JSON (Producto)
PUT,/api/productos/{productoId},Modifica parcialmente las propiedades de un producto existente.,"productoId (Ruta) + nombre, descripcion, imagen, precio (Query Params opcionales)"
DELETE,/api/productos/{productoId},Elimina un producto del catálogo por su ID.,productoId (Variable de ruta)

---

🛠️ Tecnologías Utilizadas
Java 17 (o superior)

Spring Boot 3.x

Spring Web (Creación de servicios RESTful)

Gradle (Gestor de dependencias y construcción)

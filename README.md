# Login JWT Spring Boot

Este proyecto es una implementación de un sistema de autenticación y autorización utilizando JSON Web Tokens (JWT) en una aplicación Spring Boot. La aplicación permite a los usuarios registrarse, iniciar sesión y acceder a rutas protegidas utilizando JWT para la autenticación.

## Requisitos

- Java 11 o superior
- Maven 3.6.0 o superior
- MySQL (puedes usar cualquier otra base de datos cambiando la configuración en `application.properties`)

## Instalación

1. Clona el repositorio en tu máquina local:

    ```sh
    git clone https://github.com/Benjax14/login-JWT-SpringBoot.git
    cd login-JWT-SpringBoot
    ```

2. Configura tu base de datos en el archivo `application.properties`:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Crea un archivo `.env` en la raíz del proyecto para almacenar las variables de entorno necesarias:

    ```env
    SPRING_DATASOURCE_USERNAME=root
    SPRING_DATASOURCE_PASSWORD=1234
    SPRING_DATASOURCE_DB=db
    ```

4. Instala las dependencias y construye el proyecto usando Maven:

    ```sh
    mvn clean install
    ```

5. Inicia la aplicación:

    ```sh
    mvn spring-boot:run
    ```

## Endpoints

### Registro de Usuario

- **URL:** `/api/auth/register`
- **Método:** `POST`
- **Descripción:** Registra un nuevo usuario en el sistema.
- **Cuerpo de la petición:**

    ```json
    {
        "username": "correo@gmail.com",
        "password": "password123",
		"firstname": "Benjamin",
		"lastname":  "Contreras",
		"country": "Chile"
    }
    ```

### Inicio de Sesión

- **URL:** `/api/auth/login`
- **Método:** `POST`
- **Descripción:** Autentica al usuario y devuelve un JWT.
- **Cuerpo de la petición:**

    ```json
    {
        "username": "existinguser",
        "password": "password123"
    }
    ```

- **Respuesta:**

    ```json
    {
        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    }
    ```

### Ruta Protegida

- **URL:** `/api/v1/demo`
- **Método:** `POST`
- **Descripción:** Accede a esta ruta solo con un JWT válido.
- **Encabezado de la petición:**

    ```http
    Authorization: Bearer <token>
    ```

## Estructura del Proyecto

- `src/main/java/com/benja/login/login/Config`: Contiene la configuración de seguridad y beans.
- `src/main/java/com/benja/login/login/Controllers`: Contiene los controladores REST.
- `src/main/java/com/benja/login/login/Entities`: Contiene las entidades y modelos de datos.
- `src/main/java/com/benja/login/login/Repositories`: Contiene los repositorios de Spring Data JPA.
- `src/main/java/com/benja/login/login/Jwt`: Contiene la lógica de generación y validación de JWT.
- `src/main/java/com/benja/login/login/Services`: Contiene servicios de negocio que contienen la lógica de la aplicación.
- `src/main/java/com/benja/login/login/Request`: Clases para las solicitudes de entrada.
- `src/main/java/com/benja/login/login/Response`: Clases para las respuestas de las solicitudes.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

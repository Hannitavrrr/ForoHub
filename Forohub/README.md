# ForoHub - Aplicación de Foro

## Descripción

ForoHub es una aplicación de foro desarrollada con Spring Boot. Permite a los usuarios registrarse, autenticarse y participar en discusiones a través de la creación y gestión de tópicos y respuestas. La aplicación utiliza JWT (JSON Web Tokens) para asegurar los endpoints de la API.

## Funcionalidades

- **Registro y Autenticación de Usuarios**: Los usuarios pueden registrarse y autenticarse usando JWT.
- **Gestión de Tópicos**:
  - Crear, listar, actualizar y eliminar tópicos.
  - Buscar tópicos por nombre de curso y año específico.
  - Paginación y ordenamiento de tópicos.
- **Gestión de Respuestas**: Los usuarios pueden agregar respuestas a los tópicos.

## Tecnologías Utilizadas

- **Java 11**
- **Spring Boot 2.5**
- **Spring Security**
- **JWT**
- **Spring Data JPA**
- **H2 Database** (para desarrollo)
- **Maven**

## Configuración del Proyecto

### Prerrequisitos

- JDK 11 o superior
- Maven 3.6.3 o superior

### Instalación

1. Clona el repositorio:
   ```sh
   git clone https://github.com/tu-usuario/forohub.git
2.Navega al directorio del proyecto:
cd forohub
3. Instala las dependencias del proyecto:
mvn clean install
Configuración de la Base de Datos
El proyecto está configurado para usar una base de datos H2 en memoria para desarrollo. Puedes cambiar la configuración de la base de datos en el archivo src/main/resources/application.properties.

Ejecutar la Aplicación
Para ejecutar la aplicación, usa el siguiente comando:
mvn spring-boot:run

La aplicación estará disponible en http://localhost:8080.

Uso de la API
Autenticación
Para autenticarse, envía una solicitud POST a /login con el nombre de usuario y la contraseña.

Solicitud:
POST /login
Content-Type: application/json

{
    "username": "tu_username",
    "password": "tu_password"
}

Contribuir
Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

Haz un fork del repositorio
Crea una rama (git checkout -b feature/nueva-funcionalidad)
Realiza tus cambios y haz commit (git commit -am 'Agregar nueva funcionalidad')
Sube tus cambios (git push origin feature/nueva-funcionalidad)
Abre un Pull Request
Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

Este archivo README proporciona una descripción detallada del proyecto, instrucciones para la configuración y uso, y ejemplos de cómo interactuar con la API utilizando Postman. Puedes adaptarlo y personalizarlo según las necesidades específicas de tu proyecto.

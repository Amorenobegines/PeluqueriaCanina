🐶 Peluquería Canina – Sistema de Gestión

Aplicación de escritorio desarrollada en Java (Swing + JPA + MySQL) para la administración completa de una peluquería canina.
Permite gestionar usuarios, roles, dueños, mascotas, servicios y citas, con una interfaz intuitiva y una arquitectura limpia. 
Con base de datos desplegada mediante Docker.

📦 Archivos incluidos

Archivo	Descripción
docker-compose.yml	          Levanta MySQL en Docker
peluqueria_canina.sql	        Script de creación de tablas
insert_peluqueria_canina.sql	Datos iniciales (roles, servicios, usuarios…)
src/	                        Código fuente del proyecto
dist/PeluqueriaCanina.jar	    Ejecutable de la aplicación
README.md	                    Documento de instalación y uso

🛠 Requisitos
  Java JDK 17+

  NetBeans 12+

  Docker Desktop

  MySQL Workbench (opcional)

🐳 Instalación con Docker

1. Levantar MySQL
  En la carpeta del proyecto:

  ```
  docker-compose up -d
  ```

  Esto crea:

  Servidor MySQL en localhost:3306

  Usuario: root

  Contraseña:

  Base de datos: peluqueriacanina

2. Importar la base de datos
   ```
   mysql -u root -p peluqueriacanina < peluqueria_canina.sql
   mysql -u root -p peluqueriacanina < insert_peluqueria_canina.sql
   ```

  O desde Workbench → Server → Data Import.

⚙ Configuración de persistence.xml

```
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/peluqueriacanina?serverTimezone=UTC"/>
<property name="javax.persistence.jdbc.user" value="root"/>
<property name="javax.persistence.jdbc.password" value=""/>
```

▶ Ejecutar la aplicación

  Clona el repositorio:
  ```
  git clone [https://github.com/Amorenobegines/PeluqueriaCanina.git]
  ```
 
  Abrir el proyecto en NetBeans

  Ejecutar PeluqueriaCanina.java

  Iniciar sesión con los usuarios de prueba

📂 Estructura del proyecto

```
PeluqueriaCanina/
│
├── src/
├── dist/
├── docker-compose.yml
├── peluqueria_canina.sql
├── insert_peluqueria_canina.sql
└── README.md
```

📌 Características principales

👤 Gestión de usuarios y roles
  Registro, edición y eliminación de usuarios.

  Sistema de login con validación.

  Roles: administrador, recepcionista y trabajador.


🐾 Gestión de mascotas y dueños

  Registro de mascotas con datos completos.

  Asociación automática con su dueño.

  Modificación y eliminación de registros.

✂️ Gestión de servicios
  Servicios fijos: baño, corte de pelo, corte de uñas.

  Servicios personalizados.

  CRUD completo.

📅 Gestión de citas
  Creación de citas con fecha y hora.

  Asociación de servicios y mascota.
  
  Edición y eliminación de citas.

🖥️ Interfaz gráfica (Swing)
  Formularios intuitivos.

  Validación de campos (solo letras, límites de caracteres, etc.).

  Iconos personalizados.

📄 Licencia
Este proyecto se distribuye bajo la licencia que tú elijas (MIT, Apache, GPL…).
Si no estás segura, te recomiendo MIT, que es simple y flexible.

👩‍💻 Autora
Alicia Moreno  
Desarrolladora de aplicaciones multiplataforma y web.
Apasionada por el desarrollo limpio, la arquitectura organizada y la experiencia de usuario.

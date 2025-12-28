🐶 Peluquería Canina – Sistema de Gestión

Aplicación de escritorio desarrollada en Java (Swing + JPA + MySQL) para la administración completa de una peluquería canina.
Permite gestionar usuarios, roles, dueños, mascotas, servicios y citas, con una interfaz intuitiva y una arquitectura limpia.

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

🗄️ Persistencia con JPA + MySQL
Controladores JPA generados automáticamente.

Metamodelos para Criteria API.

Conexión estable y optimizada.

🛠️ Tecnologías utilizadas
Tecnología	Uso
Java 17+	Lógica principal del sistema
Swing	Interfaz gráfica
JPA (EclipseLink)	Persistencia de datos
MySQL	Base de datos
NetBeans	IDE de desarrollo
Git + GitHub	Control de versiones

⚙️ Requisitos
Java JDK 17 o superior

MySQL 8+

NetBeans 12+

Conector JDBC: mysql-connector-j

Librerías JPA (EclipseLink)

🚀 Cómo ejecutar el proyecto
Clona el repositorio:

bash
git clone https://github.com/TU_USUARIO/PeluqueriaCanina.git
Abre el proyecto en NetBeans.

Configura la base de datos MySQL:

Crea una base de datos llamada peluqueriacanina.

Importa el script SQL (si lo incluyes en el repo).

Verifica el archivo persistence.xml con tus credenciales.

Ejecuta el proyecto desde NetBeans.

🧪 Funciones destacadas
Validación de campos con InputKey.

Utilidades de formulario con FormUtils.

Control centralizado con Controladora.

Persistencia desacoplada con ControladoraPersistencia.

📄 Licencia
Este proyecto se distribuye bajo la licencia que tú elijas (MIT, Apache, GPL…).
Si no estás segura, te recomiendo MIT, que es simple y flexible.

👩‍💻 Autora
Alicia Moreno  
Desarrolladora de aplicaciones multiplataforma y web.
Apasionada por el desarrollo limpio, la arquitectura organizada y la experiencia de usuario.

# Descripción general 
la api api-user fue realizada para la creación de nuevos usuarios.

# Instalación/Uso
Este repositorio muestra operaciones como llamadas a la API REST, incluidos métodos HTTP válidos, encabezados y contenido del cuerpo, cuando corresponda.
Las solicitudes se envían mediante métodos de llamada REST estándar, con un formato json predefinido para la creación de nuevos usuarios.

# Proceso
Al pasar el json con el formato predefinido este va a pasar por un proceso de validación del password y de el email, si estos están correctos se procederá a crear un token que se asignará a ese usuario y se guardará en la base de datos, luego retorna al cliente los datos requeridos del nuevo usuario.

# API EndPoint

- CREATE USER POST http://localhost:8080/api/usersnissumapi/user

# JSON FORMAT 
El formato Json que requiere la api para crear un nuevo usuario es el siguiente: 
{
	"name": "Juan Rodriguez",
	"email": "juan@rodriguez.org",
	"password": "hunter2",
	"phones": [
		{
			"number": "1234567",
			"citycode": "1",
			"contrycode": "57"
		}
	]
}

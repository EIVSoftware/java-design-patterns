# Ejemplo simple del uso de MongoDB con Spring con documentos embebidos

Se utiliza un servidor de MongoDB local en **127.0.0.1:27017** base de datos **test**.

Primero se hace una limpieza eliminando las colecciones `PersonaDoc` y `DireccionDoc`.

Luego se crean un documento de `PersonaDoc` el cual tiene en su interior un objeto de `DireccionDoc`.

Se hacen consultas por medio del repositorio y con criterios.

En este caso, se creará una sola colección llamada `PersonaDoc` que tendrá embebido un objeto de tipo `DireccionDoc`.

```json
{
    "_id": {
        "$oid": "5f21a7f8acf7623e34f1fa0c"
    },
    "nombre": "Juan Perez",
    "direccion": {
        "calle": "Sarmiento",
        "numero": "756"
    },
    "_class": "com.eiv.poc.docs.PersonaDoc"
}
```


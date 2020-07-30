# POC Spring Data MongoDB

## Ejemplo simple del uso de MongoDB con Spring usando objetos embebidos y documentos referenciados

Se utiliza un servidor de MongoDB local en **127.0.0.1:27017** base de datos **test**.

Primero se hace una limpieza eliminando las colecciones `personas` y `direcciones`. 

Luego se inserta en base de datos un documento de `PersonaDoc` el cual tiene en su interior un 
objeto de `DireccionObj` y referencia a un documento de `DireccionDoc`.

Se hacen consultas por medio del repositorio, usando criterios y con *querydsl*.

Colección `personas`:
```json
{
    "_id": {
        "$oid": "5f22b09eacf7620da0ef5ab1"
    },
    "nombre": "Juan Perez",
    "direccionObj": {
        "calle": "Sarmiento",
        "numero": "756"
    },
    "direccionDoc": {
        "_id": {
            "$oid": "5f22b09eacf7620da0ef5ab0"
        },
        "calle": "Sarmiento",
        "numero": "756"
    },
    "_class": "com.eiv.poc.doc.PersonaDoc"
}
```

Colección `direcciones`:
```json
{
    "_id": {
        "$oid": "5f22b09eacf7620da0ef5ab0"
    },
    "calle": "Sarmiento",
    "numero": "756",
    "_class": "com.eiv.poc.doc.DireccionDoc"
}
```


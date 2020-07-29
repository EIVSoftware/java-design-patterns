# Ejemplo simple del uso de MongoDB con Spring con documentos referenciados

Se utiliza un servidor de MongoDB local en **127.0.0.1:27017** base de datos **test**.

Primero se hace una limpieza eliminando las colecciones `PersonaDoc` y `DireccionDoc`.

Luego se crean dos documentos y se los consulta por medio del repositorio y con criterios.

En este caso, `PersonaDoc` tendrá una referencia a `DireccionDoc`.

```json
{
    "_id": {
        "$oid": "5f21a694acf7622268357703"
    },
    "nombre": "Juan Perez",
    "direccion": {
        "$ref": "direccionDoc",
        "$id": {
            "$oid": "5f21a694acf7622268357702"
        }
    },
    "_class": "com.eiv.poc.docs.PersonaDoc"
}
```

```json
{
    "_id": {
        "$oid": "5f21a694acf7622268357702"
    },
    "calle": "Sarmiento",
    "numero": "756",
    "_class": "com.eiv.poc.docs.DireccionDoc"
}
```


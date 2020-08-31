# MutantTest ([gcloud](https://github.com/jcipolatti/MutantTest/tree/gcloud))

## Descripción:
Este branch contiene el código de la versión productiva de la API. Incorpora plugins, configuraciones de conexión de base de datos y escalamiento de instancias requeridos por Google.

## Observaciones:
La versión de este branch ([gcloud](https://github.com/jcipolatti/MutantTest/tree/gcloud)) opera con una base de datos `MySql 8.0` alojada en `Google Cloud`.
Se puede ejecutar siguiendo el mismo instructivo de ejecución del [/README.md](https://github.com/jcipolatti/MutantTest/blob/master/README.md) del branch [master](https://github.com/jcipolatti/MutantTest)

# Importante:

Si se ejecuta localmente la API desde este branch ([gcloud](https://github.com/jcipolatti/MutantTest/tree/gcloud)), se podrá acceder a la misma por localhost:

`POST:` http://localhost:8080/mutant/

`GET:` http://localhost:8080/stats

Pero se estará trabajando directamente con la misma base de datos que operan las URL publicadas en la nube:

`POST:` https://keen-genius-287023.rj.r.appspot.com/mutant/

`GET:` https://keen-genius-287023.rj.r.appspot.com/stats

### NO realizar pruebas con la versión de este branch ([gcloud](https://github.com/jcipolatti/MutantTest/tree/gcloud))
### Cualquier ejecución impactará directamente en el ambiente productivo.

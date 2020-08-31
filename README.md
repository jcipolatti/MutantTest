# MutantTest

## Instrucciones de ejecución:
El servicio fue desarrollado con el IDE IntelliJ 2020 ULTIMATE por su integración con SpringBoot.

1. Abrir el proyecto alojado en la carpeta `/MutantTest`
2. Ejecutar la API:

   ![IntelliJ-RunAllTestWithCoverage](images/IntelliJ-RunMutantTestApplication.png)

---
En caso de utilizar IntelliJ COMMUNITY, u otro IDE, la API puede ser ejecutada a través del siguiente comando Maven:
`mvn springboot:run`
---

3. Ya se puede acceder al servicio a través de localhost (Ejemplos de ejecución con Postman):

   `POST:` http://localhost:8080/mutant/
   
   ![Postman-Mutant](images/Postman-Mutant.png)
   
   `GET:`http://localhost:8080/stats
      
   ![Postman-Stats](images/Postman-Stats.png)

4. Ejecutar tests con cobertura de código de IntelliJ:

   ![IntelliJ-RunAllTestWithCoverage](images/IntelliJ-RunAllTestWithCoverage.png)
   
## Observaciones:
La versión de este branch (master) opera con una base de datos H2 en memoria por lo que los valores alojados en la base de datos se perderán al detener la instancia de ejecución de la API.

Esta versión está preparada para realizar pruebas locales independientes, la versión publicada se encuentra en el branch [gcloud](https://github.com/jcipolatti/MutantTest/tree/gcloud)

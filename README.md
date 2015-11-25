# GORM Domain Objects with Same Field Name
Grails bug report on domain objects which have an unique field with the same field name.

Upgrading from Grails 2.x to 3.x causes an hibernate error on our domain objects which have an unique field with same field name. 
Please see:

    grails-app/domain/myapp/DomainObject1.groovy
    grails-app/domain/myapp/DomainObject2.groovy
	
The integration test `src/integration-test/groovy/myapp/DomainObjectIntegrationSpec.groovy` runs through without any error. But if I start the app with `grails run-app` or `gradle bootRun`, then there is the following error:

    ERROR org.hibernate.tool.hbm2ddl.SchemaExport - HHH000389: Unsuccessful: alter table domain_object2 add constraint unique_object_id unique (some_unique_field, object_id)
    ERROR org.hibernate.tool.hbm2ddl.SchemaExport - Constraint "UNIQUE_OBJECT_ID" already exists; SQL statement:
    alter table domain_object2 add constraint unique_object_id unique (some_unique_field, object_id) [90045-176]
    Grails application running at http://localhost:8080 in environment: development
	
Tested with Grails 3.0.9 
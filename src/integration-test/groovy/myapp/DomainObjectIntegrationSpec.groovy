package myapp

import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class DomainObjectIntegrationSpec extends Specification {

    void "test same key name in domain object"() {
        given: 
        DomainObject1 domainObject1 = new DomainObject1(objectId: "id1", someUniqueField: "someUniqueValue1")
        DomainObject2 domainObject2 = new DomainObject2(objectId: "id2", someUniqueField: "someUniqueValue2")
		when:
		domainObject1.save()
		domainObject2.save()
		then:
		DomainObject1.findByObjectId("id1").someUniqueField == "someUniqueValue1"
		DomainObject2.findByObjectId("id2").someUniqueField == "someUniqueValue2"
    }
}

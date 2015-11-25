package myapp

class DomainObject1 {
	String objectId
	String someUniqueField
	
    static constraints = {
		objectId(unique: ['someUniqueField'])
    }
}

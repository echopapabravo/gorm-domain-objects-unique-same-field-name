package myapp

class DomainObject2 {
	String objectId
	String someUniqueField
	
    static constraints = {
		objectId(unique: ['someUniqueField'])
    }
}

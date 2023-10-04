package org.com;

//..Immutable class in java means that once an object is created,
//we cannot change its content. In Java, all the wrapper classes
//(like Integer, Boolean, Byte, Short) and String

//1. The class must be created as final so child class can not be created.
//2. All data member must be private so direct access not allowed
//3. All data member must final, so we can not change the value after creating object.
//4.A parameter constructor should initialized all the fileld, so data member can not be modified
//with an object reference.
//5. Setter method should not create. 
public final class CustomizeImmutable {

	private final int id;
	private final String name;
	
	public CustomizeImmutable(int id1, String name1) {
		this.id = id1;
		this.name = name1;
		
	}
	public int getId() {
		return id;
		
	}
	
	public String getName() {
		return name;
	}
}

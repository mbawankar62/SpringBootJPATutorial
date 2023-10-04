package org.com.builder.design;

public class UserMain {

	//we can pass any parameter  its optional also,
	//no need to remember order as well these are the advantage over factory design pattern
	//using Builder design pattern we can achieve all 
	public static void main(String[] args) {

		User user = new User.UserBuilder()
				.setUserId(1)
				.setUserName("Rakesh")
				.setEmailId("rakesh@gmail.com")
				.build();
		
		System.out.println(user);
	}

}

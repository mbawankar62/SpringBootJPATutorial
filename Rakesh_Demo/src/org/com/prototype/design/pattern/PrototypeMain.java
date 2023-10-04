package org.com.prototype.design.pattern;

public class PrototypeMain {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.out.println("Creating obj of Prototype design pattern");
		
		NetworkConnection networkConnection = new NetworkConnection();
		networkConnection.setIp("192.168.4.4");
		networkConnection.loadVeryImportantData();

		System.out.println(networkConnection);
		
		//we want new obj of NetworkConnection
		try {
			NetworkConnection NetworkConnection2 = (NetworkConnection)networkConnection.Clone();
			System.out.println(NetworkConnection2);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}

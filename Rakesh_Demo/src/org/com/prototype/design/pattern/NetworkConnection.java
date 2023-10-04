package org.com.prototype.design.pattern;

public class NetworkConnection implements Cloneable {

	private String ip;
	private String importantData;
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getImportantData() {
		return importantData;
	}
	public void setImportantData(String importantData) {
		this.importantData = importantData;
	}
	
	
	
	@Override
	public String toString() {
		return "NetworkConnection [ip=" + ip + ", importantData=" + importantData + "]";
	}
	
	public void loadVeryImportantData() throws InterruptedException {
		this.importantData = "very very imp data";
		Thread.sleep(5000);
		
		//suppose it will take 5 min
	}
	
	//@Override
	protected Object Clone() throws CloneNotSupportedException {
		return super.clone();
		
	}
	
}

package org.com;

import java.util.Comparator;

public class Product implements Comparator<Product> {

	private int id;
	private String name;
	private float price;


	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	
	public Product() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	
	  @Override
	  public int compare(Product o1, Product o2) {
	  
	  return (o1.name.compareTo(o2.name)); }


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	 
	
	/*
	 * public int compare(Product o1, Product o2) {
	 * 
	 * if(o1.id==o2.id) return 0;
	 * 
	 * else if(o1.id> o2.id) { return 1; } else { return -1; }
	 * 
	 * }
	 */

// if we use implements Comparable<Product> 
	/*@Override
	public int compareTo(Product o) {
		if(id==o.id)  
			return 0;  
			else if(id>o.id)  
			return 1;  
			else  
			return -1;  
	}*/
	  

}

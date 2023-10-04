package com.mohit.springbootjpa.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.springbootjpa.ServiceImpl.ServiceImpl;
import com.mohit.springbootjpa.model.Product;

@RestController
@RequestMapping("/productController")
public class ProductController {

	@Autowired
	ServiceImpl service ;
	
	@PostMapping("/createProduct")
	public Product saveProduct(@RequestBody Product product)
	{
		return service.createProduct(product);
		
	}
	
	//@RequestParam: http://localhost:8080/productController/getProductById?id=1
	//@GetMapping("/getProductById")
	//public Product getProductById(@RequestParam int  id)  or 
	//public Product getProductById(@RequestParam("id") int  id)
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int  id)
	{
		return service.findById(id);
	}
	
	@GetMapping("/getProducts")
	public List<Product> getAllProduct()
	{
		return service.findAllProduct();
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product)
	{
		service.createProduct(product);
		return "Record Updated Successfully";
		
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) throws Exception
	{
		if(id == 0)
		{
		throw new Exception("Id Not Found :" +id);
		}
		service.delete(id);
		return "Record Deleted for id : " + id;
		
	}

}

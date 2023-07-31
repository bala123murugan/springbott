package core;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import model.Product;

public class CollectorsExample {

	public static void main(String[] args) {
		
		List<Product> productsList = new ArrayList<Product>();
		
		productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f)); 
        
        Double doublePriceValue = productsList.stream().collect(Collectors.averagingDouble(p->p.price));
        
        List<Float> listPriceValue = productsList.stream().map(p->p.price).collect(Collectors.toList());
        
        int value = productsList.stream().collect(Collectors.summingInt(p->p.id));
		
	}

}

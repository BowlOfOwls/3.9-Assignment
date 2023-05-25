package com.example.demotheeeight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //RestController
public class SampleController {

    // All the BEANS are connected by spring boot, which is why I am able to instantiate a SapleItem even though i have not imported it
    @Autowired
    private SampleItem sampleItem;

    @GetMapping("/products/{ID}")
    public String getProduct(@PathVariable("ID") int ID){
        switch (ID)
  {
    case 1:
    return "Product Name: Apple";
    // switch block 1...
    
    case 2:
    return "Product Name: Banana";
    // switch block 2...
    
    case 3:
    return "Product Name: Carrot";
    // switch block 2...
     
    default:
    return "No product found";
   // default switch block ...
}
    }
    
    @GetMapping("/item")
    public SampleItem getProductName(){
        sampleItem.setName("Apple");
        sampleItem.setId(1);
        sampleItem.setPrice(19.24f);
        sampleItem.setDesc("A juicy red apple");
        return sampleItem;
    }

    @Value("${product.name}")
    private String productName;

	@GetMapping("/sampleProduct")
	public String sampleProduct() {
		return String.format("Your Product is %s!", productName);
	}

    
	@GetMapping("/hello")
	public String index() {
		return "What About this?";
	}

	@GetMapping("/greet")
	public String greet(@RequestParam(value = "name", defaultValue = "World")
	String name) {
		return String.format("Hello %s!", name);
	}
	// greet?name=weikang

	@GetMapping("/person/{userId}")
	public String person(@PathVariable("userId") String userId) {
		return String.format("Your user id is %s!", userId);
	}
    // person/example

	@GetMapping("/home")
	public String home() {
		return String.format("This is the home page!");
	}

	@GetMapping("/product")
	public String product() {
		return String.format("This is the product page!");
	}
}


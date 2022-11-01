package myapp;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@SpringBootApplication
public class MyApplication {
	
	@Autowired
	private OrderService orderService;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@GetMapping("/users/{user}")
	public String getUser(@PathVariable String user){
	    return String.format("Hello, %s", user);	
	}
	
	@GetMapping("/orders")
	public List<Order> getOrders(@RequestParam(required = false) String buyer){
		if (null != buyer){
			return orderService.findByBuyer(buyer);
		}	
		return orderService.findAll();
		
	}
	
	
	@PostMapping("/orders")
	public String createOrder(@RequestBody Order newOrder){
		orderService.save(newOrder);
		return "OK";
	}
	
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
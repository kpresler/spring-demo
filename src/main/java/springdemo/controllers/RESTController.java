package springdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springdemo.services.CalculatorService;

@RestController
public class RESTController {
	
	
	@Autowired
	private CalculatorService service;
	
	@GetMapping("/calculator")
	public ResponseEntity<Integer> calculate(@RequestParam(required=true) Integer num1, @RequestParam(required=true) String mode, @RequestParam(required=false) Integer num2) {
		
		try {
			return ResponseEntity.ok(service.calculate(num1, num2, mode));
		}
		catch (IllegalArgumentException e) {
			// Service throws an IAE on invalid mode
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		}
		catch (NullPointerException e) {
			// service will throw a NPE trying to unbox `null` into an int to do math on
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
    @RequestMapping("/")
    String home() {
        return "Hola Mundo!";
    }
	

    
    @GetMapping("/users/{user}")
    public String getUser(@PathVariable String user) {
    	return String.format("Hello, %s!", user);
    }
    
    
    @GetMapping("/orders")
    public String getOrders(@RequestParam(required=false)
    Boolean shipped, @RequestParam(required=false) String after) {
    	String response = "You are requesting all ";
    	
    	response += null == shipped ? "" : (shipped ? "shipped " : "unshipped ");
    	
    	response += "orders ";
    	
    	response += (null == after ? "" : ("that were ordered after " + after));
    	
    	return response;
    }
    
    @PostMapping("/orders")
    public String createOrder(@RequestBody String newOrder) {
    	return String.format("Your new order is %s", newOrder);
    }



}

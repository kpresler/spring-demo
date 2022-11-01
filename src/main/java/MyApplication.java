import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@EnableAutoConfiguration
public class MyApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@GetMapping("/users/{user}")
	public String getUser(@PathVariable String user){
	    return String.format("Hello, %s", user);	
	}
	
	@GetMapping("/orders")
	public String getOrders(@RequestParam(required = false) Boolean shipped, @RequestParam(required=false) String after){
		String response = "You are requesting all ";

		response += null == shipped ? "" : (shipped ? "shipped " : "unshipped ");
		
		response += "orders ";

		response += (null == after ? "" : ("that were ordered after " + after));
		
		return response;
		
	}
	
	@PostMapping("/orders")
	public String createOrder(@RequestBody String newOrder){
		return String.format("Your new order is %s", newOrder);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
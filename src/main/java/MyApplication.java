import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
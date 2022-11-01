package myapp.container;

import org.springframework.stereotype.Component;

public class MyPlatformDependentService {

	public String getPlatformMessage(){
		return "PLATFORM_UNKNOWN";
	}

}

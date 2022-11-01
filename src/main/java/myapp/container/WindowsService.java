package myapp.container;

import org.springframework.stereotype.Component;

public class WindowsService extends MyPlatformDependentService{

	public String getPlatformMessage(){
		return "Greetings from Windows";
	}

}

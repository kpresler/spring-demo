package myapp.container;

import org.springframework.stereotype.Component;

public class LinuxService extends MyPlatformDependentService{

	public String getPlatformMessage(){
		return "Greetings from Linux";
	}

}

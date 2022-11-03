package myapp.container;

public class LinuxService extends MyPlatformDependentService{

	public String getPlatformMessage(){
		return "Greetings from Linux";
	}

}

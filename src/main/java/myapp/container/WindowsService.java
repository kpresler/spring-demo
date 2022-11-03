package myapp.container;

public class WindowsService extends MyPlatformDependentService{

	public String getPlatformMessage(){
		return "Greetings from Windows";
	}

}

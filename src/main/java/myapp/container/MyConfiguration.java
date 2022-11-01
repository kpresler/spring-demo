package myapp.container;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class MyConfiguration {
	

   @Bean
   @Conditional(LinuxCondition.class)
   public MyPlatformDependentService getMyLinuxService() {
      return new LinuxService();
   }

   @Bean
   @Conditional(WindowsCondition.class)
   public MyPlatformDependentService getMyWindowsService() {
      return new WindowsService();
   }
}
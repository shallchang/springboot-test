import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import service.CleanOilPatchService;
import service.impl.CleanOilPatchServiceImpl;

@ComponentScan("controller")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CleanOilPatchService getCleanOilPatchService(){
        return new CleanOilPatchServiceImpl();
    }
}
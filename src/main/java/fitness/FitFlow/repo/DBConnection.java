package fitness.FitFlow.repo;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {

    @Value("${dbuser}")
    String dbuser;
    @Value("${dbpassword}")
    String dbpassword;

    @PostConstruct
    public void init(){
        System.out.println("DB Connection init");
        System.out.println("username: " + dbuser + " | password: "+ dbpassword);
    }

}

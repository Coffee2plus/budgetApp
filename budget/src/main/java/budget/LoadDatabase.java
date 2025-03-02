package budget;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BudgetRepository repository){

        return args -> {
            log.info("Preloading " + repository.save(new Budget("01-03-2025", "Energy", true, 151.76, "This is my bill for electricity.", false, true)));
            log.info("Preloading " + repository.save(new Budget("01-01-2025", "Rent", true, 2007.10, "This is my rent bill.", false, true)));

        };
    }

}

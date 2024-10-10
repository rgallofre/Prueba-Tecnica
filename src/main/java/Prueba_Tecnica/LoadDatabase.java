package Prueba_Tecnica;

import java.time.LocalDateTime;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PricesRepository repository) {

    return args -> { 
      log.info("Preloading " + repository.save(new Prices("1", "1", LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59.00"), "35455", 1, 35.50F, "EUR")));
      log.info("Preloading " + repository.save(new Prices("0", "1", LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"), "35455", 2, 25.45F, "EUR")));
      log.info("Preloading " + repository.save(new Prices("1", "1", LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"), "35455", 3, 30.50F, "EUR")));
      log.info("Preloading " + repository.save(new Prices("1", "1", LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), "35455", 4, 38.95F, "EUR")));
    };
  }
}
/** 
private String BRAND_ID;
private String START_DATE;
private String END_DATE;
private String PRICE_LIST;
private String PRIORITY;
private Float PRICE;
private String CURR;
**/
/**

1 2020-06-15-16.00.00 2020-12-31-23.59.59 4 35455
1 38.95 EUR
 **/

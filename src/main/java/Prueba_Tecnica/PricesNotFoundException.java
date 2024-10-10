package Prueba_Tecnica;

public class PricesNotFoundException extends RuntimeException {

	  PricesNotFoundException(Long id) {
	    super("Could not find price " + id);
	  }
}
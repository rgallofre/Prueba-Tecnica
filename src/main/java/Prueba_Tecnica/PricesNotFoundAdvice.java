package Prueba_Tecnica;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
 class PricesNotFoundAdvice {

	  @ExceptionHandler(PricesNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String pricesNotFoundHandler(PricesNotFoundException ex) {
	    return ex.getMessage();
	  }

}

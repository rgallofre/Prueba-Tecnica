package Prueba_Tecnica;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
 class PricesController {
	private final PricesRepository repository;
	
	private final PricesModelAssembler assembler;

	  PricesController(PricesRepository repository, PricesModelAssembler assembler) {
	    this.repository = repository;
	    this.assembler = assembler;
	  }


	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/prices")
	  CollectionModel<EntityModel<Prices>> all() {

		  List<EntityModel<Prices>> prices = repository.findAll().stream() //
		      .map(assembler::toModel) //
		      .collect(Collectors.toList());

		  return CollectionModel.of(prices, linkTo(methodOn(PricesController.class).all()).withSelfRel());
		}
	  // end::get-aggregate-root[]

	  @PostMapping("/prices")
	  Prices newPrices(@RequestBody Prices newPrices) {
	    return repository.save(newPrices);
	  }

	  // Single item
	  
	  @GetMapping("/prices/{id}")
	  EntityModel<Prices> one(@PathVariable Long id) {

	    Prices prices = repository.findById(id) //
	        .orElseThrow(() -> new PricesNotFoundException(id));

	    return assembler.toModel(prices);}

	  /** 
	  private String PRODUCT_ID;
	  private String BRAND_ID;
	  private Date START_DATE;
	  private Date END_DATE;
	  private String PRICE_LIST;
	  private String PRIORITY;
	  private Float PRICE;
	  private String CURR;
	  **/
	 
	  @PutMapping("/prices/{id}")
	  Prices replacePrices(@RequestBody Prices newPrices, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(prices -> {
	    	prices.setPRODUCT_ID(newPrices.getPRODUCT_ID());
	        prices.setBRAND_ID(newPrices.getBRAND_ID());
	        prices.setSTART_DATE(newPrices.getSTART_DATE());
	        prices.setEND_DATE(newPrices.getEND_DATE());
	        prices.setPRICE_LIST(newPrices.getPRICE_LIST());
	        prices.setPRIORITY(newPrices.getPRIORITY());
	        prices.setPRICE(newPrices.getPRICE());
	        prices.setCURR(newPrices.getCURR());
	        return repository.save(prices);
	      })
	      .orElseGet(() -> {
	        return repository.save(newPrices);
	      });
	  }

	  @DeleteMapping("/prices/{id}")
	  ResponseEntity<?> deleteEmployee(@PathVariable Long id) {

	    repository.deleteById(id);

	    return ResponseEntity.noContent().build();
	  }
	}



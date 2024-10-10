package Prueba_Tecnica;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import Prueba_Tecnica.Prices;
import Prueba_Tecnica.PricesController;

@Component
class PricesModelAssembler implements RepresentationModelAssembler<Prices, EntityModel<Prices>> {

  @Override
  public EntityModel<Prices> toModel(Prices employee) {

    return EntityModel.of(employee, //
        linkTo(methodOn(PricesController.class).one(employee.getId())).withSelfRel(),
        linkTo(methodOn(PricesController.class).all()).withRel("prices"));
  }
}

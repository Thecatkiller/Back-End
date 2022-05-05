package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepUS16 {
    @Given("el Sistema muestra un Producto seleccionado del supplier")
    public void el_Sistema_muestra_un_Producto_seleccionado_del_supplier(){}
    @When("el usuario hace click en el botón “promover”")
    public void el_usuario_hace_click_en_el_botón_promover(){}
    @Then("el Sistema muestra un mensaje para que el supplier realice la confirmacion de promocion")

    public void el_Sistema_muestra_un_mensaje_para_que_el_supplier_realice_la_confirmacion_de_promocion(){}
    @When("el usuario hace click en el botón “Confirmar”")
    public void el_usuario_hace_click_en_el_botón_Confirmar(){}
     @Then("el Sistema muestra un mensaje temporal confirmacion de promocion")
    public void el_Sistema_muestra_un_mensaje_temporal_confirmacion_de_promocion(){}
    @Then("el Sistema generara la factura por el servicio de promocion")
    public void el_Sistema_generara_la_factura_por_el_servicio_de_promocion(){}
}

/*
Feature: Como supplier, deseo promover mi producto.
  Scenario: 4
    Given el Sistema muestra un Producto seleccionado del supplier
    When el usuario hace click en el botón “promover”
    Then el Sistema muestra un mensaje para que el supplier realice la confirmacion de promocion
    When el usuario hace click en el botón “Confirmar”
    Then el Sistema muestra un mensaje temporal confirmacion de promocion
    And el Sistema generara la factura por el servicio de promocion*/
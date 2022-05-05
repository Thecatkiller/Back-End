package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepUS7 {
    @Given("el Sistema muestra un Producto")
    public void el_sistema_muestra_un_Producto() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("When el usuario hace click en el botón “Voto arriba”")
    public void el_usuario_hace_click_en_el_botón_Voto_arriba() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("When el usuario hace click en el botón “Voto abajo””")
    public void el_usuario_hace_click_en_el_botón_Voto_abajo() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("el Sistema muestra un mensaje temporal de confirmacion de voto")
    public void el_Sistema_muestra_un_mensaje_temporal_de_confirmacion_de_voto() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("el Sistema modificara la cantidad de votos que tiene el producto")
    public void el_Sistema_modificara_la_cantidad_de_votos_que_tiene_el_producto() {
        // Write code here that turns the phrase above into concrete actions

    }
}



/*Feature: Como usuario, deseo dar un voto a favor del producto.
  Scenario: 3
    Given el Sistema muestra un Producto
    When el usuario hace click en el botón “Voto arriba”
    When el usuario hace click en el botón “Voto abajo”
    Then el Sistema muestra un mensaje temporal de confirmacion de voto
    And el Sistema modificara la cantidad de votos que tiene el producto
    */
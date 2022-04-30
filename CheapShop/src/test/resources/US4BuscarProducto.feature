Feature: Como usuario, deseo buscar un producto por nombre, para encontrar específicamente el que quiero.
  Scenario: 1
    Given el Sistema muestra la sección “Buscar” en la esquina superior derecho de la pantalla
    And el usuario llena el campo “Buscar” con el nombre de un item existente en la lista de productos
    When el usuario hace click en el botón “Aplicar”
    Then el Sistema muestra los productos en la sección Resultados de búsqueda con nombres de productos que concuerdan con el nombre de producto ingresado
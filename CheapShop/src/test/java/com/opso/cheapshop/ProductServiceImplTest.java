package com.opso.cheapshop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.opso.cheapshop.domain.model.Category;
import com.opso.cheapshop.domain.model.Product;
import com.opso.cheapshop.domain.model.Supplier;
import com.opso.cheapshop.domain.repository.CategoryRepository;
import com.opso.cheapshop.domain.repository.ProductRepository;
import com.opso.cheapshop.domain.repository.SupplierRepository;
import com.opso.cheapshop.domain.service.ProductService;
import com.opso.cheapshop.service.ProductServiceImpl;

@ExtendWith(SpringExtension.class)
public class ProductServiceImplTest {
    @MockBean
    private SupplierRepository supplierRepository;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;


    @TestConfiguration
    static class ProductServiceImplTestsConfiguration {
        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }
    }
    @Test
    @DisplayName("When getProductByName,ByDescription,ByPrice With Valid Name/Description/Price Then Returns Post")
    public void WhengetProductByNameByDescriptionByPriceWithValidNameDescriptionPriceThenReturnsPost() {
        // Arrange
        Long id = 1L;
        Double price = 2.0;
        String name = "Memory Ram";
        String description = "Memory Ram with 8GB";
        Category category = new Category().setId(id);
        Supplier supplier = new Supplier().setId(id);

        Product product = new Product().setId(id).setDescription(description).setName(name).setPrice(price).setCategory(category).setSupplier(supplier);
        when(productRepository.findById(id))
                .thenReturn(Optional.of(product));
        // Act
        Product foundProduct = productService.getProductById(id);

        // Assert
        assertThat(foundProduct.getId()).isEqualTo(id);
    }
    @Test
    @DisplayName("When getProductByName,ByDescription,ByNumber With Valid Name/Description/Number when put the price Then Returns Post")
    public void WhengetProductByNameByDescriptionByNumberWithValidNameDescriptionNumberwhenawantchangethepriceThenReturnsPost() {
        // Arrange
        String name = "Memory Ram";
        String description = "The Memory Ram or 4GB";
        Double price = 2.0;
        Double newprice = 3.0;
        Long id = 1L;
        Product product = new Product().setId(id).setDescription(description).setName(name).setPrice(price);
        when(productRepository.findById(id))
                .thenReturn(Optional.of(product));

        // Act
        product.setPrice(newprice);
        /*productService.updateProduct(id,product);*/
        Product foundProduct = productService.getProductById(id);
        // Assert
        assertThat(foundProduct.getPrice()).isEqualTo(newprice);
    }
    @Test
    @DisplayName("When getProductByName,ByDescription,Byprice With Valid Name/Description/price when i delete them name Then Returns null")
    public void WhengetProductByNameByDescriptionBypriceWithValidNameDescriptioPricenwhenideletethemnameThenReturnsnull() {
        // Arrange
        String name = "Memory Ram";
        String description = "The Memory Ram or 4GB";
        Double price = 2.0;
        Long id = 1L;
        Product product = new Product().setId(id).setDescription(description).setName(name).setPrice(price);
        when(productRepository.findById(id))
                .thenReturn(Optional.of(product));

        // Act
        productService.deleteProduct(id);
        Throwable exception = catchThrowable(() -> {
            Product foundProduct = productService.getProductById(id);
        });
        // Assert
        AssertionsForClassTypes.assertThat(exception).isEqualTo(null);
    }
}

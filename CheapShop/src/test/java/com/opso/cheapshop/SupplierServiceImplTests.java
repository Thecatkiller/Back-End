package com.opso.cheapshop;

import com.opso.cheapshop.domain.model.Supplier;
import com.opso.cheapshop.domain.repository.CategoryRepository;
import com.opso.cheapshop.domain.repository.ProductRepository;
import com.opso.cheapshop.domain.repository.SupplierRepository;
import com.opso.cheapshop.domain.service.SupplierService;
import com.opso.cheapshop.service.SupplierServiceImpl;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class SupplierServiceImplTests {
    @MockBean
    private SupplierRepository supplierRepository;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private CategoryRepository categoryRepository;
    @Autowired
    private SupplierService supplierService;


    @TestConfiguration
    static class SupplierServiceImplTestsConfiguration {
        @Bean
        public SupplierService supplierService() {
            return new SupplierServiceImpl();
        }
    }

    @Test
    @DisplayName("When getSupplierByEmail,ByDescription,Bynumber With Valid Name/Description/number Then Returns Post")
    public void WhengetCategoryByEmailByDescriptionBynumberWithValidNameDescriptionnumberThenReturnsPost() {
        // Arrange
        String email = "upc@edu.pe";
        String description = "The supplier for Memory Ram";
        Long id = 1L;
        Long number = 934874654L;
        String name="The supplier name";
        Supplier supplier = new Supplier().setId(id).setName(name).setEmail(email).setDescription(description).setNumber(number);
        when(supplierRepository.findById(id))
                .thenReturn(Optional.of(supplier));

        // Act
        Supplier foundSupplier = supplierService.getSupplierById(id);

        // Assert
        assertThat(foundSupplier.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When getSupplierByEmail,ByDescription,Bynumber With Valid Name/Description/number when put the description Then Returns Post")
    public void WhengetCategoryByNameByDescriptionWithValidNameDescriptionwhenawantchangethenameThenReturnsPost() {
        // Arrange
        String email = "upc@edu.pe";
        String description = "The supplier for Memory Ram";
        String newdescription = "The supplier for Memory Ram 4GB";
        String name="The supplier name";
        Long id = 1L;
        Long number = 934874654L;
        Supplier supplier = new Supplier().setId(id).setName(name).setDescription(description).setEmail(email).setNumber(number);
        when(supplierRepository.findById(id))
                .thenReturn(Optional.of(supplier));

        // Act
        supplier.setDescription(newdescription);
        supplierService.updateSupplier(id, supplier);
        Supplier foundSupplier = supplierService.getSupplierById(id);
        // Assert
        assertThat(foundSupplier.getDescription()).isEqualTo(newdescription);
    }

    @Test
    @DisplayName("When getSupplierByEmail,ByDescription,ByNumber With Valid Name/Description/number when i delete them Then Returns null")
    public void WhengetSupplierByNameByDescriptionByNumberWithValidNameDescriptionwhenideletethemnameThenReturnsnull() {
        // Arrange
        String email = "upc@edu.pe";
        String description = "The supplier for Memory Ram";
        Long id = 1L;
        Long number = 934874654L;
        String name ="The supplier name";
        Supplier supplier = new Supplier().setId(id).setName(name).setDescription(description).setEmail(email).setNumber(number);
        when(supplierRepository.findById(id))
                .thenReturn(Optional.of(supplier));

        // Act
        supplierService.deleteSupplier(id);
        Throwable exception = catchThrowable(() -> {
            Supplier foundSupplier = supplierService.getSupplierById(id);
        });
        // Assert
        AssertionsForClassTypes.assertThat(exception).isEqualTo(null);
    }
}
package com.opso.cheapshop;

import com.opso.cheapshop.domain.model.Category;
import com.opso.cheapshop.domain.repository.CategoryRepository;
import com.opso.cheapshop.domain.repository.ProductRepository;
import com.opso.cheapshop.domain.service.CategoryService;
import com.opso.cheapshop.service.CategoryServiceImpl;
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
public class CategoryServiceImplTests {
    @MockBean
    private CategoryRepository categoryRepository;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;


    @TestConfiguration
    static class CategoryServiceImplTestsConfiguration {
        @Bean
        public CategoryService categoryService() {
            return new CategoryServiceImpl();
        }
    }
    @Test
    @DisplayName("When getCategoryByName,ByDescription With Valid Name/Description Then Returns Post")
    public void WhengetCategoryByNameByDescriptionWithValidNameDescriptionThenReturnsPost() {
        // Arrange
        String name = "Memory Ram";
        String description = "The best Memory Ram";
        Long id = 1L;
        Category category = new Category().setId(id).setDescription(description).setName(name);
        when(categoryRepository.findById(id))
                .thenReturn(Optional.of(category));

        // Act
        Category foundCategory = categoryService.getCategoryById(id);

        // Assert
        assertThat(foundCategory.getId()).isEqualTo(id);
    }
    @Test
    @DisplayName("When getCategoryByName,ByDescription With Valid Name/Description when put the name Then Returns Post")
    public void WhengetCategoryByNameByDescriptionWithValidNameDescriptionwhenawantchangethenameThenReturnsPost() {
        // Arrange
        String newname = "Memory ram 4GB";
        String name = "Memory Ram";
        String description = "The best Memory Ram";
        Long id = 1L;
        Category category = new Category().setId(id).setDescription(description).setName(name);
        when(categoryRepository.findById(id))
                .thenReturn(Optional.of(category));

        // Act
        category.setName(newname);
        categoryService.updateCategory(id,category);
        Category foundCategory = categoryService.getCategoryById(id);
        // Assert
        assertThat(foundCategory.getName()).isEqualTo(newname);
    }
    @Test
    @DisplayName("When getCategoryByName,ByDescription With Valid Name/Description when i delete them name Then Returns null")
    public void WhengetCategoryByNameByDescriptionWithValidNameDescriptionwhenideletethemnameThenReturnsnull() {
        // Arrange
        String name = "Memory Ram";
        String description = "The best Memory Ram";
        Long id = 1L;
        Category category = new Category().setId(id).setDescription(description).setName(name);
        when(categoryRepository.findById(id))
                .thenReturn(Optional.of(category));

        // Act
        categoryService.deleteCategory(id);
        Throwable exception = catchThrowable(() -> {
            Category foundCategory = categoryService.getCategoryById(id);
        });
        // Assert
        AssertionsForClassTypes.assertThat(exception).isEqualTo(null);
    }
}

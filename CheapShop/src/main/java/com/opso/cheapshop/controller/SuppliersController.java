package com.opso.cheapshop.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opso.cheapshop.domain.model.Supplier;
import com.opso.cheapshop.domain.service.SupplierService;
import com.opso.cheapshop.resource.SaveSupplierResource;
import com.opso.cheapshop.resource.SupplierResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SuppliersController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get all Supplier", description = "Get All Suppliers by Pages", tags = {"suppliers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Suppliers returned", content = @Content(mediaType = "application/json"))
    })

    @GetMapping("/suppliers")
    public Page<SupplierResource> getAllCSuppliers(Pageable pageable) {
        Page<Supplier> supplierPage = supplierService.getAllSuppliers(pageable);
        List<SupplierResource> resources = supplierPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }
    @Operation(summary = "Create Supplier", description = "Create a new Suppliers", tags = {"suppliers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new Suppliers", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/suppliers")
    public SupplierResource createSupplier(@Valid @RequestBody SaveSupplierResource resource) {
        Supplier supplier = convertToEntity(resource);
        return convertToResource(supplierService.createSupplier(supplier));
    }
    @Operation(summary = "Update Supplier By ID", description = "Update Supplier by ID", tags = {"suppliers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Supplier returned", content = @Content(mediaType = "application/json"))

    })
    @PutMapping("/suppliers/{supplierId}")
    public SupplierResource updateSupplier(@PathVariable Long supplierId, @Valid @RequestBody SaveSupplierResource resource) {
        Supplier supplier = convertToEntity(resource);
        return convertToResource(supplierService.updateSupplier(supplierId, supplier));
    }
    @Operation(summary = "Delete Supplier By ID", description = "Delete Supplier by ID", tags = {"suppliers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Supplier deleted", content = @Content(mediaType = "application/json"))

    })
    @DeleteMapping("/suppliers/{supplierId}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long supplierId) {
        return supplierService.deleteSupplier(supplierId);
    }
    @Operation(summary = "Get Supplier By ID", description = "Get Supplier by ID", tags = {"suppliers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Supplier returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/suppliers/{supplierId}")
    public SupplierResource getSupplierById(
            @PathVariable Long supplierId) {
        return convertToResource(supplierService.getSupplierById(supplierId));
    }
    private Supplier convertToEntity(SaveSupplierResource resource) {
        return mapper.map(resource, Supplier.class);
    }
    private SupplierResource convertToResource(Supplier entity) {
        return mapper.map(entity, SupplierResource.class);
    }

}

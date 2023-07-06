package br.com.compassuol.pb.challenge.msproducts.controller;

import br.com.compassuol.pb.challenge.msproducts.dto.ProductResponse;
import br.com.compassuol.pb.challenge.msproducts.dto.ProductsDto;
import br.com.compassuol.pb.challenge.msproducts.entity.Products;
import br.com.compassuol.pb.challenge.msproducts.service.ProductsService;
import br.com.compassuol.pb.challenge.msproducts.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductsDto productsDto){
        String response = productsService.createProduct(productsDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsDto> getProductById(@PathVariable(name="id") long productId){
       return ResponseEntity.ok(productsService.getProductById(productId));
    }

    @GetMapping
    public ProductResponse getAllProducts(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE, required = false)int page,
            @RequestParam(value = "linesPerPage", defaultValue = AppConstants.DEFAULT_LINES_PER_PAGE, required = false)int linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = AppConstants.DEFAULT_ORDER_BY, required = false)String orderBy,
            @RequestParam(value = "direction", defaultValue = AppConstants.DEFAULT_DIRECTION, required = false)String direction
    ){
        return productsService.getAllProducts(page, linesPerPage, orderBy, direction);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable(name = "id") long productId){
        productsService.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProductsDto> updateProduct(@RequestBody ProductsDto productsDto, @PathVariable(name = "id") long productId){
        ProductsDto productResponse = productsService.updateProduct(productsDto, productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}

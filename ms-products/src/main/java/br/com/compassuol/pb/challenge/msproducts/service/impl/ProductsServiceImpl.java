package br.com.compassuol.pb.challenge.msproducts.service.impl;

import br.com.compassuol.pb.challenge.msproducts.dto.ProductResponse;
import br.com.compassuol.pb.challenge.msproducts.dto.ProductsDto;
import br.com.compassuol.pb.challenge.msproducts.entity.Category;
import br.com.compassuol.pb.challenge.msproducts.entity.Products;
import br.com.compassuol.pb.challenge.msproducts.exception.ResourceNotFoundException;
import br.com.compassuol.pb.challenge.msproducts.repository.CategoryRepository;
import br.com.compassuol.pb.challenge.msproducts.repository.ProductsRepository;
import br.com.compassuol.pb.challenge.msproducts.service.ProductsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;
    private CategoryRepository categoryRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository, CategoryRepository categoryRepository) {
        this.productsRepository = productsRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String createProduct(ProductsDto productsDto) {

        Products products = new Products();

        products.setDateT(productsDto.getDateT());
        products.setDescription(productsDto.getDescription());
        products.setName(productsDto.getName());
        products.setImgURL(productsDto.getImgURL());
        products.setPrice(productsDto.getPrice());

       List<Category> categories = new ArrayList<>();
       for(Category category : productsDto.getCategories()){
           Long getId = category.getCategoryId();
           Category getCategory = categoryRepository.findById(getId)
                   .orElseThrow(() -> new ResourceNotFoundException("Category", "id", getId));
           categories.add(getCategory);
           products.setCategories(categories);
       }
       productsRepository.save(products);
        return "Product created successfully";
    }

    @Override
    public ProductsDto getProductById(long productId) {
        Products products = productsRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        return mapToDTO(products);
    }

    @Override
    public ProductResponse getAllProducts(int page, int linesPerPage, String orderBy, String direction) {

        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending()
                : Sort.by(orderBy).descending();

        Pageable pageable = PageRequest.of(page, linesPerPage,sort);

        Page<Products> products = productsRepository.findAll(pageable);

        List<Products> listOfProducts = products.getContent();

        List<ProductsDto> content = listOfProducts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(content);
        productResponse.setPage(products.getNumber());
        productResponse.setLinesPerPage(products.getSize());
        productResponse.setTotalElements(products.getTotalElements());
        productResponse.setTotalPages(products.getTotalPages());
        productResponse.setLast(products.isLast());

        return productResponse;
    }

    @Override
    public void deleteProductById(long productId) {
        Products products = productsRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        productsRepository.delete(products);
    }

    @Override
    public ProductsDto updateProduct(ProductsDto productsDto, long productId) {
        Products products = productsRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        products.setDateT(productsDto.getDateT());
        products.setDescription(productsDto.getDescription());
        products.setName(productsDto.getName());
        products.setImgURL(productsDto.getImgURL());
        products.setPrice(productsDto.getPrice());

        Products updatedProduct = productsRepository.save(products);
        return mapToDTO(updatedProduct);
    }

    private ProductsDto mapToDTO(Products products){
        ProductsDto productsDto = new ProductsDto();

        productsDto.setProductId(products.getProductId());
        productsDto.setDateT(products.getDateT());
        productsDto.setDescription(products.getDescription());
        productsDto.setName(products.getName());
        productsDto.setImgURL(products.getImgURL());
        productsDto.setPrice(products.getPrice());

        return productsDto;
    }

}

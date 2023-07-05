package br.com.compassuol.pb.challenge.msproducts.service;

import br.com.compassuol.pb.challenge.msproducts.dto.ProductResponse;
import br.com.compassuol.pb.challenge.msproducts.dto.ProductsDto;

import java.util.List;

public interface ProductsService {

    ProductsDto createProduct(ProductsDto productsDto);

    ProductsDto getProductById(long productId);

    ProductResponse getAllProducts(int page, int linesPerPage, String orderBy, String direction);

    void deleteProductById(long productId);

    ProductsDto updateProduct(ProductsDto productsDto, long productId);
}

package br.com.compassuol.pb.challenge.msproducts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private List<ProductsDto> content;
    private int page;
    private int linesPerPage;
    private long totalElements;
    private int totalPages;
    private boolean last;
}

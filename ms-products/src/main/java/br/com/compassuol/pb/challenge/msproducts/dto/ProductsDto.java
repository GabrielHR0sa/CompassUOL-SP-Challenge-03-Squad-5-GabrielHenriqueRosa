package br.com.compassuol.pb.challenge.msproducts.dto;


import br.com.compassuol.pb.challenge.msproducts.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto {

    private long productId;
    private Date dateT;
    private String description;
    private String name;
    private String imgURL;
    private float price;
    private List<Category> categories;

}

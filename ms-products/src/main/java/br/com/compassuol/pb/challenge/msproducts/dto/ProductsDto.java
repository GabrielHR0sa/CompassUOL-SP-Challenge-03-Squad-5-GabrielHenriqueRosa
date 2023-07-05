package br.com.compassuol.pb.challenge.msproducts.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


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
    private int price;


}

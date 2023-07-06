package br.com.compassuol.pb.challenge.msproducts.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "date", nullable = false)
    @NotNull(message = "date can't be null or empty")
    private Date dateT;

    @Column(name = "description", nullable = false)
    @NotNull(message = "description can't be null or empty")
    private String description;

    @Column(name = "name", nullable = false)
    @NotNull(message = "name can't be null or empty")
    private String name;

    @Column(name = "imgURL", nullable = false)
    @NotNull(message = "img can't be null or empty")
    private String imgURL;

    @Column(name = "price", nullable = false)
    @NotNull(message = "price can't be null or empty")
    private float price;

}

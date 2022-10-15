package me.plantngo.backend.models;

import java.net.URL;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

/**
 * Promotion class
 * 
 * Merchants can create promotions for their stores across selected products
 * 
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    @JsonBackReference(value = "merchant_promotion")
    private Merchant merchant;

    @NotBlank
    private String promocode;

    @ManyToMany(mappedBy = "productPromotions")
    private List<Product> promoProducts;

    @NotNull
    private Double promoValue;

    private URL url;

}

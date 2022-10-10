package me.plantngo.backend.DTO;

import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@AllArgsConstructor
public class UpdateProductDTO {

    @NotNull
    private String name;

    private Double price;

    private String description;

    private Double carbonEmission;

    private String imageUrl;

    private String flavourType;
}

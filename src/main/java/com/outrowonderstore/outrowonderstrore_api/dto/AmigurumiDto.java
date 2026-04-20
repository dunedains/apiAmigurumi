package com.outrowonderstore.outrowonderstrore_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmigurumiDto {
    private Long id;

    @NotBlank(message = "no  peude ser vacio")
    @Size(min=1,max=200,message = "el nombre debe tener entre 1 y 200 caracteres")
    private String name;

    @NotBlank(message = "la descripcion es obligotaria")
    @Size(max=500,message = "la descripcion es muy larga")
    private String description;

    @NotBlank(message = "el precio es obligatorio")
    @Size(min=1,max=10,message = "el precio debe tener entre 1 y 10 caracteres")
    @Min(value = 0,message="el precio no puede ser negativo")
    private Double price;

    private String imageUrl;

    @NotNull
    @Min(value = 0,message="el stock no puede ser negativo")
    private Integer stock;
}

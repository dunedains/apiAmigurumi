package com.outrowonderstore.outrowonderstrore_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "amigurumi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Amigurumi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=1,max=200,message = "el nombre debe tener entre 1 y 200 caracteres")
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Size(max=500,message = "la descripcion es my larga")
    @Column(length = 500)
    private String description;

    @NotNull
    @Min(value = 0,message="el precio no puede ser negativo")
    @Column(nullable = false)
    private Double price;

    private String imageUrl;

    @NotNull(message = "el es stock es obligatorio")
    @Min(value = 0,message="el stock no puede ser negativo")
    private Integer stock;
}

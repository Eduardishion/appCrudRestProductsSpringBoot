package proyect.appRestProducts.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//declaracion de entidad la cual se enconvertira en la tabla en la base de dartos
@Entity
//uso de lombok para minimisar los lines de codigo
@Data
@AllArgsConstructor
@NoArgsConstructor
//nombre de tabla en base de datos
@Table(name = "Images")
public class image {

    //indice automatico
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //nombre de columna en tabla
    @Column (name = "id")
    @NotBlank(message = "El id no debe estar vacio")
    private Long id;

    @Column (name = "name")
    @NotBlank (message = "El name no debe estar vacio")
    @Size(min = 100, max = 500, message = "La description debe tener entre 100 y 500 caracteres")
    private String name;


    //relaciones
    //relacion de muchos a uno
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    @JsonBackReference
    private  product product;

}

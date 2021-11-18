package proyect.appRestProducts.entity;

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
@Table(name = "Roles")
public class role {

    //indice automatico
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //nombre de columna en tabla
    @Column (name = "id")
    @NotBlank(message = "El id no debe estar vacio")
    private Long id;

    @Column (name = "name")
    @NotBlank (message = "El name no debe estar vacio")
    @Size(min = 10, max = 200, message = "La name debe tener entre 10 y 200 caracteres")
    private String name;
}

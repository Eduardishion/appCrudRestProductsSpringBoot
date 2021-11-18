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
@Table(name = "Users")
public class user {
    //indice automatico
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //nombre de columna en tabla
    @Column (name = "id")
    @NotBlank(message = "El id no debe estar vacio")
    private Long id;

    @NotBlank (message = "El firstName no debe estar vacio")
    @Size(min = 50, max = 250, message = "El firstName debe tener entre 10 y 100 caracteres")
    @Column (name = "firstName")
    private String firstName;

    @NotBlank (message = "El lastName no debe estar vacio")
    @Size(min = 50, max = 250, message = "El lastName debe tener entre 10 y 100 caracteres")
    @Column (name = "lastName")
    private String lastName;

    @NotBlank (message = "El email no debe estar vacio")
    @Size(min = 50, max = 250, message = "El emaildebe tener entre 10 y 100 caracteres")
    @Column (name = "email")
    private String email;

    @NotBlank (message = "El password no debe estar vacio")
    @Size(min = 50, max = 250, message = "El password tener entre 10 y 100 caracteres")
    @Column (name = "password")
    private String password;

    @NotBlank (message = "El urlImage no debe estar vacio")
    @Column (name = "urlImage")
    private String urlImage;







}

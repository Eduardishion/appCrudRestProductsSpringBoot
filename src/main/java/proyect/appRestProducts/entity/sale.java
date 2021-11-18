package proyect.appRestProducts.entity;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class sale {

    @Column(name = "product_id")
    @NotBlank(message = "El product_id no debe estar vacio")
    private int product_id;


    @Column (name = "user_id")
    @NotBlank (message = "El user_id no debe estar vacio")
    private int user_id;
}

package proyect.appRestProducts.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;


//declaracion de entidad la cual se enconvertira en la tabla en la base de dartos
@Entity
//uso de lombok para minimisar los lines de codigo
@Data
@AllArgsConstructor
@NoArgsConstructor
//nombre de tabla en base de datos
@Table(name = "Products")
public class product {

    //indice automatico
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //nombre de columna en tabla
    @Column (name = "id")
    @NotBlank (message = "El id no debe estar vacio")
    private Long id;

    @NotBlank (message = "El price no debe estar vacio")
    @Column (name = "price",nullable = false)
    private float price;

    @NotBlank (message = "El discount no debe estar vacio")
    @Column (name = "discount", nullable = false)
    private float discount;

    @NotBlank (message = "El discountRate no debe estar vacio")
    @Column (name = "discountRate", nullable = false)
    private float discountRate;

    @NotBlank (message = "El stock no debe estar vacio")
    @Column (name = "stock")
    private int stock;

    @NotBlank (message = "La description no debe estar vacio")
    @Size (min = 50, max = 250, message = "La description debe tener entre 50 y 250 caracteres")
    @Column (name = "description", nullable = false)
    private String description;

    @NotBlank (message = "El features no debe estar vacio")
    @Size (min = 50, max = 250, message = "El features  debe tener entre 50 y 250 caracteres")
    @Column (name = "features", nullable = false)
    private String features;

    @Column(name = "subscribed_on")
    private java.sql.Date subscribedOn;

    @Column(name = "published_on")
    private java.sql.Timestamp publishedOn;

    //relaciones


    //solucion a recursividad y repeticion de datos al relacionar las tablas
    //https://www.iteramos.com/pregunta/30287/recursion-infinita-con-jackson-json-y-problema-de-hibernate-jpa
    //--------------relacion con tabla categoria
    //relacion de muchos a uno
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="category_id",referencedColumnName = "id")
    @JsonBackReference
    private  category category;

    //--------------relacion con tabla categoria
    //relacion de uno a muchos
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="product")
    @JsonManagedReference
    private List<image> images;

}


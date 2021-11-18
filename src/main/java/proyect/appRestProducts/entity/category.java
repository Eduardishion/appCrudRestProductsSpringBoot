package proyect.appRestProducts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//declaracion de entidad la cual se enconvertira en la tabla en la base de dartos
@Entity
//uso de lombok para minimisar los lines de codigo
@Data
@AllArgsConstructor
@NoArgsConstructor
//nombre de tabla en base de datos
@Table(name = "Categories")
public class category {

    //indice automatico
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //nombre de columna en tabla
    @Column (name = "id")
    @NotBlank(message = "El id no debe estar vacio")
    private Long id;

    @Column (name = "name")
    @NotBlank (message = "El name no debe estar vacio")
    @Size(min = 100, max = 500, message = "La name debe tener entre 100 y 500 caracteres")
    private String name;

    //relacion de uno a muchos
    //private List<product> products = new ArrayList<>();
    //https://stackoverflow.com/questions/67353793/what-does-jsonignorepropertieshibernatelazyinitializer-handler-do
    //https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue

    //solucion a recursividad y repeticion de datos al relacionar las tablas
    //https://www.iteramos.com/pregunta/30287/recursion-infinita-con-jackson-json-y-problema-de-hibernate-jpa
    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "category")
    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})////para detener iteracion infinita al hacer peticion por metodo get
    @JsonManagedReference
    private List<product> products;
}

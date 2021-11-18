package proyect.appRestProducts.controllers;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyect.appRestProducts.service.serviceProduct;
import proyect.appRestProducts.entity.product;


import java.util.Optional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000" ,methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RestController
@RequestMapping("/api/products")
public class productsController {

    //esta es un ejemplo de injeccion de dependecias la cual injecta otra clase llamada servTarea
    @Autowired
    serviceProduct servProduct;

    // obtener todas las tareas con el uso del metodo get
    @GetMapping("/")
    private  Iterable<product> getAllProducts(){
        return servProduct.getAllProducts();
    }

    // obtener un tarea especifica con id con el uso del metodo get
    @GetMapping("/{id}")
    private Optional<product> getProduct(@PathVariable("id")long id){
        return servProduct.getProductById(id);
    }

    //crear una nueva tarea con el uso del metodo post
    @PostMapping("/")
    private long saveTarea(@RequestBody product product){
        servProduct.saveProduct(product);
        return product.getId();
    }

    //eliminar una tarea especifica con id  con el uso del metodo delete
    @DeleteMapping("/{id}")
    private void deleteProduct(@PathVariable("id")long id){ ///// verificar metodo delete
        System.out.println("el id eliminado es:"+id);
        servProduct.deleteProduct(id);
    }

    //actualizar tarea con el uso del metodo put
    @PutMapping("/{id}")
    private product updateProduct(@RequestBody product product){ ///// verificar metodo actualizar
        servProduct.saveProduct(product);
        return product;
    }
}

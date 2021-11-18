package proyect.appRestProducts.service;

import proyect.appRestProducts.entity.product;

import java.util.Optional;

public interface InterfazServiceProduct {
    //implementamos metodos
    public Iterable<product> getAllProducts();
    public Optional<product> getProductById(long id);
    public void saveProduct(product product);
    public void deleteProduct(long id);
    public void updateProduct(product product, long id);

}

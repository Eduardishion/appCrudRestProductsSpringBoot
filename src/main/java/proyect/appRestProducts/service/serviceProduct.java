package proyect.appRestProducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor;
import org.springframework.stereotype.Service;
import proyect.appRestProducts.entity.product;
import proyect.appRestProducts.repository.productRepository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class serviceProduct implements InterfazServiceProduct{

    @Autowired
    productRepository productRepo;

    @PersistenceContext
    EntityManager em;

    @Override
    public  Iterable<product> getAllProducts() {

        //uso de JPQL segunda forma
        //1.-String donde vamos almacenar el comando sql
        String consulta = "SELECT p FROM product p";
        Query query = em.createQuery(consulta);
        return query.getResultList();


        //modo facil
        //Iterable<product>
        //return productRepo.findAll();


    }

    @Override
    public Optional<product> getProductById(long id) {return productRepo.findById(id);}

    @Override
    public void saveProduct(product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void updateProduct(product product, long id) {
        productRepo.save(product);

    }
}

package proyect.appRestProducts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import proyect.appRestProducts.entity.product;

@RepositoryRestResource
public interface productRepository extends CrudRepository<product,Long> {
}

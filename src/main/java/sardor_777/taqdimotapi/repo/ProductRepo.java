package sardor_777.taqdimotapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sardor_777.taqdimotapi.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {
}

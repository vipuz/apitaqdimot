package sardor_777.taqdimotapi.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import sardor_777.taqdimotapi.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
}

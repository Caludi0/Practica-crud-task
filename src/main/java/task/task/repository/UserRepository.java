package task.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.task.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

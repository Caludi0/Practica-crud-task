package task.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.task.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

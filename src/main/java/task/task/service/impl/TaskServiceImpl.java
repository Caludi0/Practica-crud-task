package task.task.service.impl;

import org.springframework.stereotype.Service;
import task.task.entity.Task;
import task.task.repository.TaskRepository;
import task.task.service.TaskService;

import java.util.List;
@Service
public class TaskServiceImpl  implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Task not found"));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setStatus(task.getStatus());
        existingTask.setUser(task.getUser());
        existingTask.setCategory(task.getCategory());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

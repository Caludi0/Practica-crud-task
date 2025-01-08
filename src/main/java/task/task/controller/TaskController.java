package task.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.task.entity.Task;
import task.task.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        return  ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}

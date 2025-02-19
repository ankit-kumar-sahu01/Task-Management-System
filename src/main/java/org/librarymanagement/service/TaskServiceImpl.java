package org.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import org.librarymanagement.model.Task;
import org.librarymanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TaskServiceImpl {
	
	@Autowired
	private TaskRepository taskRepository;
	
	//Create Task
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	//Update Task
	public Task updateTask(Long id, Task task) {
		Optional<Task> opt = taskRepository.findById(id);
		if(opt.isPresent()) {
			Task updatedTask = opt.get();
			updatedTask.setTitle(task.getTitle());
			updatedTask.setDescription(task.getDescription());
            updatedTask.setCategory(task.getCategory());
            updatedTask.setPriority(task.getPriority());
            updatedTask.setDueDate(task.getDueDate());
            updatedTask.setCompleted(task.isCompleted());
            return taskRepository.save(updatedTask);
		}else {
			return null;
		}
	}
	//Delete Task
	
	public void deleteTask(Long id) {
		 taskRepository.deleteById(id);
	}
	//Get Task By Id

	public Task getTaskById(Long id) {
		Optional<Task> opt = taskRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	//Get All Task

	 public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
	//Get Task By Category

	public List<Task> getTasksByCategory(String category) {
		return taskRepository.findByCategory(category);
	}
	//Get Task By Priority

	public List<Task> getTasksByPriority(String priority) {
		return taskRepository.findByPriority(priority);
	}
	//Get Completed Task

	public List<Task> getCompletedTasks(boolean completed) {
		return taskRepository.findByCompleted(completed);
	}
}

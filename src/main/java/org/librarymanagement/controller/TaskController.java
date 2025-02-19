package org.librarymanagement.controller;

import org.librarymanagement.model.Task;
import org.librarymanagement.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-details";
    }

    @GetMapping("/new")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-form";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        taskService.updateTask(id, task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/category/{category}")
    public String getTasksByCategory(@PathVariable String category, Model model) {
        List<Task> tasks = taskService.getTasksByCategory(category);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/priority/{priority}")
    public String getTasksByPriority(@PathVariable String priority, Model model) {
        List<Task> tasks = taskService.getTasksByPriority(priority);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/completed/{completed}")
    public String getTasksByCompletionStatus(@PathVariable boolean completed, Model model) {
        List<Task> tasks = taskService.getCompletedTasks(completed);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}
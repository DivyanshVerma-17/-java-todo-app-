```java
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

// Task Class
class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;
    private String priority; // HIGH, MEDIUM, LOW

    public Task(int id, String title, String description, String priority, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.completed = false;
        this.createdDate = LocalDateTime.now();
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public LocalDateTime getDueDate() { return dueDate; }
    public String getPriority() { return priority; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }

    public void display() {
        String status = completed ? "✓ DONE" : "⚬ TODO";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║ ID: " + String.format("%-30d", id) + "║");
        System.out.println("║ Title: " + String.format("%-27s", title) + "║");
        System.out.println("║ Status: " + String.format("%-26s", status) + "║");
        System.out.println("║ Priority: " + String.format("%-24s", priority) + "║");
        System.out.println("║ Description: " + String.format("%-22s", description) + "║");
        System.out.println("║ Due Date: " + String.format("%-25s", dueDate.format(formatter)) + "║");
        System.out.println("╚════════════════════════════════════╝");
    }
}

// Todo Manager Class
class TodoManager {
    private List<Task> tasks;
    private int taskIdCounter;

    public TodoManager() {
        tasks = new ArrayList<>();
        taskIdCounter = 1;
    }

    // Add Task
    public void addTask(String title, String description, String priority, LocalDateTime dueDate) {
        Task task = new Task(taskIdCounter++, title, description, priority, dueDate);
        tasks.add(task);
        System.out.println("\n✓ Task added successfully! (ID: " + task.getId() + ")");
    }

    // Display All Tasks
    public void displayAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks available!");
            return;
        }
        
        System.out.println("\n╔════════════ ALL TASKS ════════════╗");
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId() + " | " + task.getTitle() + 
                             " | Status: " + (task.isCompleted() ? "✓" : "○") + 
                             " | Priority: " + task.getPriority());
        }
        System.out.println("╚════════════════════════════════════╝");
    }

    // Display Detailed Task
    public void displayTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.display();
                return;
            }
        }
        System.out.println("Task not found!");
    }

    // Mark Task as Complete
    public void completeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                System.out.println("✓ Task marked as complete!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    // Delete Task
    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("✓ Task deleted!");
    }

    // Update Task
    public void updateTask(int id, String title, String description, String priority) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(title);
                task.setDescription(description);
                task.setPriority(priority);
                System.out.println("✓ Task updated!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    // Filter by Priority
    public void filterByPriority(String priority) {
        System.out.println("\n╔════ Tasks with Priority: " + priority + " ════╗");
        boolean found = false;
        for (Task task : tasks) {
            if (task.getPriority().equals(priority)) {
                System.out.println("ID: " + task.getId() + " | " + task.getTitle() + 
                                 " | Status: " + (task.isCompleted() ? "✓" : "○"));
                found = true;
            }
        }
        if (!found) System.out.println("No tasks with this priority!");
        System.out.println("╚════════════════════════════════════╝");
    }

    // Get Completed Tasks
    public void getCompletedTasks() {
        System.out.println("\n╔════════ COMPLETED TASKS ════════╗");
        boolean found = false;
        for (Task task : tasks) {
            if (task.isCompleted()) {
                System.out.println("✓ " + task.getTitle());
                found = true;
            }
        }
        if (!found) System.out.println("No completed tasks!");
        System.out.println("╚════════════════════════════════════╝");
    }

    // Get Pending Tasks
    public void getPendingTasks() {
        System.out.println("\n╔════════ PENDING TASKS ════════╗");
        boolean found = false;
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                System.out.println("⚬ " + task.getTitle());
                found = true;
            }
        }
        if (!found) System.out.println("No pending tasks!");
        System.out.println("╚════════════════════════════════════╝");
    }

    // Display Menu
    public void displayMenu() {
        System.out.println("\n╔═══════════════════════════════════╗");
        System.out.println("║       TODO APPLICATION             ║");
        System.out.println("╚═══════════════════════════════════╝");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. View Task Details");
        System.out.println("4. Complete Task");
        System.out.println("5. Delete Task");
        System.out.println("6. Update Task");
        System.out.println("7. Filter by Priority");
        System.out.println("8. View Completed Tasks");
        System.out.println("9. View Pending Tasks");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }
}

// Main Class
public class TodoApp {
    public static void main(String[] args) {
        TodoManager manager = new TodoManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            manager.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (HIGH/MEDIUM/LOW): ");
                    String priority = scanner.nextLine();
                    LocalDateTime dueDate = LocalDateTime.now().plusDays(7);
                    manager.addTask(title, description, priority, dueDate);
                    break;

                case 2:
                    manager.displayAllTasks();
                    break;

                case 3:
                    System.out.print("Enter task ID: ");
                    int id = scanner.nextInt();
                    manager.displayTask(id);
                    break;

                case 4:
                    System.out.print("Enter task ID to complete: ");
                    int completeId = scanner.nextInt();
                    manager.completeTask(completeId);
                    break;

                case 5:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteTask(deleteId);
                    break;

                case 6:
                    System.out.print("Enter task ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String newDesc = scanner.nextLine();
                    System.out.print("Enter new priority: ");
                    String newPriority = scanner.nextLine();
                    manager.updateTask(updateId, newTitle, newDesc, newPriority);
                    break;

                case 7:
                    System.out.print("Enter priority to filter (HIGH/MEDIUM/LOW): ");
                    String filterPriority = scanner.nextLine();
                    manager.filterByPriority(filterPriority);
                    break;

                case 8:
                    manager.getCompletedTasks();
                    break;

                case 9:
                    manager.getPendingTasks();
                    break;

                case 10:
                    System.out.println("\nThank you for using Todo App!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
                  }

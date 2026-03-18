# Todo Application (Java)

A feature-rich command-line todo application for managing tasks efficiently.

## Features

✨ **Core Features:**
- ✅ Add tasks with title, description, and priority
- ✅ View all tasks in a formatted list
- ✅ View detailed task information
- ✅ Mark tasks as complete
- ✅ Delete tasks
- ✅ Update task information
- ✅ Filter tasks by priority (HIGH, MEDIUM, LOW)
- ✅ View completed and pending tasks separately
- ✅ Automatic timestamps for task creation

## How to Compile & Run

```bash
# Compile
javac TodoApp.java

# Run
java TodoApp
Usage
-Select an option from the menu (1-10)
-Follow the prompts to manage your tasks
-Tasks are organized by priority and completion status
Features Explained
Add Task: Create a new task with description and priority
View Tasks: See all tasks at a glance
Task Details: View complete information about a specific task
Complete Task: Mark a task as done
Delete Task: Remove a task from the list
Update Task: Modify task details
Filter: View tasks by priority level
Completed/Pending: Separate view of done and pending tasks
Task Structure
class Task {
    - id (unique identifier)
    - title
    - description
    - completed (true/false)
    - priority (HIGH, MEDIUM, LOW)
    - createdDate
    - dueDate
}

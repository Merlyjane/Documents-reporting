import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskPriorityManager {
    // Inner class for Task
    static class Task implements Comparable<Task> {
        private String name;
        private int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return "[Priority: " + priority + "] " + name;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Priority Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Highest Priority Task");
            System.out.println("3. Complete Highest Priority Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task priority (1 = highest): ");
                    int priority = scanner.nextInt();
                    taskQueue.add(new Task(name, priority));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (!taskQueue.isEmpty()) {
                        System.out.println("Highest Priority Task: " + taskQueue.peek());
                    } else {
                        System.out.println("No tasks available.");
                    }
                    break;

                case 3:
                    if (!taskQueue.isEmpty()) {
                        System.out.println("Completed Task: " + taskQueue.poll());
                    } else {
                        System.out.println("No tasks to complete.");
                    }
                    break;

                case 4:
                    if (!taskQueue.isEmpty()) {
                        System.out.println("All Tasks:");
                        for (Task task : taskQueue) {
                            System.out.println(task);
                        }
                    } else {
                        System.out.println("No tasks available.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

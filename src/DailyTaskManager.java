import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas Task untuk merepresentasikan tugas harian
class Task {
    private String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + title;
    }
}

// Kelas TaskManager untuk mengelola daftar tugas
class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title) {
        tasks.add(new Task(title));
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
        } else {
            System.out.println("Nomor tugas tidak valid.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Tidak ada tugas yang tersedia.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

// Kelas utama untuk menjalankan aplikasi
public class DailyTaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        String command;

        System.out.println("Selamat datang di Pengelola Tugas Harian!");

        while (true) {
            System.out.println("\nPerintah yang tersedia: add, complete, list, exit");
            System.out.print("Masukkan perintah: ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Masukkan judul tugas: ");
                    String title = scanner.nextLine();
                    taskManager.addTask(title);
                    System.out.println("Tugas ditambahkan: " + title);
                    break;
                case "complete":
                    System.out.print("Masukkan nomor tugas yang akan diselesaikan: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine(); // Menghapus newline
                    taskManager.completeTask(taskNumber - 1);
                    break;
                case "list":
                    taskManager.displayTasks();
                    break;
                case "exit":
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Perintah tidak dikenal. Silakan coba lagi.");
            }
        }
    }
}

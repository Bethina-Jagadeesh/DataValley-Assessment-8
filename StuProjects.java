import java.util.ArrayList;
import java.util.List;

public class StuProjects {
    static class Project {
        String studentName;
        int dueDate;
        int completionDate;

        Project(String name, int due, int complete) {
            studentName = name;
            dueDate = due;
            completionDate = complete;
        }

        boolean isOnTime() {
            return completionDate == dueDate;
        }

        boolean isEarly() {
            return completionDate < dueDate;
        }

        boolean isLate() {
            return completionDate > dueDate;
        }

        int completionTime() {
            return Math.abs(completionDate - dueDate);
        }
    }

    public static void analyzeProjects(List<Project> projects) {
        int onTime = 0, early = 0, late = 0, totalTime = 0;
        for (Project p : projects) {
            if (p.isOnTime()) onTime++;
            if (p.isEarly()) early++;
            if (p.isLate()) late++;
            totalTime += p.completionTime();
        }
        double averageTime = projects.isEmpty() ? 0 : (double) totalTime / projects.size();
        System.out.println("On Time: " + onTime + ", Early: " + early + ", Late: " + late);
        System.out.println("Average Completion Time: " + averageTime);
    }

    public static void main(String[] args) {
        // Example list of projects
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Alice", 5, 5)); // on time
        projects.add(new Project("Bob", 5, 4)); // early
        projects.add(new Project("Charlie", 5, 6)); // late

        // Analyze the projects
        analyzeProjects(projects);
    }
}
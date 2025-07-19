public class Main {
    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();

        boolean result = pm.assignEmployeeToProject(3,5);

        if (result) {
            System.out.println("Employee assigned successfully");
        }  else {
            System.out.println("Employee not assigned successfully");
        }
    }
}
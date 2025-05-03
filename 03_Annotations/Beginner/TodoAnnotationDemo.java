import java.lang.annotation.*;
import java.lang.reflect.Method;


public class TodoAnnotationDemo {
    public static void main(String[] args) {
        Method[] methods = ProjectTasks.class.getDeclaredMethods();

        System.out.println("Pending TODOs:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  → Task: " + todo.task());
                System.out.println("  → Assigned To: " + todo.assignedTo());
                System.out.println("  → Priority: " + todo.priority());
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}


class ProjectTasks {

    @Todo(task = "Implement user authentication", assignedTo = "Rajesh", priority = "HIGH")
    public void loginFeature() {}

    @Todo(task = "Add logout functionality", assignedTo = "Anu")
    public void logoutFeature() {}

    @Todo(task = "Optimize search", assignedTo = "Ravi", priority = "LOW")
    public void searchFeature() {}

    public void completedFeature() {
        System.out.println("Feature already completed");
    }
}



import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}


public class TaskAnnotationDemo {
    public static void main(String[] args) throws Exception {
        TaskManager manager = new TaskManager();
        Method method = manager.getClass().getMethod("completeTask");

        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
        System.out.println("Task Priority: " + taskInfo.priority());
        System.out.println("Assigned To: " + taskInfo.assignedTo());
    }
}


class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Rajesh")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}


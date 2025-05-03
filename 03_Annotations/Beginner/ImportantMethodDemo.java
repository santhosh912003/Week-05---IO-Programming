import java.lang.annotation.*;
import java.lang.reflect.Method;


public class ImportantMethodDemo {
    public static void main(String[] args) {
        Method[] methods = CriticalOperations.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod imp = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + ", Level: " + imp.level());
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH"; // optional parameter with default value
}


class CriticalOperations {

    @ImportantMethod(level = "CRITICAL")
    public void processPayments() {
        System.out.println("Processing payments...");
    }

    @ImportantMethod 
    public void backupDatabase() {
        System.out.println("Backing up database...");
    }
	
	@ImportantMethod(level = "VERY LOW")
    public void logActivity() {
        System.out.println("Logging activity...");
    }
}


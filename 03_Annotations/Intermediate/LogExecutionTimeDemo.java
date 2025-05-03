import java.lang.annotation.*;
import java.lang.reflect.Method;


public class LogExecutionTimeDemo {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method[] methods = Calculator.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(calc);  
                long end = System.nanoTime();
                long duration = (end - start) / 1_000_000; // convert to ms
                System.out.println("Executed " + method.getName() + " in " + duration + " ms");
            }
        }
    }
}



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}


class Calculator {

    @LogExecutionTime
    public void longOperation() {
        try {
            Thread.sleep(500); // simulate long task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void shortOperation() {
        try {
            Thread.sleep(100); // simulate short task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


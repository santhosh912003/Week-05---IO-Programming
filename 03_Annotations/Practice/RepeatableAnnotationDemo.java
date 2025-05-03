import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}



public class RepeatableAnnotationDemo {
    public static void main(String[] args) throws Exception {
        BugTracker tracker = new BugTracker();
        Method method = tracker.getClass().getMethod("resolveBugs");

        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
        for (BugReport bug : bugReports) {
            System.out.println("Bug: " + bug.description());
        }
    }
}


class BugTracker {
    @BugReport(description = "NullPointerException on login")
    @BugReport(description = "UI glitch on dashboard")
    public void resolveBugs() {
        System.out.println("Resolving bugs...");
    }
}
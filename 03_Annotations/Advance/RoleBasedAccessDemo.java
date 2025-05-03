import java.lang.annotation.*;
import java.lang.reflect.Method;

public class RoleBasedAccessDemo {

    public static void invokeIfAllowed(Object obj, String methodName, String currentUserRole) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (roleAllowed.value().equals(currentUserRole)) {
                method.invoke(obj);
            } else {
                System.out.println("Access Denied for role: " + currentUserRole);
            }
        } else {
            method.invoke(obj);
        }
    }

    public static void main(String[] args) throws Exception {
        AdminService service = new AdminService();
        invokeIfAllowed(service, "deleteUser", "ADMIN");
        invokeIfAllowed(service, "deleteUser", "USER");
        invokeIfAllowed(service, "viewDashboard", "USER");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted by ADMIN.");
    }

    @RoleAllowed("USER")
    public void viewDashboard() {
        System.out.println("Dashboard viewed by USER.");
    }
}

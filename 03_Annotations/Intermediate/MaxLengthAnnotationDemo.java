import java.lang.annotation.*;
import java.lang.reflect.Field;


public class MaxLengthAnnotationDemo {
    public static void main(String[] args) {
        try {
            User user1 = new User("Rajesh"); // valid
            System.out.println("User1: " + user1.getUsername());

            User user2 = new User("SuperLongUsername"); // invalid
            System.out.println("User2: " + user2.getUsername());

        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}


class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;

        
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength max = field.getAnnotation(MaxLength.class);
                if (username.length() > max.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + max.value());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}



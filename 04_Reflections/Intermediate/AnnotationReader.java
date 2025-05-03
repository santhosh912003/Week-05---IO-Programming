import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationReader {
    public static void main(String[] args) {
        Class<?> clazz = Book.class;
        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Rajesh K")
class Book {}

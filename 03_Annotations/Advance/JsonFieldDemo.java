import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonFieldDemo {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Rajesh", 23);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String name;

    @JsonField(name = "user_age")
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, String> jsonMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), String.valueOf(field.get(obj)));
            }
        }
        StringBuilder json = new StringBuilder("{");
        jsonMap.forEach((key, value) -> json.append("\"").append(key).append("\":\"").append(value).append("\","));
        if (json.charAt(json.length() - 1) == ',') json.deleteCharAt(json.length() - 1);
        json.append("}");
        return json.toString();
    }
}

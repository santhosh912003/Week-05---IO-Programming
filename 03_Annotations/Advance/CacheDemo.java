import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

public class CacheDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.square(4));
        System.out.println(calc.square(4));
        System.out.println(calc.square(5));
        System.out.println(calc.square(5));
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class Calculator {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int square(int num) {
        if (cache.containsKey(num)) {
            System.out.println("Returned from cache");
            return cache.get(num);
        }
        System.out.println("Computing square of " + num);
        int result = num * num;
        cache.put(num, result);
        return result;
    }
}

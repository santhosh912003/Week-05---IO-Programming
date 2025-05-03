import java.util.ArrayList;

public class SuppressWarningDemo {

    @SuppressWarnings("unchecked")
    void createRawList() {
        ArrayList list = new ArrayList(); 
        list.add("Rajesh");
        System.out.println("List: " + list);
    }

    public static void main(String[] args) {
        new SuppressWarningDemo().createRawList();
    }
}

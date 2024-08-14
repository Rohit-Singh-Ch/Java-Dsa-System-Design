import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> lists = new ArrayList<Integer>() {{
            add(3);
            add(2);
            add(4);
            add(6);
        }};
        for(int n=1;n<lists.size();n++){
            for(int i=1;i<=10;i++){
                System.out.println(lists.get(n) + "x" + i + " = " + (n*i));
            }
            System.out.println("==================");
        }
    }
}

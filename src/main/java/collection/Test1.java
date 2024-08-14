package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {

//        int bits = (int) (Math.log(16)/ Math.log(2));
//        System.out.println(bits);

        String input = "(()))(";
       if(input.length() %2 != 0) System.out.println(-1);
        int count = 0;
        int swap = 0;
        for (char bracket : input.toCharArray()) {
            if (bracket == '(') count++;
            else {
                count --;
                if(count < 0) swap++;
            }
        }
        if(count == 0) System.out.println(swap);

//        Set<Integer> s = new HashSet<Integer>(){{
//           add(10);add(20);add(30);
//        }};
//
//        System.out.println(s);
//        Iterator<Integer> iterator = s.iterator();
//        while (iterator.hasNext()){
//            Integer next = iterator.next();
//            s.remove(10);
//          //  s.add(50);
//
//        }
//        for (Integer integer : s) {
//            s.add(60);
//        }

       // System.out.println(s);
    }
}


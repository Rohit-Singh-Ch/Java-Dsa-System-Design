import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> test = Class.forName("Test");
        test.newInstance();
    }

}


final class MyCache {
    private final int CAPACITY = 10;
    private List<String> list = new ArrayList<>(CAPACITY);
    private ConcurrentMap<String, Object> cache = new ConcurrentHashMap<>();

    public void push(String key, Object val){
        if(list.size() == CAPACITY){
            pop(list.get(CAPACITY));
        }
        if(!list.contains(key)) {
            list.add(key);
        }
        cache.putIfAbsent(key, val);
    }

    public void pop(String key){
        cache.remove(key);
    }

    public void deleteAll(){
        cache.clear();
    }
}
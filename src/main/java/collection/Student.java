package collection;

import java.util.Comparator;
import java.util.TreeSet;

public class Student implements Comparable{
    String name;
    Integer rollNo;

    Student(String name, Integer rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return rollNo + "----" + name;
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        if(this.rollNo < student.rollNo) return -1;
        else if (this.rollNo > student.rollNo) return 1;
        else return 0;
    }
}

class Test{
    public static void main(String[] args) {
        TreeSet t = new TreeSet();
        t.add(new Student("Aashish",101));
        t.add(new Student("Deepak",104));
        t.add(new Student("Raghu",102));
        t.add(new Student("Rohit",108));

        System.out.println(t);

        TreeSet comparator = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String name1 = ((Student)o1).name.toString();
                String name2 = ((Student)o2).name.toString();
                //reverse order of student name
                return name2.compareTo(name1);
            }
        });

        comparator.add(new Student("Aashish",101));
        comparator.add(new Student("Deepak",104));
        comparator.add(new Student("Raghu",102));
        comparator.add(new Student("Rohit",108));
        System.out.println(comparator);
    }
}

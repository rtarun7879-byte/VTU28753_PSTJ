import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}

class Checker implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        // CGPA - decreasing order
        if (s1.cgpa != s2.cgpa) {
            return Double.compare(s2.cgpa, s1.cgpa);
        }

        // Name - alphabetical order
        if (!s1.name.equals(s2.name)) {
            return s1.name.compareTo(s2.name);
        }

        // ID - increasing order
        return Integer.compare(s1.id, s2.id);
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, name, cgpa));
        }

        Collections.sort(students, new Checker());

        for (Student s : students) {
            System.out.println(s.name);
        }

        sc.close();
    }
}
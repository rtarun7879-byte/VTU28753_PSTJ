import java.util.*;
import java.io.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() { return id; }
    String getName() { return name; }
    double getCGPA() { return cgpa; }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());

        for (String event : events) {
            String[] tokens = event.split(" ");

            if (tokens[0].equals("ENTER")) {
                String name = tokens[1];
                double cgpa = Double.parseDouble(tokens[2]);
                int id = Integer.parseInt(tokens[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (tokens[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }

    class StudentComparator implements Comparator<Student> {
        public int compare(Student a, Student b) {
            // Highest CGPA first
            if (a.getCGPA() != b.getCGPA()) {
                return Double.compare(b.getCGPA(), a.getCGPA());
            }
            // Same CGPA -> ascending name
            if (!a.getName().equals(b.getName())) {
                return a.getName().compareTo(b.getName());
            }
            // Same CGPA and name -> ascending id
            return Integer.compare(a.getID(), b.getID());
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalEvents = Integer.parseInt(scan.nextLine());

        List<String> events = new ArrayList<>();
        while (totalEvents-- != 0) {
            String s = scan.nextLine();
            events.add(s);
        }
        scan.close();

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
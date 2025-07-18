package presentation;

import entity.Manage;
import entity.Student;

import java.util.ArrayList;

public class AttendanceManager implements Manage<Student> {
    ArrayList<Student> students = new ArrayList<>();

    @Override
    public void add(Student item) {
        students.add(item);
    }

    @Override
    public void update(int index, Student item) {
        students.set(index, item);
    }

    @Override
    public void delete(Student item) {
        students.remove(item);
    }

    @Override
    public void display() {
        for (Student item : students) {
            System.out.println(item);
        }
    }




}

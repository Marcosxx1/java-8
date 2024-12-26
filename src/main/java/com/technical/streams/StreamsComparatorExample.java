package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;

public class StreamsComparatorExample {

    public static List<Student> sortedStudentsByName(){

        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
    }

    public static List<Student> studentsSortedByGpa(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .toList();
    }

    public static List<Student> studentListSortedReversedByGpa(){
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName).reversed())
                .toList();
    }

    public static void main(String[] args) {

        System.out.println("Students sorted by name: ");
        sortedStudentsByName().forEach(System.out::println);

        System.out.println("Students sorted by GPA: ");
        studentsSortedByGpa().forEach(System.out::println);

        System.out.println("Students sorted by GPA Reversed: ");
        studentListSortedReversedByGpa().forEach(System.out::println);
    }
}

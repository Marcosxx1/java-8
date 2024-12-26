package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class StreamsFilterExample {

    public static Predicate<Student> femaleStudents = ( (student -> student.getGender().equalsIgnoreCase("female")));
    public static Predicate<Student> gpaGreaterThanFour =((student -> student.getGpa() >= 4));

    public static List<Student> getAllFemaleStudents(){
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .filter(femaleStudents.and(gpaGreaterThanFour)) // Stream<Student>
                //filters and sends only the students whose gender is female
                .toList();
    }

    public static void main(String[] args) {
        getAllFemaleStudents().forEach(System.out::println);
    }
}

package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    //student name and their activities in a map
    static List<Student> students = StudentDataBase.getAllStudents();
    static Predicate<Student> gradeLevelGreaterThanThree = (student -> student.getGradeLevel() >= 3);
    static Predicate<Student> GpaGreaterThanThreeDotNine = (student -> student.getGradeLevel() >= 3.9);

    
    public static void main(String[] args) {

        Map<String, List<String>> studentMap = students.stream()
                //.filter((student -> student.getGradeLevel() >= 3 && student.getGradeLevel() >= 3.9))
                .filter(gradeLevelGreaterThanThree)
                .filter(GpaGreaterThanThreeDotNine)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));


        System.out.println(studentMap);
    }
}



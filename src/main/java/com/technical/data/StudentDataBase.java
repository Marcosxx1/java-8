package com.technical.data;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class StudentDataBase {

    public static List<Student> getAllStudents() {

        Student student1 = new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));
        Student student2 = new Student("Jenny", 2, 4.0, "female", Arrays.asList("swimming", "gymnastics", "soccer"));

        Student student3 = new Student("Emily", 3, 4.0, "female", Arrays.asList("swimming", "gymnastics", "aerobics"));
        Student student4 = new Student("Dave", 3, 3.9, "male", Arrays.asList("swimming", "gymnastics", "soccer"));

        Student student5 = new Student("Sophia", 4, 3.5, "female", Arrays.asList("swimming", "dancing", "football"));
        Student student6 = new Student("James", 4, 3.9, "male", Arrays.asList("swimming", "basketball", "baseball", "football"));

        return List.of(student1, student2, student3, student4, student5, student6);
    }
}

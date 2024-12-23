package com.technical.functionalInterfaces;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static List<Student> studentList = StudentDataBase.getAllStudents();
    public static Consumer<Student> consumerStudentName = (student) -> System.out.println(student.getName());
    public static Consumer<Student> consumerStudentActivities = (student) -> System.out.println(student.getActivities());

    public static void printName() {
         studentList.forEach(consumerStudentName);
    }

    public static void printNameAndActivities() {
        System.out.println("\nprintNameAndActivities");

        studentList.forEach(consumerStudentName.andThen(consumerStudentActivities));//consumer chaining
    }


    public static void printNameAndActivitiesWithFilter() {

        System.out.println("\nprintNameAndActivitiesWithFilter");

        studentList.forEach(student -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() >= 4) {
                consumerStudentName.andThen(consumerStudentActivities).accept(student);
            }
        });
    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

        c1.accept("java8");

        printName();

        printNameAndActivities();

        printNameAndActivitiesWithFilter();
    }
}




/*    public static void printNameAndActivitiesWithFilterStream() {

        System.out.println("\nprintNameAndActivitiesWithFilterStream");
        studentList.stream()
                .filter(student -> student.getGradeLevel() >= 3 && student.getGpa() >= 4)
                .forEach(consumerStudentName.andThen(consumerStudentActivities));
    }*/
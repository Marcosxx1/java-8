package com.technical.functionalInterfaces;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> studentPredicateGrade = (student -> student.getGradeLevel() >= 3);
    static Predicate<Student> studentPredicateGPA = (student -> student.getGpa() >= 4);

    static Predicate<Student> studentStartsWithJ = (student -> student.getName().startsWith("J"));

    static List<Student> listOfStudents = StudentDataBase.getAllStudents();

    public static void filterStudentsByGradeLevel() {
        listOfStudents.forEach(student -> {

            if (studentPredicateGrade.test(student)) {
                System.out.println("Students with grade >= 3: " + student);
            }
        });
    }

    public static void filterStudentsByGradeGPA() {
        listOfStudents.forEach(student -> {

            if (studentPredicateGPA.test(student)) {
                System.out.println("Students with GPA >= 4: " + student);
            }
        });
    }


    public static void filterStudentByGradeLevelAndGpa(){
        listOfStudents.forEach(student -> {
            if(studentPredicateGrade.and(studentPredicateGPA).test(student)){
                System.out.println("Students with grade >= 3 AND GPA >= 4: " + student);
            }
        });
    }

    public static void filterStudentWithNameStartingWithJAndGradeAndGpa(){
        listOfStudents.forEach(student -> {

            if(studentStartsWithJ.and(studentPredicateGPA).and(studentPredicateGrade).test(student)){
                System.out.println("Students with grade >= 3 AND GPA >= 4 AND name starts with J: " + student);
            }
        });
    }


    public static void main(String[] args) {

        filterStudentsByGradeLevel();
        filterStudentsByGradeGPA();
        filterStudentByGradeLevelAndGpa();
        filterStudentWithNameStartingWithJAndGradeAndGpa();
    }
}

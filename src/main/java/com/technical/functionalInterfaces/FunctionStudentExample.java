package com.technical.functionalInterfaces;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.technical.functionalInterfaces.PredicateStudentExample.studentPredicateGrade;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>> mapStudentsToGradeMap = (students -> {
        Map<String, Double> studentGradeMap = new HashMap<>();

        students.forEach((student -> {
            if(studentPredicateGrade.test(student)){
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        }));
        return studentGradeMap;
    });

    public static void main(String[] args) {
        List<Student> students = StudentDataBase.getAllStudents();

        System.out.println(mapStudentsToGradeMap.apply(students));
    }
}

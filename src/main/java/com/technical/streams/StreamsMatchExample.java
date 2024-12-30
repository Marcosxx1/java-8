package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;

public class StreamsMatchExample {

    public static List<Student> students = StudentDataBase.getAllStudents();

    public static Boolean allMatch() {
        return students.stream()
                .allMatch(student -> student.getGpa() >= 3.9);
    }

    public static Boolean anyMatch() {
        return students.stream()
                .anyMatch(student -> student.getGpa() >= 3.9);
    }

    public static Boolean noneMatch(){
        return students.stream()
                .noneMatch(student -> student.getGpa() >= 3.9);
    }

    public static void main(String[] args) {
        System.out.println("Allmatch : " + allMatch()); // Deve retornar false pois NEM TODOS são iguais ao predicado student.getPga() >= 3.9
        System.out.println("AnyMatch : " + anyMatch()); // Deve retornar true pois EXISTEM valores que são iguais ao predicado student.getPga() >= 3.9
        System.out.println("NoneMatch : " + noneMatch()); // Deve retornar false, pois NEM TODOS são diferentes
    }
}

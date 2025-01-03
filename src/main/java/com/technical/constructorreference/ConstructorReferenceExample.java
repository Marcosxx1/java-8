package com.technical.constructorreference;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    static Supplier<Student> studentSupplier = Student::new; // Devemos ter um construtor vazio

    static Function<String, Student> studentFunction = Student::new;

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());
        System.out.println(studentFunction.apply("ABDEFG"));
    }
}

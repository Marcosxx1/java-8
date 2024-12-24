package com.technical.functionalInterfaces;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

   static Supplier<Student> studentSupplier = () ->
            new Student("Marcos", 4, 4.0, "X", Arrays.asList("Football", "Volleyball"));

   static Supplier<List<Student>> listSupplier = ()-> StudentDataBase.getAllStudents();

    public static void main(String[] args) {
        System.out.println("Student  is: " + studentSupplier.get());
        System.out.println("Students are: " + listSupplier.get());
    }
}

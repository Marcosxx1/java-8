package com.technical.methodreference;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.function.Predicate;

import static com.technical.data.StudentDataBase.studentSupplier;

public class RefactorMethodReferenceExample {

    static Predicate<Student> studentPredicate = RefactorMethodReferenceExample::returnStudent;

    private static boolean returnStudent(Student student) {
        return studentSupplier.get().getGradeLevel() >= 3;
    }

    public static void main(String[] args) {

        System.out.println(studentPredicate.test(studentSupplier.get()));
    }
}

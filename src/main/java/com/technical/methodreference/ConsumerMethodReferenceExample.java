package com.technical.methodreference;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    /*
    * ClassName::methodName
    * */
    static Consumer<Student> studentConsumer = System.out::println;

    /*
    * ClassName::InstanceMethodName
    * */
    static Consumer<Student>studentConsumerInstance = Student::printListActivities;

    static List<Student> listOfStudent = StudentDataBase.getAllStudents();

    public static void main(String[] args) {
        listOfStudent.forEach(studentConsumer);
        System.out.println("\n");
        listOfStudent.forEach(studentConsumerInstance);
    }
}

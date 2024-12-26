package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;

public class StreamsFlatMapExample {

    public static List<String> studentActivities() {

        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities)//Stream<List<String>>
                .flatMap(List::stream) // Cria uuma Stream<String>, assim podemos usar o collect ou teríamos o erro "toList() in Collectors cannot be applied. reason: no instance(s) of type variable(s) exist so that List<String> conforms to String inference variable T has incompatible bounds: eualiti constraint String lower bounds: List<String>
                .toList();
    }

    public static void main(String[] args) {

        System.out.println(studentActivities());
    }
}

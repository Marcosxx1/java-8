package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

public class StreamMapReduceExample {


/*    private static int numberOfNoteBooks() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getNoteBooks) // Stream<Integer>
                .reduce(0, (a, b) -> a + b);
    }*/

    private static int numberOfNoteBooks() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getNoteBooks) // Stream<Integer>
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(numberOfNoteBooks());
    }
}

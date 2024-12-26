package com.technical.streams;

import com.technical.data.Student;
import com.technical.data.StudentDataBase;

import java.util.List;

public class StreamsFlatMapDistinctCountAndSortedExample {

    public static List<String> returnStudentActivities() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .toList();
    }

    public static Long returnActivitiesCount(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static List<String> returnActivitieSorted(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .sorted().distinct()
                .toList();
    }





    public static void main(String[] args) {

        System.out.println("Atividades: " + returnStudentActivities());
        System.out.println("Contagem de atividades não repetidas: " + returnActivitiesCount());
        System.out.println("Atividades organizadas(sort): " + returnActivitieSorted());
    }
}

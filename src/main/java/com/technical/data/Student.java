package com.technical.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    private List<String> activities;

    public Student(String s) {
        this.name = s;
    }

    public void printListActivities(){
        System.out.println(activities);
    }
}

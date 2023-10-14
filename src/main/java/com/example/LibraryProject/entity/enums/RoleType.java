package com.example.LibraryProject.entity.enums;

public enum RoleType {

    ANONYMOUS("Anonymous"),
    MEMBER("Member"),
    EMPLOYEE("Employee"),
    ADMIN("Admin");


    public final String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

package org.example;

public class Employee {
    private int id;
    private String first_Name;
    private String last_Name;
    private String role;

    public Employee(int id, String first_Name, String last_Name, String role) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

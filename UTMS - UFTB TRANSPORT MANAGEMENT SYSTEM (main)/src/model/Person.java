package model;

public class Person {
    protected String name;
    protected String id;
    protected String department;  // NEW

    public Person(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getInfo() {
        return name + "," + id + "," + department;  // include department
    }
}

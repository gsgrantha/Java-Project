package model;

public class StudentBus extends Transport {
    public StudentBus(String number, Route route) {
        super(number, route);
    }

    @Override
    public String getType() {
        return "Student Bus " + number;
    }
}

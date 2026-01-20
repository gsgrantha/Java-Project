package model;

public class StaffCar extends Transport {
    public StaffCar(String number, Route route) {
        super(number, route);
    }

    @Override
    public String getType() {
        return "Staff Car " + number;
    }
}

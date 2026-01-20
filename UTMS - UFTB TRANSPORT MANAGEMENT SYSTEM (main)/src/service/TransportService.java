package service;

import model.*;

public class TransportService {

    public static Transport createTransport(String type, String number, Route route) {
        if (type.equals("Student")) {
            return new StudentBus(number, route);
        } else {
            return new StaffCar(number, route);
        }
    }
}

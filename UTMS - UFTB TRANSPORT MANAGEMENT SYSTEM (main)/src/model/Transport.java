package model;

public abstract class Transport {
    protected String number;
    protected Route route;

    public Transport(String number, Route route) {
        this.number = number;
        this.route = route;
    }

    public abstract String getType();
}

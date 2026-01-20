package model;

public class Route {
    private String pickup;
    private String drop;

    public Route(String pickup, String drop) {
        this.pickup = pickup;
        this.drop = drop;
    }

    public String getRoute() {
        return pickup + " -> " + drop;
    }
}

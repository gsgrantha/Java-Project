package model;

public class Assignment {
    private final Person person;
    private final Transport transport;

    public Assignment(Person person, Transport transport) {
        this.person = person;
        this.transport = transport;
    }

    public String toFileString() {
        return person.getInfo() + "," + transport.getType() + "," + transport.route.getRoute();
    }
}

package model;

public class Person {
    private final String type;
    private final String id;

    public Person(String type, String id) {
        this.type = type;
        this.id = type;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}

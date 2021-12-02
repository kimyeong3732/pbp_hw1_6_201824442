package edu.pnu.admin;

public class Beverage {
    private String type;
    private String name;

    public Beverage(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getBeverageName() {
        return name;
    }

    @Override
    public int hashCode() {
        return type.hashCode() * name.hashCode();
    }

    public boolean equals(Beverage beverage) {
        return this.hashCode() == beverage.hashCode();
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", name, type);
    }
}

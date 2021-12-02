public class Beverage {
    private String type;
    private String name;

    public Beverage(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public int hashcode() {
        return (int) ((int)name.hashCode() * (int)type.hashCode());
    }

    public String getBeverageName() {
        return name;
    }

    public String toString() {
        String result = String.format("[%s, %s]", name, type);
        return result;
    }

    public boolean equals(Beverage a) {
        return (this.hashcode() == a.hashcode());
    }
}

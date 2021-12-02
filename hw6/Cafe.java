package edu.pnu.admin;
import edu.pnu.collection.*;

public class Cafe {
    private String name;
    private GenericList<Beverage> students = new GenericList<Beverage>();

    public Cafe(String name) {
        this.name = name;
    }

    public void addBeverage(Beverage beverage) {
        students.add(beverage);
    }

    public void removeAllBeverage() {
        students.clear();
    }

    public Beverage findBeverage(String name, String type) {
        Beverage find = new Beverage(name, type);

        for(int i=0; i<students.getSize(); i++) {
            if(students.getValue(i).equals(find)) {
                return find;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String str = " Cafe Name: " + name + " Beverage Count: " + students.getSize() + '\n';
        for(int i=0; i<students.getSize(); i++) {
            str += '\t' + students.getValue(i).toString() + '\n';
        }
        return str;
    }
}

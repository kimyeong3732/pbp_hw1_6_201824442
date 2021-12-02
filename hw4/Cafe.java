import java.util.HashMap;
import java.util.Iterator;

public class Cafe {
    private String name;
    private HashMap<String, Beverage> menus = new HashMap<>();

    public Cafe(String name) {
        this.name = name;
    }

    public int hashcode() {
        return (int)name.hashCode();
    }

    public void addBeverage(Beverage a) {
        menus.put(a.getBeverageName(), a);
    }

    public void removeAllBeverage() {
        menus.clear();
    }

    public String toString() {
        String msg = " Cafe Name: " + name + " Beverage Count: " + menus.size() + "\n";
        Iterator<Beverage> valus = menus.values().iterator();
        while(valus.hasNext()) {
            msg += "\t" + valus.next() + "\n";
        }
        return msg;
    }

    public Beverage findBeverage(String name, String type) {
        int found = 0;
        Beverage tofind = new Beverage(name, type);
        Iterator<Beverage> index = menus.values().iterator();
        while(index.hasNext()) {
            if(tofind.equals(index.next())) {
                found = 1;
                break;
            }
        }

        if(found == 1) {
            return tofind;
        }
        else {
            return null;
        }
    }

    public boolean equals(Cafe a) {
        return (this.hashcode() == a.hashcode());
    }

}

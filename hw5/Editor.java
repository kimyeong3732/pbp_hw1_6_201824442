package edu.pnu.edit;
import edu.pnu.shape.*;
import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void clear() {
        shapes.clear();
    }

    public void list() {
        int i = 1;
        System.out.print("[");
        for(Shape shape: shapes) {
            System.out.print(shape);
            if(i != shapes.size())
                System.out.print(", ");
            i++;
        }
        System.out.println("]");
    }
}

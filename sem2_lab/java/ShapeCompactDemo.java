import javax.swing.*;
import java.awt.*;

/* ---------- Interfaces ---------- */

interface Printable {
    void printDetails();
}

interface Compactable {
    void compact();
}

interface Drawable {
    void draw(Graphics g);
}

/* ---------- Rectangle ---------- */

class RectangleShape implements Printable, Compactable, Drawable {
    int x, y, l, w;

    RectangleShape(int x, int y, int l, int w) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.w = w;
    }

    int area() {
        return l * w;
    }

    public void printDetails() {
        System.out.println("Rectangle:");
        System.out.println("Length = " + l);
        System.out.println("Width = " + w);
        System.out.println("Area = " + area());
    }

    public void compact() {
        System.out.println("Compacting Rectangle");
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(x, y, l, w);
    }
}

/* ---------- Sphere ---------- */

class SphereShape implements Printable, Compactable, Drawable {
    int x, y, r;

    SphereShape(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    double area() {
        return 4 * Math.PI * r * r;   // surface area
    }

    public void printDetails() {
        System.out.println("Sphere:");
        System.out.println("Radius = " + r);
        System.out.println("Surface Area = " + area());
    }

    public void compact() {
        System.out.println("Compacting Sphere");
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawOval(x, y, r * 2, r * 2);
    }
}

/* ---------- Drawing Panel ---------- */

class DrawPanel extends JPanel {
    RectangleShape rect;
    SphereShape sphere;

    DrawPanel(RectangleShape r, SphereShape s) {
        rect = r;
        sphere = s;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        rect.draw(g);
        sphere.draw(g);
    }
}

/* ---------- Main Class ---------- */

public class ShapeCompactDemo {
    public static void main(String[] args) {

        RectangleShape rect = new RectangleShape(50, 50, 120, 80);
        SphereShape sphere = new SphereShape(220, 50, 40);

        // Printable
        rect.printDetails();
        sphere.printDetails();

        // Compactable
        rect.compact();
        sphere.compact();

        // GUI
        JFrame frame = new JFrame("Rectangle and Sphere");
        frame.add(new DrawPanel(rect, sphere));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

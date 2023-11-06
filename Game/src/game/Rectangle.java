package game;

public class Rectangle {

    // (x, y) represents top-left corner of Rectangle.
    double x, y, width, height;

    public Rectangle() {
        this.setSize(1,1);
        this.setPos(0, 0);
    }

    public Rectangle(double x, double y, double w, double h) {
        this.setPos(x, y);
        this.setSize(w, h);
    }

    public void setSize(double w, double h) {
        this.width = w;
        this.height = h;
    }

    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean overlaps(Rectangle other) {

        // this to the left of other.
        boolean noOverlap = this.x + this.width < other.x ||
                        other.x + other.width < this.x ||
                        this.y + this.height < other.y ||
                        other.y + other.width < this.y;

        return !noOverlap;
    }

}

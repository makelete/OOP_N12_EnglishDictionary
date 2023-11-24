package game;

public class Vector {
    public double x;
    public double y;

    public Vector() {
        this.set(0, 0);
    }

    public Vector(double x, double y) {
        this.set(x, y);
    }

    public void set (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void multiply(double m) {
        this.x *= m;
        this.y *= m;
    }

    public double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public void setLength(double L) {
        double curLength = this.getLength();
        // if cur length is 0, then sur angle is undefined. Assume cur angle is 0.
        if(curLength == 0) {
            this.set(L, 0);
        } else {
            this.multiply(1 / curLength);
            this.multiply(L);
        }
    }

    public double getAngle() {
        return Math.toDegrees(Math.atan2(this.y, this.x));
    }

    public void setAngle(double angleDegress) {
        double L = this.getLength();
        double angleRad = Math.toRadians(angleDegress);
        this.x = L * Math.cos(angleRad);
        this.y = L * Math.sin(angleRad);
    }
}
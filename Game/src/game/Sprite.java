package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    public Vector position;
    public Vector velocity;
    public double rotation;
    public Rectangle boundary;
    public Image image;

    public Sprite() {
        this.position = new Vector();
        this.velocity = new Vector();
        this.rotation = 0;
        this.boundary = new Rectangle();
    }

    public Sprite(String imageFile) {
        this();
        setImage(imageFile);
    }

    public void setImage(String imageFile) {
        this.image = new Image(imageFile);
        this.boundary.setSize(this.image.getWidth(), this.image.getHeight());
    }

    public Rectangle getBoundary() {
        this.boundary.setPos(this.position.x, this.position.y);
        return this.boundary;
    }

    public boolean overlaps(Sprite other) {
        return this.getBoundary().overlaps(other.getBoundary());
    }

    public void update(double deltaTime) {
        // update position according to velocity.
        this.position.add(this.velocity.x * deltaTime, this.velocity.y * deltaTime);
    }

    public void render(GraphicsContext context) {
        context.save();

        context.translate(this.position.x, this.position.y);
        context.rotate(this.rotation);
        context.translate(-this.image.getWidth() / 2, -this.image.getHeight() / 2);
        context.drawImage(this.image, 0, 0);

        context.restore();
    }
}
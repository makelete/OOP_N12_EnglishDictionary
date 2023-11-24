package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    public Vector position;
    public Vector velocity;
    public double rotation;
    public Rectangle boundary;
    public Image image;
    public double elapsedTime; // seconds.

    public Sprite() {
        this.position = new Vector();
        this.velocity = new Vector();
        this.rotation = 0;
        this.boundary = new Rectangle();
        this.elapsedTime = 0;
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

    public void wrap(double scrWidth, double scrHeight) {
        double halfimageW = this.image.getWidth()/2;
        double halfimageH = this.image.getHeight()/2;

        if(this.position.x + halfimageW < 0) this.position.x = scrWidth + halfimageW;
        if(this.position.x > scrWidth + halfimageW) this.position.x = -halfimageW;
        if(this.position.y + halfimageH < 0) this.position.y = scrHeight + halfimageH;
        if (this.position.y > scrHeight + halfimageH) this.position.y = -halfimageH;
    }

    public void update(double deltaTime) {
        // increase elapsed time for this sprite.
        this.elapsedTime += deltaTime;
        // update position according to velocity.
        this.position.add(this.velocity.x * deltaTime, this.velocity.y * deltaTime);
        // wrap around scr.
        this.wrap(800, 300);
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
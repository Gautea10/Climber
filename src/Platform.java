import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Created by Gaute on 4/26/2017.
 */
public class Platform extends Scene {
    private int platPosX;
    private int platPosY;
    private int platSizeWidth;
    private int platSizeHeight;

    private Shape platform;

    public Platform(int platPosX, int platPosY, int platSizeWidth, int platSizeHeight) {
        super();
        this.platPosX = platPosX;
        this.platPosY = platPosY;
        this.platSizeWidth = platSizeWidth;
        this.platSizeHeight = platSizeHeight;

        System.out.println(platPosY);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.draw(platform);
        graphics.fill(platform);
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

    }

    public void init(GameContainer gc) throws SlickException {
        platform = new Rectangle(platPosX,platPosY,platSizeWidth,platSizeHeight);
    }

    public boolean collidesWith(Shape s)
    {
        return platform.intersects(s);
    }

    // Getters and Setters
    public int getPlatPosX() {
        return platPosX;
    }

    public void setPlatPosX(int platPosX) {
        this.platPosX = platPosX;
    }

    public int getPlatPosY() {
        return platPosY;
    }

    public void setPlatPosY(int platPosY) {
        this.platPosY = platPosY;
    }

    public int getPlatSizeWidth() {
        return platSizeWidth;
    }

    public void setPlatSizeWidth(int platSizeWidth) {
        this.platSizeWidth = platSizeWidth;
    }

    public int getPlatSizeHeight() {
        return platSizeHeight;
    }

    public void setPlatSizeHeight(int platSizeHeight) {
        this.platSizeHeight = platSizeHeight;
    }

    public Shape getPlatform() {
        return platform;
    }

    public void setPlatform(Shape platform) {
        this.platform = platform;
    }
}

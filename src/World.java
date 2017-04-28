import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.opengl.Texture;

/**
 * Created by Gaute on 4/23/2017.
 */

// Structure for the first world/map
public class World extends Scene {

    private Shape levelBase, baseR, baseL;
    private Shape platform1, platform2, platform3, platform4, platform5, platform6, platform7, platform8;

    Image background;
    Image groundTexture;

    public World() {
        super();
        setPriority(2);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.clear();
        graphics.drawImage(background, 0, 0);
        graphics.setColor(Color.white);

        // Base of level
        graphics.draw(levelBase);
        graphics.texture(levelBase,groundTexture,0,10);
        graphics.draw(baseR);
        graphics.fill(baseR);
        graphics.draw(baseL);
        graphics.fill(baseL);

        // Platforms
        graphics.draw(platform1);
        graphics.texture(platform1,groundTexture,0,10);

        //graphics.fill(platform1);
        graphics.draw(platform2);
        graphics.texture(platform2,groundTexture,0,10);
        graphics.draw(platform3);
        graphics.texture(platform3,groundTexture,0,10);
        graphics.draw(platform4);
        graphics.texture(platform4,groundTexture,0,10);
        graphics.draw(platform5);
        graphics.texture(platform5,groundTexture,0,10);
        graphics.draw(platform6);
        graphics.texture(platform6,groundTexture,0,10);
        graphics.draw(platform7);
        graphics.texture(platform7,groundTexture,0,1);
        graphics.draw(platform8);
        graphics.texture(platform8,groundTexture,0,10);
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

    }

    public void init(GameContainer gameContainer) throws SlickException {

        levelBase = new Rectangle(0,680,1024,100);
        baseR = new Rectangle(0 - 100,-500,100,2560);
        baseL = new Rectangle(1024,-500,100,2560);

        // Platforms
        platform1 = new Rectangle(0, 580, 100, 50);
        platform2 = new Rectangle(1024 - 100, 580, 100, 50);
        platform3 = new Rectangle(1024/2 - 250, 500, 500, 50);

        platform4 = new Rectangle((1024/2) - 224, 350, 120, 50);
        platform5 = new Rectangle(600, 350, 120, 50);

        platform6 = new Rectangle(0,220,200,50);
        platform7 = new Rectangle(1024-200,240,200,50);
        platform8 = new Rectangle(1024/2 - 250,100,500,40);

        background = new Image("sprites/world1Bg.png");
        groundTexture = new Image("sprites/world1Texture.png");
    }

    public boolean collidesWith(Shape s)
    {
        return levelBase.intersects(s) ||
                baseR.intersects(s) ||
                baseL.intersects(s) ||
                platform1.intersects(s) ||
                platform2.intersects(s) ||
                platform3.intersects(s) ||
                platform4.intersects(s) ||
                platform5.intersects(s) ||
                platform6.intersects(s) ||
                platform7.intersects(s) ||
                platform8.intersects(s);
    }

    public String toString()
    {
        return "Sence3";
    }
}


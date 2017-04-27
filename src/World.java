import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Gaute on 4/23/2017.
 */

// Structure for the first world/map
public class World extends Scene {

    private Shape levelBase, baseR, baseL;
    private Shape platform1, platform2, platform3, platform4, platform5, platform6, platform7, platform8;

    public World() {
        super();
        setPriority(2);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.clear();
        graphics.setColor(Color.white);

        // Base of level
        graphics.draw(levelBase);
        graphics.fill(levelBase);
        graphics.draw(baseR);
        graphics.fill(baseR);
        graphics.draw(baseL);
        graphics.fill(baseL);

        // Platforms
        graphics.draw(platform1);
        graphics.fill(platform1);
        graphics.draw(platform2);
        graphics.fill(platform2);
        graphics.draw(platform3);
        graphics.fill(platform3);
        graphics.draw(platform4);
        graphics.fill(platform4);
        graphics.draw(platform5);
        graphics.fill(platform5);
        graphics.draw(platform6);
        graphics.fill(platform6);
        graphics.draw(platform7);
        graphics.fill(platform7);
        graphics.draw(platform8);
        graphics.fill(platform8);
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

    }

    public void init(GameContainer gameContainer) throws SlickException {

        levelBase = new Rectangle(0,680,1024,100);
        baseR = new Rectangle(0 - 100,0,100,2560);
        baseL = new Rectangle(1024,0,100,2560);

        // Platforms
        platform1 = new Rectangle(0, 580, 100, 50);
        platform2 = new Rectangle(1024 - 100, 580, 100, 50);
        platform3 = new Rectangle(1024/2 - 250, 500, 500, 50);

        platform4 = new Rectangle((1024/2) - 224, 350, 120, 50);
        platform5 = new Rectangle(600, 350, 120, 50);

        platform6 = new Rectangle(0,220,200,50);
        platform7 = new Rectangle(1024-200,240,200,50);
        platform8 = new Rectangle(1024/2 - 250,100,500,40);
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


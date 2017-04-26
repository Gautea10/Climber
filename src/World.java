import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;

/**
 * Created by Gaute on 4/23/2017.
 */

// Structure for the first world/map
public class World extends Scene {

    int speed = 12;

    private Shape /*platform,*/ levelBase, baseR, baseL;
    private Platform platform;
    private Platform platform1;
    private Platform platform2;


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
        platform.render(gameContainer, graphics);
        platform1.render(gameContainer, graphics);
        platform2.render(gameContainer, graphics);
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

    }

    public void init(GameContainer gameContainer) throws SlickException {

        levelBase = new Rectangle(0,680,1024,100);
        baseR = new Rectangle(0 - 100,0,100,2560);
        baseL = new Rectangle(1024,0,100,2560);

        platform = new Platform(400,500,100,50);
        platform1 = new Platform(600,300,100,50);
        platform2 = new Platform(200,100,100,50);

        platform.init(gameContainer);
        platform1.init(gameContainer);
        platform2.init(gameContainer);
    }

    public boolean collidesWith(Shape s)
    {
        return levelBase.intersects(s) ||
                baseR.intersects(s) ||
                baseL.intersects(s);
    }

    public String toString()
    {
        return "Sence3";
    }
}


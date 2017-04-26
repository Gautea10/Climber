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


    public World() {
        super();
        setPriority(2);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.clear();

        graphics.setColor(Color.white);

        graphics.draw(levelBase);
        graphics.fill(levelBase);

        graphics.draw(baseR);
        graphics.fill(baseR);
        graphics.draw(baseL);
        graphics.fill(baseL);

    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

    }

    public void init(GameContainer gc) throws SlickException {

        levelBase = new Rectangle(0,680,1024,100);
        baseR = new Rectangle(0 - 100,0,100,2560);
        baseL = new Rectangle(1024,0,100,2560);
        
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


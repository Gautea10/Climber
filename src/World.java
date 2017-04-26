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

    Player player;

    Image ground;

    int cameraX = 0;
    int cameraY = 0;
    int cameraXinit = 0;
    int CameraYinit;


    ArrayList<Shape> base;

    int speed = 12;

    private Shape /*platform,*/ levelBase, baseR, baseL;

    int platPosX = 900;
    int platPosY = 600;
    int platSizeX = 100;
    int getPlatSizeY = 50;

    public World() {
        super();
        setPriority(2);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.clear();

        graphics.setColor(Color.white);

        /*
        for (int i = 0; i < 11; i++) {
            graphics.draw(base.get(i));
            graphics.texture(levelBase, ground);
        }*/

        graphics.draw(levelBase);
        graphics.fill(levelBase);

        graphics.draw(baseR);
        graphics.fill(baseR);
        graphics.draw(baseL);
        graphics.fill(baseL);

        /*
        graphics.draw(platform);
        graphics.texture(platform, ground, platform.getCenterX(),platform.getCenterY());*/

    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

        /*
        Input input = gameContainer.getInput();

        if (input.isKeyDown(Input.KEY_D)) {
            cameraX += speed;
        }
        else if (input.isKeyDown(Input.KEY_A)) {
            cameraX -= speed;
        }

        if (t == 0) {
            Game.manager.addSence(new Enemy());
            t++;
        }*/
    }

    public void init(GameContainer gc) throws SlickException {
        /*
        float[] polygonPoints = new float[]
                {
                        0,0,
                        50,0,
                        50,550,
                        750,550,
                        750,350,
                        600,350,
                        600,300,
                        750,300,
                        750,0,
                        800,0,
                        800,600,
                        0,600};*/

        levelBase = new Rectangle(0,680,1024,100);
        baseR = new Rectangle(0 - 100,0,100,2560);
        baseL = new Rectangle(1024,0,100,2560);

        //platform = new Rectangle(platPosX,platPosY,100,50);
        ground = new Image("sprites/ground.png");

        //base = new ArrayList<Shape>();

    }

    public boolean collidesWith(Shape s)
    {
        return levelBase.intersects(s) ||
                baseR.intersects(s) ||
                baseL.intersects(s);

        //return platform.intersects(s);
    }

    public String toString()
    {
        return "Sence3";
    }
}


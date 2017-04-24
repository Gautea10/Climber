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
    int t = 0;

    int cameraX = 0;
    int cameraY = 0;
    int cameraXinit = 0;
    int CameraYinit;

    /*
    ArrayList<Image> map;
    ArrayList<Shape> hitbox;*/

    int speed = 12;

    private Shape platform, levelBase;

    int platPosX = 0;
    int platPosY = 668;

    public World() {
        super();
        setPriority(2);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.clear();
        graphics.setColor(Color.green);
        graphics.draw(levelBase);
        graphics.draw(platform);

        /*
        int groundPos = 0;
        for (int i = 0; i < 50; i++) {
            map.get(i).draw(groundPos, 668);
            groundPos += 100;
        }*/
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
        float[] polygonPoints = new float[]
                {0,0,
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
                        0,600};

        levelBase = new Polygon(polygonPoints);
        platform = new Rectangle(500,400,100,50);

        /*
        ground = new Image("sprites/ground.png");

        map = new ArrayList<Image>();
        for (int i = 0; i < 50; i++) {
            map.add(i, ground);
        }*/
    }

    public boolean collidesWith(Shape s)
    {
        return levelBase.intersects(s) || platform.intersects(s);
        //return platform.intersects(s);
    }

    public String toString()
    {
        return "Sence3";
    }
}


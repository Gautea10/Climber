import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;



public class Enemy extends Scene  {


    private Animation sprite;
    private static float speed = 2;
    public float yEnemy = 10;
    public float xEnemy = 5;
    private static float gravity = 0.5f;
    public Shape Enemyhitbox;
    private World world;



    public Enemy(World world) {
        super();
        setPriority(6);
        System.out.println("Enemy Ran");
        this.world = world;

    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {

        graphics.setColor(Color.red);
        graphics.draw(Enemyhitbox);
        graphics.setColor(Color.white);
        sprite.draw(Enemyhitbox.getX(), Enemyhitbox.getY());

    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {
        yEnemy += gravity;


        // Collision in Y
        Enemyhitbox.setY(Enemyhitbox.getY() + yEnemy);

        if(world.collidesWith(Enemyhitbox)) {
            Enemyhitbox.setY (Enemyhitbox.getY() - yEnemy);
            yEnemy = 0;
        }

        // Collision X
        Enemyhitbox.setX (Enemyhitbox.getX() + xEnemy);

        if (world.collidesWith(Enemyhitbox)) {
            Enemyhitbox.setX(Enemyhitbox.getX() - xEnemy);
            xEnemy = 0;
        }
    }

    public void init(GameContainer gc) throws SlickException {
        Image[] Ghost = {
                new Image("sprites/ghost.png"),
                new Image("sprites/ghost2.png"),
                new Image("sprites/ghost3.png"),
                new Image("sprites/ghost4.png")
        };

        int sprspeed = 63;

        int[] duration = {sprspeed, sprspeed, sprspeed, sprspeed};
        sprite = new Animation(Ghost, duration, true);

        Enemyhitbox = new Rectangle(xEnemy, yEnemy,40, 80);
    }


    public String toString() {
        return "Sence4";
    }






}

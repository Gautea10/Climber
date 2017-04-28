import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class EnemyElf extends Scene  {
    private Animation sprite;
    private float yEnemy = 0;
    private float xEnemy = 0;
    private static float gravity = 0.02f;
    public Shape Enemyhitbox;
    private World2 world2;

    public EnemyElf(World2 world2) {
            super();
            setPriority(5);
            System.out.println("EnemyElf Ran");
            this.world2 = world2;
            }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
            {

            graphics.setColor(Color.red);
            graphics.setColor(Color.white);
            sprite.draw(Enemyhitbox.getX(), Enemyhitbox.getY());

            }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

        yEnemy += gravity;

        // Collision in Y
        Enemyhitbox.setY(Enemyhitbox.getY() + yEnemy);

        if (world2.collidesWithWorld2(Enemyhitbox)) {
            Enemyhitbox.setY(Enemyhitbox.getY() - yEnemy);
            yEnemy = 0;
        }

        // Collision X
        Enemyhitbox.setX(Enemyhitbox.getX() + xEnemy);

        if (world2.collidesWithWorld2(Enemyhitbox)) {
            Enemyhitbox.setX(Enemyhitbox.getX() - xEnemy);
            xEnemy = 0;
        }
    }

    public void init(GameContainer gc) throws SlickException {
            Image[] elf = {
                    new Image("sprites/elfidle.png"),
                    new Image("sprites/elfidle.png")
            };

            int sprspeed = 63;

            int[] duration = {sprspeed, sprspeed};

            sprite = new Animation(elf, duration, true);

            Enemyhitbox = new Rectangle(xEnemy, yEnemy,40, 80);
            }


    public String toString() {
            return "Sence5";
    }
}

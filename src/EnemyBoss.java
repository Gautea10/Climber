import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Created by HEH on 28.04.2017.
 */
public class EnemyBoss extends Scene {

    private Animation sprite;
    private float yEnemy = 0;
    private float xEnemy = 0;
    private static float gravity = 0.02f;
    public Shape Enemyhitbox;
    private World3 world3;
    public int lives = 5;

    public EnemyBoss(World3 world3) {
        super();
        setPriority(5);
        System.out.println("EnemyElf Ran");
        this.world3 = world3;
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

        if (world3.collidesWithWorld3(Enemyhitbox)) {
            Enemyhitbox.setY(Enemyhitbox.getY() - yEnemy);
            yEnemy = 0;
        }

        // Collision X
        Enemyhitbox.setX(Enemyhitbox.getX() + xEnemy);

        if (world3.collidesWithWorld3(Enemyhitbox)) {
            Enemyhitbox.setX(Enemyhitbox.getX() - xEnemy);
            xEnemy = 0;
        }
    }

    public void init(GameContainer gc) throws SlickException {
        Image[] Boss = {
                new Image("sprites/bossLeft1.png"),
                new Image("sprites/bossLeft2.png"),
                new Image("sprites/bossLeft3.png"),
                new Image("sprites/bossLeft4.png")
        };

        // Image[] BossLeft = {
        //       new Image("sprites/bossRight1.png"),
        //        new Image("sprites/bossRight2.png"),
        //        new Image("sprites/bossRight3.png"),
        //        new Image("sprites/bossRight4.png")
        // };

        int sprspeed = 150;

        int[] duration = {sprspeed, sprspeed, sprspeed, sprspeed};

        sprite = new Animation(Boss, duration, true);

        Enemyhitbox = new Rectangle(xEnemy, yEnemy, 119 ,95);
    }


    public String toString() {
        return "Sence5";
    }
}

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import sun.security.provider.SHA;


public class EnemyBoss extends Scene {

    private Animation sprite, right, left;
    private float yEnemy = 0;
    private float xEnemy = 0;
    public Shape Enemyhitbox;
    private World3 world3;
    public int lives = 20;

    public EnemyBoss(World3 world3) {
        super();
        setPriority(5);
        System.out.println("EnemyBoss Ran");
        this.world3 = world3;
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        sprite.draw(Enemyhitbox.getX(), Enemyhitbox.getY());
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

        if(Enemyhitbox.getX() <= (1024/2) - (119/2)) {
            sprite = left;
        } else if (Enemyhitbox.getX() > (1024/2) - (119/2)) {
            sprite = right;
        }
    }

    public void init(GameContainer gc) throws SlickException {
        Image[] BossLeft = {
                new Image("sprites/bossLeft1.png"),
                new Image("sprites/bossLeft2.png"),
                new Image("sprites/bossLeft3.png"),
                new Image("sprites/bossLeft4.png")
        };

        Image[] Boss = {
                new Image("sprites/bossRight1.png"),
                new Image("sprites/bossRight2.png"),
                new Image("sprites/bossRight3.png"),
                new Image("sprites/bossRight4.png")
        };


        int sprspeed = 150;

        int[] duration = {sprspeed, sprspeed, sprspeed, sprspeed};

        right = new Animation(Boss, duration, true);
        left = new Animation(BossLeft, duration, true);
        sprite =  right;

        Enemyhitbox = new Rectangle(xEnemy, yEnemy, 119 ,95);
    }

    //Method that moves the boss after the target
    public Shape followPlayer(Shape targetHitbox, Shape selfHitbox) {
        int step = 1;

        float a = targetHitbox.getX() - selfHitbox.getX();
        float b = targetHitbox.getY() - selfHitbox.getY();
        double h = (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        selfHitbox.setX(selfHitbox.getX() + (float)(a / h * step));
        selfHitbox.setY(selfHitbox.getY() + (float)(b / h * step));

        return selfHitbox;
    }

    public String toString() {
        return "Sence5";
    }
}

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


/**
 * Created by Gaute on 4/23/2017.
 */

// Structure for the Player, creates the player then skips to World
public class Player extends Scene {

    private static float gravity = 0.5f;
    public static float jumpStrength = -13;
    private static float speed = 12;

    //private Animation player;
    public Shape playerHitbox, slashHitboxR, slashHitboxL;

    int LorR = 0;

    private Animation sprite, idle, idle2, right, left, slashR, slashSpriteR, slashL, slashSpriteL;
    public float xPlayer = 1024 / 2;
    public float yPlayer = 388;

    public Player() {
        super();
        setPriority(5);
        System.out.println("Player Ran");
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        // Player
        sprite.draw(playerHitbox.getX(), playerHitbox.getY());
        slashSpriteR.draw(playerHitbox.getX() - 5, playerHitbox.getY());
        slashSpriteL.draw(playerHitbox.getX() - 40, playerHitbox.getY());

        graphics.setColor(Color.red);
        graphics.draw(playerHitbox);

        graphics.setColor(Color.green);
        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && LorR == 0) {
            graphics.draw(slashHitboxR);
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && LorR == 1) {
            graphics.draw(slashHitboxL);
        }
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException
    {
        yPlayer += gravity;

        // Collision in Y
        playerHitbox.setY(playerHitbox.getY() + yPlayer);
        slashHitboxR.setY(slashHitboxR.getY() + yPlayer);
        slashSpriteR.setCurrentFrame(0);
        slashHitboxL.setY(slashHitboxL.getY() + yPlayer);
        slashSpriteL.setCurrentFrame(0);

        // X acceleration
        if( gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            xPlayer = speed;
            sprite = right;
            LorR = 0;
        }
        else if( gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            xPlayer = -speed;
            sprite = left;
            LorR = 1;
        }
        else if(LorR == 0)
        {
            xPlayer = 0;
            sprite = idle;
        }

        else if (LorR == 1)
        {
            xPlayer = 0;
            sprite = idle2;
        }

        // Pickaxe slash
        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && LorR == 0) {
            slashSpriteR.setCurrentFrame(1);
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && LorR == 1) {
            slashSpriteL.setCurrentFrame(1);
        }
    }

    public void init(GameContainer gc) throws SlickException
    {

        Image[] movementIdle = {
                new Image("sprites/character_idle1.png"),
                new Image("sprites/character_idle2.png"),
                new Image("sprites/character_idle3.png"),
                new Image("sprites/character_idle4.png"),
                new Image("sprites/character_idle5.png")
        };

        Image[] movementIdleL = {
                new Image("sprites/character_idle1_L.png"),
                new Image("sprites/character_idle2_L.png"),
                new Image("sprites/character_idle3_L.png"),
                new Image("sprites/character_idle4_L.png"),
                new Image("sprites/character_idle5_L.png")
        };

        Image [] movementRight = {
                new Image("sprites/character_run1_R.png"),
                new Image("sprites/character_run2_R.png"),
                new Image("sprites/character_run3_R.png"),
                new Image("sprites/character_run4_R.png"),
                new Image("sprites/character_run5_R.png"),
                new Image("sprites/character_run6_R.png"),
                new Image("sprites/character_run7_R.png"),
                new Image("sprites/character_run8_R.png")
        };

        Image [] movementLeft = {
                new Image("sprites/character_run1_L.png"),
                new Image("sprites/character_run2_L.png"),
                new Image("sprites/character_run3_L.png"),
                new Image("sprites/character_run4_L.png"),
                new Image("sprites/character_run5_L.png"),
                new Image("sprites/character_run6_L.png"),
                new Image("sprites/character_run7_L.png"),
                new Image("sprites/character_run8_L.png")
        };

        Image [] pickAxeSlashR = {
                new Image("sprites/slash.png"),
                new Image("sprites/slash1.png")
        };
        Image [] pickAxeSlashL = {
                new Image("sprites/slash.png"),
                new Image("sprites/slash2.png")
        };

        int aniSpeed1 = 150;
        int aniSpeed2 = 65;
        int aniSpeed3 = 500;

        int [] duration = {aniSpeed1, aniSpeed1, aniSpeed1, aniSpeed1, aniSpeed1};
        int [] duration2 = {aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2};
        int [] duration3 = {aniSpeed3, aniSpeed3};

        // Player sprite
        idle = new Animation(movementIdle, duration, true);
        idle2 = new Animation(movementIdleL, duration, true);
        right = new Animation(movementRight, duration2, true);
        left = new Animation(movementLeft, duration2, true);
        sprite = idle;

        playerHitbox  = new Rectangle(xPlayer-20,yPlayer,40,80);
        System.out.println(yPlayer);

        // Attack sprite
        slashR = new Animation(pickAxeSlashR, duration3, false);
        slashL = new Animation(pickAxeSlashL, duration3, false);

        slashSpriteR = slashR;
        slashSpriteL = slashL;
        slashHitboxR = new Rectangle(xPlayer, yPlayer ,70,80);
        slashHitboxL = new Rectangle(xPlayer - 60, yPlayer,70,80);

    }

    public String toString(World world)
    {
        return "Sence2";
    }
}

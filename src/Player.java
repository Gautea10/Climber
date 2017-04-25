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
    private static float jumpStrength = -15;
    private static float speed = 12;

    //private Animation player;
    private Shape playerHitboxR;
    private Shape playerHitboxL;
    private Shape slashHitboxR;
    private Shape slashHitboxL;
    private World world;

    int LorR = 0;

    private Animation sprite, idle, idle2, right, left, slashR, slashSpriteR, slashL, slashSpriteL, jumpR, jumpL;
    private float xPlayer = 200;
    private float yPlayer = 100;

    public Player(World world) {
        super();
        setPriority(3);
        this.world = world;
        System.out.println("Player Ran");
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        sprite.draw(playerHitboxR.getX(), playerHitboxR.getY());
        slashSpriteR.draw(playerHitboxR.getX(), playerHitboxR.getY());
        slashSpriteL.draw(playerHitboxR.getX() - 15, playerHitboxR.getY());

        graphics.setColor(Color.red);
        if (LorR == 0) {
            graphics.draw(playerHitboxR);
        }

        if (LorR == 1) {
            graphics.draw(playerHitboxL);
        }

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
        playerHitboxR.setY(playerHitboxR.getY() + yPlayer);
        playerHitboxL.setY(playerHitboxL.getY() + yPlayer);

        slashHitboxR.setY(slashHitboxR.getY() + yPlayer);
        slashSpriteR.setCurrentFrame(0);

        slashHitboxL.setY(slashHitboxL.getY() + yPlayer);
        slashSpriteL.setCurrentFrame(0);

        if( world.collidesWith(playerHitboxR) || world.collidesWith(playerHitboxL)) {
            playerHitboxR.setY( playerHitboxR.getY() - yPlayer );
            playerHitboxL.setY( playerHitboxL.getY() - yPlayer );
            slashHitboxR.setY( slashHitboxR.getY() - yPlayer );
            slashHitboxL.setY( slashHitboxL.getY() - yPlayer );
            yPlayer = 0;
        }

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

        // Jump
        if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            playerHitboxR.setY(playerHitboxR.getY()+0.1f);
            playerHitboxL.setY(playerHitboxL.getY()+0.1f);
            slashHitboxR.setY(slashHitboxR.getY()+0.1f);
            slashHitboxL.setY(slashHitboxL.getY()+0.1f);

            if(world.collidesWith(playerHitboxR)) {
                yPlayer = jumpStrength;
            }
        }

        // Collision
        playerHitboxR.setX( playerHitboxR.getX() + xPlayer );
        playerHitboxL.setX( playerHitboxL.getX() + xPlayer );
        slashHitboxR.setX( slashHitboxR.getX() + xPlayer );
        slashHitboxL.setX( slashHitboxL.getX() + xPlayer );

        if(world.collidesWith(playerHitboxR) || world.collidesWith(playerHitboxL)) {
            playerHitboxR.setX( playerHitboxR.getX() - xPlayer );
            playerHitboxL.setX( playerHitboxL.getX() - xPlayer );
            slashHitboxR.setX( slashHitboxR.getX() - xPlayer );
            slashHitboxL.setX( slashHitboxL.getX() - xPlayer );
            xPlayer = 0;
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

        /*
        Image [] jumpRight = {
                new Image("sprites/character_run2_R.png"),
                new Image("sprites/character_run2_R.png")
        };

         Image [] jumpLeft = {
                new Image("sprites/character_run2_L.png"),
                new Image("sprites/character_run2_L.png")
        };*/

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

        idle = new Animation(movementIdle, duration, true);
        idle2 = new Animation(movementIdleL, duration, true);
        right = new Animation(movementRight, duration2, true);
        left = new Animation(movementLeft, duration2, true);
        slashR = new Animation(pickAxeSlashR, duration3, false);
        slashL = new Animation(pickAxeSlashL, duration3, false);

        /*
        jumpR = new Animation(jumpRight, duration3, false);
        jumpL = new Animation(jumpLeft, duration3, false);*/

        sprite = idle;
        slashSpriteR = slashR;
        slashSpriteL = slashL;
        playerHitboxR  = new Rectangle(xPlayer,yPlayer,60,80);
        playerHitboxL  = new Rectangle(xPlayer + 20,yPlayer,60,80);
        slashHitboxR = new Rectangle(xPlayer + 25, yPlayer ,70,80);
        slashHitboxL = new Rectangle(xPlayer - 15, yPlayer,70,80);
    }

    public String toString(World world)
    {
        return "Sence2";
    }
}

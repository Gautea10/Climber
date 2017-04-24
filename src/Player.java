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
    private Shape player;
    private World world;

    int LorR = 0;

    //private Animation sprite, idle, idle2, right, left, jumpR, jumpL;
    private float xPlayer = 0;
    private float yPlayer = 0;

    public Player(World world) {
        super();
        setPriority(3);
        this.world = world;
        System.out.println("Player Ran");
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        //player.draw(xPlayer,yPlayer);
        graphics.setColor(Color.red);
        graphics.draw(player);
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException
    {
        yPlayer += gravity;

        // Collision in Y
        player.setY(player.getY() + yPlayer);

        if( world.collidesWith(player)) {
            player.setY( player.getY() - yPlayer );
            yPlayer = 0;
        }

        // X acceleration
        if( gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            xPlayer = speed;
            LorR = 0;
        }
        else if( gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            xPlayer = -speed;
            LorR = 1;
        }
        else
        {
            xPlayer = 0;
        }

        // Jump
        if (gameContainer.getInput().isKeyDown(Input.KEY_W) && LorR == 0) {
            player.setY(player.getY()+0.1f);

            if(world.collidesWith(player)) {
                //player = jumpR;
                yPlayer = jumpStrength;
            }
        }
        else if(gameContainer.getInput().isKeyDown(Input.KEY_W) && LorR == 1) {
            player.setY(player.getY()+0.1f);

            if(world.collidesWith(player)) {
                //player = jumpL;
                yPlayer = jumpStrength;
            }
        }

        // Collision
        player.setX( player.getX() + xPlayer );
        if( world.collidesWith(player) )
        {
            player.setX( player.getX() - xPlayer );
            xPlayer = 0;
        }
    }

    public void init(GameContainer gc) throws SlickException
    {
        /*
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

        Image [] jumpRight = {
                new Image("sprites/character_run2_R.png"),
                new Image("sprites/character_run2_R.png")
        };

         Image [] jumpLeft = {
                new Image("sprites/character_run2_L.png"),
                new Image("sprites/character_run2_L.png")
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
        jumpR = new Animation(jumpRight, duration3, false);
        jumpL = new Animation(jumpLeft, duration3, false);*/

        //player = idle;
        player  = new Rectangle(200,200,49,49);
    }

    public String toString(World world)
    {
        return "Sence2";
    }
}

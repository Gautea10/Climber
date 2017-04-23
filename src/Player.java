import org.newdawn.slick.*;

/**
 * Created by Gaute on 4/23/2017.
 */

// Structure for the Player, creates the player then skips to World
public class Player extends Scene {

    int t = 0;

    private Animation sprite, idle, right, left;
    private float xPlayer,yPlayer = 590;
    private float speed = 12;

    public Player() {
        super();
        setPriority(2);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        sprite.draw(xPlayer,yPlayer);
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException
    {
        Input input = gameContainer.getInput();

        //Character
        if (input.isKeyDown(Input.KEY_D)) {
            xPlayer += speed;
            sprite = right;
        }
        else if (input.isKeyDown(Input.KEY_A)) {
            xPlayer -= speed;
            sprite = left;
        } else {
            sprite = idle;
        }

        // Creates the world once
        if (t == 0) {
            Game.manager.addSence(new World());
            t++;
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

        int aniSpeed1 = 150;
        int aniSpeed2 = 65;

        int [] duration = {aniSpeed1, aniSpeed1, aniSpeed1, aniSpeed1, aniSpeed1};
        int [] duration2 = {aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2, aniSpeed2};

        idle = new Animation(movementIdle, duration, true);
        right = new Animation(movementRight, duration2, true);
        left = new Animation(movementLeft, duration2, true);

        sprite = idle;
    }

    public String toString()
    {
        return "Sence2";
    }
}

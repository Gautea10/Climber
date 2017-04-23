import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Gaute on 4/23/2017.
 */

public class Player {
    private Animation sprite, idle, right, left;
    private float xPlayer,yPlayer;
    private float speed = 12;


    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
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

    public void render() throws SlickException {
        yPlayer = 590;
        sprite.draw(xPlayer,yPlayer);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
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

        // Find a way to check if player ran to the right or left, to pick direction the idle animation is supposed to be.
    }
}

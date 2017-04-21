import javafx.scene.layout.Background;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Climber extends BasicGameState {
    Image ground;
    Image bckgrnd;

    private Animation sprite, idle, right, left;
    private float x,y;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        ground = new Image("sprites/ground.png");

        Image [] movementIdle = {
                new Image("sprites/character_idle1.png"),
                new Image("sprites/character_idle2.png"),
                new Image("sprites/character_idle3.png"),
                new Image("sprites/character_idle4.png"),
                new Image("sprites/character_idle5.png")
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

        int [] duration = {150, 150, 150, 150, 150};
        int [] duration2 = {150, 150, 150, 150, 150, 150, 150, 150};

        idle = new Animation(movementIdle, duration, true);
        left = new Animation(movementLeft, duration2, false);
        right = new Animation(movementRight, duration2, false);

        sprite = idle;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        int posX = 0;

        for (int i = 0; i < 11; i++) {
            ground.draw(posX,668);
            posX += 100;
        }

        y = 590;
        sprite.draw(x,y);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();

        if (input.isKeyDown(Input.KEY_D)) {
            System.out.println("Key pressed");
            x += 10;
        }
        else if (input.isKeyDown(Input.KEY_A)) {
            x -= 10;
        }
    }
}

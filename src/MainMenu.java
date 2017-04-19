import javafx.scene.layout.Background;
import org.newdawn.slick.*;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Gaute on 4/19/2017.
 */
public class MainMenu extends BasicGameState {

    Image startBtn;
    Image bckgrnd;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        startBtn = new Image("sprites/startBtn.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        startBtn.draw();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
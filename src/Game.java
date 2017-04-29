import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

// Implements the SceneManager to the project, and skips to MainMenu
public class Game extends BasicGame{

    public static SceneManager manager;

    public Game() {
        super("Climber");
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        manager.update(gameContainer, i);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        manager.render(gameContainer, graphics);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        System.out.println("Game Ran");
        manager = new SceneManager(gameContainer);
        manager.addSence(new MainMenu());
    }
}

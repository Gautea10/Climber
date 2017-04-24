import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Created by Gaute on 4/24/2017.
 */
public class Boot extends Scene {

    private World world;
    private Player player;

    public Boot() {
        super();
        setPriority(1);
        System.out.println("Boot Ran");
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        world.update(gameContainer, i);
        player.update(gameContainer, i);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        world.render(gameContainer, graphics);
        player.render(gameContainer, graphics);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        // Creates world and player
        world = new World();
        world.init(gameContainer);

        player = new Player( world );
        player.init(gameContainer);
    }

    public String toString()
    {
        return "Sence1";
    }
}

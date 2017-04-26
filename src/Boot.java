import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;

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
    public void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {
        world.update(gameContainer, i);
        player.update(gameContainer, i);
    }

    @Override
    public void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException {

        world.render(gameContainer, graphics);
        player.render(gameContainer, graphics);

        changeBackground(graphics);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        // Creates world and player
        world = new World();
        world.init(gameContainer);

        player = new Player( world );
        player.init(gameContainer);
    }

    public void changeBackground(Graphics graphics) throws SlickException{
        graphics.setBackground(new org.newdawn.slick.Color(125, 125, 125));
    }

    public String toString()
    {
        return "Sence1";
    }
}

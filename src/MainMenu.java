import org.newdawn.slick.*;
import org.newdawn.slick.state.GameState;

import java.awt.*;
import java.awt.Color;

/**
 * Created by Gaute on 4/23/2017.
 */
public class MainMenu extends Scene {
    public MainMenu() {
        super();
        setPriority(1);
    }

    protected void CustomRender(GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws SlickException
    {
        // Render a static red box
        graphics.setColor(org.newdawn.slick.Color.red);
        graphics.fillRect(100, 100, 200, 200);
    }

    protected void CustomUpdate (GameContainer gameContainer, int i) throws SlickException {


        //if Space is pressed
        if (gameContainer.getInput().isKeyPressed(Input.KEY_SPACE)) {
            // Add a new Sence2 instance to the SenceManager
            Game.manager.addSence(new Player());
        }
    }

    public void init (GameContainer gameContainer) throws SlickException {

    }

    public String toString()
    {
        return "Sence1";
    }
}

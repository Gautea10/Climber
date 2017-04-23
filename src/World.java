import org.newdawn.slick.*;

/**
 * Created by Gaute on 4/23/2017.
 */

// Structure for the first world/map
public class World extends Scene {

    Image ground;

    public World() {
        super();
        setPriority(3);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        int posX = 0;

        for (int i = 0; i < 11; i++) {
            ground.draw(posX,668);
            posX += 100;
        }
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException
    {

    }

    public void init(GameContainer gc) throws SlickException
    {
        ground = new Image("sprites/ground.png");

    }

    public String toString()
    {
        return "Sence2";
    }
}


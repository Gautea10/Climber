import org.newdawn.slick.*;

/**
 * Created by Gaute on 4/24/2017.
 */
public class Enemy extends Scene {
    public Enemy() {
        super();
        setPriority(4);
        System.out.println("Enemy kjørte");
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {

    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException
    {

    }

    public void init(GameContainer gc) throws SlickException
    {

    }

    public String toString()
    {
        return "Sence4";
    }
}

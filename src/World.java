import javafx.scene.Camera;
import org.newdawn.slick.*;

import java.util.ArrayList;

/**
 * Created by Gaute on 4/23/2017.
 */

// Structure for the first world/map
public class World extends Scene {

    Image ground;
    int t = 0;

    ArrayList<Image> map;

    public World() {
        super();
        setPriority(3);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        int groundPos = 0;
        for (int i = 0; i < 50; i++) {
            map.get(i).draw(groundPos, 668);
            groundPos += 100;
        }
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

        if (t == 0) {
            Game.manager.addSence(new Enemy());
            t++;
        }
    }

    public void init(GameContainer gc) throws SlickException
    {
        ground = new Image("sprites/ground.png");

        map = new ArrayList<Image>();
        for (int i = 0; i < 50; i++) {
            map.add(i, ground);
        }
    }

    public String toString()
    {
        return "Sence3";
    }
}


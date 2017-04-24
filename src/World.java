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

    int cameraX = 0;
    int cameraY = 0;
    int cameraXinit = 0;
    int CameraYinit;

    ArrayList<Image> map;

    int speed = 12;

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
        Input input = gameContainer.getInput();

        if (input.isKeyDown(Input.KEY_D)) {
            cameraX += speed;
        }
        else if (input.isKeyDown(Input.KEY_A)) {
            cameraX -= speed;
        }

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
        return "Sence2";
    }
}


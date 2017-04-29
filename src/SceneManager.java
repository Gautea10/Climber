import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


// Keeps control over what java files is playing
public class SceneManager {
    private List<Scene> sences;

    private GameContainer gc;

    public SceneManager (GameContainer gc) {
        this.gc = gc;
        sences = new ArrayList<Scene>();
    }

    // Add a scene to the list and call the init method
    public void addSence (MainMenu sence ) {
        sences.add(sence);

        try {
            sence.init(gc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(sences);
    }

    public void addSence(Boot sence) {
        sences.add(sence);

        try {
            sence.init(gc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(sences);
    }

    // Render all scenes
    public void render(GameContainer gc, Graphics g) throws SlickException {
        for( int i = 0 ; i < sences.size() ; i++ )
        {
            sences.get(i).render(gc, g);
        }
    }

    // Update all scenes
    public void update(GameContainer gc, int t) throws SlickException {
        for( int i = 0 ; i < sences.size() ; i++ )
        {
            sences.get(i).update(gc,t);
        }
    }

    // Clear the list
    public void clear ()
    {
        sences = new ArrayList<Scene>();
    }

}

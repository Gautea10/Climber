import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;

/**
 * Created by Gaute on 4/19/2017.
 */
public class Main {

    private static String gameName = "Climber";
    public static int gameWidth = 1024;
    public static int gameHeight = 768;
    public static int climberID = 0;
    public static int mainMenuID = 0;

    public Main(String gameName){
        super();
        new Game();
    }

    public static void main(String[] args) {

        try {
            AppGameContainer app = new AppGameContainer( new Game() );
            app.setDisplayMode(gameWidth, gameHeight, false);
            app.setTargetFrameRate(60);
            app.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

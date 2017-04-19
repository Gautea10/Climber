import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;
import java.awt.Image;

/**
 * Created by Gaute on 4/19/2017.
 */
public class Main extends StateBasedGame {

    private static String gameName = "Climber";
    public static int gameWidth = 1024;
    public static int gameHeight = 768;
    public static int climberID = 0;
    public static int mainMenuID = 0;

    public Main(String gameName){
        super(gameName);
        this.addState(new MainMenu());
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.getState(mainMenuID).init(gameContainer, this);
        this.enterState(mainMenuID);
    }

    public static void main(String[] args) {
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Main(gameName));
            appgc.setDisplayMode(gameWidth, gameHeight, false);
            appgc.setTargetFrameRate(60);
            appgc.start();
        }
        catch (SlickException e){
            e.printStackTrace();
        }
    }
}

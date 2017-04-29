import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


// The structure for the game's main menu, skips to Player after space/startButton is clicked
public class MainMenu extends Scene {

    Image startBtn;
    int startBtnPosX = 384;
    int startBtnPosY = 200;
    int startBtnWidth = 300;
    int startBtnHeight = 150;

    public static Highscore highscore;

    public MainMenu() {
        super();
        setPriority(1);
    }

    protected void CustomRender(GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws SlickException
    {
        graphics.drawString("Main menu", 490, 100);
        startBtn.draw(startBtnPosX, startBtnPosY, startBtnWidth, startBtnHeight);

        graphics.drawString("Highscore", 100, 100);

        Set set = highscore.sortHighscore().entrySet();
        Iterator i = set.iterator();
        String s = "";

        for (int j = 0; j < set.size(); j++) {
            Map.Entry me = (Map.Entry)i.next();
            s += me.getKey() + ": " + me.getValue() + "\n";
        }
        graphics.drawString(s, 100, 120);

        graphics.drawString("Move: W,A,S,D", 470, 500);
        graphics.drawString("Attack: Space", 470, 520);
    }

    protected void CustomUpdate (GameContainer gameContainer, int i) throws SlickException {

        int posX = gameContainer.getInput().getMouseX();
        int posY = gameContainer.getInput().getMouseY();
        //System.out.println(posX + ", " + posY);

        if ((posX > startBtnPosX && posX < startBtnPosX + startBtnWidth) && (posY > startBtnPosY && posY < startBtnPosY + startBtnHeight)) {
            if (gameContainer.getInput().isMousePressed(0)) {
                Game.manager.addSence(new Boot());
                System.out.println("start");
            }
        }
    }

    public void init (GameContainer gameContainer) throws SlickException {
        startBtn = new Image("sprites/startBtn.png");

        highscore = Highscore.getInstance();
    }

    public String toString()
    {
        return "Sence1";
    }
}

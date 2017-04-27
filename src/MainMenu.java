import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Image;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


// The structure for the game's main menu, skips to Player after space/startButton is clicked
public class MainMenu extends Scene {

    Image startBtn;
    int startBtnPosX = 384;
    int startBtnPosY = 300;

    public static Highscore highscore;

    public MainMenu() {
        super();
        setPriority(1);
    }

    protected void CustomRender(GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws SlickException
    {
        graphics.drawString("Main menu", 500, 100);
        startBtn.draw(startBtnPosX,startBtnPosY,300,150);

        graphics.drawString("Highscore", 100, 100);

        Set set = highscore.sortHighscore().entrySet();
        Iterator i = set.iterator();
        String s = "";

        for (int j = 0; j < set.size(); j++) {
            Map.Entry me = (Map.Entry)i.next();
            s += me.getKey() + ": " + me.getValue() + "\n";
        }
        graphics.drawString(s, 100, 120);
    }

    protected void CustomUpdate (GameContainer gameContainer, int i) throws SlickException {

        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if ((posX > startBtnPosX && posX < 684) && (posY > startBtnPosY && posY < 450)) {
            if (Mouse.isButtonDown(0)) {
                Game.manager.addSence(new Boot());
            }
        }
    }

    public void init (GameContainer gameContainer) throws SlickException {
        startBtn = new Image("sprites/startBtn.png");

        highscore = Highscore.getInstance();

        highscore.addHighscore("name1", 12);
        highscore.addHighscore("name2", 122);
        highscore.addHighscore("name3", 4);
    }

    public String toString()
    {
        return "Sence1";
    }
}

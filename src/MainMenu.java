import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.GameState;

import java.awt.*;
import java.awt.Color;

/**
 * Created by Gaute on 4/23/2017.
 */

// The structure for the game's main menu, skips to Player after space/startButton is clicked
public class MainMenu extends Scene {

    Image startBtn;
    int startBtnPosX = 384;
    int startBtnPosY = 300;

    public MainMenu() {
        super();
        setPriority(1);
    }

    protected void CustomRender(GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws SlickException
    {
        graphics.drawString("Main menu", 500, 100);
        startBtn.draw(startBtnPosX,startBtnPosY,300,150);
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

    }

    public String toString()
    {
        return "Sence1";
    }
}

import org.newdawn.slick.*;
import org.newdawn.slick.Image;


public class MainMenu extends Scene {

    Image startBtn;
    private int startBtnPosX = 384;
    private int startBtnPosY = 250;
    private int startBtnWidth = 300;
    private int startBtnHeight = 150;

    public static Highscore highscore;

    private Image background;

    public MainMenu() {
        super();
        setPriority(1);
    }

    protected void CustomRender(GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws SlickException
    {
        graphics.drawString("Main menu", 490, 100);
        graphics.drawImage(background,0,0);

        startBtn.draw(startBtnPosX, startBtnPosY, startBtnWidth, startBtnHeight);

        graphics.drawString("Highscore", 80, 250);
        graphics.drawString(highscore.returnAsString(), 80, 280);

        graphics.drawString("Move: W,A,S,D", 470, 500);
        graphics.drawString("Attack: Space", 470, 520);
    }

    protected void CustomUpdate (GameContainer gameContainer, int i) throws SlickException {

        int posX = gameContainer.getInput().getMouseX();
        int posY = gameContainer.getInput().getMouseY();

        if ((posX > startBtnPosX && posX < startBtnPosX + startBtnWidth) && (posY > startBtnPosY && posY < startBtnPosY + startBtnHeight)) {
            if (gameContainer.getInput().isMousePressed(0)) {
                Game.manager.addSence(new Boot());
            }
        }
    }

    public void init (GameContainer gameContainer) throws SlickException {
        startBtn = new Image("sprites/startBtn.png");
        background = new Image("sprites/menuBg.png");

        highscore = Highscore.getInstance();
    }

    public String toString()
    {
        return "Sence1";
    }
}

import org.newdawn.slick.*;

public class Finish extends Scene {

    Image background;

    public Finish() {
        super();
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.clear();
        graphics.drawImage(background,0,0);
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

    }

    public void init(GameContainer gameContainer) throws SlickException {
        background = new Image("sprites/youWon.png");
    }
}
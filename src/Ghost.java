import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Gaute on 4/23/2017.
 */
public class Ghost {
    private Animation spriteGhost, ghostIdle;
    private float ghostX,ghostY;

    public int getID() {
        return 0;
    }

    public void setPos(float x, float y) {
        this.ghostX = x;
        this.ghostY = y;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        Image [] ghostAni = {
                new Image("sprites/ghost.png"),
                new Image("sprites/ghost2.png"),
                new Image("sprites/ghost3.png"),
                new Image("sprites/ghost4.png")
        };

        int aniSpeed1 = 150;

        int [] duration = {aniSpeed1, aniSpeed1, aniSpeed1, aniSpeed1};
        ghostIdle = new Animation(ghostAni, duration, true);
        spriteGhost = ghostIdle;
    }

    public void render(GameContainer gameContainer, Graphics graphics)
    {
        spriteGhost.draw(ghostX, ghostY);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}

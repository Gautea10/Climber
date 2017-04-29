import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class Win extends Scene {

    public Shape flagHitbox;
    private Animation flagAni, flag;

    public Win() {
        super();
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException {
        // Flag
        flag.draw(flagHitbox.getX(), flagHitbox.getY());
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

    }

    public void init(GameContainer gameContainer) throws SlickException {
        //Flag
        Image [] flagMovement = {
                new Image("sprites/flag1.png"),
                new Image("sprites/flag2.png"),
                new Image("sprites/flag3.png"),
                new Image("sprites/flag4.png")
        };

        flagAni = new Animation(flagMovement, 400, true);
        flag = flagAni;

        flagHitbox = new Rectangle(1024/2,580,32,100);

        int aniSpeedFlag = 400;
        int [] durationFlag = {aniSpeedFlag, aniSpeedFlag, aniSpeedFlag, aniSpeedFlag};
    }

    // Getters Setters
    public Shape getFlagHitbox() {
        return flagHitbox;
    }

    public void setFlagHitbox(Shape flagHitbox) {
        this.flagHitbox = flagHitbox;
    }

    public Animation getFlagAni() {
        return flagAni;
    }

    public void setFlagAni(Animation flagAni) {
        this.flagAni = flagAni;
    }

    public Animation getFlag() {
        return flag;
    }

    public void setFlag(Animation flag) {
        this.flag = flag;
    }
}
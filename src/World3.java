import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Created by Gaute on 4/27/2017.
 */
public class World3 extends Scene {

    private Shape levelBase, baseR, baseL;
    private Shape platform18, platform19, platform20,
            platform21, platform22, platform23,
            platform24, platform25, platform26;

    Image background3;
    Image groundTexture3;

    public World3() {
        super();
        setPriority(4);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.clear();
        graphics.drawImage(background3, 0, 0);
        graphics.setColor(Color.red);

        // Base of level
        graphics.draw(levelBase);
        graphics.texture(levelBase,groundTexture3,0,10);
        graphics.draw(baseR);
        graphics.fill(baseR);
        graphics.draw(baseL);
        graphics.fill(baseL);

        // Platforms
        graphics.draw(platform18);
        graphics.texture(platform18,groundTexture3,0,10);
        graphics.draw(platform19);
        graphics.texture(platform19,groundTexture3,0,10);;
        graphics.draw(platform20);
        graphics.texture(platform20,groundTexture3,0,10);
        graphics.draw(platform21);
        graphics.texture(platform21,groundTexture3,0,10);
        graphics.draw(platform22);
        graphics.texture(platform22,groundTexture3,0,10);
        graphics.draw(platform23);
        graphics.texture(platform23,groundTexture3,0,10);
        graphics.draw(platform24);
        graphics.texture(platform24,groundTexture3,0,10);
        graphics.draw(platform25);
        graphics.texture(platform25,groundTexture3,0,10);
        graphics.draw(platform26);
        graphics.texture(platform26,groundTexture3,0,10);
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

    }

    public void init(GameContainer gameContainer) throws SlickException {

        levelBase = new Rectangle(0,680,1024,100);
        baseR = new Rectangle(0 - 100,-500,100,2560);
        baseL = new Rectangle(1024,-500,100,2560);

        // Platforms
        platform18 = new Rectangle(624, 550, 100, 30);
        platform19 = new Rectangle(350, 550, 100, 30);
        platform20 = new Rectangle(0, 500, 200, 50);
        platform21 = new Rectangle(824, 500, 200, 50);
        platform22 = new Rectangle(162, 350, 100, 50);
        platform23 = new Rectangle(50,130,200,50);
        platform24 = new Rectangle(387,210,250,40);
        platform25 = new Rectangle(774,130,200,50);
        platform26 = new Rectangle(762,350,100,50);

        background3 = new Image("sprites/world3Bg.png");
        groundTexture3 = new Image("sprites/world2Texture.png");
    }

    public boolean collidesWithWorld3(Shape s)
    {
        return levelBase.intersects(s) ||
                baseR.intersects(s) ||
                baseL.intersects(s) ||
                platform18.intersects(s) ||
                platform19.intersects(s) ||
                platform20.intersects(s) ||
                platform21.intersects(s) ||
                platform22.intersects(s) ||
                platform23.intersects(s) ||
                platform24.intersects(s) ||
                platform25.intersects(s) ||
                platform26.intersects(s);
    }

    public String toString()
    {
        return "Sence4";
    }
}


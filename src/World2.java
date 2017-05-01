import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class World2 extends Scene {

    private Shape levelBase, baseR, baseL;
    private Shape platform9, platform10, platform11,
            platform12, platform13, platform14,
            platform15, platform16, platform17;

    private Image background2;
    private Image groundTexture2;

    public World2() {
        super();
        setPriority(3);
    }

    protected void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.clear();
        graphics.drawImage(background2, 0, 0);
        graphics.setColor(Color.green);

        // Base of level
        graphics.draw(levelBase);
        graphics.texture(levelBase,groundTexture2,0,10);
        graphics.draw(baseR);
        graphics.fill(baseR);
        graphics.draw(baseL);
        graphics.fill(baseL);

        // Platforms
        graphics.draw(platform9);
        graphics.texture(platform9,groundTexture2,0,10);
        graphics.draw(platform10);
        graphics.texture(platform10,groundTexture2,0,10);
        graphics.draw(platform11);
        graphics.texture(platform11,groundTexture2,0,10);
        graphics.draw(platform12);
        graphics.texture(platform12,groundTexture2,0,10);
        graphics.draw(platform13);
        graphics.texture(platform13,groundTexture2,0,10);
        graphics.draw(platform14);
        graphics.texture(platform14,groundTexture2,0,10);
        graphics.draw(platform15);
        graphics.texture(platform15,groundTexture2,0,10);
        graphics.draw(platform16);
        graphics.texture(platform16,groundTexture2,0,10);
        graphics.draw(platform17);
        graphics.texture(platform17,groundTexture2,0,10);

        graphics.setColor(Color.white);
    }

    protected void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {

    }

    public void init(GameContainer gameContainer) throws SlickException {

        levelBase = new Rectangle(0,680,1024,100);
        baseR = new Rectangle(0 - 100,-500,100,2560);
        baseL = new Rectangle(1024,-500,100,2560);

        // Platforms
        platform9 = new Rectangle(624, 535, 50, 50);
        platform10 = new Rectangle(350, 535, 50, 50);
        platform11 = new Rectangle(100, 500, 250, 50);
        platform12 = new Rectangle(674, 500, 250, 50);

        platform13 = new Rectangle(162, 350, 300, 50);
        platform14 = new Rectangle(544, 350, 300, 50);

        platform15 = new Rectangle(50,205,200,50);
        platform16 = new Rectangle(774,205,200,50);
        platform17 = new Rectangle(387,100,250,40);

        background2 = new Image("sprites/world2Bg.png");
        groundTexture2 = new Image("sprites/world2Texture.png");
    }

    public boolean collidesWithWorld2(Shape s)
    {
        return levelBase.intersects(s) ||
                baseR.intersects(s) ||
                baseL.intersects(s) ||
                platform9.intersects(s) ||
                platform10.intersects(s) ||
                platform11.intersects(s) ||
                platform12.intersects(s) ||
                platform13.intersects(s) ||
                platform14.intersects(s) ||
                platform15.intersects(s) ||
                platform16.intersects(s) ||
                platform17.intersects(s);
    }

    public String toString()
    {
        return "Sence4";
    }
}


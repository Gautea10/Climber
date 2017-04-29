import org.newdawn.slick.*;

public class Main {

    public static int gameWidth = 1024;
    public static int gameHeight = 768;

    public Main(String gameName){
        super();
        new Game();
    }

    public static void main(String[] args) {

        try {
            AppGameContainer app = new AppGameContainer( new Game() );
            app.setDisplayMode(gameWidth, gameHeight, false);
            app.setTargetFrameRate(60);
            app.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

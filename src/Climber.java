import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Climber extends BasicGameState {
    Image ground;
    Player player = new Player();
    //Image bckgrnd;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        ground = new Image("sprites/ground.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        int posX = 0;
        //Graphics2D g2d = (Graphics2D) graphics;

        for (int i = 0; i < 11; i++) {
            ground.draw(posX,668);
            posX += 100;
        }

        //player.render();  //This makes the game crash
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}

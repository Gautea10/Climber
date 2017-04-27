import org.newdawn.slick.*;

import java.util.ArrayList;


public class Boot extends Scene {

    private World world;
    private Player player;
    ArrayList<Enemy> enemyArrayList;
    private int score = 0;
    Highscore highscore;

    public Boot() {
        super();
        setPriority(1);
        System.out.println("Boot Ran");
    }

    @Override
    public void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {
        world.update(gameContainer, i);
        player.update(gameContainer, i);
        for (int l = 0; l < enemyArrayList.size(); l++){
            enemyArrayList.get(l).update(gameContainer, i);
        }


        for (int g = 0; g < enemyArrayList.size(); g++) {
            if (player.playerHitbox.intersects(enemyArrayList.get(g).Enemyhitbox)) {
                Game.manager.clear();
                Game.manager.addSence(new MainMenu());
            }
        }

        for (int h = 0; h < enemyArrayList.size(); h++) {
            if (player.slashHitboxL.intersects(enemyArrayList.get(h).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
                enemyArrayList.get(h).setState(STATE.INVISIBLE);
                enemyArrayList.get(h).Enemyhitbox.setLocation(500000,500000);
                score += 10;
            }
        }

        for (int j = 0; j < enemyArrayList.size(); j++) {
            if (player.slashHitboxR.intersects(enemyArrayList.get(j).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
                enemyArrayList.get(j).setState(STATE.INVISIBLE);
                enemyArrayList.get(j).Enemyhitbox.setLocation(500000, 5000000);
                score += 10;
            }
        }
    }

    @Override
    public void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException {
        world.render(gameContainer, graphics);
        player.render(gameContainer, graphics);
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).render(gameContainer, graphics);
        }

        graphics.drawString("Score: " + score, 10, 50);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        // Creates world and player
        world = new World();
        world.init(gameContainer);

        player = new Player( world );
        player.init(gameContainer);

        enemyArrayList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            enemyArrayList.add(i, new Enemy(world));
            enemyArrayList.get(i).init(gameContainer);
        }

        highscore = Highscore.getInstance();
    }

    public String toString()
    {
        return "Sence1";
    }
}
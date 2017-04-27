import org.newdawn.slick.*;

import java.util.ArrayList;

public class Boot extends Scene {

    //private World world;
    //private Player player;
    ArrayList<Enemy> enemyArrayList;

    private World world;
    private World2 world2;
    private World3 world3;
    private Player player;
    private Enemy enemy;
    private Win win;

    public Boot() {
        super();
        setPriority(1);
        System.out.println("Boot Ran");
    }

    @Override
    public void CustomUpdate(GameContainer gameContainer, int i) throws SlickException {
        world.update(gameContainer, i);
        world2.update(gameContainer, i);
        world3.update(gameContainer, i);
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
            }
        }

        for (int j = 0; j < enemyArrayList.size(); j++) {
            if (player.slashHitboxR.intersects(enemyArrayList.get(j).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
                enemyArrayList.get(j).setState(STATE.INVISIBLE);
                enemyArrayList.get(j).Enemyhitbox.setLocation(500000, 5000000);
            }
        }

        // Player collision Y
        if(world.collidesWith(player.playerHitbox) /*|| world2.collidesWithWorld2(player.playerHitbox) /*|| world3.collidesWithWorld3(player.playerHitbox)*/) {
            player.playerHitbox.setY(player.playerHitbox.getY() - player.yPlayer );
            player.slashHitboxR.setY( player.slashHitboxR.getY() - player.yPlayer );
            player.slashHitboxL.setY( player.slashHitboxL.getY() - player.yPlayer );
            player.yPlayer = 0;
        }

        // Jump
        if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            player.playerHitbox.setY(player.playerHitbox.getY() + 0.1f);
            player.slashHitboxR.setY(player.slashHitboxR.getY() + 0.1f);
            player.slashHitboxL.setY(player.slashHitboxL.getY() + 0.1f);

            if(world.collidesWith(player.playerHitbox) /*|| world2.collidesWithWorld2(player.playerHitbox) /*|| world3.collidesWithWorld3(player.playerHitbox)*/) {
                player.yPlayer = player.jumpStrength;
            }
        }

        // Player collision X
        player.playerHitbox.setX( player.playerHitbox.getX() + player.xPlayer );
        player.slashHitboxR.setX( player.slashHitboxR.getX() + player.xPlayer );
        player.slashHitboxL.setX( player.slashHitboxL.getX() + player.xPlayer );

        if (world.collidesWith(player.playerHitbox) /*|| world2.collidesWithWorld2(player.playerHitbox) /*|| world3.collidesWithWorld3(player.playerHitbox)*/) {
            player.playerHitbox.setX( player.playerHitbox.getX() - player.xPlayer );
            player.slashHitboxR.setX( player.slashHitboxR.getX() - player.xPlayer );
            player.slashHitboxL.setX( player.slashHitboxL.getX() - player.xPlayer );
            player.xPlayer = 0;
        }

        /*
        // Enemy Collisions
        if(world2.collidesWithWorld2(enemy.Enemyhitbox)) {
            enemy.Enemyhitbox.setY (enemy.Enemyhitbox.getY() - enemy.yEnemy);
            enemy.yEnemy = 0;
        }

        // Collision X
        enemy.Enemyhitbox.setX (enemy.Enemyhitbox.getX() + enemy.xEnemy);

        if (world2.collidesWithWorld2(enemy.Enemyhitbox)) {
            enemy.Enemyhitbox.setX(enemy.Enemyhitbox.getX() - enemy.xEnemy);
            enemy.xEnemy = 0;
        }*/
    }

    @Override
    public void CustomRender(GameContainer gameContainer, Graphics graphics) throws SlickException {
        world.render(gameContainer,graphics);
        //world2.render(gameContainer, graphics);
        //world3.render(gameContainer, graphics);

        player.render(gameContainer, graphics);
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).render(gameContainer, graphics);
        }

        win.render(gameContainer, graphics);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        // Creates world and player

        world = new World();
        world.init(gameContainer);

        world2 = new World2();
        world2.init(gameContainer);

        world3 = new World3();
        world3.init(gameContainer);

        player = new Player();
        player.init(gameContainer);

        win = new Win();
        win.init(gameContainer);

        enemyArrayList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            enemyArrayList.add(i, new Enemy(world));
            enemyArrayList.get(i).init(gameContainer);
        }
    }

    public String toString()
    {
        return "Sence1";
    }
}
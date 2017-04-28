import org.newdawn.slick.*;

import java.util.ArrayList;

public class Boot extends Scene {

    ArrayList<Enemy> enemyArrayListWorld1;
    ArrayList<Enemy> enemyArrayListWorld2;

    private World world;
    private World2 world2;
    private World3 world3;
    private Player player;
    private Win win;
    private int score = 0;
    private int activeWorld = 1;

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

        for (int l = 0; l < enemyArrayListWorld1.size(); l++){
            enemyArrayListWorld1.get(l).update(gameContainer, i);
            enemyArrayListWorld2.get(l).update(gameContainer, i);
        }


        for (int g = 0; g < enemyArrayListWorld1.size(); g++) {
            if (player.playerHitbox.intersects(enemyArrayListWorld1.get(g).Enemyhitbox) && activeWorld == 1) {
                Game.manager.clear();
                Game.manager.addSence(new MainMenu());
                System.out.println("37");
            }
        }

        for (int g = 0; g < enemyArrayListWorld2.size(); g++) {
            if (player.playerHitbox.intersects(enemyArrayListWorld2.get(g).Enemyhitbox) && activeWorld == 2) {
                Game.manager.clear();
                Game.manager.addSence(new MainMenu());
                System.out.println("45");
            }
        }

        for (int h = 0; h < enemyArrayListWorld1.size(); h++) {
            if (player.slashHitboxL.intersects(enemyArrayListWorld1.get(h).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 1) {
                enemyArrayListWorld1.get(h).setState(STATE.INVISIBLE);
                enemyArrayListWorld1.get(h).Enemyhitbox.setLocation(500000,500000);
                score += 10;
            }
        }

        for (int h = 0; h < enemyArrayListWorld2.size(); h++) {
            if (player.slashHitboxL.intersects(enemyArrayListWorld2.get(h).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 2) {
                enemyArrayListWorld2.get(h).setState(STATE.INVISIBLE);
                enemyArrayListWorld2.get(h).Enemyhitbox.setLocation(500000,500000);
                score += 10;
            }
        }

        for (int j = 0; j < enemyArrayListWorld1.size(); j++) {
            if (player.slashHitboxR.intersects(enemyArrayListWorld1.get(j).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 1) {
                enemyArrayListWorld1.get(j).setState(STATE.INVISIBLE);
                enemyArrayListWorld1.get(j).Enemyhitbox.setLocation(500000, 5000000);
                score += 10;
            }
        }

        for (int j = 0; j < enemyArrayListWorld2.size(); j++) {
            if (player.slashHitboxR.intersects(enemyArrayListWorld2.get(j).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 2) {
                enemyArrayListWorld2.get(j).setState(STATE.INVISIBLE);
                enemyArrayListWorld2.get(j).Enemyhitbox.setLocation(500000, 5000000);
                score += 10;
            }
        }


        if (player.playerHitbox.intersects(win.getFlagHitbox()) && score >= 20 && activeWorld == 1){
            activeWorld = 2;
            win.flagHitbox.setLocation(500000,500000);
            for (int j = 0; j < enemyArrayListWorld1.size(); j++) {
                enemyArrayListWorld1.get(j).Enemyhitbox.setLocation(5000000, 500000);
            }
        }

        if (player.playerHitbox.intersects(win.getFlagHitbox()) && score >= 50 && activeWorld == 2) {
            activeWorld = 3;
            win.flagHitbox.setLocation(50000000, 500000);
            for (int j = 0; j < enemyArrayListWorld2.size(); j++) {
                enemyArrayListWorld2.get(j).Enemyhitbox.setLocation(5000000, 500000);
            }
        }

        // Player collision Y
        if (world.collidesWith(player.playerHitbox) && activeWorld == 1 || world2.collidesWithWorld2(player.playerHitbox) && activeWorld == 2 || world3.collidesWithWorld3(player.playerHitbox) && activeWorld == 3) {
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

            if(world.collidesWith(player.playerHitbox) && activeWorld == 1 || world2.collidesWithWorld2(player.playerHitbox) && activeWorld == 2 || world3.collidesWithWorld3(player.playerHitbox) && activeWorld == 3) {
                player.yPlayer = player.jumpStrength;
            }
        }

        // Player collision X
        player.playerHitbox.setX( player.playerHitbox.getX() + player.xPlayer );
        player.slashHitboxR.setX( player.slashHitboxR.getX() + player.xPlayer );
        player.slashHitboxL.setX( player.slashHitboxL.getX() + player.xPlayer );

        if (world.collidesWith(player.playerHitbox) && activeWorld == 1 || world2.collidesWithWorld2(player.playerHitbox) && activeWorld == 2 || world3.collidesWithWorld3(player.playerHitbox) && activeWorld == 3) {
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

        if (activeWorld == 1) {
            world.render(gameContainer, graphics);
            for (int i = 0; i < enemyArrayListWorld1.size(); i++) {
                enemyArrayListWorld1.get(i).render(gameContainer, graphics);
            }
        }
        if (activeWorld == 2) {
            world2.render(gameContainer, graphics);
            for (int i = 0; i < enemyArrayListWorld2.size(); i++) {
                enemyArrayListWorld2.get(i).render(gameContainer, graphics);
            }
        }
        if (activeWorld == 3) {
            world3.render(gameContainer, graphics);
        }

        player.render(gameContainer, graphics);


        if (score >= 20 && activeWorld == 1) {
            win.render(gameContainer, graphics);
        }

        if (score >= 50 && activeWorld == 2) {
            win.getFlagHitbox().setLocation(512, 580);
            win.render(gameContainer, graphics);
        }
        graphics.drawString("Score: " + score,10, 50);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        // Creates world, player and enemies

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

        enemyArrayListWorld1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            enemyArrayListWorld1.add(i, new Enemy(world));
            enemyArrayListWorld1.get(i).init(gameContainer);
        }

        enemyArrayListWorld2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            enemyArrayListWorld2.add(i, new Enemy(world));
            enemyArrayListWorld2.get(i).init(gameContainer);
        }
    }

    public String toString()
    {
        return "Sence1";
    }
}
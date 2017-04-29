import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Boot extends Scene {

    private ArrayList<Enemy> enemyArrayListWorld1;
    private ArrayList<EnemyElf> enemyArrayListWorld2;
    private EnemyBoss boss;

    private World world;
    private World2 world2;
    private World3 world3;
    private Player player;
    private Win win;
    private int score = 0;
    private int activeWorld = 1;

    int time = 0;
    int duration = 30;

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

        if (activeWorld == 1) {
            for (int l = 0; l < enemyArrayListWorld1.size(); l++) {
                enemyArrayListWorld1.get(l).update(gameContainer, i);
            }
        }

        if (activeWorld == 2) {
            for (int l = 0; l < enemyArrayListWorld2.size(); l++){
                enemyArrayListWorld2.get(l).update(gameContainer, i);
            }
        }

        if (activeWorld == 3) {
            boss.Enemyhitbox = boss.followPlayer(player.playerHitbox, boss.Enemyhitbox);
            boss.update(gameContainer, i);
        }


        for (int g = 0; g < enemyArrayListWorld1.size(); g++) {
            if (player.playerHitbox.intersects(enemyArrayListWorld1.get(g).Enemyhitbox) && activeWorld == 1) {
                for (int j = 0; j < enemyArrayListWorld1.size(); j++) {
                    enemyArrayListWorld1.remove(j);
                }
                Game.manager.clear();
                Game.manager.addSence(new MainMenu());
                System.out.println("37");

            }
        }

        for (int g = 0; g < enemyArrayListWorld2.size(); g++) {
            if (player.playerHitbox.intersects(enemyArrayListWorld2.get(g).Enemyhitbox) && activeWorld == 2) {
                for (int j = 0; j < enemyArrayListWorld2.size(); j++){
                    enemyArrayListWorld2.remove(j);
                }
                Game.manager.clear();
                Game.manager.addSence(new MainMenu());
                System.out.println("45");
            }
        }

        if (player.playerHitbox.intersects(boss.Enemyhitbox) && activeWorld == 3) {
            Game.manager.clear();
            Game.manager.addSence(new MainMenu());
        }

        // Player attack collisions Left
        for (int h = 0; h < enemyArrayListWorld1.size(); h++) {
            if (player.slashHitboxL.intersects(enemyArrayListWorld1.get(h).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 1) {
                time += i;
                System.out.println("EnemyL: " + time);
                if (time<duration) {
                    enemyArrayListWorld1.get(h).setState(STATE.INVISIBLE);
                    enemyArrayListWorld1.get(h).Enemyhitbox.setLocation(500000, 500000);
                    score += 10;
                }
            }
            if (!gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
                time = 0;
            }
        }

        for (int h = 0; h < enemyArrayListWorld2.size(); h++) {
            if (player.slashHitboxL.intersects(enemyArrayListWorld2.get(h).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 2) {
                time += i;
                System.out.println("EnemyL: " + time);
                if (time<duration) {
                    enemyArrayListWorld2.get(h).setState(STATE.INVISIBLE);
                    enemyArrayListWorld2.get(h).Enemyhitbox.setLocation(500000, 500000);
                    score += 10;
                }
            }
            if (!gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
                time = 0;
            }
        }

        if (player.slashHitboxL.intersects(boss.Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 3) {
            time += i;
            System.out.println("Boss: " + time);
            if (time<duration) {
                if (boss.lives > 0) {
                    boss.lives -= 1;
                } else {
                    boss.setState(STATE.INVISIBLE);
                    boss.Enemyhitbox.setLocation(5000000, 500000);
                }
            }
            if (!gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
                time = 0;
            }
        }

        // Player attack collisions Right
        for (int j = 0; j < enemyArrayListWorld1.size(); j++) {
            if (player.slashHitboxR.intersects(enemyArrayListWorld1.get(j).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 1) {
                time += i;
                System.out.println("EnemyR: " + time);
                if (time<duration) {
                    enemyArrayListWorld1.get(j).setState(STATE.INVISIBLE);
                    enemyArrayListWorld1.get(j).Enemyhitbox.setLocation(500000, 5000000);
                    score += 10;
                }
            }
            if (!gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
                time = 0;
            }
        }

        for (int j = 0; j < enemyArrayListWorld2.size(); j++) {
            if (player.slashHitboxR.intersects(enemyArrayListWorld2.get(j).Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 2) {
                time += i;
                System.out.println("EnemyR: " + time);
                if (time<duration) {
                    enemyArrayListWorld2.get(j).setState(STATE.INVISIBLE);
                    enemyArrayListWorld2.get(j).Enemyhitbox.setLocation(500000, 5000000);
                    score += 10;
                }
            }
            if (!gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
                time = 0;
            }
        }

        if (player.slashHitboxR.intersects(boss.Enemyhitbox) && gameContainer.getInput().isKeyDown(Input.KEY_SPACE) && activeWorld == 3) {
            time += i;
            if (time<duration) {
                if (boss.lives > 0) {
                    boss.lives -= 1;
                } else {
                    boss.setState(STATE.INVISIBLE);
                    boss.Enemyhitbox.setLocation(500000, 500000);
                }
            }
            if (!gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
                time = 0;
            }
        }

        // Player intersect with The flag
        if (player.playerHitbox.intersects(win.getFlagHitbox()) && score >= 20 && activeWorld == 1){
            activeWorld = 2;
            win.flagHitbox.setLocation(500000,500000);
            for (int j = 0; j < enemyArrayListWorld1.size(); j++) {
                enemyArrayListWorld1.remove(j);
            }
        }

        if (player.playerHitbox.intersects(win.getFlagHitbox()) && score >= 50 && activeWorld == 2) {
            activeWorld = 3;
            win.flagHitbox.setLocation(50000000, 500000);
            for (int j = 0; j < enemyArrayListWorld2.size(); j++) {
                enemyArrayListWorld2.remove(j);
            }
        }

        // Boss die
        if (boss.lives == 0 && activeWorld == 3) {
            boss.Enemyhitbox.setLocation(50000, 50000);
            String name = JOptionPane.showInputDialog(null, "You have completed the game\n type in your name");
            MainMenu.highscore.addHighscore(name, score);
            Game.manager.clear();
            Game.manager.addSence(new MainMenu());
        }

        // Player collision World Y
        if (world.collidesWith(player.playerHitbox) && activeWorld == 1 ||
                world2.collidesWithWorld2(player.playerHitbox) && activeWorld == 2 ||
                world3.collidesWithWorld3(player.playerHitbox) && activeWorld == 3) {

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

            if(world.collidesWith(player.playerHitbox) && activeWorld == 1 ||
                    world2.collidesWithWorld2(player.playerHitbox) && activeWorld == 2 ||
                    world3.collidesWithWorld3(player.playerHitbox) && activeWorld == 3) {

                player.yPlayer = player.jumpStrength;
            }
        }

        // Player collision World X
        player.playerHitbox.setX( player.playerHitbox.getX() + player.xPlayer );
        player.slashHitboxR.setX( player.slashHitboxR.getX() + player.xPlayer );
        player.slashHitboxL.setX( player.slashHitboxL.getX() + player.xPlayer );

        if (world.collidesWith(player.playerHitbox) && activeWorld == 1 ||
                world2.collidesWithWorld2(player.playerHitbox) && activeWorld == 2 ||
                world3.collidesWithWorld3(player.playerHitbox) && activeWorld == 3) {

            player.playerHitbox.setX( player.playerHitbox.getX() - player.xPlayer );
            player.slashHitboxR.setX( player.slashHitboxR.getX() - player.xPlayer );
            player.slashHitboxL.setX( player.slashHitboxL.getX() - player.xPlayer );
            player.xPlayer = 0;
        }

        //System.out.println(boss.lives);
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
            boss.render(gameContainer, graphics);
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

        Rectangle r1 = new Rectangle(20, 50, 200,80);
        Rectangle r2 = new Rectangle(770,50,200, 80);
        Rectangle r3 = new Rectangle(270,0, 440, 20);
        Rectangle r4 = new Rectangle(280,170, 140,90);
        Rectangle r5 = new Rectangle(570, 170, 140, 90);
        Rectangle r6 = new Rectangle(20, 280, 180, 190);
        Rectangle r7 = new Rectangle(770,300,180,190);
        Rectangle r8 = new Rectangle(150, 580,660, 20);

        ArrayList<Rectangle> rectanglesWorld1 = new ArrayList<>();

        rectanglesWorld1.add(r1);
        rectanglesWorld1.add(r2);
        rectanglesWorld1.add(r3);
        rectanglesWorld1.add(r4);
        rectanglesWorld1.add(r5);
        rectanglesWorld1.add(r6);
        rectanglesWorld1.add(r7);
        rectanglesWorld1.add(r8);

        Random randomizer = new Random();

        enemyArrayListWorld1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            enemyArrayListWorld1.add(i, new Enemy(world));
            enemyArrayListWorld1.get(i).init(gameContainer);
            Rectangle random = rectanglesWorld1.get(randomizer.nextInt(rectanglesWorld1.size()));
            enemyArrayListWorld1.get(i).Enemyhitbox.setLocation(randomizer.nextInt((int) random.getWidth()) + random.getX(), randomizer.nextInt((int) random.getHeight()) + random.getY());
        }

        Rectangle r9 = new Rectangle(20, 40, 200,80);
        Rectangle r10 = new Rectangle(770,40,200, 80);
        Rectangle r11 = new Rectangle(270,10, 440, 20);
        Rectangle r12 = new Rectangle(280,170, 140,90);
        Rectangle r13 = new Rectangle(570, 170, 140, 90);
        Rectangle r14 = new Rectangle(20, 270, 100, 140);
        Rectangle r15 = new Rectangle(850,270,100,140);
        Rectangle r16 = new Rectangle(100, 590,320, 20);
        Rectangle r17 = new Rectangle(570,590,320,20);

        ArrayList<Rectangle> rectanglesWorld2 = new ArrayList<>();

        rectanglesWorld2.add(r9);
        rectanglesWorld2.add(r10);
        rectanglesWorld2.add(r11);
        rectanglesWorld2.add(r12);
        rectanglesWorld2.add(r13);
        rectanglesWorld2.add(r14);
        rectanglesWorld2.add(r15);
        rectanglesWorld2.add(r16);
        rectanglesWorld2.add(r17);

        enemyArrayListWorld2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            enemyArrayListWorld2.add(i, new EnemyElf(world2));
            enemyArrayListWorld2.get(i).init(gameContainer);
            Rectangle random = rectanglesWorld2.get(randomizer.nextInt(rectanglesWorld2.size()));
            enemyArrayListWorld2.get(i).Enemyhitbox.setLocation(randomizer.nextInt((int) random.getWidth()) + random.getX(), randomizer.nextInt((int) random.getHeight()) + random.getY());
        }

        boss = new EnemyBoss(world3);
        boss.init(gameContainer);
        boss.Enemyhitbox.setLocation(512, 100);
    }

    public String toString()
    {
        return "Sence1";
    }
}
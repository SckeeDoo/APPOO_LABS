package com.mygdx.game.States;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Bat;
import com.mygdx.game.sprites.Obstacle;


import java.util.ArrayList;

/**
 * Created by schiduvasile on 2/26/17.
 */
public class PlayState extends State {

    private static final int OBSTACLE_SPACING = 190;
    private static final int OBSTACLE_COUNT = 4;
    ShapeRenderer shapeRenderer;
    private Bat bat;
    private Texture background;
    private Texture ground;
    private Vector2 groundPosition1, groundPosition2;


    private Array<Obstacle> obstacles;



    public PlayState(GameStateManager gsm) {
        super(gsm);
        shapeRenderer = new ShapeRenderer();
        bat = new Bat(50,300);
        background = new Texture("bg.png");
        ground = new Texture("ground.png");
        groundPosition1 = new Vector2(cam.position.x - cam.viewportWidth / 2 - 180, 0);
        groundPosition2 = new Vector2((cam.position.x - cam.viewportWidth / 2) - 180 + ground.getWidth(), 0);

        cam.setToOrtho(false, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        obstacles = new Array<Obstacle>();

        for(int i = 1 ; i <= OBSTACLE_COUNT ; i++) {
            obstacles.add(new Obstacle(i *(OBSTACLE_SPACING + Obstacle.OBSTACLE_WIDTH)));
        }



    }

    public void update(float dt) {
        handleInput();;
        bat.update(dt);
        updateGround();
        cam.position.x = bat.getPosition().x + 30;

        for (int i = 0 ; i < bat.getPosition() ; i++) {
            Obstacle obstacle = obstacles.get(i);

            if (cam.position.x - (cam.viewportWidth / 2) > obstacle.getPosBottomOb().x + obstacle.getTopObstacle().getWidth()) {
                obstacle.reposition(());
            }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bat.update(dt);
        updateGround();
        cam.position.x = bat.getPosition().x + 30;

        for (int i = 0 ; i < obstacles.size ; i++) {
            Obstacle obstacle = obstacles.get(i);

            if (cam.position.x - (cam.viewportWidth / 2) > obstacle.getPosTopOb().x + obstacle.getTopObstacle().getWidth()) {
                obstacle.reposition(obstacle.getPosTopOb().x  + ((Obstacle.OBSTACLE_WIDTH + OBSTACLE_SPACING) * OBSTACLE_COUNT));
            }
            if (obstacle.collides(bat.getBounds())) {
                gsm.set(new PlayState(gsm));
            }
        }

        if(bat.getPosition().y <= ground.getHeight() - 60) {
            gsm.set(new PlayState(gsm));
        }
        cam.update();
    }
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            bat.jump();
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);

        sb.begin();
        sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bat.getTexture(), bat.getPosition().x, bat.getPosition().y);

        for(Obstacle obstacle : obstacles) {

            sb.draw(obstacle.getTopObstacle(), obstacle.getPosTopOb().x, obstacle.getPosTopOb().y);
            sb.draw(obstacle.getBottomObstacle(), obstacle.getPosBottomOb().x, obstacle.getPosBottomOb().y);

        }

        sb.draw(ground, groundPosition1.x, groundPosition1.y);
        sb.draw(ground, groundPosition2.x, groundPosition2.y);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        bat.dispose();

        for (Obstacle obstacle : obstacles) {
            obstacle.dispose();
        }
    }

    public void updateGround() {
        if (cam.position.x - (cam.viewportWidth / 2) > groundPosition1.x + ground.getWidth()) {
            groundPosition1.add(ground.getWidth() * 2, 0);
        }
        if (cam.position.x - (cam.viewportWidth / 2) > groundPosition2.x + ground.getWidth()) {
            groundPosition2.add(ground.getWidth() * 2, 0);
        }
    }
}

package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import sun.java2d.pipe.RegionClipSpanIterator;

import java.util.Random;

/**
 * Created by schiduvasile on 2/26/17.
 */
public class Obstacle {


    private static final int FLUCTUATION = 300;
    private static final int OBSTACLE_GAP = 180;
    private static final int LOWEST_OPENING = 200;
    private Texture topObstacle, bottomObstacle;
    private Vector2 posTopOb, posBottomOb;
    private Random rand;
    private Rectangle boundsTop, boundsBottom;

    public  static final int OBSTACLE_WIDTH = 30;

    public Obstacle(float x) {
        topObstacle = new Texture("topob.png");
        bottomObstacle = new Texture("bottomob.png");
        rand = new Random();

        posTopOb = new Vector2(x,rand.nextInt(FLUCTUATION) + OBSTACLE_GAP + LOWEST_OPENING);
        posBottomOb = new Vector2(x, posTopOb.y - OBSTACLE_GAP - bottomObstacle.getHeight());

        boundsTop = new Rectangle(posTopOb.x, posTopOb.y, topObstacle.getWidth(), topObstacle.getHeight());
        boundsBottom = new Rectangle(posBottomOb.x, posBottomOb.y, bottomObstacle.getWidth(), bottomObstacle.getHeight());
    }

    public Texture getTopObstacle() {
        return topObstacle;
    }



    public Texture getBottomObstacle() {
        return bottomObstacle;
    }

    public Vector2 getPosTopOb() {
        return posTopOb;
    }

    public Vector2 getPosBottomOb() {
        return posBottomOb;
    }

    public void reposition(float x) {
        posTopOb.set(x,rand.nextInt(FLUCTUATION) + OBSTACLE_GAP + LOWEST_OPENING);
        posBottomOb.set(x, posTopOb.y - OBSTACLE_GAP - bottomObstacle.getHeight());
        boundsTop.setPosition(posTopOb.x, posTopOb.y);
        boundsBottom.setPosition(posBottomOb.x, posBottomOb.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(boundsTop) || player.overlaps(boundsBottom);
    }

    public Rectangle getBoundsTop() {
        return boundsTop;
    }

    public void setBoundsTop(Rectangle boundsTop) {
        this.boundsTop = boundsTop;
    }

    public Rectangle getBoundsBottom() {
        return boundsBottom;
    }

    public void setBoundsBottom(Rectangle boundsBottom) {
        this.boundsBottom = boundsBottom;
    }

    public void dispose() {
        topObstacle.dispose();
        bottomObstacle.dispose();
    }


}


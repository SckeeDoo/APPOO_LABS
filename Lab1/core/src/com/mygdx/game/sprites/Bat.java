package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by schiduvasile on 2/26/17.
 */
public class Bat {
    private static final int MOVEMENT  = 110;
    private static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bat;
    private Texture texture;
    private Rectangle bounds;
    private Animation batAnimation;


    public Bat (int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bat = new Texture("bat.png");
        texture = new Texture("batanimation.png");
        batAnimation = new Animation(new TextureRegion(texture), 3, 0.2f);
        bounds = new Rectangle(x + 40, y + 40, (texture.getWidth()  / 3) - 100, texture.getHeight() - 100);

    }

    public void update(float dt){
        batAnimation.update(dt);
        if (position.y > 0)
            velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);

        velocity.scl(1/dt);

        if (position.y < 0) {
            position.y = 0;
        }
        bounds.setPosition(position.x, position.y);

    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return batAnimation.getFrame();
    }


    public void jump(){
        velocity.y = 250;
    }

    public void dispose() {
        texture.dispose();
    }
}

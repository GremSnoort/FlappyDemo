package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyDemo;
import com.mygdx.game.sprites.Plane;

public class PlayState extends State {

    //private Texture plane;
    private Plane plane;
    private Texture bg;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        plane = new Plane(50, 300);
        //plane = new Texture("plane.png");
        camera.setToOrtho(false, 360, 640);
        bg = new Texture("bg.jpg");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
        {
            plane.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        plane.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg, camera.position.x-(camera.viewportWidth/2), 0);
        sb.draw(plane.getPlane(), plane.getPosition().x, plane.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}

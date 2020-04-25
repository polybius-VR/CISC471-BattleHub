package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;

public class BattleScreen implements Screen{
	private GameScreen gameScreen;
	private Stage stage;
	private Game game;
	private SpriteBatch batch;
	private Label lblTextbox;
	private Texture enemy;
	
	public BattleScreen(GameScreen aGameScreen) {
		gameScreen = aGameScreen;
		game = aGameScreen.getGame();
		stage = new Stage(new ScreenViewport());
		batch = new SpriteBatch();
		lblTextbox = new Label("", MyGdxGame.skin);
		enemy = new Texture(Gdx.files.internal("dragondetail.png"));
		
		TextButton skill1 = new TextButton("Tackle",MyGdxGame.skin);
		skill1.setWidth(Gdx.graphics.getWidth()/4);
		skill1.setPosition(0, 160);
		skill1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        TextButton skill2 = new TextButton("Flamethrower",MyGdxGame.skin);
        skill2.setWidth(Gdx.graphics.getWidth()/4);
        skill2.setPosition(skill2.getWidth(), 160);
        skill2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        TextButton skill3 = new TextButton("Water Gun",MyGdxGame.skin);
        skill3.setWidth(Gdx.graphics.getWidth()/4);
        skill3.setPosition(skill3.getWidth()*2, 160);
        skill3.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        TextButton skill4 = new TextButton("Nature's Power",MyGdxGame.skin);
        skill4.setWidth(Gdx.graphics.getWidth()/4);
        skill4.setPosition(skill4.getWidth()*3, 160);
        skill4.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        TextButton fleeButton = new TextButton("Flee!",MyGdxGame.skin);
        fleeButton.setWidth(Gdx.graphics.getWidth()/4);
        fleeButton.setPosition(fleeButton.getWidth()*3,Gdx.graphics.getHeight()-fleeButton.getHeight());
        fleeButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {              
               game.setScreen(gameScreen);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        lblTextbox.setColor(Color.BLACK);
		lblTextbox.setSize(Gdx.graphics.getWidth(),160);
		lblTextbox.setPosition(0, 0);
		lblTextbox.setWrap(Boolean.TRUE);
		lblTextbox.setText("Battle Start!");
		
        addBackgroundGuide();
        stage.addActor(skill1);
        stage.addActor(skill2);
        stage.addActor(skill3);
        stage.addActor(skill4);
        stage.addActor(fleeButton);
        stage.addActor(lblTextbox);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.392f, 0.584f, 0.929f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
		batch.begin();
		batch.draw(enemy, Gdx.graphics.getWidth()/2 - enemy.getWidth()/2, Gdx.graphics.getHeight()/2 - enemy.getHeight()/2, 725, 445);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		enemy.dispose();
	}

	private void addBackgroundGuide(){
		Texture texture = new Texture(Gdx.files.internal("background.jpg"));
		texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

		TextureRegion textureRegion = new TextureRegion(texture);
		textureRegion.setRegion(0,0,texture.getWidth(),texture.getWidth());
		Image background = new Image(textureRegion);
		background.setSize(Gdx.graphics.getWidth(), 144);
		background.setPosition(0,0);
		stage.addActor(background);
	}
}

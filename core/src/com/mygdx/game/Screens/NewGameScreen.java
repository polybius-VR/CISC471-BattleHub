package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.Entities.Skills.Element;

public class NewGameScreen implements Screen{
	private Stage stage;
	private Game game;
	private Player player;
	private Boolean invalidFlag = Boolean.FALSE;
	
	private TextField txtUsername;
	private Label lblTextbox;
	private TextButton BtnNext;
	private TextButton BtnBack;
	private TextButton BtnOption1;
	private TextButton BtnOption2;
	private TextButton BtnOption3;
	
	private int state = 0; //Variable that checks the current state of the new game screen. State 0 = input name, State 1 = select class, State 2 = select type
	
	public NewGameScreen(Game aGame) {
		game = aGame;
		stage = new Stage(new ScreenViewport());		
		lblTextbox = new Label("", MyGdxGame.skin);		
		txtUsername = new TextField("",MyGdxGame.skin);
		BtnNext = new TextButton("",MyGdxGame.skin);
		BtnBack = new TextButton("",MyGdxGame.skin);
		BtnOption1 = new TextButton("",MyGdxGame.skin, "toggle");
		BtnOption2 = new TextButton("",MyGdxGame.skin, "toggle");
		BtnOption3 = new TextButton("",MyGdxGame.skin, "toggle");
		player = new Player();
		
		addBackgroundGuide();
		
		lblTextbox.setColor(Color.BLACK);
		lblTextbox.setSize(Gdx.graphics.getWidth(),160);
		lblTextbox.setPosition(0, 0);
		lblTextbox.setWrap(Boolean.TRUE);
		
		txtUsername.setWidth(500);
	    txtUsername.setPosition(Gdx.graphics.getWidth()/2-txtUsername.getWidth()/2,Gdx.graphics.getHeight()/2-txtUsername.getHeight()/2);
	    
		BtnNext.setWidth(Gdx.graphics.getWidth()/2);
		BtnNext.setPosition(Gdx.graphics.getWidth()/2-BtnNext.getWidth()/2,Gdx.graphics.getHeight()/2-BtnNext.getHeight()*2);	    		
		BtnBack.setWidth(Gdx.graphics.getWidth()/2);
		BtnBack.setPosition(Gdx.graphics.getWidth()/2-BtnBack.getWidth()/2,Gdx.graphics.getHeight()/2-BtnBack.getHeight()*3);
		BtnOption1.setWidth(Gdx.graphics.getWidth()/3);
		BtnOption1.setPosition(0,Gdx.graphics.getHeight()/2-BtnOption1.getHeight()/2);
		BtnOption2.setWidth(Gdx.graphics.getWidth()/3);
		BtnOption2.setPosition(Gdx.graphics.getWidth()-BtnOption2.getWidth(),Gdx.graphics.getHeight()/2-BtnOption2.getHeight()/2);
		BtnOption3.setWidth(Gdx.graphics.getWidth()/3);
		BtnOption3.setPosition(Gdx.graphics.getWidth()/2-BtnOption3.getWidth()/2,Gdx.graphics.getHeight()/2-BtnOption3.getHeight()/2);
        
		txtUsername.setVisible(Boolean.FALSE);
		BtnOption1.setVisible(Boolean.FALSE);
		BtnOption2.setVisible(Boolean.FALSE);
		BtnOption3.setVisible(Boolean.FALSE);
		
        BtnNext.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (state == 0) {
                	if (null != txtUsername && !txtUsername.getText().isEmpty()) {
                    	player.setName(txtUsername.getText());                    	
                    	invalidFlag = Boolean.FALSE;
                    	selectClass();
                    } else {
                    	if (invalidFlag == Boolean.FALSE) {
                    		lblTextbox.setText(lblTextbox.getText() + "\nName can't be empty");
                    		invalidFlag = Boolean.TRUE;
                    	}
                    }
                }
                else if (state == 1) {
                	if (!BtnOption1.isChecked() && !BtnOption2.isChecked()) {
                		if (invalidFlag == Boolean.FALSE) {
                			lblTextbox.setText(lblTextbox.getText() + "\nSelect a Class First!");
                			invalidFlag = Boolean.TRUE;
                		}
                	}
                	else {
                		if (BtnOption1.isChecked()) {
                    		player.setPlayerClass(Player.PlayerClass.KNIGHT);
                    		player.setMaxHealth(100);
                    		player.setHealth(100);
                    		player.setAttack(40);
                    		player.setDefense(100);
                    		player.setSpeed(40);
                    		player.setLevel(1);
                    		player.setExperience(0);
                		}
                    	if (BtnOption2.isChecked()) {
                    		player.setPlayerClass(Player.PlayerClass.SPELLCASTER);
                    		player.setMaxHealth(40);
                    		player.setHealth(40);
                    		player.setAttack(100);
                    		player.setDefense(40);
                    		player.setSpeed(100);
                    		player.setLevel(1);
                    		player.setExperience(0);
                    	}
                    	
                    	invalidFlag = Boolean.FALSE;
                    	selectType();
                	}
                }
                else if (state == 2) {
                	if (!BtnOption1.isChecked() && !BtnOption2.isChecked() && !BtnOption3.isChecked()) {
                		if (invalidFlag == Boolean.FALSE) {
                			lblTextbox.setText(lblTextbox.getText() + "\nSelect an Element First!");
                			invalidFlag = Boolean.TRUE;
                		}
                	} else {
                		if (BtnOption1.isChecked())
                    		player.setElement(new Element(Element.Elements.FIRE));
                    	if (BtnOption2.isChecked())
                    		player.setElement(new Element(Element.Elements.WATER));
                    	if (BtnOption3.isChecked())
                    		player.setElement(new Element(Element.Elements.GRASS));
                    	
                    	invalidFlag = Boolean.FALSE;
                    	
                    	game.setScreen(new GameScreen(game, player));
                	}
                }
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        BtnBack.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
               if (state == 0)
            	   game.setScreen(new TitleScreen(game));
               if (state == 1)
            	   setName();
               if (state == 2)
            	   selectClass();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        BtnOption1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
               BtnOption2.setChecked(Boolean.FALSE);
               BtnOption3.setChecked(Boolean.FALSE);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        BtnOption2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	BtnOption1.setChecked(Boolean.FALSE);
            	BtnOption3.setChecked(Boolean.FALSE);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        BtnOption3.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	BtnOption1.setChecked(Boolean.FALSE);
            	BtnOption2.setChecked(Boolean.FALSE);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
                
        stage.addActor(lblTextbox);
        stage.addActor(BtnNext);
        stage.addActor(BtnBack);
        stage.addActor(BtnOption1);
        stage.addActor(BtnOption2);
        stage.addActor(BtnOption3);
        stage.addActor(txtUsername);
        
        setName();
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
	
	private void setName() {
		state = 0;
		lblTextbox.setText("Please input your character's name.");
		
		txtUsername.setVisible(Boolean.TRUE);
		BtnOption1.setVisible(Boolean.FALSE);
		BtnOption2.setVisible(Boolean.FALSE);
		BtnOption3.setVisible(Boolean.FALSE);
	    txtUsername.setMessageText("Enter your name:");	    
	    
	    BtnNext.setText("Next");	    
	    BtnBack.setText("Cancel");
	}
	private void selectClass() {
		state = 1;
		lblTextbox.setText("Select which class you want to play as.");		
		
		txtUsername.setVisible(Boolean.FALSE);
		BtnOption1.setVisible(Boolean.TRUE);
		BtnOption2.setVisible(Boolean.TRUE);
		BtnOption3.setVisible(Boolean.FALSE);
		
        BtnOption1.setChecked(Boolean.FALSE);
		BtnOption2.setChecked(Boolean.FALSE);
        BtnOption3.setChecked(Boolean.FALSE);
		
		BtnOption1.setText("Knight");
		BtnOption2.setText("Spellcaster");
		BtnBack.setText("Previous");
	}
	
	private void selectType() {
		state = 2;
		lblTextbox.setText("Select which Elemental Type you prefer.");		
		
		txtUsername.setVisible(Boolean.FALSE);
		BtnOption1.setVisible(Boolean.TRUE);
		BtnOption2.setVisible(Boolean.TRUE);
		BtnOption3.setVisible(Boolean.TRUE);
		
		BtnOption1.setChecked(Boolean.FALSE);
		BtnOption2.setChecked(Boolean.FALSE);
        BtnOption3.setChecked(Boolean.FALSE);
        
		BtnOption1.setText("Fire");
		BtnOption2.setText("Water");
		BtnOption3.setText("Grass");
		BtnNext.setText("Finish");
	}

}

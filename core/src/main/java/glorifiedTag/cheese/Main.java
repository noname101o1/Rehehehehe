package glorifiedTag.cheese;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Texture playerTexture;
    private Texture altPlayerTexture;
    private FitViewport viewport;

    @Override
    public void create() {

        //try to load textures
        try {
            image = new Texture("libgdx.png");
            playerTexture = new Texture("player.png");
            altPlayerTexture = new Texture("alternatePlayer.png");
        } catch (Exception e) {
            //outputs error message if the texture can't be loaded instead of crashing the program
            System.out.println("error loading textures");
        }
        batch = new SpriteBatch();
        
        //sets the aspect ratio and the scale of the display window
        viewport = new FitViewport(21, 16);

        //tells libgdx to handle input through the Input class
        Input inputprocceserInput = new Input();
        Gdx.input.setInputProcessor(inputprocceserInput);
    }

    @Override
    public void resize(int width, int height){
        viewport.update(width, height, true);
        batch.setProjectionMatrix(viewport.getCamera().combined);
    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    private void input(){

    }

    private void logic(){

    }

    private void draw(){
        //draws a blank background color to cover up previous frames
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);


        //all draw calls should go between batch.begin and batch.end because its more efficient
        batch.begin();
        batch.draw(image, 140, 210);
        batch.draw(playerTexture,1,2,10,7);
        batch.end();
    }
}

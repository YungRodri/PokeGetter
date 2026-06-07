package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainMenuScreen implements Screen {

    final GameLluviaMenu game;
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;
    private Texture fondo;
    private BitmapFont fuente;

    public MainMenuScreen(final GameLluviaMenu game) {
	this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
	camera = new OrthographicCamera();
	camera.setToOrtho(false, 800, 480);

        Pixmap pixmapOriginal = new Pixmap(Gdx.files.internal("girl.png"));
        Pixmap pixmapDestino = new Pixmap(800, 480, pixmapOriginal.getFormat());

        pixmapDestino.drawPixmap(pixmapOriginal,
            0, 0, pixmapOriginal.getWidth(), pixmapOriginal.getHeight(),
            0, 0, pixmapDestino.getWidth(), pixmapDestino.getHeight()
        );

        this.fondo = new Texture(pixmapDestino);
        pixmapOriginal.dispose();
        pixmapDestino.dispose();

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("pokemon_pixel_font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24;
        parameter.color = com.badlogic.gdx.graphics.Color.WHITE;
        parameter.borderWidth = 2f;
        parameter.borderColor = Color.BLACK;

        this.fuente = generator.generateFont(parameter);

        generator.dispose();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

	batch.begin();
        batch.draw(fondo, 0,0, 800, 480);
	fuente.getData().setScale(2, 2);
	fuente.draw(batch, "Bienvenido a \nRecolecta Pokebolas!!! ", 30, camera.viewportHeight/2+50);
	fuente.draw(batch, "Toca en cualquier lugar \npara comenzar!", 30, camera.viewportHeight/2-50);

	batch.end();

	if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
	}
    }

    @Override
    public void show() {
		// TODO Auto-generated method stub
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
        if (fondo != null) {
            fondo.dispose();
        }

        if (fuente != null) {
            fuente.dispose();
        }
    }

}

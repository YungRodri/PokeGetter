package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class GameOverScreen implements Screen {

    private final GameLluviaMenu game;
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;
    private int puntajeFinal;
    private Texture fondo;
    private BitmapFont fuente;

    public GameOverScreen(final GameLluviaMenu game, int puntajeFinal) {
        this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
        this.puntajeFinal = puntajeFinal;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        Pixmap pixmapOriginal = new Pixmap(Gdx.files.internal("rocket_wide.png"));
        Pixmap pixmapDestino = new Pixmap(800, 480, pixmapOriginal.getFormat());

        pixmapDestino.drawPixmap(pixmapOriginal,
            0, 0, pixmapOriginal.getWidth(), pixmapOriginal.getHeight(),
            0, 0, pixmapDestino.getWidth(), pixmapDestino.getHeight()
        );

        this.fondo = new Texture(pixmapDestino);
        pixmapOriginal.dispose();
        pixmapDestino.dispose();

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("pokemon_pixel_font.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 42;
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
        fuente.draw(batch, "GAME OVER", 325, 330);
        fuente.draw(batch, "Puntaje final: " + puntajeFinal, 280, 270);
        fuente.draw(batch, "HighScore: " + game.getHigherScore(), 280, 230);

        fuente.draw(batch, "Presiona ENTER para reiniciar", 180, 160);
        fuente.draw(batch, "Presiona ESC para volver al menu", 180, 125);

        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) || Gdx.input.justTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
    }

    @Override
    public void show() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        fondo.dispose();
    }
}

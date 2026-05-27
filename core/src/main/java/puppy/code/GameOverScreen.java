package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverScreen implements Screen {

    private final GameLluviaMenu game;
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;
    private int puntajeFinal;

    public GameOverScreen(final GameLluviaMenu game, int puntajeFinal) {
        this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
        this.puntajeFinal = puntajeFinal;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        font.draw(batch, "GAME OVER", 330, 330);
        font.draw(batch, "Puntaje final: " + puntajeFinal, 300, 270);
        font.draw(batch, "HighScore: " + game.getHigherScore(), 320, 230);

        font.draw(batch, "Presiona ENTER para reiniciar", 270, 160);
        font.draw(batch, "Presiona ESC para volver al menu", 260, 125);

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
    }
}

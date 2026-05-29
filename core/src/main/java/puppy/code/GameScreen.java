package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    private final GameLluviaMenu game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont font;
    private Tarro tarro;
    private Lluvia lluvia;

    public GameScreen(final GameLluviaMenu game) {
        this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();

        GestorRecursos recursos = GestorRecursos.getInstancia();

        tarro = new Tarro(
            recursos.getTexturaJugador(),
            recursos.getSonidoHerido()
        );

        lluvia = new Lluvia(
            recursos.getTexturaPokebolaNormal(),
            recursos.getTexturaPokebolaRocket(),
            recursos.getTexturaPokebolaCurativa(),
            recursos.getTexturaPokebolaRocketFuerte(),
            recursos.getSonidoDrop(),
            recursos.getMusicaLluvia()
        );

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        tarro.crear();
        lluvia.crear();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            pausarJuego();
            return;
        }

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        actualizarJuego();
        dibujarJuego();
    }

    private void actualizarJuego() {
        if (!tarro.estaHerido()) {
            tarro.actualizarMovimiento();
        }

        if (!lluvia.actualizarMovimiento(tarro)) {
            actualizarHighScore();

            game.setScreen(new GameOverScreen(game, lluvia.getPuntaje()));
            dispose();
        }
    }

    private void actualizarHighScore() {
        if (game.getHigherScore() < lluvia.getPuntaje()) {
            game.setHigherScore(lluvia.getPuntaje());
        }
    }

    private void dibujarJuego() {
        batch.begin();

        tarro.dibujar(batch);
        lluvia.actualizarDibujoLluvia(batch);
        dibujarHUD();

        batch.end();
    }

    private void dibujarHUD() {
        font.getData().setScale(1.25f);

        font.draw(batch, "Puntos: " + lluvia.getPuntaje(), 20, 460);
        font.draw(batch, "Vidas: " + lluvia.getVidas(), 620, 460);
        font.draw(batch, "HighScore: " + game.getHigherScore(), 290, 460);
        font.draw(batch, "Nivel: " + lluvia.getDificultadActual(), 350, 420);

        font.getData().setScale(1f);
    }

    private void pausarJuego() {
        lluvia.pausar();
        game.setScreen(new PausaScreen(game, this));
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        lluvia.continuar();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
        lluvia.pausar();
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        tarro.destruir();
        lluvia.destruir();
    }
}

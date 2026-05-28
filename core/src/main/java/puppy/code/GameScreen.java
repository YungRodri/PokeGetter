package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
	final GameLluviaMenu game;
    private OrthographicCamera camera;
	private SpriteBatch batch;
	private BitmapFont font;
	private Tarro tarro;
	private Lluvia lluvia;


	//boolean activo = true;

	public GameScreen(final GameLluviaMenu game) {
		this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
        // load the images for the droplet and the bucket, 64x64 pixels each
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
	      // camera
	      camera = new OrthographicCamera();
	      camera.setToOrtho(false, 800, 480);
	      batch = new SpriteBatch();
	      // creacion del tarro
	      tarro.crear();

	      // creacion de la lluvia
	      lluvia.crear();
	}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        // Movimiento del jugador solo si no está herido
        if (!tarro.estaHerido()) {
            tarro.actualizarMovimiento();
        }

        // La lluvia/pokebolas siempre se actualiza
        if (!lluvia.actualizarMovimiento(tarro)) {

            if (game.getHigherScore() < lluvia.getPuntaje()) {
                game.setHigherScore(lluvia.getPuntaje());
            }

            game.setScreen(new GameOverScreen(game, lluvia.getPuntaje()));
            dispose();
            return;
        }

        batch.begin();

        tarro.dibujar(batch);
        lluvia.actualizarDibujoLluvia(batch);

        font.draw(batch, "Puntos: " + lluvia.getPuntaje(), 5, 475);
        font.draw(batch, "Vidas: " + lluvia.getVidas(), 670, 475);
        font.draw(batch, "HighScore: " + game.getHigherScore(), camera.viewportWidth / 2 - 50, 475);
        font.draw(batch, "Nivel: " + lluvia.getDificultadActual(), 360, 445);

        batch.end();
    }

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	  // continuar con sonido de lluvia
	  lluvia.continuar();
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {
		lluvia.pausar();
		game.setScreen(new PausaScreen(game, this));
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

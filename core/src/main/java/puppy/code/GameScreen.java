package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class GameScreen implements Screen {
    final GameLluviaMenu game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont font;
    private Tarro tarro;
    private Lluvia lluvia;
    private Texture fondo;
    private BitmapFont fuente;


    //boolean activo = true;

    public GameScreen(final GameLluviaMenu game) {

        this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();

        Sound hurtSound = Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));
        tarro = new Tarro(new Texture(Gdx.files.internal("bucket.png")), hurtSound);


        Texture gota = new Texture(Gdx.files.internal("drop.png"));
        Texture gotaMala = new Texture(Gdx.files.internal("dropBad.png"));
        Texture gotaCurativa = new Texture(Gdx.files.internal("dropHeal.png"));
        Texture gotaRocketFuerte = new Texture(Gdx.files.internal("dropRocketStrong.png"));

        Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        Music bgMusic = Gdx.audio.newMusic(Gdx.files.internal("Pokemon_Center.mp3"));
        lluvia = new Lluvia(gota, gotaMala, gotaCurativa, gotaRocketFuerte, dropSound, bgMusic);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();

        tarro.crear();
        lluvia.crear();

        Pixmap pixmapOriginal = new Pixmap(Gdx.files.internal("fondo.png"));
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
        parameter.size = 32;
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

        // Implementacion del fondo


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

        batch.draw(fondo, 0,0, 800, 480);
        tarro.dibujar(batch);
        lluvia.actualizarDibujoLluvia(batch);

        fuente.draw(batch, "Puntos: " + lluvia.getPuntaje(), 5, 475);
        fuente.draw(batch, "Vidas: " + lluvia.getVidas(), 670, 475);
        fuente.draw(batch, "HighScore: " + game.getHigherScore(), camera.viewportWidth / 2 - 50, 475);
        fuente.draw(batch, "Nivel: " + lluvia.getDificultadActual(), 360, 445);

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
      fuente.dispose();
	}

}

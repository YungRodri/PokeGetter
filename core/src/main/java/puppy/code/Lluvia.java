package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lluvia {

    private Array<Pokebola> pokebolas;
    private long lastDropTime;

    private Texture gotaBuena;
    private Texture gotaMala;

    private Sound dropSound;
    private Music rainMusic;

    private EstadoJuego estadoJuego;

    public Lluvia(Texture gotaBuena, Texture gotaMala, Sound ss, Music mm) {
        this.rainMusic = mm;
        this.dropSound = ss;
        this.gotaBuena = gotaBuena;
        this.gotaMala = gotaMala;
        this.estadoJuego = new EstadoJuego();
    }

    public void crear() {
        pokebolas = new Array<Pokebola>();
        crearPokebola();

        rainMusic.setLooping(true);
        rainMusic.play();
    }

    private void crearPokebola() {
        float x = MathUtils.random(0, 800 - 64);
        float y = 480;
        float velocidad = 300;

        /*
         * Probabilidad:
         * 30% PokebolaRocket
         * 70% PokebolaNormal
         */
        if (MathUtils.random(1, 10) <= 3) {
            pokebolas.add(new PokebolaRocket(x, y, velocidad, gotaMala));
        } else {
            pokebolas.add(new PokebolaNormal(x, y, velocidad, gotaBuena));
        }

        lastDropTime = TimeUtils.nanoTime();
    }

    public boolean actualizarMovimiento(Tarro tarro) {

        // generar pokebolas cada cierto tiempo
        if (TimeUtils.nanoTime() - lastDropTime > 100000000) {
            crearPokebola();
        }

        // recorrer desde atrás para poder eliminar sin problemas
        for (int i = pokebolas.size - 1; i >= 0; i--) {

            Pokebola pokebola = pokebolas.get(i);

            pokebola.actualizar(Gdx.graphics.getDeltaTime());

            // si cae al suelo, se elimina
            if (pokebola.estaEliminada()) {
                pokebolas.removeIndex(i);
            }
            // si choca con Charmander/Tarro, aplica su efecto
            else if (pokebola.getBounds().overlaps(tarro.getArea())) {

                pokebola.aplicarEfecto(estadoJuego);
                dropSound.play();

                pokebolas.removeIndex(i);

                if (estadoJuego.estaGameOver()) {
                    return false;
                }
            }
        }

        return true;
    }

    public void actualizarDibujoLluvia(SpriteBatch batch) {

        for (int i = 0; i < pokebolas.size; i++) {
            pokebolas.get(i).dibujar(batch);
        }
    }

    public int getPuntaje() {
        return estadoJuego.getPuntaje();
    }

    public int getVidas() {
        return estadoJuego.getVidas();
    }

    public void destruir() {
        dropSound.dispose();
        rainMusic.dispose();
    }

    public void pausar() {
        rainMusic.stop();
    }

    public void continuar() {
        rainMusic.play();
    }
}

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
    private Texture gotaCurativa;
    private Texture gotaRocketFuerte;

    private Sound dropSound;
    private Music rainMusic;

    private EstadoJuego estadoJuego;

    public Lluvia(Texture gotaBuena, Texture gotaMala, Texture gotaCurativa, Texture gotaRocketFuerte, Sound ss, Music mm) {
        this.rainMusic = mm;
        this.dropSound = ss;
        this.gotaBuena = gotaBuena;
        this.gotaMala = gotaMala;
        this.gotaCurativa = gotaCurativa;
        this.gotaRocketFuerte = gotaRocketFuerte;
        this.estadoJuego = new EstadoJuego();
    }

    public void crear() {
        pokebolas = new Array<Pokebola>();
        crearPokebola();

        rainMusic.setLooping(true);
        rainMusic.play();
    }

    public boolean actualizarMovimiento(Tarro tarro) {

        if (TimeUtils.nanoTime() - lastDropTime > 500000000) {
            crearPokebola();
        }

        for (int i = pokebolas.size - 1; i >= 0; i--) {

            Pokebola pokebola = pokebolas.get(i);

            pokebola.actualizar(Gdx.graphics.getDeltaTime());

            if (pokebola.estaEliminada()) {
                pokebolas.removeIndex(i);
            } else if (pokebola.getBounds().overlaps(tarro.getArea())) {

                pokebola.capturar(estadoJuego, tarro);
                dropSound.play();

                pokebolas.removeIndex(i);

                if (estadoJuego.estaGameOver()) {
                    return false;
                }
            }
        }

        return true;
    }

    private void crearPokebola() {
        float x = MathUtils.random(0, 800 - 64);
        float y = 480;

        int azar = MathUtils.random(1, 100);

        if (azar <= 10) {
            // 10% Rocket fuerte: quita 2 vidas y cae más rápido
            pokebolas.add(new PokebolaRocketFuerte(x, y, 420, gotaRocketFuerte));
        } else if (azar <= 30) {
            // 20% Rocket normal: quita 1 vida
            pokebolas.add(new PokebolaRocket(x, y, 350, gotaMala));
        } else if (azar <= 45) {
            // 15% Curativa: recupera 1 vida
            pokebolas.add(new PokebolaCurativa(x, y, 250, gotaCurativa));
        } else {
            // 55% Normal: suma puntos
            pokebolas.add(new PokebolaNormal(x, y, 300, gotaBuena));
        }

        lastDropTime = TimeUtils.nanoTime();
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

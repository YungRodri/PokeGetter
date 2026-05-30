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

    private Texture pokebola;
    private Texture gotaMala;
    private Texture gotaCurativa;
    private Texture gotaRocketFuerte;
    private Texture gotaVeloz;
    private Texture gotaPeso;

    private Sound dropSound;
    private Music rainMusic;

    private EstadoJuego estadoJuego;
    private Nivel nivelActual;
    private int dificultadActual;

    public Lluvia(Texture pokebola, Texture gotaMala, Texture gotaCurativa, Texture gotaRocketFuerte, Texture gotaVeloz, Texture gotaPeso, Sound ss, Music mm) {
        this.rainMusic = mm;
        this.dropSound = ss;
        this.pokebola = pokebola;
        this.gotaMala = gotaMala;
        this.gotaCurativa = gotaCurativa;
        this.gotaRocketFuerte = gotaRocketFuerte;
        this.gotaVeloz = gotaVeloz;
        this.gotaPeso = gotaPeso;
        this.estadoJuego = new EstadoJuego();
    }
    private Nivel crearNivelFacil() {
        return new NivelBuilder()
            .conProbabilidadRocketFuerte(5)
            .conProbabilidadRocket(20)
            .conProbabilidadCurativa(35)
            .conProbabilidadVeloz(40)
            .conProbabilidadPeso(45)
            .conVelocidadNormal(260)
            .conVelocidadCurativa(230)
            .conVelocidadRocket(310)
            .conVelocidadRocketFuerte(360)
            .conVelocidadVeloz(360)
            .conVelocidadPeso(360)
            .conTiempoGeneracion(700000000)
            .build();
    }

    private Nivel crearNivelMedio() {
        return new NivelBuilder()
            .conProbabilidadRocketFuerte(10)
            .conProbabilidadRocket(30)
            .conProbabilidadCurativa(40)
            .conProbabilidadVeloz(45)
            .conProbabilidadPeso(50)
            .conVelocidadNormal(300)
            .conVelocidadCurativa(250)
            .conVelocidadRocket(350)
            .conVelocidadRocketFuerte(420)
            .conVelocidadVeloz(420)
            .conVelocidadPeso(420)
            .conTiempoGeneracion(500000000)
            .build();
    }

    private Nivel crearNivelDificil() {
        return new NivelBuilder()
            .conProbabilidadRocketFuerte(15)
            .conProbabilidadRocket(40)
            .conProbabilidadCurativa(45)
            .conProbabilidadVeloz(55)
            .conProbabilidadPeso(60)
            .conVelocidadNormal(350)
            .conVelocidadCurativa(290)
            .conVelocidadRocket(430)
            .conVelocidadRocketFuerte(520)
            .conVelocidadVeloz(420)
            .conVelocidadPeso(420)
            .conTiempoGeneracion(350000000)
            .build();
    }
    private void actualizarDificultad() {
        int puntaje = estadoJuego.getPuntaje();

        if (puntaje >= 10000) {
            if (dificultadActual != 3) {
                dificultadActual = 3;
                nivelActual = crearNivelDificil();
            }
        } else if (puntaje >= 4000) {
            if (dificultadActual != 2) {
                dificultadActual = 2;
                nivelActual = crearNivelMedio();
            }
        } else {
            if (dificultadActual != 1) {
                dificultadActual = 1;
                nivelActual = crearNivelFacil();
            }
        }
    }
    public void crear() {
        pokebolas = new Array<Pokebola>();

        dificultadActual = 1;
        nivelActual = crearNivelFacil();

        crearPokebola();

        rainMusic.setLooping(true);
        rainMusic.play();
    }
    public boolean actualizarMovimiento(Tarro tarro) {

        if (TimeUtils.nanoTime() - lastDropTime > nivelActual.getTiempoGeneracion()) {
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

        actualizarDificultad();


        return true;
    }

    private void crearPokebola() {
        float x = MathUtils.random(0, 800 - 64);
        float y = 480;

        int azar = MathUtils.random(1, 100);
        Pokebola pokebola;

        if (azar <= nivelActual.getProbabilidadRocketFuerte()) {
            pokebola = new PokebolaRocketFuerte(x, y, nivelActual.getVelocidadRocketFuerte(), gotaRocketFuerte,100);
            pokebola.setEstrategiaMovimiento(new MovimientoZigZag());

        } else if (azar <= nivelActual.getProbabilidadRocket()) {
            pokebola = new PokebolaRocket(x, y, nivelActual.getVelocidadRocket(), gotaMala, 100);
            pokebola.setEstrategiaMovimiento(new MovimientoRapido());

        } else if (azar <= nivelActual.getProbabilidadCurativa()) {
            pokebola = new PokebolaCurativa(x, y, nivelActual.getVelocidadCurativa(), gotaCurativa, 100);
            pokebola.setEstrategiaMovimiento(new MovimientoNormal());
            
        } else if (azar <= nivelActual.getProbabilidadVeloz()) {
            pokebola = new VelozBall(x, y, nivelActual.getVelocidadVeloz(), gotaVeloz, 100);
            pokebola.setEstrategiaMovimiento(new MovimientoRapido());
    
        } else if (azar <= nivelActual.getProbabilidadPeso()) {
            pokebola = new PesoBall(x, y, nivelActual.getVelocidadPeso(), gotaPeso, 100);
            pokebola.setEstrategiaMovimiento(new MovimientoRapido());
        } else {
            pokebola = new PokebolaNormal(x, y, nivelActual.getVelocidadNormal(), this.pokebola, 100);
            pokebola.setEstrategiaMovimiento(new MovimientoNormal());
        }

        pokebolas.add(pokebola);
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
    public int getDificultadActual() {
        return dificultadActual;
    }
}

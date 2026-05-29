package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GestorRecursos {

    private static GestorRecursos instancia;

    private Texture texturaJugador;
    private Texture texturaPokebolaNormal;
    private Texture texturaPokebolaRocket;
    private Texture texturaPokebolaCurativa;
    private Texture texturaPokebolaRocketFuerte;

    private Sound sonidoDrop;
    private Sound sonidoHerido;

    private Music musicaLluvia;

    private GestorRecursos() {
        texturaJugador = new Texture(Gdx.files.internal("bucket.png"));
        texturaPokebolaNormal = new Texture(Gdx.files.internal("drop.png"));
        texturaPokebolaRocket = new Texture(Gdx.files.internal("dropBad.png"));
        texturaPokebolaCurativa = new Texture(Gdx.files.internal("dropHeal.png"));
        texturaPokebolaRocketFuerte = new Texture(Gdx.files.internal("dropRocketStrong.png"));

        sonidoDrop = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        sonidoHerido = Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));

        musicaLluvia = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
    }

    public static GestorRecursos getInstancia() {
        if (instancia == null) {
            instancia = new GestorRecursos();
        }

        return instancia;
    }

    public Texture getTexturaJugador() {
        return texturaJugador;
    }

    public Texture getTexturaPokebolaNormal() {
        return texturaPokebolaNormal;
    }

    public Texture getTexturaPokebolaRocket() {
        return texturaPokebolaRocket;
    }

    public Texture getTexturaPokebolaCurativa() {
        return texturaPokebolaCurativa;
    }

    public Texture getTexturaPokebolaRocketFuerte() {
        return texturaPokebolaRocketFuerte;
    }

    public Sound getSonidoDrop() {
        return sonidoDrop;
    }

    public Sound getSonidoHerido() {
        return sonidoHerido;
    }

    public Music getMusicaLluvia() {
        return musicaLluvia;
    }

    public void destruir() {
        texturaJugador.dispose();
        texturaPokebolaNormal.dispose();
        texturaPokebolaRocket.dispose();
        texturaPokebolaCurativa.dispose();
        texturaPokebolaRocketFuerte.dispose();

        sonidoDrop.dispose();
        sonidoHerido.dispose();

        musicaLluvia.dispose();
    }
    public static void destruirInstancia() {
        if (instancia != null) {
            instancia.destruir();
            instancia = null;
        }
    }
}

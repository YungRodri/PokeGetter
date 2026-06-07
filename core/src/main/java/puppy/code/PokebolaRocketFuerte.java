package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class PokebolaRocketFuerte extends Pokebola {

    public PokebolaRocketFuerte(float x, float y, float velocidad, Texture textura,int puntaje) {
        super(x, y, velocidad, textura, puntaje);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego, Tarro tarro) {
        estadoJuego.quitarVida(2);

        int puntuacion = (int)(getPuntaje() * -0.55);
        estadoJuego.sumarPuntos(puntuacion);
        tarro.activarAnimacionDano();
    }
}

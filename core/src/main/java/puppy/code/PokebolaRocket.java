package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class PokebolaRocket extends Pokebola {

    public PokebolaRocket(float x, float y, float velocidad, Texture textura, int puntaje) {
        super(x, y, velocidad, textura, puntaje);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego, Tarro tarro) {
        estadoJuego.quitarVida(1);

        int puntuacion = (int)(getPuntaje() * -0.75);
        estadoJuego.sumarPuntos(puntuacion);
        tarro.activarAnimacionDano();
    }
}

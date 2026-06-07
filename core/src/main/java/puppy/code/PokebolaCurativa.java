package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class PokebolaCurativa extends Pokebola {

    public PokebolaCurativa(float x, float y, float velocidad, Texture textura, int puntaje) {
        super(x, y, velocidad, textura, puntaje);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego, Tarro tarro) {
        estadoJuego.recuperarVida(1);

        int puntuacion = (int)(getPuntaje() * 0.75f);
        estadoJuego.sumarPuntos(puntuacion);
    }
}

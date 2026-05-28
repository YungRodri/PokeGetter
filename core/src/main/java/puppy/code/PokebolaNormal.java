package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class PokebolaNormal extends Pokebola {

    public PokebolaNormal(float x, float y, float velocidad, Texture textura, int puntaje) {
        super(x, y, velocidad, textura, puntaje);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego, Tarro tarro) {
        estadoJuego.sumarPuntos(getPuntaje());
    }
}

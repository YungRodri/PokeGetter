package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class PokebolaNormal extends Pokebola {

    public PokebolaNormal(float x, float y, float velocidad, Texture textura) {
        super(x, y, velocidad, textura);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego, Tarro tarro) {
        estadoJuego.sumarPuntos(10);
    }
}

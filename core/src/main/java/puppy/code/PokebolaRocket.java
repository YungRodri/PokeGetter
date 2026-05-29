package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class PokebolaRocket extends Pokebola {

    public PokebolaRocket(float x, float y, float velocidad, Texture textura) {
        super(x, y, velocidad, textura);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego, Tarro tarro) {
        estadoJuego.quitarVida(1);
    }
}

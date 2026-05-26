package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class PokebolaRocketFuerte extends Pokebola {

    public PokebolaRocketFuerte(float x, float y, float velocidad, Texture textura) {
        super(x, y, velocidad, textura);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego) {
        estadoJuego.quitarVida(2);
    }
}

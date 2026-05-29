package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class PokebolaCurativa extends Pokebola {

    public PokebolaCurativa(float x, float y, float velocidad, Texture textura) {
        super(x, y, velocidad, textura);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego, Tarro tarro) {
        if(estadoJuego.getVidas()< 5){
            estadoJuego.recuperarVida(1);
        }
        estadoJuego.sumarPuntos(5);
    }
}

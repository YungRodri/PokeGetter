/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puppy.code;
import com.badlogic.gdx.graphics.Texture;
/**
 *
 * @author HP
 */
public class PesoBall extends Pokebola {

    public PesoBall(float x, float y, float velocidad, Texture textura, int puntaje) {
        super(x, y, velocidad, textura, puntaje);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego, Tarro tarro) {
        // Aplicamos el buff directamente a Charmander
        tarro.aplicarDebuffVelocidad();
    }
}

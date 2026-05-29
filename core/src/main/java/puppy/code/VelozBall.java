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
public class VelozBall extends Pokebola {

    public VelozBall(float x, float y, float velocidad, Texture textura) {
        super(x, y, velocidad, textura);
    }

    @Override
    public void aplicarEfecto(EstadoJuego estadoJuego, Tarro tarro) {
        // Puedes darle unos puntos extra si quieres
        estadoJuego.sumarPuntos(15); 
        // Aplicamos el buff directamente a Charmander
        tarro.aplicarBuffVelocidad();
    }
}

package puppy.code;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Pokebola implements EfectoCaptura {

    private float x;
    private float y;
    private float velocidad;
    private Texture textura;
    private Rectangle bounds;
    private boolean eliminada;

    public Pokebola(float x, float y, float velocidad, Texture textura) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.textura = textura;
        this.bounds = new Rectangle(x, y, 64, 64);
        this.eliminada = false;
    }

    public void actualizar(float delta) {
        this.y -= velocidad * delta;
        this.bounds.setPosition(x, y);

        if (salioDePantalla()) {
            eliminar();
        }
    }

    public void dibujar(SpriteBatch batch) {
        batch.draw(textura, x, y, 64, 64);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean salioDePantalla() {
        return y + 64 < 0;
    }

    public boolean estaEliminada() {
        return eliminada;
    }

    public void eliminar() {
        this.eliminada = true;
    }
    public final void capturar(EstadoJuego estadoJuego, Tarro tarro) {
        aplicarEfecto(estadoJuego, tarro);
        eliminar();
    }
}

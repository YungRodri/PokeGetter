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
    private EstrategiaMovimiento estrategiaMovimiento;
    private int puntaje;

    public Pokebola(float x, float y, float velocidad, Texture textura, int puntaje) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.textura = textura;
        this.bounds = new Rectangle(x, y, 64, 64);
        this.eliminada = false;
        this.estrategiaMovimiento = new MovimientoNormal();
        this.puntaje = puntaje;
    }

    public int getPuntaje() { return puntaje; }

public final void actualizar(float delta) {
        estrategiaMovimiento.mover(this, delta);

        if (salioDePantalla()) {
            eliminar();
        }
    }

    public void mover(float movimientoX, float movimientoY) {
        this.x += movimientoX;
        this.y += movimientoY;

        if (this.x < 0) {
            this.x = 0;
        }

        if (this.x > 800 - 64) {
            this.x = 800 - 64;
        }

        this.bounds.setPosition(this.x, this.y);
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setEstrategiaMovimiento(EstrategiaMovimiento estrategiaMovimiento) {
        this.estrategiaMovimiento = estrategiaMovimiento;
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

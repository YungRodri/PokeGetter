package puppy.code;

import com.badlogic.gdx.math.MathUtils;

public class MovimientoZigZag implements EstrategiaMovimiento {

    private float tiempo;

    public MovimientoZigZag() {
        this.tiempo = 0;
    }

    @Override
    public void mover(Pokebola pokebola, float delta) {
        tiempo += delta;

        float movimientoX = MathUtils.sin(tiempo * 5f) * 120f * delta;
        float movimientoY = -pokebola.getVelocidad() * delta;

        pokebola.mover(movimientoX, movimientoY);
    }
}

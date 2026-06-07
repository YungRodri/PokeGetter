package puppy.code;

public class MovimientoNormal implements EstrategiaMovimiento {

    @Override
    public void mover(Pokebola pokebola, float delta) {
        pokebola.mover(0, -pokebola.getVelocidad() * delta);
    }
}

package puppy.code;

public class MovimientoRapido implements EstrategiaMovimiento {

    @Override
    public void mover(Pokebola pokebola, float delta) {
        pokebola.mover(0, -pokebola.getVelocidad() * 1.35f * delta);
    }
}

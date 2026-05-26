package puppy.code;

public class EstadoJuego {

    private int vidas;
    private int puntaje;

    public EstadoJuego() {
        this.vidas = 3;
        this.puntaje = 0;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    public void recuperarVida(int cantidad) {
        this.vidas += cantidad;
    }

    public void quitarVida(int cantidad) {
        this.vidas -= cantidad;

        if (this.vidas < 0) {
            this.vidas = 0;
        }
    }

    public boolean estaGameOver() {
        return this.vidas <= 0;
    }
}

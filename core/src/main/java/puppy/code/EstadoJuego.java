package puppy.code;

public class EstadoJuego {

    private int vidas;
    private int puntaje;
    private int vidasMaximas;

    public EstadoJuego() {
        this.vidas = 3;
        this.puntaje = 0;
        this.vidasMaximas = 5;
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

        if (this.vidas > this.vidasMaximas) {
            this.vidas = this.vidasMaximas;
        }
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

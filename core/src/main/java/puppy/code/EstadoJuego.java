package puppy.code;

public class EstadoJuego {

    private static EstadoJuego instancia;

    private int vidas;
    private int puntaje;
    private static final int vidasMaximas = 5;

    private EstadoJuego() {
        this.vidas = 3;
        this.puntaje = 0;
    }

    // 3. Método público estático para obtener la instancia
    public static EstadoJuego getInstance() {
        if (instancia == null) {
            instancia = new EstadoJuego();
        }
        return instancia;
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

        if (this.vidas > vidasMaximas) {
            this.vidas = vidasMaximas;
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
    
    // Método adicional recomendado para Singletons en juegos
    public void reiniciar() {
        this.vidas = 3;
        this.puntaje = 0;
    }
}
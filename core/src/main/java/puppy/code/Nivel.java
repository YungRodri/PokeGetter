package puppy.code;

public class Nivel {

    private int probabilidadRocketFuerte;
    private int probabilidadRocket;
    private int probabilidadCurativa;

    private float velocidadNormal;
    private float velocidadCurativa;
    private float velocidadRocket;
    private float velocidadRocketFuerte;

    private long tiempoGeneracion;

    public Nivel(int probabilidadRocketFuerte,
                 int probabilidadRocket,
                 int probabilidadCurativa,
                 float velocidadNormal,
                 float velocidadCurativa,
                 float velocidadRocket,
                 float velocidadRocketFuerte,
                 long tiempoGeneracion) {

        this.probabilidadRocketFuerte = probabilidadRocketFuerte;
        this.probabilidadRocket = probabilidadRocket;
        this.probabilidadCurativa = probabilidadCurativa;
        this.velocidadNormal = velocidadNormal;
        this.velocidadCurativa = velocidadCurativa;
        this.velocidadRocket = velocidadRocket;
        this.velocidadRocketFuerte = velocidadRocketFuerte;
        this.tiempoGeneracion = tiempoGeneracion;
    }

    public int getProbabilidadRocketFuerte() {
        return probabilidadRocketFuerte;
    }

    public int getProbabilidadRocket() {
        return probabilidadRocket;
    }

    public int getProbabilidadCurativa() {
        return probabilidadCurativa;
    }

    public float getVelocidadNormal() {
        return velocidadNormal;
    }

    public float getVelocidadCurativa() {
        return velocidadCurativa;
    }

    public float getVelocidadRocket() {
        return velocidadRocket;
    }

    public float getVelocidadRocketFuerte() {
        return velocidadRocketFuerte;
    }

    public long getTiempoGeneracion() {
        return tiempoGeneracion;
    }
}

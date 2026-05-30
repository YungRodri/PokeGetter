package puppy.code;

public class Nivel {

    private int probabilidadRocketFuerte;
    private int probabilidadRocket;
    private int probabilidadCurativa;
    private int probabilidadVeloz;
    private int probabilidadPeso;

    private float velocidadNormal;
    private float velocidadCurativa;
    private float velocidadRocket;
    private float velocidadRocketFuerte;
    private float velocidadVeloz;
    private float velocidadPeso;

    private long tiempoGeneracion;

    public Nivel(int probabilidadRocketFuerte,
                 int probabilidadRocket,
                 int probabilidadCurativa,
                 int probabilidadVeloz,
                 int probabilidadPeso,
                 float velocidadNormal,
                 float velocidadCurativa,
                 float velocidadRocket,
                 float velocidadRocketFuerte,
                 float velocidadVeloz,
                 float velocidadPeso,
                 long tiempoGeneracion) {

        this.probabilidadRocketFuerte = probabilidadRocketFuerte;
        this.probabilidadRocket = probabilidadRocket;
        this.probabilidadCurativa = probabilidadCurativa;
        this.probabilidadVeloz = probabilidadVeloz;
        this.probabilidadPeso = probabilidadPeso;
        this.velocidadNormal = velocidadNormal;
        this.velocidadCurativa = velocidadCurativa;
        this.velocidadRocket = velocidadRocket;
        this.velocidadRocketFuerte = velocidadRocketFuerte;
        this.velocidadVeloz = velocidadVeloz;
        this.velocidadPeso = velocidadPeso;
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
    
    public int getProbabilidadVeloz() {
        return probabilidadVeloz;
    }
    
    public int getProbabilidadPeso() {
        return probabilidadPeso;
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
    
    public float getVelocidadVeloz() {
        return velocidadVeloz;
    }
    
    public float getVelocidadPeso() {
        return velocidadPeso;
    }

    public long getTiempoGeneracion() {
        return tiempoGeneracion;
    }
}

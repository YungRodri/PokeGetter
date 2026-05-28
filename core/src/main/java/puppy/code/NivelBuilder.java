package puppy.code;

public class NivelBuilder {

    private int probabilidadRocketFuerte;
    private int probabilidadRocket;
    private int probabilidadCurativa;

    private float velocidadNormal;
    private float velocidadCurativa;
    private float velocidadRocket;
    private float velocidadRocketFuerte;

    private long tiempoGeneracion;

    public NivelBuilder() {
        this.probabilidadRocketFuerte = 10;
        this.probabilidadRocket = 30;
        this.probabilidadCurativa = 45;

        this.velocidadNormal = 300;
        this.velocidadCurativa = 250;
        this.velocidadRocket = 350;
        this.velocidadRocketFuerte = 420;

        this.tiempoGeneracion = 500000000;
    }

    public NivelBuilder conProbabilidadRocketFuerte(int probabilidadRocketFuerte) {
        this.probabilidadRocketFuerte = probabilidadRocketFuerte;
        return this;
    }

    public NivelBuilder conProbabilidadRocket(int probabilidadRocket) {
        this.probabilidadRocket = probabilidadRocket;
        return this;
    }

    public NivelBuilder conProbabilidadCurativa(int probabilidadCurativa) {
        this.probabilidadCurativa = probabilidadCurativa;
        return this;
    }

    public NivelBuilder conVelocidadNormal(float velocidadNormal) {
        this.velocidadNormal = velocidadNormal;
        return this;
    }

    public NivelBuilder conVelocidadCurativa(float velocidadCurativa) {
        this.velocidadCurativa = velocidadCurativa;
        return this;
    }

    public NivelBuilder conVelocidadRocket(float velocidadRocket) {
        this.velocidadRocket = velocidadRocket;
        return this;
    }

    public NivelBuilder conVelocidadRocketFuerte(float velocidadRocketFuerte) {
        this.velocidadRocketFuerte = velocidadRocketFuerte;
        return this;
    }

    public NivelBuilder conTiempoGeneracion(long tiempoGeneracion) {
        this.tiempoGeneracion = tiempoGeneracion;
        return this;
    }

    public Nivel build() {
        return new Nivel(
            probabilidadRocketFuerte,
            probabilidadRocket,
            probabilidadCurativa,
            velocidadNormal,
            velocidadCurativa,
            velocidadRocket,
            velocidadRocketFuerte,
            tiempoGeneracion
        );
    }
}

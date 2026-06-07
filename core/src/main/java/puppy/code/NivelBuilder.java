package puppy.code;

public class NivelBuilder {

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

    public NivelBuilder() {
        this.probabilidadRocketFuerte = 10;
        this.probabilidadRocket = 30;
        this.probabilidadCurativa = 40;
        this.probabilidadVeloz = 45;
        this.probabilidadPeso = 50;

        this.velocidadNormal = 300;
        this.velocidadCurativa = 250;
        this.velocidadRocket = 350;
        this.velocidadRocketFuerte = 420;
        this.velocidadVeloz = 420;
        this.velocidadPeso = 420;

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
    
    public NivelBuilder conProbabilidadVeloz(int probabilidadVeloz) {
        this.probabilidadVeloz = probabilidadVeloz;
        return this;
    }
    
    public NivelBuilder conProbabilidadPeso(int probabilidadPeso) {
        this.probabilidadPeso = probabilidadPeso;
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
    
    public NivelBuilder conVelocidadVeloz(float velocidadVeloz) {
        this.velocidadVeloz = velocidadVeloz;
        return this;
    }
    
    public NivelBuilder conVelocidadPeso(float velocidadPeso) {
        this.velocidadPeso = velocidadPeso;
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
            probabilidadVeloz,
            probabilidadPeso,
            velocidadNormal,
            velocidadCurativa,
            velocidadRocket,
            velocidadRocketFuerte,
            velocidadVeloz,
            velocidadPeso,
            tiempoGeneracion
        );
    }
}

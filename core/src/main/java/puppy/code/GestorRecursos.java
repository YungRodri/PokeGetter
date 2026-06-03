package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class GestorRecursos {

    // 1. La única instancia de la clase (Singleton)
    private static GestorRecursos instancia;

    // 2. Declaración explícita de CADA recurso de tu juego
    private Texture texturaPokebolaNormal;
    private Texture texturaPokebolaRocket;
    private Texture texturaPokebolaRocketFuerte;
    private Texture texturaPokebolaCurativa;
    private Texture texturaPokebolaVeloz;
    private Texture texturaPokebolaPeso;
    private Texture texturaTarro;
    
    // Constructor privado
    private GestorRecursos() {
        // Se cargan todos los recursos obligatoriamente al instanciar el gestor
        texturaPokebolaNormal = new Texture("drop.png");
        texturaPokebolaRocket = new Texture("dropBad.png");
        texturaPokebolaRocketFuerte = new Texture("dropRocketStrong.png");
        texturaPokebolaCurativa = new Texture("dropHeal.png");
        texturaPokebolaVeloz = new Texture("dropSpeed.png");
        texturaPokebolaPeso = new Texture("dropSlow.png");
        texturaTarro = new Texture("bucket.png");
    }

    // 3. Método de acceso global
    public static GestorRecursos getInstance() {
        if (instancia == null) {
            instancia = new GestorRecursos();
        }
        return instancia;
    }

    // 4. Métodos Getters específicos para cada recurso
    public Texture getTexturaPokebolaNormal() {
        return texturaPokebolaNormal;
    }
    
    public Texture getTexturaPokebolaRocket() {
        return texturaPokebolaRocket;
    }
    
    public Texture getTexturaPokebolaRocketFuerte() {
        return texturaPokebolaRocketFuerte;
    }

    public Texture getTexturaPokebolaCurativa() {
        return texturaPokebolaCurativa;
    }
    
    public Texture getTexturaPokebolaVeloz() {
        return texturaPokebolaVeloz;
    }
    
    public Texture getTexturaPokebolaPeso() {
        return texturaPokebolaPeso;
    }

    public Texture getTexturaTarro() {
        return texturaTarro;
    }

    // 5. Método para liberar memoria
    public void liberarRecursos() {
        if (texturaPokebolaNormal != null) texturaPokebolaNormal.dispose();
        if (texturaPokebolaRocket != null) texturaPokebolaRocket.dispose();
        if (texturaPokebolaRocketFuerte != null) texturaPokebolaRocketFuerte.dispose();
        if (texturaPokebolaCurativa != null) texturaPokebolaCurativa.dispose();
        if (texturaPokebolaVeloz != null) texturaPokebolaVeloz.dispose();
        if (texturaPokebolaPeso != null) texturaPokebolaPeso.dispose();
        if (texturaTarro != null) texturaTarro.dispose();
    }
}
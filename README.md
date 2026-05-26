# PokeGetter

Proyecto de videojuego desarrollado en Java con LibGDX para la asignatura Programación Avanzada.

## Descripción

PokeGetter es un juego basado en la mecánica de atrapar objetos que caen desde la parte superior de la pantalla. El jugador controla a Charmander y debe atrapar pokebolas positivas, evitando las pokebolas negativas del equipo Rocket.

## Mecánicas implementadas

- Pokebola normal: suma puntos.
- Pokebola curativa: recupera vida.
- Pokebola Rocket: quita vida.
- Pokebola Rocket fuerte: quita más vida.
- Sistema de puntaje.
- Sistema de vidas.
- Pantalla de pausa.
- Pantalla de Game Over.
- Sprites personalizados.

## Requisitos técnicos aplicados

- Clase abstracta `Pokebola`.
- Interfaz `EfectoCaptura`.
- Uso de polimorfismo mediante `aplicarEfecto`.
- Patrón Template Method mediante el método `capturar`.
- Proyecto desarrollado en Java con LibGDX.

## Ejecución

Para ejecutar el proyecto desde terminal:

```bash
.\gradlew.bat lwjgl3:run

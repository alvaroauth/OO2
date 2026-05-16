package ejercicio18;

import ejercicio18.Armaduras.*;
import ejercicio18.Armas.*;

import java.util.List;

public class FabricaPersonajes {
    public Personaje crearGuerrero(String nom){
        return new Personaje(
                nom,
                new Espada(),
                new Acero(),
                List.of(new Habilidad("Cuerpo a Cuerpo"))
        );
    }

    public Personaje crearArquero(String nom){
        return new Personaje(
                nom,
                new Arco(),
                new Cuero(),
                List.of(new Habilidad("Combate a Distancia"))
        );
    }

    public Personaje crearMago(String nom){
        return new Personaje(
                nom,
                new Baston(),
                new Cuero(),
                List.of(new Habilidad("Magia"), new Habilidad("Combate a Distancia"))
        );
    }
}

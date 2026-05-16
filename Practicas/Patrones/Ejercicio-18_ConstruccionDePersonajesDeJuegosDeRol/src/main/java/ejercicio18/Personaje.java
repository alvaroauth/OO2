package ejercicio18;

import ejercicio18.Armaduras.Armadura;
import ejercicio18.Armas.Arma;

import java.util.List;

public class Personaje {
    private String nombre;
    private int vida = 100;
    private Arma arma;
    private Armadura armadura;
    private List<Habilidad> habilidades;

    public Personaje(String nombre, Arma arma, Armadura armadura, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.arma = arma;
        this.armadura = armadura;
        this.habilidades = habilidades;
    }

    public void pelearContra(Personaje defensor) {
        if (!this.puedeCombatir() || !defensor.puedeCombatir())
            throw new IllegalStateException("Uno de los dos jugadores no puede combatir");

        defensor.perderVida(defensor.getArmadura().recibirDanio(this.getArma()));
    }

    protected void perderVida(int vida){
        this.vida -= vida;
    }

    protected boolean puedeCombatir(){
        return this.vida > 0;
    }

    public Arma getArma() {
        return arma;
    }

    public Armadura getArmadura() {
        return armadura;
    }
}

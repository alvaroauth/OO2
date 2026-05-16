package ejercicio05;

public class TablaPeriodica {
    public Atomo hidrogeno() { return new Atomo("Hidrógeno", "H",  1, +1, false); }
    public Atomo oxigeno()   { return new Atomo("Oxígeno",   "O", 16, -2, false); }
    public Atomo cloro()     { return new Atomo("Cloro",     "Cl",35, -1, false); }
    public Atomo sodio()     { return new Atomo("Sodio",     "Na",23, +1, true);  }
    public Atomo calcio()    { return new Atomo("Calcio",    "Ca",40, +2, true);  }
}

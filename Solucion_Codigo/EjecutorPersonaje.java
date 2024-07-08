public class EjecutorPersonaje {
    public static void main(String[] args) {
        Personaje guerrero = new Guerreros("Basico Cargado", 75.0, 300000.0, 3000.0);
        Personaje mago = new Magos("Hegida del Sol", 450.0, 150000.0, 1500.0);
        Personaje arquero = new Arqueros("Basico Potenciado", 100.0, 400000.0, 1200.0);

        System.out.println("===============");
        System.out.println("Guerrero stats");
        System.out.println("===============");
        System.out.println("Ataque: " + guerrero.ataque());
        System.out.println("Defensa: " + guerrero.defensa());
        System.out.println("Caracteristicas Principales:");
        System.out.println(guerrero);
        System.out.println();

        System.out.println("===============");
        System.out.println("Mago stats");
        System.out.println("===============");
        System.out.println("Ataque: " + mago.ataque());
        System.out.println("Defensa: " + mago.defensa());
        System.out.println("Caracteristicas Principales:");
        System.out.println(mago);
        System.out.println();

        System.out.println("===============");
        System.out.println("Arquero stats");
        System.out.println("===============");
        System.out.println("Ataque: " + arquero.ataque());
        System.out.println("Defensa: " + arquero.defensa());
        System.out.println("Caracteristicas Principales:");
        System.out.println(arquero);
        System.out.println();

       
        System.out.println("\nSimulando batallas...\n");
        System.out.println("Batalla entre " + guerrero.tipo() + " y " + mago.tipo());
        determinarGanador(guerrero, mago);

        System.out.println("Batalla entre " + mago.tipo() + " y " + arquero.tipo());
        determinarGanador(mago, arquero);

        System.out.println("Batalla entre " + arquero.tipo() + " y " + guerrero.tipo());
        determinarGanador(arquero, guerrero);
    }

    public static void determinarGanador(Personaje p1, Personaje p2) {
        int resultadoP1 = p1.ataque() - p2.defensa();
        int resultadoP2 = p2.ataque() - p1.defensa();

        if (resultadoP1 > resultadoP2) {
            System.out.println("El ganador es: " + p1.tipo());
            p1.aumentarNivelxWin();
            System.out.println("Nuevo nivel de XP de " + p1.tipo() + ": " + p1.nivelXP);
        } else if (resultadoP2 > resultadoP1) {
            System.out.println("El ganador es: " + p2.tipo());
            p2.aumentarNivelxWin();
            System.out.println("Nuevo nivel de XP de " + p2.tipo() + ": " + p2.nivelXP);
        } else {
            System.out.println("La batalla terminó en empate.");
        }
        System.out.println();
    }
}

abstract class Personaje {
    public double nivelXP;
    public double vidaMaxima;

    public Personaje(double nivelXP, double vidaMaxima) {
        this.nivelXP = nivelXP;
        this.vidaMaxima = vidaMaxima;
    }

    public abstract int ataque();
    public abstract int defensa();
    public abstract String tipo();

    public void aumentarNivelxWin() {
        
       // Cambiar valores de la xp que se gana
        this.nivelXP += 100000; 
    }

    @Override
    public String toString() {
        return "Nivel XP: " + nivelXP + ", Vida Maxima: " + vidaMaxima;
    }
}

class Guerreros extends Personaje {
    public String HabsCuerpoaCuerpo;
    public double nivelFuerza;

    public Guerreros(String HabsCuerpoaCuerpo, double nivelFuerza, double nivelXP, double vidaMaxima) {
        super(nivelXP, vidaMaxima);
        this.HabsCuerpoaCuerpo = HabsCuerpoaCuerpo;
        this.nivelFuerza = nivelFuerza;
    }

    @Override
    public int ataque() {
        return 75;
    }

    @Override
    public int defensa() {
        return 250;
    }

    @Override
    public String tipo() {
        return "Guerrero";
    }

    @Override
    public String toString() {
        return "Guerreros{" + "HabsCuerpoaCuerpo=" + HabsCuerpoaCuerpo + ", nivelFuerza=" + nivelFuerza + ", " + super.toString() + '}';
    }
}

class Magos extends Personaje {
    public String Hechizos;
    public double nivelPoderMagico;

    public Magos(String Hechizos, double nivelPoderMagico, double nivelXP, double vidaMaxima) {
        super(nivelXP, vidaMaxima);
        this.Hechizos = Hechizos;
        this.nivelPoderMagico = nivelPoderMagico;
    }

    @Override
    public int ataque() {
        return 200;
    }

    @Override
    public int defensa() {
        return 76;
    }

    @Override
    public String tipo() {
        return "Mago";
    }

    @Override
    public String toString() {
        return "Magos{" + "Hechizos=" + Hechizos + ", nivelPoderMagico=" + nivelPoderMagico + ", " + super.toString() + '}';
    }
}

class Arqueros extends Personaje {
    public String HabiliadesArquero;
    public double nivelPresicion;

    public Arqueros(String HabiliadesArquero, double nivelPresicion, double nivelXP, double vidaMaxima) {
        super(nivelXP, vidaMaxima);
        this.HabiliadesArquero = HabiliadesArquero;
        this.nivelPresicion = nivelPresicion;
    }

    @Override
    public int ataque() {
        return 250;
    }

    @Override
    public int defensa() {
        return 65;
    }

    @Override
    public String tipo() {
        return "Arquero";
    }

    @Override
    public String toString() {
        return "Arqueros{" + "HabiliadesArquero=" + HabiliadesArquero + ", nivelPresicion=" + nivelPresicion + ", " + super.toString() + '}';
    }
}

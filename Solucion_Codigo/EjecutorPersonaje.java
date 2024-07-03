
import java.util.ArrayList;
public class EjecutorPersonaje {
    public static void main(String[] args) {
        Personaje guerrero = new Guerreros("Basico Cargado", 75.0, 300000.0, 3000.0);
        Personaje mago = new Magos("Hegida del Sol", 450.0, 150000.0, 1500.0);
        Personaje arquero = new Arqueros("Basico Potenciado", 100.0, 400000.0, 1200.0);
        System.out.println("===============");
        System.out.println("Guerreros stats");
        System.out.println("===============");
        System.out.println("Ataque: " +guerrero.ataque());
        System.out.println("Defensa: "+guerrero.defensa());
        System.out.println("Caracteristicas Principales:");
        System.out.println(guerrero);
        System.out.println(" ");
        System.out.println("===============");
        System.out.println("Mago stats");
        System.out.println("===============");
        System.out.println("Ataque: " +mago.ataque());
        System.out.println("Defensa: "+mago.defensa());
        System.out.println("Caracteristicas Principales:");
        System.out.println(mago);
        System.out.println(" ");
        System.out.println("===============");
        System.out.println("Arquero stats");
        System.out.println("===============");
        System.out.println("Ataque: " +arquero.ataque());
        System.out.println("Defensa: "+arquero.defensa());
        System.out.println("Caracteristicas Principales:");
        System.out.println(arquero);
    }
}
abstract class Personaje{
    public double nivelXP;
    public double vidaMaxima;
    public abstract int ataque();
    public abstract int defensa();

    public Personaje(double nivelXP, double vidaMaxima) {
        this.nivelXP = nivelXP;
        this.vidaMaxima = vidaMaxima;
    }
    public void CrearPersonaje(){    
    } 
    public void aumentarNivelxWin(){       
    }
    public void asignarPuntuacionBatalla(){
    }
}
class Guerreros extends Personaje{  
    public String HabsCuerpoaCuerpo;
    public double nivelFuerza;
    public int ataque(){
    return 75;
    }   
    public int defensa(){
    return 250;
    }  
    public Guerreros(String HabsCuerpoaCuerpo, double nivelFuerza, double nivelXP, double vidaMaxima) {
        super(nivelXP, vidaMaxima);
        this.HabsCuerpoaCuerpo = HabsCuerpoaCuerpo;
        this.nivelFuerza = nivelFuerza;
    }

    @Override
    public String toString() {
        return "Guerreros{" + "HabsCuerpoaCuerpo=" + HabsCuerpoaCuerpo + ", nivelFuerza=" + nivelFuerza + '}';
    }
   
    
}
class Magos extends Personaje{
    public String Hechizos;
    public double nivelPoderMagico;
    public int ataque(){
    return 200;
    }   
    public int defensa(){
    return 76;
    } 
    public Magos(String Hechizos, double nivelPoderMagico, double nivelXP, double vidaMaxima) {
        super(nivelXP, vidaMaxima);
        this.Hechizos = Hechizos;
        this.nivelPoderMagico = nivelPoderMagico;
    }

    @Override
    public String toString() {
        return "Magos{" + "Hechizos=" + Hechizos + ", nivelPoderMagico=" + nivelPoderMagico + '}';
    }
    
}
class Arqueros extends Personaje{
    public String HabiliadesArquero;
    public double nivelPresicion;
     public int ataque(){
    return 250;
    }   
    public int defensa(){
    return 65;
    } 

    public Arqueros(String HabiliadesArquero, double nivelPresicion, double nivelXP, double vidaMaxima) {
        super(nivelXP, vidaMaxima);
        this.HabiliadesArquero = HabiliadesArquero;
        this.nivelPresicion = nivelPresicion;
    }

    @Override
    public String toString() {
        return "Arqueros{" + "HabiliadesArquero=" + HabiliadesArquero + ", nivelPresicion=" + nivelPresicion + '}';
    }
    
}


import java.util.ArrayList;

public class Problema_2_CuentaEjecutor {
    public static void main(String[] args) {
        // establecer menus
        Menu menuCarta=new MenuCarta(2,3.20,10,"Bandeja 2",10);
        Menu menuDia=new MenuDia(1.5,1,"encebollado",3);
        Menu menuNinos=new MenuNinos(1,2,"pizza",5);
        Menu menuEconomico=new MenuEconomico(10,"seco de pollo",2.5);
        ArrayList<Menu> listMenu=new ArrayList<Menu>();
        //establecer valores
        menuCarta.calcularMenuF();
        menuDia.calcularMenuF();
        menuNinos.calcularMenuF();
        menuEconomico.calcularMenuF();
        //anadir menus
        listMenu.add(menuDia);
        listMenu.add(menuCarta);
        listMenu.add(menuEconomico);
        listMenu.add(menuNinos);
        //establecer cuenta
        Cuenta cuenta = new Cuenta("alberto",listMenu,12);
        System.out.println("estabrecer menus");
        cuenta.calcularVC();
        //ijmprimir
        System.out.println(cuenta);
        
    }
    
}
class Cuenta  {
    public String nombreClienete;
    public ArrayList<Menu> listMenu;
    public double valorCancelar;
    public double subTotal;
    public int iva;

    public Cuenta(String nombreClienete, ArrayList<Menu> listMenu, int iva) {
        this.nombreClienete = nombreClienete;
        this.listMenu = listMenu;
        this.iva = iva;
    }
    
    public void calcularVC (){
        for(Menu menu:listMenu){
            this.subTotal+=menu.valorMenu;
        }
        double tem=this.subTotal*this.iva/100;
        this.valorCancelar=this.subTotal+tem;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "nombreClienete=" + nombreClienete + ", listMenu=" + listMenu + ", valorCancelar=" + valorCancelar + ", subTotal=" + subTotal + ", iva=" + iva + "";
    }
    
}
abstract class Menu {
    public String nombrePlato;
    public double valorMenu;
    public double valorInicialMenu;

    public Menu(String nombrePlato, double valorInicialMenu) {
        this.nombrePlato = nombrePlato;
        this.valorInicialMenu = valorInicialMenu;
    }
   
    abstract void calcularMenuF();

    @Override
    public String toString() {
        return  "nombrePlato=" + nombrePlato + ", valorMenu=" + this.valorMenu+ ", valorInicialMenu=" + valorInicialMenu + '}';
    }
}
//--------------------------------------------------------------------------------------------------------
class MenuCarta extends Menu{
    public double valorPGuarnicion;
    public double valorBebida;
    public double porcentajeAServision;
    public MenuCarta(double valorPGuarnicion, double valorBebida, double porcentajeAServision, String nombrePlato, double valorInicialMenu) {
        super(nombrePlato, valorInicialMenu);
        this.valorPGuarnicion = valorPGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeAServision = porcentajeAServision;
    }
    public void calcularMenuF(){
        this.porcentajeAServision=this.valorInicialMenu*(this.porcentajeAServision/100);
        this.valorMenu=this.valorBebida+this.valorPGuarnicion+this.valorInicialMenu+this.porcentajeAServision;
    }
    @Override
    public String toString() {
        return "\n MenuCarta{"+super.toString() + "valorPGuarnicion=" + valorPGuarnicion + ", valorBebida=" + valorBebida + ", AServision=" + porcentajeAServision + '}';
    }   
}
//--------------------------------------------------------------------------------------------------------
class MenuDia extends Menu{
    public double valorPostre;
    public double valorBebida;
    public MenuDia(double valorPostre, double valorBebida, String nombrePlato, double valorInicialMenu) {
        super(nombrePlato, valorInicialMenu);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    } 
    public void calcularMenuF(){
        this.valorMenu=valorPostre+this.valorBebida+this.valorInicialMenu;
    }
    @Override
    public String toString() {
        return "\n MenuDia{"+super.toString() + "valorPostre=" + valorPostre + ", valorBebida=" + valorBebida + '}';
    }   
}
//--------------------------------------------------------------------------------------------------------
class MenuNinos extends Menu{
    public double valorPHelado;
    public double valorPPatel;
    public MenuNinos(double valorPHelado, double valorPPatel, String nombrePlato, double valorInicialMenu) {
        super(nombrePlato, valorInicialMenu);
        this.valorPHelado = valorPHelado;
        this.valorPPatel = valorPPatel;
    }
    public void calcularMenuF(){
        this.valorMenu=this.valorPPatel+this.valorPHelado+this.valorInicialMenu;
    }
    @Override
    public String toString() {
        return "\n MenuNinos{" +super.toString()+ "valorPHelado=" + valorPHelado + ", valorPPatel=" + valorPPatel + '}';
    }   
}
//--------------------------------------------------------------------------------------------------------
class MenuEconomico extends Menu{
    public double porcentajeDescuento;

    public MenuEconomico(double porcentajeDescuento, String nombrePlato, double valorInicialMenu) {
        super(nombrePlato, valorInicialMenu);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void calcularMenuF(){
        this.porcentajeDescuento=this.valorInicialMenu*(this.porcentajeDescuento/100);
        this.valorMenu=this.valorInicialMenu-this.porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "\n MenuEconomico{" +super.toString()+ "Descuento=" + porcentajeDescuento + '}';
    }
    
}

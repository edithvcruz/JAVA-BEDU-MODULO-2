package Ejemplo1;
public class CajaMisteriosaMain{
    //[] o ... es exactamente lo mismo
    // args argumnetos
    //
    public static void main (String[]args){

     CajaMisteriosa<String>cajita=new CajaMisteriosa<>();
     cajita.guardar ("Hola Mundo");
     String valor=cajita.sacar();

     System.out.println("El valor de la caja es _=->"+valor);
    }

}
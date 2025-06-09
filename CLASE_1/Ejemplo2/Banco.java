package Ejemplo2;

import java.util.List;

public class Banco {

    //? se utilza cuando el cogico no usa nada especifico de la cllase objetivo
    public static void verCuentas(List<?> cuentas){

        for (Object o : cuentas){
       //object para que sea lo mas general
       //to String es llamado internamente por printIn
       //to String/hascode es parte de Object

            System.out.println(o);
        }

    }
        
    
    public static void verTitulares(List<? extends CuentaBancaria >cuentas){
    //List <? extends Cuenta Bancaria permite que se use cuenta Bancaria o cualquiera de sus clases hijas
   //LECTURA-extends
    //Upper Bounded Wilcard

    for (CuentaBancaria o: cuentas){
    System.out.println(o.getTitular());
    }
}


    public static void depositarCuentas (List <? super CuentaDebito> cuentas){
    //Lower Bounded Wilcard
    //Acceso a clase o a los padres de esa clase
    //ESCRITURA-super
    for (Object o :cuentas){
        if (o instanceof CuentaBancaria){
          ((CuentaBancaria) o). depositar(100);
        }
    }

    }
}
    

    

    


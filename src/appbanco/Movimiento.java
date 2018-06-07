/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbanco;

/**
 *
 * @author User
 */
public class Movimiento extends Thread{
    float a_monto;
    CuentaBanco a_cta;
    int a_tiempo;
    public Movimiento(CuentaBanco p_cta, float p_monto, int p_tiempo)
    {
     a_cta=p_cta;
     a_monto=p_monto;
     a_tiempo=p_tiempo;
    }
    @Override
    public void run()
    {
     try
     {  
     if (this.getName().toString().equals("Thread-0"))
     { 
         //sleep(500);
         a_cta.setC1(0);
         System.out.println("Hilo0"); 
         while ( a_cta.getC2() == 0 ) 
         {
             System.out.println("h 0-Point 1");
             if (a_cta.getAcceso() == 2)
             {
                 while (a_cta.getAcceso() == 2) { a_cta.setC1(1);}
                 a_cta.setC1(0);
             }
             System.out.println("h 0 -Point 2");
         }
     }
     
     if (this.getName().toString().equals("Thread-1"))
     { 
         
         a_cta.setC2(0);
         System.out.println("Hilo1");
          while ( a_cta.getC1() == 0 ) 
         {
             System.out.println("h 1 -Point 1");
             if (a_cta.getAcceso() == 1)
             {
                 while (a_cta.getAcceso()==1) { 
                     System.out.println("Valor bucle -1 :" +a_cta.getAcceso());
                     a_cta.setC2(1); }
                 a_cta.setC2(0);
             }
             System.out.println("h 1 -Point 2");
         }
     }
     System.out.println(this.getName()); 
     System.out.println("Acceso :" +a_cta.getAcceso()); 
     // Danger Zone :u
     float saldo= a_cta.obtenerSaldo();//---obtiene saldo anterior
     System.out.println("saldo actual : "+saldo);
     sleep(a_tiempo); //--la cajera cuenta el dinero
     System.out.println("actualizando cuenta: "+a_monto);
     saldo=saldo+a_monto; //--obtiene nuevo saldo
     a_cta.actualizarSaldo(saldo);
     System.out.println("nuevo saldo: "+saldo);
     
     if (this.getName().toString().equals("Thread-0")) { a_cta.setC1(1); a_cta.setAcceso(2);}
     if (this.getName().toString().equals("Thread-1")) { a_cta.setC2(1); a_cta.setAcceso(1);}
     
     System.out.println("Acceso_Sal :" +a_cta.getAcceso());
    }
     catch(InterruptedException e)
    {
    }
    }

    
}

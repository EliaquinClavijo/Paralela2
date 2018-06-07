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
public class AppBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CuentaBanco cuenta= new CuentaBanco();
        Movimiento abono = new Movimiento(cuenta, 500,400);
        Movimiento cargo = new Movimiento(cuenta, -300,300);
        abono.start();
        cargo.start();
        try
        {
        abono.join();
        cargo.join();
        }
        catch(InterruptedException e)
        {}
        System.out.println("Saldo = "+cuenta.obtenerSaldo());
    }
    
}

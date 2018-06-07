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
public class CuentaBanco {
    int C1;
    int C2;
    int Acceso;

    public int getC1() {
        return C1;
    }

    public void setC1(int C1) {
        this.C1 = C1;
    }

    public int getC2() {
        return C2;
    }

    public void setC2(int C2) {
        this.C2 = C2;
    }

    public int getAcceso() {
        return Acceso;
    }

    public void setAcceso(int Acceso) {
        this.Acceso = Acceso;
    }
    
    public static float a_CtaBan;
    public CuentaBanco()
    {
        C1= 1;
        C2 = 1;
        Acceso = 1;
    a_CtaBan=0;
    }
    //--devuelve el saldo actual de la cuenta
    public static float obtenerSaldo()
    {
    return a_CtaBan;
    }
    //-- actualiza el valor de la cuenta
    public static void actualizarSaldo(float nuevoSaldo)
    {
    a_CtaBan= nuevoSaldo;
    }

}

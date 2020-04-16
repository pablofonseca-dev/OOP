package cr.ac.ucenfotec.TL;

import cr.ac.ucenfotec.BL.*;
import cr.ac.ucenfotec.DL.Banco;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {

    Banco objBanco;

    public Controller(){
        objBanco = new Banco();
    }

    public boolean validarExistenciaCliente(String identificacion){
        return objBanco.validarExistenciaCliente(identificacion);
    }

    public boolean validarExistenciaCuenta(int numeroCuenta){
        return objBanco.validarExistenciaCuentaBancaria(numeroCuenta);
    }

    public void registrarCliente(String nombre, String primerApellido, String segundoApellido,
                                    String identificacion, String detalleDireccion){
        Cliente objCliente = new Cliente(
                nombre,
                primerApellido,
                segundoApellido,
                identificacion,
                detalleDireccion
        );

        objBanco.registrarCliente(objCliente);
    }

    public boolean registrarCuentaCorriente(String identificacion){
        if(this.validarExistenciaCliente(identificacion)){
            CuentaCorriente cuentaCorriente = new CuentaCorriente();
            objBanco.registrarCuentaBancaria(identificacion, cuentaCorriente);
            return true;
        }
        return false;
    }

    public boolean registrarCuentaAhorro(String identificacion){
        if(this.validarExistenciaCliente(identificacion)){
            CuentaAhorro cuentaAhorro = new CuentaAhorro();
            objBanco.registrarCuentaBancaria(identificacion, cuentaAhorro);
            return true;
        }
        return false;
    }

    public boolean registrarCuentaAhorroProgramado(String identificacion){
        if(this.validarExistenciaCliente(identificacion)){
                CuentaAhorroProgramado cuentaAhorro = new CuentaAhorroProgramado();
                objBanco.registrarCuentaBancaria(identificacion, cuentaAhorro);
                return true;
        }
        return false;
    }


    public ArrayList<String> obtenerClientesRegistrados(){
        ArrayList<String> clientesRegistrados = new ArrayList<>();
        for(Cliente e: objBanco.obtenerClientes()){
            clientesRegistrados.add(e.toString());
        }
        return clientesRegistrados;
    }

    public ArrayList<String> obtenerCuentasRegistradas(){
        ArrayList<String> cuentasRegistradas = new ArrayList<>();
        for(CuentaBancaria e: objBanco.obtenerCuentasBancarias()){
            cuentasRegistradas.add(e.toString());
        }
        return cuentasRegistradas;
    }

    public boolean realizarDepositoBancario(int numeroCuenta, String descripcion, double monto){
        if(this.validarExistenciaCuenta(numeroCuenta)) {
            TransaccionBancaria deposito = new DepositoBancario(descripcion, monto);
            return objBanco.realizarTransaccion(numeroCuenta, deposito);
        }
        return false;
    }

    public boolean realizarRetiroBancario(int numeroCuenta, String descripcion, double monto){
        if(this.validarExistenciaCuenta(numeroCuenta)) {
            TransaccionBancaria retiro = new RetiroBancario(descripcion, monto);
            return objBanco.realizarTransaccion(numeroCuenta, retiro);
        }
        return false;
    }

    public String obtenerDatosCliente(String identificacion){
        if(this.validarExistenciaCliente(identificacion)){
            return objBanco.obtenerDatosCliente(identificacion);
        }else{
            return null;
        }
    }




}

package cr.ac.ucenfotec.DL;


import cr.ac.ucenfotec.BL.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que se va a encargar de realizar todas las operaciones necesarias relacionadas con la persistencia de la
 * información, en memoria y también en archivos locales.
 */
public class Banco {

    //Buffer que escribe los datos en un archivo específico.
    private BufferedWriter bufferedWriter;

    //File Writer que se le implementará al BufferedWriter
    private FileWriter writer;

    //Buffer que lee los datos de un archivo específico.
    private BufferedReader bufferedReader;

    //Buffer que se le implementará al BufferedReader
    private FileReader reader;

    //ArrayList temporal que almacenará los datos de los usuarios en memoria.
    private ArrayList<CuentaBancaria> cuentasBancarias;

    //ArrayList temporal que almacenará los datos de los materiales en memoria.
    private ArrayList<Cliente> clientes;

    //URL de los ficheros que se van a utilizar en el programa.
    public static final String URL_CUENTAS_CSV = "src/cr/ac/ucenfotec/CSV/CUENTAS.csv";
    public static final String URL_CLIENTES_CSV = "src/cr/ac/ucenfotec/CSV/CLIENTES.csv";

    public Banco() {
        //Se inicializan los objetos necesarios.
        this.bufferedWriter = null;
        this.writer = null;

        this.bufferedReader = null;
        this.reader = null;

        this.cuentasBancarias = new ArrayList<>();
        this.clientes = new ArrayList<>();

        //Automáticamente se carga la información en Objetos de los clientes y de los bancos registrados en el
        // archivo CSV de cada uno.
        this.cargarCuentasBancariasCSV();
        this.cargarClientesCSV();

    }

    /**
     * TODO: Registra un cliente del banco y lo guarda en un archivo CSV.
     * @param objCliente: Objeto de tipo Cliente que se va a utilizar para registrar.
     */
    public void registrarCliente(Cliente objCliente){
        try{
            this.writer = new FileWriter(new File(Banco.URL_CLIENTES_CSV), true);
            this.bufferedWriter = new BufferedWriter(this.writer);

            bufferedWriter.write(objCliente.toCSVString());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();

            this.clientes.add(objCliente);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO: Método que carga los clientes registrados en el archivo CSV a la lista.
     * @return ArrayList Collection de tipo Cliente con la información de todos los clientes registrados.
     */
    private void cargarClientesCSV(){
        try{
            this.reader = new FileReader(Banco.URL_CLIENTES_CSV);
            this.bufferedReader = new BufferedReader(this.reader);

            HashMap<String, String> hMap = new HashMap<>();

            String[] commaDivision;
            String data;

            while((data = bufferedReader.readLine()) != null){

                commaDivision = data.split(",");

                String[] colonDivision;

                //In Line
                for(int i = 0; i < commaDivision.length; i++){
                    colonDivision = commaDivision[i].split(":");
                    hMap.put(colonDivision[0], colonDivision[1]);
                }

                //Create the object
                Cliente tempCliente = new Cliente(
                  hMap.get("Nombre"),
                  hMap.get("PrimerApellido"),
                  hMap.get("SegundoApellido"),
                  hMap.get("Identificacion"),
                  hMap.get("DetalleDireccion")
                );

                this.clientes.add(tempCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * TODO: Valida que no exista un usuario en el archivo CSV que tenga la misma identificación.
     * @param identificacion: Identificación con la que se va a comparar.
     * @return true si el usuario existe o false si no existe un usuario con esa identificación.
     */
    public boolean validarExistenciaCliente(String identificacion){
        if(new File(Banco.URL_CLIENTES_CSV).exists()) {
            try {
                this.reader = new FileReader(new File(Banco.URL_CLIENTES_CSV));
                this.bufferedReader = new BufferedReader(this.reader);
                String[] array;
                String line_data;
                String[] arr;
                while ((line_data = bufferedReader.readLine()) != null) {
                    array = line_data.split(",");
                    arr = array[3].split(":");
                    if (arr[1].equals(identificacion)) {
                        return true;
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Método que se encarga de registrar una cuenta bancaria, se necesita un cliente existente.
     * Este método solo le agrega al objeto de tipo Cliente la asociación correspondiente.
     * Cuando el programa finaliza su ejecución, el enlace deja de existir, pero la cuenta se almacena en el archivo
     * CSV, por lo que pueden listarse sin problema.
     * @param identificacionUsuario: Identificación del usuario al que se le va a enlazar la cuenta bancaria.
     * @param objCuentaBancaria: Objeto de tipo CuentaBancaria.
     * @return true si se pudo registrar la cuenta bancaria en el archivo CSV y si se pudo asociar a un usuario.
     * * *
     * *
     */
    public boolean registrarCuentaBancaria(String identificacionUsuario, CuentaBancaria objCuentaBancaria){
        try{
            for(Cliente e: clientes) {
                if (e.getIdentificacion().equals(identificacionUsuario)) {
                    this.writer = new FileWriter(new File(Banco.URL_CUENTAS_CSV), true);
                    this.bufferedWriter = new BufferedWriter(this.writer);
                    bufferedWriter.write(objCuentaBancaria.toCSVString());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    //Se agrega la cuenta para el cliente.
                    e.agregarCuentaBancaria(objCuentaBancaria);
                    //Se carga al Collection.
                    this.cuentasBancarias.add(objCuentaBancaria);
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Método que almacena objetos de tipo CuentaBancaria con la información registrada en el archivo CSV de las
     * cuentas.
     */
    private void cargarCuentasBancariasCSV(){
        try{
            this.reader = new FileReader(Banco.URL_CUENTAS_CSV);
            this.bufferedReader = new BufferedReader(this.reader);

            HashMap<String, String> hMap = new HashMap<>();

            String[] commaDivision;
            String data;

            while((data = bufferedReader.readLine()) != null){

                commaDivision = data.split(",");

                String[] colonDivision;

                //In Line
                for(int i = 0; i < commaDivision.length; i++){
                    colonDivision = commaDivision[i].split(":");
                    hMap.put(colonDivision[0], colonDivision[1]);
                }

                //Create the object
                if(hMap.get("TipoCuenta").equalsIgnoreCase("CuentaAhorro")){

                    CuentaAhorro cuentaAhorro = new CuentaAhorro();
                    cuentaAhorro.setSaldo(Double.parseDouble(hMap.get("Saldo")));
                    cuentaAhorro.setFechaApertura(LocalDate.parse(hMap.get("FechaApertura")));
                    cuentaAhorro.setNumeroTarjeta(Integer.parseInt(hMap.get("NumeroTarjeta")));

                    this.cuentasBancarias.add(cuentaAhorro);

                }else if(hMap.get("TipoCuenta").equalsIgnoreCase("CuentaCorriente")){

                    CuentaCorriente cuentaCorriente = new CuentaCorriente();
                    cuentaCorriente.setSaldo(Double.parseDouble(hMap.get("Saldo")));
                    cuentaCorriente.setFechaApertura(LocalDate.parse(hMap.get("FechaApertura")));
                    cuentaCorriente.setNumeroTarjeta(Integer.parseInt(hMap.get("NumeroTarjeta")));

                    this.cuentasBancarias.add(cuentaCorriente);

                }else{
                    CuentaAhorroProgramado cuentaAhorroProgramado = new CuentaAhorroProgramado();
                    cuentaAhorroProgramado.setSaldo(Double.parseDouble(hMap.get("Saldo")));
                    cuentaAhorroProgramado.setFechaApertura(LocalDate.parse(hMap.get("FechaApertura")));
                    cuentaAhorroProgramado.setNumeroTarjeta(Integer.parseInt(hMap.get("NumeroTarjeta")));

                    this.cuentasBancarias.add(cuentaAhorroProgramado);

                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Método que realiza una transacción bancaria.
     * @param numeroCuenta: Número de la cuenta bancaria a la que se le va a realizar la transacción.
     * @param transaccion: Transacción bancaria que se va a realizar, ya sea depósito o retiro bancario.
     * @return true si se pudo efectuar la transacción.
     */
    public boolean realizarTransaccion(int numeroCuenta, TransaccionBancaria transaccion){
        try{
            for(CuentaBancaria e: cuentasBancarias){
                if(e.getNumeroTarjeta() == numeroCuenta){
                    return e.realizarTransaccion(transaccion);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Método que retorna un ArrayList Collection con la información de las Cuentas Bancarias cargadas y todas sus
     * transacciones realizadas.
     * @return ArrayList Collection con la información de las Cuentas Bancarias cargadas.
     */
    public ArrayList<CuentaBancaria> obtenerCuentasBancarias(){
        return this.cuentasBancarias;
    }

    /**
     * Método que retorna un ArrayList Collection con la información de los Clientes cargados.
     */
    public ArrayList<Cliente> obtenerClientes(){
        return this.clientes;
    }

    public String obtenerDatosCliente(String identificacion){
        for(Cliente e : this.clientes){
            if(e.getIdentificacion().equalsIgnoreCase(identificacion)){
                return e.toString();
            }
        }
        return null;
    }
    /**
     * Método que se encarga de validar la existencia de una cuenta bancaria.
     * @param numeroCuenta: número de cuenta.
     * @return true si la cuenta existe.
     */
    public boolean validarExistenciaCuentaBancaria(int numeroCuenta){
        if(new File(Banco.URL_CUENTAS_CSV).exists()) {
            try {
                this.reader = new FileReader(new File(Banco.URL_CUENTAS_CSV));
                this.bufferedReader = new BufferedReader(this.reader);
                String[] array;
                String line_data;
                String[] arr;
                while ((line_data = bufferedReader.readLine()) != null) {
                    array = line_data.split(",");
                    arr = array[0].split(":");
                    if (arr[1].equals(String.valueOf(numeroCuenta))) {
                        return true;
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Valida que exista una cuenta corriente dentro del Collection con el número de cuenta proporcionado.
     * @param numeroCuenta número de la cuenta.
     * @return true si existe una cuenta corriente.
     */
    public boolean validarExistenciaCuentaCorriente(int numeroCuenta){
        if(this.validarExistenciaCuentaBancaria(numeroCuenta)){
            for(CuentaBancaria e: this.cuentasBancarias){
                if(e.getNumeroTarjeta() == numeroCuenta){
                    if(e instanceof CuentaCorriente){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean cargarCuentaAhorroProgramado(int numeroCuenta, double saldo){
        for(CuentaBancaria cuentaBancaria: this.cuentasBancarias){
            if(cuentaBancaria.getNumeroTarjeta() == numeroCuenta){
                if (cuentaBancaria instanceof CuentaAhorroProgramado) {
                    return ((CuentaAhorroProgramado) cuentaBancaria).transferirSaldo(saldo);
                }
            }
        }
        return false;
    }


}

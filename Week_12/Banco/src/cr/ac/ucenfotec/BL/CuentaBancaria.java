package cr.ac.ucenfotec.BL;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class CuentaBancaria implements toCSVFormat{

    protected int numeroTarjeta;
    protected double saldo;
    protected ArrayList<TransaccionBancaria> transacciones;
    protected LocalDate fechaApertura;


    public CuentaBancaria() {
        this.numeroTarjeta = Integer.parseInt(CodeGenerator.generateAlphaCode(7, false));
        this.fechaApertura = LocalDate.now();
        this.transacciones = new ArrayList<>();
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public ArrayList<TransaccionBancaria> obtenerHistorialTransacciones(){
        return transacciones;
    }

    /**
     * Método Abstracto que permitirá realizar una transacción.
     * @param tempTransaccion: Transacción que se le va a realizar a la cuenta bancaria.
     * @return true si puede ser realizado.
     */
    public abstract boolean realizarTransaccion(TransaccionBancaria tempTransaccion);


    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();
        format.append("--DATOS GENERALES DE LA CUENTA--").append("\n");
        format.append("Número de Tarjeta : ").append(this.getNumeroTarjeta()).append("\n");
        format.append("Fecha de Apertura : ").append(this.getFechaApertura()).append("\n");
        if(this.saldo > .0)
            format.append("Saldo Actual : ").append(this.getSaldo()).append("\n\n");
        if(this.obtenerHistorialTransacciones() != null) {
            format.append("-HISTORIAL DE TRANSACCIONES-").append("\n");
            for(TransaccionBancaria e: transacciones){
                format.append(e.toString()).append("\n");
            }
        }
        return String.valueOf(format);
    }

    /**
     * Método que se encarga de convertir los atributos de la clase en un formato de una línea de tipo CSV.
     */
    @Override
    public String toCSVString() {
        StringBuilder format = new StringBuilder();
            format.append("NumeroTarjeta").append(":").append(this.getNumeroTarjeta()).append(",");
            format.append("Saldo").append(":").append(this.getSaldo()).append(",");
            format.append("FechaApertura").append(":").append(this.getFechaApertura());
        return String.valueOf(format);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentaBancaria that = (CuentaBancaria) o;
        return numeroTarjeta == that.numeroTarjeta;
    }
}

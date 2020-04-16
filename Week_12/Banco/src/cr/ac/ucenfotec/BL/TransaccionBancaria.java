package cr.ac.ucenfotec.BL;

import java.time.LocalDate;

public abstract class TransaccionBancaria {

    protected String IDTransaccion;
    protected LocalDate fechaTransaccion;
    protected String descripcionTransaccion;
    protected double montoTransaccion;

    public TransaccionBancaria(){
        this.IDTransaccion = CodeGenerator.generateAlphaCode(14, true);
        this.fechaTransaccion = LocalDate.now();
        this.descripcionTransaccion = "";
        this.montoTransaccion = .0;
    }

    public TransaccionBancaria(String descripcionTransaccion, double montoTransaccion) {
        this.IDTransaccion = CodeGenerator.generateAlphaCode(14, true);
        this.fechaTransaccion = LocalDate.now();
        this.descripcionTransaccion = descripcionTransaccion;
        this.montoTransaccion = montoTransaccion;
    }

    public TransaccionBancaria(double montoTransaccion) {
        this.IDTransaccion = CodeGenerator.generateAlphaCode(14, true);
        this.fechaTransaccion = LocalDate.now();
        this.montoTransaccion = montoTransaccion;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public String getDescripcionTransaccion() {
        return descripcionTransaccion;
    }

    public double getMontoTransaccion() {
        return montoTransaccion;
    }

    public String getIDTransaccion(){
        return IDTransaccion;
    }

}

package cr.ac.ucenfotec.BL;

public class DepositoBancario extends TransaccionBancaria {

    public DepositoBancario() {
    }

    public DepositoBancario(String descripcionTransaccion, double montoTransaccion) {
        super(descripcionTransaccion, montoTransaccion);
    }

    public DepositoBancario(double montoTransaccion) {
        super(montoTransaccion);
    }

    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();
        format.append("DATOS DEL DEPÓSITO").append("\n");
        format.append("Código del Depósito : ").append(this.getIDTransaccion()).append("\n");
        format.append("Fecha de Realización : ").append(this.getFechaTransaccion()).append("\n");
        if(this.getDescripcionTransaccion() != null)
            format.append("Descripción : ").append(this.getDescripcionTransaccion()).append("\n");
        format.append("Monto del Depósito : ").append(this.getMontoTransaccion()).append("\n");
        return String.valueOf(format);
    }
}

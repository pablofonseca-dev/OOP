package cr.ac.ucenfotec.BL;

public class RetiroBancario extends TransaccionBancaria{

    public RetiroBancario() {
    }

    public RetiroBancario(double montoTransaccion) {
        super(montoTransaccion);
    }

    public RetiroBancario(String descripcionTransaccion, double montoTransaccion) {
        super(descripcionTransaccion, montoTransaccion);
    }

    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();
        format.append("DATOS DEL RETIRO").append("\n");
        format.append("Código del Retiro : ").append(this.getIDTransaccion()).append("\n");
        format.append("Fecha de Realización : ").append(this.getFechaTransaccion()).append("\n");
        if(this.getDescripcionTransaccion() != null)
            format.append("Descripción : ").append(this.getDescripcionTransaccion()).append("\n");
        format.append("Monto del Retiro : ").append(this.getMontoTransaccion()).append("\n");
        return String.valueOf(format);
    }
}

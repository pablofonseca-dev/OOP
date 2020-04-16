package cr.ac.ucenfotec.BL;

public class CuentaAhorro extends CuentaBancaria implements toCSVFormat{

    public static final double SALDO_MINIMO_RETIRO = 100000;
    public static final double TASA_INTERES = 0.32;

    /**
     * Método Abstracto que permitirá realizar una transacción.
     *
     * @param tempTransaccion : Transacción que se le va a realizar a la cuenta bancaria.
     * @return true si puede ser realizado.
     */
    @Override
    public boolean realizarTransaccion(TransaccionBancaria tempTransaccion) {
        if(tempTransaccion instanceof DepositoBancario){
            super.saldo += tempTransaccion.getMontoTransaccion();
            super.transacciones.add(tempTransaccion);
            return true;
        }else if(tempTransaccion instanceof  RetiroBancario){
            if(super.saldo >= SALDO_MINIMO_RETIRO){
                double porcentajeMinimo = Math.ceil(((super.saldo * 50) / 100));
                if(tempTransaccion.getMontoTransaccion() <= porcentajeMinimo){
                    this.saldo -= tempTransaccion.getMontoTransaccion();
                    super.transacciones.add(tempTransaccion);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();
        format.append("CUENTA DE AHORRO").append("\n");
        format.append(super.toString());
        return String.valueOf(format);
    }

    /**
     * Método que se encarga de convertir los atributos de la clase en un formato de una línea de tipo CSV.
     */
    @Override
    public String toCSVString() {
        StringBuilder format = new StringBuilder();
        format.append(super.toCSVString()).append(",").append("TipoCuenta").append(":").append("CuentaAhorro");
        return String.valueOf(format);
    }
}

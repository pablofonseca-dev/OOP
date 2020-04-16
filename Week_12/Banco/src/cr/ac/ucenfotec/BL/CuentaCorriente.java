package cr.ac.ucenfotec.BL;

public class CuentaCorriente extends CuentaBancaria implements toCSVFormat{

    //Se realiza un depósito inicial de 50 mil colones.
    public CuentaCorriente() {
        super();
        realizarTransaccion(new DepositoBancario("Depósito Inicial", 50000.0));
    }

    /**
     * Método Abstracto que permitirá realizar una transacción.
     *
     * @param tempTransaccion : Transacción que se le va a realizar a la cuenta bancaria.
     * @return true si puede ser realizado.
     */
    @Override
    public boolean realizarTransaccion(TransaccionBancaria tempTransaccion) {
        if(tempTransaccion instanceof DepositoBancario){
            super.saldo += tempTransaccion.montoTransaccion;
            super.transacciones.add(tempTransaccion);
            return true;
        }else if(tempTransaccion instanceof  RetiroBancario){
            if(super.saldo < tempTransaccion.montoTransaccion){
                return false;
            }else{
                super.saldo -= tempTransaccion.montoTransaccion;
                super.transacciones.add(tempTransaccion);
                return true;
            }
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();
        format.append("CUENTA CORRIENTE").append("\n");
        format.append(super.toString());
        return String.valueOf(format);
    }

    /**
     * Método que se encarga de convertir los atributos de la clase en un formato de una línea de tipo CSV.
     */
    @Override
    public String toCSVString() {
        StringBuilder format = new StringBuilder();
        format.append(super.toCSVString()).append(",").append("TipoCuenta").append(":").append("CuentaCorriente");
        return String.valueOf(format);
    }
}

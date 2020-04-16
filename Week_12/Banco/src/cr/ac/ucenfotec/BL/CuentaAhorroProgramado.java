package cr.ac.ucenfotec.BL;
import java.time.LocalDate;
import java.time.Period;

public class CuentaAhorroProgramado extends CuentaBancaria implements toCSVFormat{

    private CuentaCorriente cuentaCorriente;

    public CuentaAhorroProgramado() {
    }

    public CuentaAhorroProgramado(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    /**
     * Método que se encarga de realizar la transferencia de retiro de dinero de una cuenta corriente y depositarlo
     * en la cuenta de ahorro programado.
     * @param saldo: saldo que se va a depositar a la cuenta de ahorro programado y que se retirará de la cuenta
     *             corriente asociada.
     * @return true si se pudo realizar las transacciones bancarias, false si la cuenta corriente no tuvo el saldo
     * suficiente.
     */
    public boolean transferirSaldo(double saldo){
        TransaccionBancaria retiroBancario = new RetiroBancario("Transferencia A Cuenta de Ahorro Programado",
                saldo);

        boolean transaccionRealizada = this.cuentaCorriente.realizarTransaccion(retiroBancario);
        if(transaccionRealizada){
            TransaccionBancaria depositoBancario = new DepositoBancario("Saldo Transferido de Cuenta Corriente",
                    retiroBancario.getMontoTransaccion());
           this.transacciones.add(depositoBancario);
           return true;
        }else{
            return false;
        }
    }

    /**
     * Método Abstracto que permitirá realizar una transacción.
     * Solo permite realizar retiros bancariois cuando la cuenta ya tiene al menos un año de haber sido activada.
     * @param tempTransaccion : Transacción que se le va a realizar a la cuenta bancaria.
     * @return true si puede ser realizado.
     */
    @Override
    public boolean realizarTransaccion(TransaccionBancaria tempTransaccion) {
        if(tempTransaccion instanceof RetiroBancario){
            if(Period.between(super.fechaApertura, LocalDate.now()).getYears() > 0){
                this.saldo -= tempTransaccion.getMontoTransaccion();
                this.transacciones.add(tempTransaccion);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();
        format.append("CUENTA DE AHORRO PROGRAMADO").append("\n");
        format.append(super.toString());
        format.append("-CUENTA CORRIENTE ASOCIADA-").append("\n");
        if(this.cuentaCorriente != null){
            format.append(this.cuentaCorriente.getNumeroTarjeta()).append("\n");
        }else{
            format.append("NINGUNA");
        }
        return String.valueOf(format);
    }

    /**
     * Método que se encarga de convertir los atributos de la clase en un formato de una línea de tipo CSV.
     */
    @Override
    public String toCSVString() {
        StringBuilder format = new StringBuilder();
        format.append(super.toCSVString()).append(",").append("TipoCuenta").append(":").append(
                "CuentaAhorroProgramado");
        return String.valueOf(format);
    }
}

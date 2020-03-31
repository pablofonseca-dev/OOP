package cr.ac.ucenfotec.BL;

public class Jefatura extends Empleado{

    private double montoAdicional;



    public Jefatura() {
        super();
    }

    public Jefatura(String nombreEmpleado, String primerApellidoEmpleado, String segundoApellidoEmpleado, String identificacionEmpleado) {
        super(nombreEmpleado, primerApellidoEmpleado, segundoApellidoEmpleado, identificacionEmpleado);
        this.montoAdicional = montoAdicional;
    }

    @Override
    public void setSueldoEmpleado(double sueldoEmpleado) {
        if(this.montoAdicional > 0){
            sueldoEmpleado += montoAdicional; //Solo para jefes
        }
        super.setSueldoEmpleado(sueldoEmpleado);
    }

    public double getMontoAdicional() {
        return montoAdicional;
    }

    public void setMontoAdicional(double montoAdicional) {
        this.montoAdicional = montoAdicional;
    }

    @Override
    public String toString() {
        return "Jefatura{" +
                "montoAdicional=" + montoAdicional +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", primerApellidoEmpleado='" + primerApellidoEmpleado + '\'' +
                ", segundoApellidoEmpleado='" + segundoApellidoEmpleado + '\'' +
                ", identificacionEmpleado='" + identificacionEmpleado + '\'' +
                ", sueldoEmpleado=" + sueldoEmpleado +
                '}';
    }
}

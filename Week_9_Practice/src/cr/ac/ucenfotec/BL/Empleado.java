package cr.ac.ucenfotec.BL;

public class Empleado implements Comparable{

    protected String nombreEmpleado;
    protected String primerApellidoEmpleado;
    protected String segundoApellidoEmpleado;
    protected String identificacionEmpleado;
    protected double sueldoEmpleado;

    public Empleado() {
        nombreEmpleado = "";
        primerApellidoEmpleado = "";
        segundoApellidoEmpleado = "";
        identificacionEmpleado = "";
        sueldoEmpleado = .0;
    }

    public Empleado(String nombreEmpleado,
                    String primerApellidoEmpleado,
                    String segundoApellidoEmpleado,
                    String identificacionEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.primerApellidoEmpleado = primerApellidoEmpleado;
        this.segundoApellidoEmpleado = segundoApellidoEmpleado;
        this.identificacionEmpleado = identificacionEmpleado;
        this.sueldoEmpleado = .0;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getPrimerApellidoEmpleado() {
        return primerApellidoEmpleado;
    }

    public void setPrimerApellidoEmpleado(String primerApellidoEmpleado) {
        this.primerApellidoEmpleado = primerApellidoEmpleado;
    }

    public String getSegundoApellidoEmpleado() {
        return segundoApellidoEmpleado;
    }

    public void setSegundoApellidoEmpleado(String segundoApellidoEmpleado) {
        this.segundoApellidoEmpleado = segundoApellidoEmpleado;
    }

    public String getIdentificacionEmpleado() {
        return identificacionEmpleado;
    }

    public void setIdentificacionEmpleado(String identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public double getSueldoEmpleado() {
        return sueldoEmpleado;
    }

    public void setSueldoEmpleado(double sueldoEmpleado) {
        this.sueldoEmpleado = sueldoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                ", primerApellidoEmpleado='" + primerApellidoEmpleado + '\'' +
                ", segundoApellidoEmpleado='" + segundoApellidoEmpleado + '\'' +
                ", identificacionEmpleado='" + identificacionEmpleado + '\'' +
                ", sueldoEmpleado=" + sueldoEmpleado +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        Empleado objEmpleado = (Empleado) o;
        if(this.getSueldoEmpleado() > objEmpleado.getSueldoEmpleado()){
            return 1;
        }else if(this.getSueldoEmpleado() < objEmpleado.getSueldoEmpleado()){
            return -1;
        }else{
            return 0;
        }
    }
}

package Entidades;

public class Alquiler {
    private int id;
    private int plazo;
    private double montoTotal;
    private double multa;
    private String fecha;
    private  int cedula;



    public Alquiler() {
        this(0,0,0,0,"",0);
    }

    public Alquiler(int id, int plazo, double montoTotal, double multa, String fecha, int cedula) {
        this.id = id;
        this.plazo = plazo;
        this.montoTotal = montoTotal;
        this.multa = multa;
        this.fecha = fecha;
        this.cedula = cedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public String getFecha() { return fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getCedula() { return cedula; }

    public void setCedula(int cedula) { this.cedula = cedula; }

    @Override
    public String toString() {
        return "Alquiler{" +
                "id=" + id +
                ", plazo=" + plazo +
                ", montoTotal=" + montoTotal +
                ", multa=" + multa +
                ", fecha='" + fecha + '\'' +
                ", cedula=" + cedula +
                '}';
    }
}

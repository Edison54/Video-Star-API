package Entidades;

public class DetalleAlquiler {
private int id;
private int idPeli;
private int costoAlqui;
private int cantidad;


    public DetalleAlquiler() {
        this(0,0,0,0);
    }


    public DetalleAlquiler(int id, int idPeli, int costoAlqui, int cantidad) {
        this.id = id;
        this.idPeli = idPeli;
        this.costoAlqui = costoAlqui;
        this.cantidad = cantidad;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getIdPeli() { return idPeli; }

    public void setIdPeli(int idPeli) { this.idPeli = idPeli; }

    public int getCostoAlqui() { return costoAlqui; }

    public void setCostoAlqui(int costoAlqui) { this.costoAlqui = costoAlqui; }

    public int getCantidad() { return cantidad; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return "DetalleAlquiler{" +
                "id=" + id +
                ", idPeli=" + idPeli +
                ", costoAlqui=" + costoAlqui +
                ", cantidad=" + cantidad +
                '}';
    }
}

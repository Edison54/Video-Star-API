package Entidades;

public class Videos {
    private int id;
   private String tituloPeli;
   private int anio;
   private String genero;
   private String nacionalidad;
    private int cantidad;
    private String imagenHD;
    private String descripcion;



    public Videos() {
        this(0,"",0,"","",0,"","");
    }


    public Videos(int id, String tituloPeli, int year, String genero, String nacionalidad, int cantidad, String imagenHD,String descripcion ) {
        this.id = id;
        this.tituloPeli = tituloPeli;
        this.anio = year;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.cantidad = cantidad;
        this.imagenHD = imagenHD;
        this.descripcion = descripcion;
    }

    public String getTituloPeli() {
        return tituloPeli;
    }

    public void setTituloPeli(String tituloPeli) {
        this.tituloPeli = tituloPeli;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagenHD() {
        return imagenHD;
    }

    public void setImagenHD(String imagenHD) {
        this.imagenHD = imagenHD;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Videos{" +
                "id=" + id +
                ", tituloPeli='" + tituloPeli + '\'' +
                ", anio=" + anio +
                ", genero='" + genero + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", imagenHd='" + imagenHD + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}

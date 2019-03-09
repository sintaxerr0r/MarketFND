package Clases;



public class Imagen {

    //atributos
    private long id_imagen;
    private String ruta;
    private String fecha_creacion;
    private int fk_oferta;
    private int fk_usuario;

    //constructor por defecto
    public Imagen() {}

    //constructor con parametros
    public Imagen(int id_imagen, String ruta, String fecha_creacion, int fk_oferta, int fk_usuario) {

        this.id_imagen = id_imagen;
        this.ruta = ruta;
        this.fecha_creacion = fecha_creacion;
        this.fk_oferta = fk_oferta;
        this.fk_usuario = fk_usuario;
    }

    //get and set
    public long getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getFk_oferta() {
        return fk_oferta;
    }

    public void setFk_oferta(int fk_oferta) {
        this.fk_oferta = fk_oferta;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
}//fin clase

package Clases;

public class Oferta {

    //atributos
    private long id_oferta;
    private String descripcion;
    private int precio;
    private short unidades;
    private String ubicacion;
    private String fecha_publicacion;
    private String fecha_expiracion;
    private boolean vigente;
    private int fk_producto;
    private long fk_empresa_oferta;


    //constructor por defecto
    public Oferta() {}

    //constructor con parametros
    public Oferta(long id_oferta, String descripcion, int precio, short unidades, String ubicacion,
                                String fecha_publicacion, String fecha_expiracion, boolean vigente,
                                int fk_producto, long fk_empresa_oferta) {

        this.id_oferta = id_oferta;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
        this.ubicacion = ubicacion;
        this.fecha_publicacion = fecha_publicacion;
        this.fecha_expiracion = fecha_expiracion;
        this.vigente = vigente;
        this.fk_producto = fk_producto;
        this.fk_empresa_oferta = fk_empresa_oferta;
    }

    //getter and setter
    public long getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(long id_oferta) {
        this.id_oferta = id_oferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public short getUnidades() {
        return unidades;
    }

    public void setUnidades(short unidades) {
        this.unidades = unidades;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(String fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public int getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(int fk_producto) {
        this.fk_producto = fk_producto;
    }

    public long getFk_empresa_oferta() {
        return fk_empresa_oferta;
    }

    public void setFk_empresa_oferta(long fk_empresa_oferta) {
        this.fk_empresa_oferta = fk_empresa_oferta;
    }

}//fin clase

package Clases;


public class Usuario {

    //atributos
    private long id_nombre;
    private String nombre;
    private String apellido;
    private String email;
    private short telefono;

    //constructor por defecto
    public Usuario() {}


    //constructor con parametros
    public Usuario(int id_nombre, String nombre, String apellido, String email, short telefono) {

        this.id_nombre = id_nombre;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    //get and set
    public long getId_nombre() {
        return id_nombre;
    }

    public void setId_nombre(long id_nombre) {
        this.id_nombre = id_nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getTelefono() {
        return telefono;
    }

    public void setTelefono(short telefono) {
        this.telefono = telefono;
    }

}//fin clase

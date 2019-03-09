package Clases;


public class Usuario {

    //atributos

    private String nombre;
    private String apellido;
    private String email;
    private short telefono;

    //constructor por defecto
    public Usuario() {}


    //constructor con parametros
    public Usuario(String nombre, String apellido, String email, short telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    //get and set
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

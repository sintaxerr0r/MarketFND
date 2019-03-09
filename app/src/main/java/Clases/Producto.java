package Clases;

public class Producto {
    private Integer id;
    private String nombre;
    private Integer id_categoria;
    private String categoria;

    public Producto() {
    }

    public Producto(Integer id, String nombre, Integer id_categoria, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.id_categoria = id_categoria;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

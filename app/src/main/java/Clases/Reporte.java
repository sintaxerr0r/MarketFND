package Clases;

public class Reporte {
    private String comentario;
    private Long id_oferta;
    private Integer id_categoria_reporte;

    public Reporte() {
    }

    public Reporte(String comentario, Long id_oferta, Integer id_categoria_reporte) {
        this.comentario = comentario;
        this.id_oferta = id_oferta;
        this.id_categoria_reporte = id_categoria_reporte;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(Long id_oferta) {
        this.id_oferta = id_oferta;
    }

    public Integer getId_categoria_reporte() {
        return id_categoria_reporte;
    }

    public void setId_categoria_reporte(Integer id_categoria_reporte) {
        this.id_categoria_reporte = id_categoria_reporte;
    }
}

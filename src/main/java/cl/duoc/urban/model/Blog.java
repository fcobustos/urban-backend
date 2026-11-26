package cl.duoc.urban.model;

import jakarta.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 500)
    private String resumen;

    private String imagenPortada;
    private String categoria;
    private String autor;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String detalleJson;

    public Blog() {}

    public Blog(String slug, String titulo, String resumen, String imagenPortada, String categoria, String autor, String detalleJson) {
        this.slug = slug;
        this.titulo = titulo;
        this.resumen = resumen;
        this.imagenPortada = imagenPortada;
        this.categoria = categoria;
        this.autor = autor;
        this.detalleJson = detalleJson;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getResumen() { return resumen; }
    public void setResumen(String resumen) { this.resumen = resumen; }
    public String getImagenPortada() { return imagenPortada; }
    public void setImagenPortada(String imagenPortada) { this.imagenPortada = imagenPortada; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getDetalleJson() { return detalleJson; }
    public void setDetalleJson(String detalleJson) { this.detalleJson = detalleJson; }
}

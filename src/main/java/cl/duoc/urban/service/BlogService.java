package cl.duoc.urban.service;

import cl.duoc.urban.model.Blog;
import cl.duoc.urban.repository.BlogRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> listarTodos() {
        return blogRepository.findAll();
    }

    public Blog obtenerPorSlug(String slug) {
        return blogRepository.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("Articulo no encontrado: " + slug));
    }

    public Blog crear(Blog blog) {
        if (blog.getId() == null) {
            long nextId = blogRepository.findAll().stream()
                    .mapToLong(b -> b.getId() != null ? b.getId() : 0L)
                    .max()
                    .orElse(0L) + 1L;
            blog.setId(nextId);
        }
        if (blog.getSlug() == null || blog.getSlug().isBlank()) {
            blog.setSlug(blog.getTitulo().toLowerCase().replaceAll("[^a-z0-9]+", "-"));
        }
        return blogRepository.save(blog);
    }

    public Blog actualizar(Long id, Blog datos) {
        Blog existente = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog no encontrado con ID: " + id));
        existente.setTitulo(datos.getTitulo());
        existente.setResumen(datos.getResumen());
        existente.setImagenPortada(datos.getImagenPortada());
        existente.setCategoria(datos.getCategoria());
        existente.setDetalleJson(datos.getDetalleJson());
        return blogRepository.save(existente);
    }

    public void eliminar(Long id) {
        blogRepository.deleteById(id);
    }
}
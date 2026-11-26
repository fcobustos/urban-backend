package cl.duoc.urban.controller;

import cl.duoc.urban.model.Blog;
import cl.duoc.urban.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@Tag(name = "Blogs", description = "Gestion de articulos del blog de UrbanStyle")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los articulos del blog (Publico)")
    public List<Blog> listar() {
        return blogService.listarTodos();
    }

    @GetMapping("/{slug}")
    @Operation(summary = "Obtener detalle de un articulo por su slug (Publico)")
    public ResponseEntity<Blog> obtenerPorSlug(@PathVariable String slug) {
        return ResponseEntity.ok(blogService.obtenerPorSlug(slug));
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo articulo (Solo ADMIN)", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Blog> crear(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.crear(blog));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un articulo existente (Solo ADMIN)", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Blog> actualizar(@PathVariable Long id, @RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.actualizar(id, blog));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un articulo (Solo ADMIN)", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        blogService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

package cl.duoc.urban.repository;

import cl.duoc.urban.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Optional<Blog> findBySlug(String slug);
}

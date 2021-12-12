package platform.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import platform.model.Snippet;

import java.util.List;

/**
 * This is an interface saving as Snippet Repository
 * @author Beauclair Dongmo Ngnintedem
 */
public interface SnippetRepository extends CrudRepository<Snippet, String> {

    @Query(value = "SELECT * FROM Snippet " +
            "       WHERE SECRET = FALSE " +
            "       ORDER BY date DESC " +
            "       LIMIT 10;", nativeQuery = true)
    List<Snippet> findAllWithoutAnyRestrictionOrderByDateDescLimitTen();
}

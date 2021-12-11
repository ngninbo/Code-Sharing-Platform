package platform.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import platform.model.Snippet;

import java.util.List;
import java.util.Optional;

public interface SnippetRepository extends CrudRepository<Snippet, String> {

    @Query(value = "SELECT * FROM Snippet " +
            "       WHERE SECRET = FALSE " +
            "       ORDER BY date DESC " +
            "       LIMIT 10;", nativeQuery = true)
    List<Snippet> findAllWithoutAnyRestrictionOrderByDateDescLimitTen();

    @Query(value = "SELECT * FROM Snippet " +
            "       WHERE id = ?1 AND SECRET = TRUE;",
            nativeQuery = true)
    Optional<Snippet> findSecretSnippetById(String uuid);

    @Modifying
    @Query(value = "UPDATE Snippet SET views = CASE " +
            "                                       WHEN views - 1 <= 0 THEN 0 " +
            "                                       ELSE views - 1 " +
            "                                  END WHERE id = ?1" ,
            nativeQuery = true)
    void decrementViews (String id);

    @Modifying
    @Query(value = "UPDATE Snippet SET time = ?1  WHERE id = ?2" , nativeQuery = true)
    void updateTime (long newTime , String id) ;
}

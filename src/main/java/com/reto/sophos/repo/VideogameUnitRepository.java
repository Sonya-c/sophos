
package com.reto.sophos.repo;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.reto.sophos.models.VideogameUnit;
import com.reto.sophos.models.VideogameTitle;
import java.util.List;
public interface VideogameUnitRepository extends JpaRepository<VideogameUnit, Integer> {
	List<VideogameUnit> findAll();

	@Query("SELECT unit FROM VideogameUnit unit WHERE unit.videogameTitle = :videogameTitle")
  List<VideogameUnit> findUnitsByVideogameTitle(@Param("videogameTitle") VideogameTitle videogameTitle);
}


package com.reto.sophos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reto.sophos.models.VideogameTitle;
import java.util.List;
public interface VideogameTitleRepository extends JpaRepository<VideogameTitle, Integer> {
	List<VideogameTitle> findAll();
}

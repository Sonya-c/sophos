
package com.reto.sophos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reto.sophos.models.Director;
import java.util.List;
public interface DirectorRepository extends JpaRepository<Director, Integer> {
	List<Director> findAll();
}

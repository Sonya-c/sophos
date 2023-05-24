

package com.reto.sophos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reto.sophos.models.Producer;
import java.util.List;
public interface ProducerRepository extends JpaRepository<Producer, Integer> {
	List<Producer> findAll();
}

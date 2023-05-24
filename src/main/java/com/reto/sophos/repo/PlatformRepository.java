

package com.reto.sophos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reto.sophos.models.Platform;
import java.util.List;
public interface PlatformRepository extends JpaRepository<Platform, Integer> {
	List<Platform> findAll();
}



package com.reto.sophos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reto.sophos.models.Loan;
import java.util.List;
public interface LoanRepository extends JpaRepository<Loan, Integer> {
	List<Loan> findAll();
}

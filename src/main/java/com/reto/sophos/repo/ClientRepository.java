package com.reto.sophos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reto.sophos.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
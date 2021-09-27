package com.sigabem.freteendpoint.repository;

import com.sigabem.freteendpoint.entity.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {



}

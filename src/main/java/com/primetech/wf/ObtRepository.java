package com.primetech.wf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObtRepository extends JpaRepository<Obt, Long> {

	public List<Obt> findByNama(String nama);

}

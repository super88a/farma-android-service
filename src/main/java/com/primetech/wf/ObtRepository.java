package com.primetech.wf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ObtRepository extends JpaRepository<Obt, Long> {

	public Obt findByNama(String nama);
	public List<Obt> findByNamaContaining(String nama);

}

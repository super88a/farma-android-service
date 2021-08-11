package com.primetech.wf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ObtRepositoryImpl implements ObtRepository {

	@PersistenceContext
  private EntityManager em;

	@Override
	public List<Obt> findByNama(String nama) {
		TypeQuery q = em.createQuery("select o from Obt o where o.nama = ?1", Obt.class);
		q.setParameter(1, nama);
		
		return query.getResultList();
	}

}

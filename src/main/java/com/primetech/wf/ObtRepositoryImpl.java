package com.primetech.wf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class ObtRepositoryImpl implements ObtRepository {

	@PersistenceContext
  private EntityManager em;

	@Override
	public List<Obt> findByNama(String nama) {
		TypedQuery q = em.createQuery("select o from Obt o where o.nama = ?1", Obt.class);
		q.setParameter(1, nama);
		
		return q.getResultList();
	}

}

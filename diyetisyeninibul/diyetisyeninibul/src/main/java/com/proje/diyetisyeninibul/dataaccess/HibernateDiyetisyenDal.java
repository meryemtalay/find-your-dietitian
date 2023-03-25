package com.proje.diyetisyeninibul.dataaccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.proje.diyetisyeninibul.entities.Diyetisyen;

@Repository
public class HibernateDiyetisyenDal implements IDiyetisyenDal {
	
	private EntityManager entityManager;

	@Autowired
	public HibernateDiyetisyenDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
	
	@Override
	@Transactional
	public List<Diyetisyen> getAll() {
		List<Diyetisyen> diyetisyenler = getSession().createQuery("from Diyetisyen", Diyetisyen.class).getResultList();		
		return diyetisyenler;
	}

	@Override
	@Transactional
	public Diyetisyen getByDiyetisyenID(int diyetisyenID) {
		Diyetisyen diyetisyen = getSession().get(Diyetisyen.class, diyetisyenID);
		return diyetisyen;
	}
	
	@Override
	@Transactional
	public String update(Diyetisyen diyetisyen) {
		getSession().save(diyetisyen);
		return "Bilgiler güncellendi";
	}
	
	@Override
	@Transactional
	public void delete(Diyetisyen diyetisyen) {
		getSession().delete(diyetisyen);
	}

	@Override
	@Transactional
	public String save(Diyetisyen diyetisyen) {
		getSession().save(diyetisyen);
		return "Bilgiler kaydedildi";
	}

}


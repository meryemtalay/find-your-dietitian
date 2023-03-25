package com.proje.diyetisyeninibul.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proje.diyetisyeninibul.dataaccess.IDiyetisyenDal;
import com.proje.diyetisyeninibul.entities.Diyetisyen;

@Service
public class DiyetisyenManager implements IDiyetisyenService {

	private IDiyetisyenDal diyetisyenDal;

	@Autowired
	public DiyetisyenManager(IDiyetisyenDal diyetisyenDal) {
		this.diyetisyenDal = diyetisyenDal;
	}

	@Override
	@Transactional
	public List<Diyetisyen> getAll() {
		return this.diyetisyenDal.getAll();
	}

	@Override
	@Transactional
	public Diyetisyen getByDiyetisyenID(int diyetisyenID) {
		return this.diyetisyenDal.getByDiyetisyenID(diyetisyenID);
	}
	
	@Override
	@Transactional
	public void update(int diyetisyenID, Diyetisyen diyetisyen) {
		this.diyetisyenDal.update(diyetisyen);
	}

	@Override
	@Transactional
	public void delete(Diyetisyen diyetisyen) {
		this.diyetisyenDal.delete(diyetisyen);
	}

	@Override
	@Transactional
	public Diyetisyen save(Diyetisyen diyetisyen) {
		this.diyetisyenDal.save(diyetisyen);
		return diyetisyen;
	}

}

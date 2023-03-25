package com.proje.diyetisyeninibul.business;

import java.util.List;

import com.proje.diyetisyeninibul.entities.Diyetisyen;

public interface IDiyetisyenService {
	List<Diyetisyen> getAll();
	Diyetisyen getByDiyetisyenID(int diyetisyenID);
	void update(int diyetisyenID, Diyetisyen diyetisyen);
	void delete(Diyetisyen diyetisyen);	
	Diyetisyen save(Diyetisyen diyetisyen);
}

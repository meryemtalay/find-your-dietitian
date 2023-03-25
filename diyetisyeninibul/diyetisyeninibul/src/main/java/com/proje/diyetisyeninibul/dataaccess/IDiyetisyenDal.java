package com.proje.diyetisyeninibul.dataaccess;

import java.util.List;

import com.proje.diyetisyeninibul.entities.Diyetisyen;

public interface IDiyetisyenDal {
	List<Diyetisyen> getAll();
	Diyetisyen getByDiyetisyenID(int diyetisyenID);
	String update(Diyetisyen diyetisyen);
	void delete(Diyetisyen diyetisyen);	
	String save (Diyetisyen diyetisyen);
}

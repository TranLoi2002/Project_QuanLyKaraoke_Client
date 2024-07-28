package dao.impl;

import dao.TaiKhoan_DAO;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class TaiKhoanImpl implements TaiKhoan_DAO {
	private EntityManager em;
	public TaiKhoanImpl() {
		em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
	}
	
	@Override
	public TaiKhoan getTaiKHoanTheoTenDN(String tenDN) {
		// TODO Auto-generated method stub
		return em.find(TaiKhoan.class, tenDN);
	}
}

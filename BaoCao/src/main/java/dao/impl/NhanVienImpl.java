package dao.impl;

import java.util.List;

import dao.NhanVien_DAO;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class NhanVienImpl implements NhanVien_DAO {
	private EntityManager em;

	public NhanVienImpl() {
		// TODO Auto-generated constructor stub
		em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
	}

	@Override
	public NhanVien getNVtheoMa(String maNV) {
		// TODO Auto-generated method stub
		return em.find(NhanVien.class, maNV);
	}

	@Override
	public List<NhanVien> getAllNhanVien() {
		// TODO Auto-generated method stub
		return em.createQuery("select n from NhanVien n").getResultList();
	}

	@Override
	public void addNhanVien(NhanVien nv) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nv);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}
	@Override
	public void capNhat_NhanVien(NhanVien nv) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(nv);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public int kiemTraMa(String ma) {
		// TODO Auto-generated method stub
//		try {
//			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_NhanVien WHERE MaNhanVien = ?");
//			statement.setString(1, ma);
//			 ResultSet resultSet = statement.executeQuery();
//			 resultSet.next();
//		     int count = resultSet.getInt(1);
//		     return count;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		return 0;
	}

	@Override
	public List<NhanVien> getNVtheoTen(String ten) {
		// TODO Auto-generated method stub
		return null;
	}


	
	@Override
	public NhanVien timNhanVienTheoTaiKhoan(String user) {
		// TODO Auto-generated method stub
		return em.find(NhanVien.class, user);
	}
	@Override
	public List<NhanVien> searchNhanVien(String ten, String soDienThoai, int gioiTinh) {
		// TODO Auto-generated method stub
		return em.createQuery("Select n from NhanVien n"
								+ " where n.tenNhanVien like :name"
								+ " and n.soDienThoai like :sdt"
								+ " and n.gioiTinh like :gt")
				.setParameter("name", "%"+ten+"%")	
				.setParameter("sdt", "%"+soDienThoai+"%")
				.setParameter("gt", gioiTinh)
				.getResultList();
	}@Override
	public List<NhanVien> searchNhanVienByGioiTinh(int gioiTinh) {
		// TODO Auto-generated method stub
		return em.createQuery("Select n from NhanVien n "
				+ "where n.gioiTinh like :gt")
				.setParameter("gt", gioiTinh )
				.getResultList();
	}@Override
	public List<NhanVien> searchNhanVienBySoDienThoai(String soDienThoai) {
		// TODO Auto-generated method stub
		return em.createQuery("Select n from NhanVien n "
				+ "where n.soDienThoai like :sdt")
				.setParameter("sdt", "%"+soDienThoai+"%" )
				.getResultList();
	}@Override
	public List<NhanVien> searchNhanVienByTen(String ten) {
		// TODO Auto-generated method stub
		return em.createQuery("Select n from NhanVien n "
				+ "where  n.tenNhanVien like :name")
				.setParameter("name", "%"+ten+"%" )
				.getResultList();
	}
}

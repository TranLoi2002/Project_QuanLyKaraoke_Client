package dao.impl;

import java.util.List;

import dao.DichVu_DAO;
import entity.DichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DichVuImpl implements DichVu_DAO{
	private EntityManager em;

	public DichVuImpl() {
		// TODO Auto-generated constructor stub
		em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
	}

	@Override
	public void addDichVu(DichVu dv) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(dv);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<DichVu> getAllDichVu() {
		// TODO Auto-generated method stub
		return em.createQuery("select dv from DichVu dv").getResultList();
	}

	@Override
	public void capNhat_DichVu(DichVu dv) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(dv);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean delete_DichVu(String ma) {
		DichVu dichVu = em.find(DichVu.class, ma);
        if (dichVu != null) {
            em.remove(dichVu);
            return true;
        } else {
            return false;
        }
	}

	@Override
	public List<DichVu> getAllPhongTheoGiaDV(String gia) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT dv FROM DichVu dv WHERE dv.giaDichVu <= :gia")
				.setParameter("gia", gia)
				.getResultList();
	}

	@Override
	public List<DichVu> getAllPhongTheoGiaDV_1(String giaCu, String giaMoi) {
		// TODO Auto-generated method stub

		return em.createQuery("SELECT dv FROM DichVu dv WHERE dv.giaDichVu > :giaCu AND dv.giaDichVu <= :giaMoi")
				.setParameter("giaCu", giaCu)
				.setParameter("giaMoi", giaMoi)
				.getResultList();
	}

	@Override
	public List<DichVu> getAllPhongTheoGiaDV_3(String gia) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT dv FROM DichVu dv WHERE dv.giaDichVu > :gia")
        		.setParameter("gia", gia)
        		.getResultList();
	}

	@Override
	public List<DichVu> getAllPhongTheoDonVi(String don) {
		// TODO Auto-generated method stub
		
		return em.createQuery("SELECT dv FROM DichVu dv WHERE dv.donVi = :don")
	        	.setParameter("don", don)
	        	.getResultList();
	}

	@Override
	public List<DichVu> getAllPhongTheoTinhTrang(String tt) {
		// TODO Auto-generated method stub
		
		return em.createQuery("SELECT dv FROM DichVu dv WHERE dv.trangThai = :tt")
			       .setParameter("tt", tt)
			       .getResultList();
	}

	@Override
	public List<DichVu> getAllPhongTheoTen(String t) {
		// TODO Auto-generated method stub
		
		return em.createQuery("SELECT dv FROM DichVu dv WHERE dv.tenDichVu LIKE :t")
		        .setParameter("t", "%" + t + "%")
		        .getResultList();
	}

	@Override
	public DichVu getDVtheoTen(String tenDV) {
		// TODO Auto-generated method stub
		 em.createQuery("SELECT dv FROM DichVu dv WHERE dv.tenDichVu = :tenDV")
		 	.setParameter("tenDV", tenDV);
        List<DichVu> resultList = ((Query) em).getResultList();
        // Assuming a unique service name, return the first element (or null if not found)
        return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public List<DichVu> getDichVuUaThich() {
		// TODO Auto-generated method stub
		
		return em.createNativeQuery("SELECT dv.maDichVu, dv.tenDichVu, dv.giaDichVu, "
                + "SUM(ctHD.soLuong) AS soLuongBan, SUM(ctHD.soLuong * dv.giaDichVu) AS tongDoanhThu "
                + "FROM DichVu dv JOIN ChiTietHoaDon ctHD ON dv.maDichVu = ctHD.maDichVu "
                + "GROUP BY dv.maDichVu, dv.tenDichVu, dv.giaDichVu "
                + "ORDER BY soLuongBan DESC", DichVu.class)
        .getResultList();
	}

	@Override
	public int getSLBanTheoMa(String ma) {
		// TODO Auto-generated method stub
		em.createNamedQuery("SELECT SUM(ctHD.soLuong) FROM ChiTietHoaDon ctHD WHERE ctHD.dichVu.maDichVu = :ma")
        .setParameter("ma", ma);
        Long soLuongBan = (Long) ((Query) em).getSingleResult();
        return soLuongBan != null ? soLuongBan.intValue() : 0;
	}

	@Override
	public double getTongDTTheoMa(String ma) {
		// TODO Auto-generated method stub
		em.createNamedQuery("SELECT SUM(ctHD.soLuong * dv.giaDichVu) FROM ChiTietHoaDon ctHD WHERE ctHD.dichVu.maDichVu = :ma")
        	.setParameter("ma", ma);
        Double tongDoanhThu = (Double) ((Query) em).getSingleResult();
        return tongDoanhThu != null ? tongDoanhThu.doubleValue() : 0.0;
	}

	@Override
	public int kiemTraMa(String ma) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void markDichVuAsNgungBan(String maDichVu) {
		// TODO Auto-generated method stub
					DichVu dichVu = em.find(DichVu.class, maDichVu);
				    dichVu.setTrangThai("Ngung Bán");
				    // Start a transaction and commit the changes
				    EntityTransaction tx = em.getTransaction();
				    try {
				        tx.begin();
				        em.merge(dichVu); // Merge the updated dichVu entity
				        tx.commit();
				    } catch (Exception e) {
				        tx.rollback();
				        e.printStackTrace();
				    }
	}


}

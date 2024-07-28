package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import java.sql.Date;
import java.sql.PreparedStatement;

import entity.KhachHang;
import entity.NhanVien;
import entity.PhongHat;


public interface NhanVien_DAO {
	public void addNhanVien(NhanVien nv);
	public NhanVien getNVtheoMa(String maNV);
	public List<NhanVien> getAllNhanVien() ;
	public NhanVien timNhanVienTheoTaiKhoan(String user);
	public List<NhanVien> getNVtheoTen(String ten);
	public void capNhat_NhanVien(NhanVien nv);

//	}
//	// thêm nhan vien mới

	// kiểm tra mã nhan vien có trùng không
	public int kiemTraMa(String ma);
//	//kiem tra SDT
//	public int kiemTraSDT(String sdt) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_NhanVien WHERE SoDienThoai = ?");
//			statement.setString(1, sdt);
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
//		return 0;
//	}
//	//kiem tra CCCD
//		public int kiemTraCCCD(String cccd) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement statement = null;
//			try {
//				statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_NhanVien WHERE CCCD = ?");
//				statement.setString(1, cccd);
//				 ResultSet resultSet = statement.executeQuery();
//				 resultSet.next();
//			     int count = resultSet.getInt(1);
//			     return count;
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			finally {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			return 0;
//		}
//	//Cập nhật thông tin nhan vien
//	public void capNhat_NhanVien(NhanVien nv) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		try {
////			SELECT MaNhanVien, TenNhanVien, NgaySinh, SoDienThoai, CCCD, GioiTinh, DiaChi, ChucVu, TrangThai FROM tbl_NhanVien WHERE MaNhanVien ='"+maNV+"'";
//			stmt = con.prepareStatement("UPDATE tbl_NhanVien SET TenNhanVien=? , NgaySinh=? , SoDienThoai=? , CCCD=? ,  GioiTinh=?, DiaChi=? , ChucVu=? , TrangThai=?  WHERE MaNhanVien=?");
//			stmt.setString(1, nv.getTenNhanVien());
//			stmt.setDate(2, new java.sql.Date(nv.getNgaySinh().getTime()));
//			stmt.setString(3, nv.getSoDienThoai());
//			stmt.setString(4, nv.getcCCD());
//			stmt.setInt(5, nv.getGioiTinh());
//			stmt.setString(6, nv.getDiaChi());
//			stmt.setString(7, nv.getChucVu());
//			stmt.setString(8, nv.getTrangThai());
//			stmt.setString(9, nv.getMaNhanVien());
//			stmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO: handle exception
//		}
//		
//	}
	// tìm kiếm thông tin Nhan Vien
 	public List<NhanVien> searchNhanVienByTen(String ten) ;

    public List<NhanVien> searchNhanVienBySoDienThoai(String soDienThoai);

    public List<NhanVien> searchNhanVienByGioiTinh(int gioiTinh);

    public List<NhanVien> searchNhanVien(String ten, String soDienThoai, int gioiTinh);
}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.DichVu;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhongHat;

public interface DichVu_DAO {
	public void addDichVu(DichVu nv);
	public List<DichVu> getAllDichVu() ;
	public void capNhat_DichVu(DichVu nv);
	public boolean delete_DichVu(String ma);
	
	public List<DichVu> getAllPhongTheoGiaDV(String gia);
	public List<DichVu> getAllPhongTheoGiaDV_1(String giaCu, String giaMoi);
	public List<DichVu> getAllPhongTheoGiaDV_3(String gia);
	public List<DichVu> getAllPhongTheoDonVi(String don);
	public List<DichVu> getAllPhongTheoTinhTrang(String tt);
	public List<DichVu> getAllPhongTheoTen(String t);
	public DichVu getDVtheoTen(String tenDV);
	public List<DichVu> getDichVuUaThich();
	public int getSLBanTheoMa(String ma);
	public double getTongDTTheoMa(String ma);
	public int kiemTraMa(String ma);
	public void markDichVuAsNgungBan(String maDichVu);
//	public ArrayList<DichVu> getAllDichVu() {
//		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
//		
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT * from tbl_DichVu";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				float gia = rs.getFloat(3);
//				int soLuong = rs.getInt(4);
//				String donVi = rs.getString(5);
//				String trangThai = rs.getString(6);
//				
//				DichVu dv = new DichVu(ma, ten, gia, soLuong, donVi, trangThai);
//				dsDichVu.add(dv);
//			}
//		
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsDichVu;
//	}
//	
//	// thêm dịch vụ mới
//	public void addDichVu(DichVu dv) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			statement = con.prepareStatement("insert into tbl_DichVu values(?,?,?,?,?,?)");
//			statement.setString(1, dv.getMaDichVu());
//			statement.setString(2, dv.getTenDichVu());
//			statement.setFloat(3, dv.getGiaDichVu());
//			statement.setInt(4, dv.getSoLuong());
//			statement.setString(5, dv.getDonVi());
//			statement.setString(6, dv.getTrangThai());
//			statement.executeUpdate();
//		} catch (SQLException e) {
//				e.printStackTrace();
//		}
//		finally {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//					e.printStackTrace();
//					// TODO: handle exception
//				}
//			}
//		}
//	// kiểm tra mã có trùng không
//	public int kiemTraMa(String ma) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_DichVu WHERE MaDichVu = ?");
//			statement.setString(1, ma);
//			ResultSet resultSet = statement.executeQuery();
//			resultSet.next();
//			int count = resultSet.getInt(1);
//			return count;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				}
//			}
//			return 0;
//	}
//	//Xóa Dịch vụ trên SQL
//	public boolean delete_DichVu(String ma) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("DELETE FROM tbl_DichVu WHERE MaDichVu =?");
//			stmt.setString(1, ma);
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//							
//		} finally {
//			try {
//				stmt.close();
//		} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return n > 0;
//	}
//	//Cập nhật thông tin Dịch vụ
//	public void capNhat_DichVu(DichVu dv) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement("UPDATE tbl_DichVu SET TenDichVu=? , GiaDichVu=? , SoLuong=? , DonVi=? , TrangThai=? WHERE MaDichVu=?");
//			stmt.setString(1, dv.getTenDichVu());
//			stmt.setFloat(2, dv.getGiaDichVu());
//			stmt.setInt(3, dv.getSoLuong());
//			stmt.setString(4, dv.getDonVi());
//			stmt.setString(5,dv.getTrangThai());
//			stmt.setString(6, dv.getMaDichVu());
//			stmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}
//	}
//	// thay đổi trạng thái của dịch vụ
//	public boolean markDichVuAsNgungBan(String maDichVu) {
//	    ConnectDB.getInstance();
//	    Connection con = ConnectDB.getConnection();
//	    PreparedStatement stmt = null;
//	    int n = 0;
//	    try {
//	        stmt = con.prepareStatement("UPDATE tbl_DichVu SET TrangThai = N'Ngừng Bán' WHERE MaDichVu = ?");
//	        stmt.setString(1, maDichVu);
//	        n = stmt.executeUpdate();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        try {
//	            stmt.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    return n > 0;
//	}
//	// tìm danh sách phòng theo giá dịch vụ
//	public ArrayList<DichVu> getAllPhongTheoGiaDV(String gia) {
//		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT * from tbl_DichVu where GiaDichVu <= '" + gia + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				float donGia = rs.getFloat(3);
//				int soLuong = rs.getInt(4);
//				String donVi = rs.getString(5);
//				String trangThai = rs.getNString(6);
//
//				DichVu dv = new DichVu(ma, ten, donGia, soLuong, donVi, trangThai);
//						
//				dsDichVu.add(dv);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsDichVu;
//	}
//	// tìm danh sách phòng theo giá dịch vụ
//	public ArrayList<DichVu> getAllPhongTheoGiaDV_1(String giaCu, String giaMoi) {
//		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT * from tbl_DichVu where GiaDichVu > '" + giaCu + "' and GiaDichVu <= '" + giaMoi + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				float donGia = rs.getFloat(3);
//				int soLuong = rs.getInt(4);
//				String donVi = rs.getString(5);
//				String trangThai = rs.getNString(6);
//
//				DichVu dv = new DichVu(ma, ten, donGia, soLuong, donVi, trangThai);
//						
//				dsDichVu.add(dv);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsDichVu;
//	}
//	// tìm danh sách phòng theo giá dịch vụ
//	public ArrayList<DichVu> getAllPhongTheoGiaDV_3(String gia) {
//		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT * from tbl_DichVu where GiaDichVu > '" + gia + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				float donGia = rs.getFloat(3);
//				int soLuong = rs.getInt(4);
//				String donVi = rs.getString(5);
//				String trangThai = rs.getNString(6);
//
//				DichVu dv = new DichVu(ma, ten, donGia, soLuong, donVi, trangThai);
//						
//				dsDichVu.add(dv);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsDichVu;
//	}
//	// tìm danh sách phòng theo đơn vị
//	public ArrayList<DichVu> getAllPhongTheoDonVi(String don) {
//		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT * from tbl_DichVu where DonVi = N'" + don + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				float donGia = rs.getFloat(3);
//				int soLuong = rs.getInt(4);
//				String donVi = rs.getString(5);
//				String trangThai = rs.getNString(6);
//
//				DichVu dv = new DichVu(ma, ten, donGia, soLuong, donVi, trangThai);
//						
//				dsDichVu.add(dv);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsDichVu;
//	}
//	// tìm danh sách phòng theo tình trạng
//	public ArrayList<DichVu> getAllPhongTheoTinhTrang(String tt) {
//		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT * from tbl_DichVu where TrangThai = N'" + tt + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				float donGia = rs.getFloat(3);
//				int soLuong = rs.getInt(4);
//				String donVi = rs.getString(5);
//				String trangThai = rs.getNString(6);
//
//				DichVu dv = new DichVu(ma, ten, donGia, soLuong, donVi, trangThai);
//						
//				dsDichVu.add(dv);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsDichVu;
//	}
//	// tìm danh sách phòng theo tên dịch vụ
//	public ArrayList<DichVu> getAllPhongTheoTen(String t) {
//		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT * from tbl_DichVu where TenDichVu like N'%" + t + "%'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				float donGia = rs.getFloat(3);
//				int soLuong = rs.getInt(4);
//				String donVi = rs.getString(5);
//				String trangThai = rs.getNString(6);
//
//				DichVu dv = new DichVu(ma, ten, donGia, soLuong, donVi, trangThai);
//						
//				dsDichVu.add(dv);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsDichVu;
//	}
//	// tìm nhân viên theo ten
//		public DichVu getDVtheoTen(String tenDV) {
//			DichVu dv = null;
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement stmt = null;
//			try {
//				
//				String sql = "SELECT * FROM tbl_DichVu WHERE TenDichVu = ?";
//				stmt=con.prepareStatement(sql);
//				stmt.setString(1, tenDV);
//				ResultSet rs = stmt.executeQuery();
//				while(rs.next()){
//					 dv = new DichVu(rs.getString(1), rs.getString(2), 
//							 rs.getFloat(3), rs.getInt(4), rs.getString(5),
//							 rs.getString(6));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			finally {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//					// TODO: handle exception
//				}
//			}
//			return dv;
//		}
//
//		public List<DichVu> getDichVuUaThich() {
//
//			String sql = "SELECT tbl_ChiTietHoaDon.MaDichVu, tbl_DichVu.TenDichVu, tbl_DichVu.GiaDichVu, "
//					+ "soLuongBan = SUM(tbl_ChiTietHoaDon.SoLuong), tongDoanhThu=SUM(tbl_ChiTietHoaDon.SoLuong)*tbl_DichVu.GiaDichVu\r\n"
//					+ "FROM tbl_ChiTietHoaDon INNER JOIN tbl_DichVu ON tbl_ChiTietHoaDon.MaDichVu = tbl_DichVu.MaDichVu \r\n"
//					+ "GROUP BY tbl_ChiTietHoaDon.MaDichVu, tbl_DichVu.TenDichVu, tbl_DichVu.GiaDichVu\r\n"
//					+ "ORDER BY soLuongBan DESC";
//			PreparedStatement statement = null;
//			List<DichVu> list = new ArrayList<DichVu>();
//			try {
//
//				statement = ConnectDB.getConnection().prepareStatement(sql);
//
//				ResultSet rs = statement.executeQuery();
//
//				while (rs.next()) {
//						DichVu dv = new DichVu(rs.getString("MaDichVu"), rs.getString("TenDichVu"), rs.getFloat("GiaDichVu"));
//						list.add(dv);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return list;
//		}
//		
//		public int getSLBanTheoMa(String ma) {
//			int sl = 0;
//			String sql = "SELECT soLuongBan = SUM(tbl_ChiTietHoaDon.SoLuong)\r\n"
//					+ "FROM tbl_ChiTietHoaDon INNER JOIN tbl_DichVu ON tbl_ChiTietHoaDon.MaDichVu = tbl_DichVu.MaDichVu \r\n"
//					+ "WHERE tbl_ChiTietHoaDon.MaDichVu =  N'"+ma+"'\r\n"
//					+ "GROUP BY tbl_ChiTietHoaDon.MaDichVu, tbl_DichVu.TenDichVu, tbl_DichVu.GiaDichVu\r\n"
//					+ "ORDER BY soLuongBan DESC";
//			PreparedStatement statement = null;
//			try {
//				statement = ConnectDB.getConnection().prepareStatement(sql);
//				ResultSet r = statement.executeQuery();
//				r.next();
//				sl = r.getInt(1);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			finally {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			return sl;
//		}
//		
//		public double getTongDTTheoMa(String ma) {
//			double dt = 0;
//			String sql = "SELECT tongDoanhThu=SUM(tbl_ChiTietHoaDon.SoLuong)*tbl_DichVu.GiaDichVu\r\n"
//					+ "FROM tbl_ChiTietHoaDon INNER JOIN tbl_DichVu ON tbl_ChiTietHoaDon.MaDichVu = tbl_DichVu.MaDichVu \r\n"
//					+ "WHERE tbl_ChiTietHoaDon.MaDichVu =  N'"+ma+"'\r\n"
//					+ "GROUP BY tbl_ChiTietHoaDon.MaDichVu, tbl_DichVu.TenDichVu, tbl_DichVu.GiaDichVu\r\n";
//			PreparedStatement statement = null;
//			try {
//				statement = ConnectDB.getConnection().prepareStatement(sql);
//				ResultSet r = statement.executeQuery();
//				r.next();
//				dt = r.getDouble(1);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			finally {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			return dt;
//		}
//
}






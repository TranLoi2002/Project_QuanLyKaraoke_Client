//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import connectDB.ConnectDB;
//import entity.DichVu;
//import entity.DonDatPhong;
//import entity.KhachHang;
//import entity.PhongHat;
//
//public class DonDatPhong_DAO {
//	public ArrayList<DonDatPhong> getAllDonDatPhongTheoMaPH(String ma) {
//
//		
//		ArrayList<DonDatPhong> list = new ArrayList<DonDatPhong>();
//		try {
//
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "select MaDonDatPhong, ddp.MaKhachHang, TenKhachHang, SoDienThoai, ddp.MaPhongHat, TenPhongHat, NgayDat, gioDat\r\n"
//					+ "from tbl_DonDatPhong ddp join tbl_KhachHang kh on ddp.MaKhachHang = kh.MaKhachHang \r\n"
//					+ "join tbl_PhongHat p on ddp.MaPhongHat = p.MaPhongHat where p.MaPhongHat = '"+ma+"'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				DonDatPhong ddp = new DonDatPhong(rs.getString("MaDonDatPhong"), rs.getDate("NgayDat"), rs.getTime("gioDat"), 
//						new PhongHat(rs.getString("MaPhongHat"), rs.getString("TenPhongHat")),
//						new KhachHang(rs.getString("MaKhachHang"),rs.getString("TenKhachHang"),rs.getString("SoDienThoai")));
//				list.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	
//	// thêm đơn đặt phòng
//	public  void addDonDatPhong(DonDatPhong ddp) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//				statement = con.prepareStatement("insert into tbl_DonDatPhong values(?,?,?,?,?)");
//				statement.setString(1, ddp.getMaDonDatPhong());
//				statement.setDate(2, ddp.getNgayDat());
//				statement.setTime(3, ddp.getGioDat());
//				statement.setString(4, ddp.getPhongHat().getMaPhongHat());
//				statement.setString(5, ddp.getKhachHang().getMaKhachHang());
//				statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				// TODO: handle exception
//			}
//		}
//	}
//	// kiểm tra mã có trùng không
//	public int kiemTraMaDonDatPhong(String ma) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_DonDatPhong WHERE MaDonDatPhong = ?");
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
//		return 0;
//	}
//	// hủy đặt phòng
//	public  void deletePhieuDatPhong(String maDDP) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		String sql = "delete from tbl_DonDatPhong where MaDonDatPhong=?";
//		try {
//				statement = con.prepareStatement(sql);
//				statement.setString(1, maDDP);
//				statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				// TODO: handle exception
//			}
//		}
//	}
//	//tim mã đơn đặt theo tên khách hàng và tên phòng
//	public String getMaDDPTheoTenKH(String tenKH, String tenPH) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		String ma = null;
//		try {
//			statement = con.prepareStatement("select MaDonDatPhong\r\n"
//					+ "from (tbl_DonDatPhong ddp join tbl_KhachHang kh on ddp.MaKhachHang = kh.MaKhachHang) "
//					+ "join tbl_PhongHat p on ddp.MaPhongHat = p.MaPhongHat\r\n"
//					+ "where kh.TenKhachHang = N'" + tenKH + "' and p.TenPhongHat = '" + tenPH + "'");
//			statement.setString(1, tenKH);
//			statement.setString(2, tenPH);
//			ResultSet rs = statement.executeQuery();
//		    ma = rs.getString(1);
//		    return ma;
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
//		return ma;
//	}
//	public String getMaDDPTheoMaPH(String maPH) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		String ma = null;
//		try {
//			statement = con.prepareStatement("SELECT MaDonDatPhong FROM tbl_DonDatPhong ddp JOIN tbl_PhongHat p "
//					+ "ON ddp.MaPhongHat = p.MaPhongHat WHERE ddp.MaPhongHat = ?");
//
//			statement.setString(1, maPH);
//			ResultSet rs = statement.executeQuery();
//		    ma = rs.getString(1);
//		    return ma;
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
//		return ma;
//	}
//	
//	// get DDP theo ma
//	public DonDatPhong getDonDatPhongtheoMaPH(String maPH) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		DonDatPhong ddp = null;
//		
//		try {
//
//			statement = con.prepareStatement("SELECT ddp.MaDonDatPhong ,ddp.NgayDat,ddp.GioDat,ddp.MaPhongHat,ddp.MaKhachHang,kh.TenKhachHang,kh.SoDienThoai FROM tbl_DonDatPhong ddp JOIN tbl_PhongHat p  ON ddp.MaPhongHat = p.MaPhongHat JOIN tbl_KhachHang kh  ON ddp.MaKhachHang = kh.MaKhachHang WHERE p.MaPhongHat = ?");
//			statement.setString(1, maPH);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				ddp = new DonDatPhong(rs.getString("MaDonDatPhong"), rs.getDate("NgayDat"), rs.getTime("gioDat"), 
//						new PhongHat(rs.getString("MaPhongHat")),
//						new KhachHang(rs.getString("MaKhachHang"),rs.getString("TenKhachHang"),rs.getString("SoDienThoai")));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ddp;
//	}
//	//Cập nhật thông tin đặt phòng
//	public void capNhat_DonDatPhong(DonDatPhong ddp) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement("UPDATE tbl_DonDatPhong SET NgayDat=? , GioDat=? WHERE MaDonDatPhong=?");
//			stmt.setDate(1, ddp.getNgayDat());
//			stmt.setTime(2, ddp.getGioDat());
//			stmt.setString(3, ddp.getMaDonDatPhong());
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
//	// số lượng đơn đặt phòng theo mã phòng
//	public int getSoLuongMaDDPTheoMaPhong(String ma) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_DonDatPhong WHERE MaPhongHat = ?");
//			statement.setString(1, ma);
//			ResultSet rs = statement.executeQuery();
//			rs.next();
//			int soLuongDonDatPhong = rs.getInt(1);
//		    
//		    return soLuongDonDatPhong;
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
//
//}

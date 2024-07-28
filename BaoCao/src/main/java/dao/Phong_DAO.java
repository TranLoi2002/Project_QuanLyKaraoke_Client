//package dao;
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import connectDB.ConnectDB;
//import java.sql.Statement;
//
//import entity.LoaiPhong;
//import entity.NhanVien;
//import entity.PhongHat;
//public class Phong_DAO {
//	public ArrayList<PhongHat> getAllPhong() {
//		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
//		
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//				
//				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
//				dsPhong.add(p);
//			}
//		
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsPhong;
//	}
//	// thêm phòng mới
//	public void addPhong(PhongHat p) {
//
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//				statement = con.prepareStatement("insert into tbl_PhongHat values(?,?,?,?,?,?)");
//				statement.setString(1, p.getMaPhongHat());
//				statement.setString(2, p.getTenPhongHat());
//				statement.setDouble(3, p.getGiaPhong());
//				statement.setString(4, p.getTinhTrang());
//				statement.setInt(5, p.getSucChua());
//				statement.setString(6, p.getLoaiPhong().getMaLoaiPhong());
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
//	public int kiemTraMa(String ma) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_PhongHat WHERE MaPhongHat = ?");
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
//	//Xóa phòng trên SQL
//	public boolean delete_Phong(String ma) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("DELETE FROM tbl_PhongHat WHERE MaPhongHat =?");
//			stmt.setString(1, ma);
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//					
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return n > 0;
//	}
//	//Cập nhật thông tin phòng
//	public void capNhat_PhongHat(PhongHat ph) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement("UPDATE tbl_PhongHat SET TenPhongHat=? , GiaPhong=? , TinhTrang=? , SucChua=? , MaLoaiPhong=? WHERE MaPhongHat=?");
//			stmt.setString(1, ph.getTenPhongHat());
//			stmt.setDouble(2, ph.getGiaPhong());
//			stmt.setString(3, ph.getTinhTrang());
//			stmt.setInt(4, ph.getSucChua());
//			stmt.setString(5, ph.getLoaiPhong().getMaLoaiPhong());
//			stmt.setString(6, ph.getMaPhongHat());
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
//	// kiểm tra tên phòng không trùng
//	public int kiemTraTen(String tenPhong) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_PhongHat WHERE TenPhongHat = ?");
//			statement.setString(1, tenPhong);
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
//	// tìm phòng hát theo mã
//	public PhongHat getPhongtheoMa(String ma) {
//		PhongHat p = null;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement("SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong where MaPhongHat = ?");
//			stmt.setString(1, ma);
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()) {
//				String maP = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//				
//				p = new PhongHat(maP, ten, lp, donGia, tinhTrang, sucChua);
//			}
//		
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return p;
//	}
//	// tìm phòng hát theo tên phòng
//	public PhongHat getPhongtheoSoPhong(String sp) {
//		PhongHat p = null;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement("SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong where TenPhongHat = ?");
//			stmt.setString(1, sp);
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()) {
//				String maP = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//				
//				p = new PhongHat(maP, ten, lp, donGia, tinhTrang, sucChua);
//			}
//		
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return p;
//	}
//	// tìm danh sách phòng theo loại phòng
//	public ArrayList<PhongHat> getAllPhongTheoLoaiPhong(String loai) {
//		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong where l.TenLoaiPhong = N'" + loai + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//
//				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
//				dsPhong.add(p);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsPhong;
//	}
//	// tìm danh sách phòng theo tình trạng
//	public ArrayList<PhongHat> getAllPhongTheoTinhTrang(String tt) {
//		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong where p.TinhTrang = N'" + tt + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//
//				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
//				dsPhong.add(p);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsPhong;
//	}
//	// tìm danh sách phòng theo sức chưa
//	public ArrayList<PhongHat> getAllPhongTheoSucChua(String sc) {
//		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong where p.SucChua = N'" + sc + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//
//				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
//				dsPhong.add(p);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsPhong;
//	}
//	// tìm danh sách phòng theo tên phòng
//	public ArrayList<PhongHat> getAllPhongTheoTenPhong(String t) {
//		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong where p.TenPhongHat like N'%" + t + "%'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//
//				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
//				dsPhong.add(p);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsPhong;
//	}
//	// tìm danh sách phòng theo loại phòng và tình trạng
//	public ArrayList<PhongHat> getAllPhongTheoLPTT(String loai, String tt) {
//		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong" +
//						" FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong "
//						+ "where l.TenLoaiPhong like N'" + loai + "' and p.TinhTrang like N'" + tt + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//
//				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
//				dsPhong.add(p);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsPhong;
//	}
//	// tìm danh sách phòng theo loại phòng và sức chứa
//	public ArrayList<PhongHat> getAllPhongTheoLPSC(String loai, String sc) {
//		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong" +
//						" FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong "
//						+ "where l.TenLoaiPhong like N'" + loai + "' and p.SucChua like N'" + sc + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//
//				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
//				dsPhong.add(p);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsPhong;
//	}
//	// tìm danh sách phòng theo tình trạng và sức chứa
//	public ArrayList<PhongHat> getAllPhongTheoTTSC(String tt, String sc) {
//		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong" +
//						" FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong "
//						+ "where p.TinhTrang like N'" + tt + "' and p.SucChua like N'" + sc + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//
//				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
//				dsPhong.add(p);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsPhong;
//	}
//	// tìm danh sách phòng theo tình trạng và sức chứa
//	public ArrayList<PhongHat> getAllPhongTheoLPTTSC(String loai, String tt, String sc) {
//		ArrayList<PhongHat> dsPhong = new ArrayList<PhongHat>();
//
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT p.MaPhongHat, p.TenPhongHat, p.GiaPhong, p.TinhTrang, p.SucChua, p.MaLoaiPhong, l.TenLoaiPhong" +
//						" FROM tbl_PhongHat p join tbl_LoaiPhong l on p.MaLoaiPhong = l.MaLoaiPhong "
//						+ "where p.TinhTrang like N'" + tt + "' and p.SucChua like N'" + sc + "' and l.TenLoaiPhong like N'" + loai + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				double donGia = rs.getDouble(3);
//				String tinhTrang = rs.getString(4);
//				int sucChua = rs.getInt(5);
//				LoaiPhong lp = new LoaiPhong(rs.getString(6), rs.getString(7));
//
//				PhongHat p = new PhongHat(ma, ten, lp, donGia, tinhTrang, sucChua);
//				dsPhong.add(p);
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsPhong;
//	}
//	//Chuyen trang thai tu trong sang cho
//	public void datPhong(String tt,String ma) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement("UPDATE tbl_PhongHat SET TinhTrang=? WHERE MaPhongHat=?");
//			stmt.setString(1, tt);
//			stmt.setString(2, ma);
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
//	//Chuyen trang thai tu trong hoặc chờ sang đang sử dụng
//	public void nhanPhong(String tt,String ma) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement("UPDATE tbl_PhongHat SET TinhTrang=? WHERE MaPhongHat=?");
//			stmt.setString(1, tt);
//			stmt.setString(2, ma);
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
//
//}

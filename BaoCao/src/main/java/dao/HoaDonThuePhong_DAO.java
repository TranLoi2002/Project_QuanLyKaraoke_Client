//package dao;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Time;
//import java.util.ArrayList;
//
//import connectDB.ConnectDB;
//import entity.ChiTietDichVu;
//import entity.DichVu;
//import entity.DonDatPhong;
//import entity.HoaDonThuePhong;
//import entity.KhachHang;
//import entity.LoaiPhong;
//import entity.NhanVien;
//import entity.PhongHat;
//
//public class HoaDonThuePhong_DAO {
//	
//	public ArrayList<HoaDonThuePhong> getAllHoaDonThuePhong() {
//		ArrayList<HoaDonThuePhong> dsHoaDonThuePhong = new ArrayList<HoaDonThuePhong>();
//		
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "Select hd.MaHoaDon, NgayTaoHoaDon, GioVao, GioRa, ph.MaPhongHat, TenPhongHat, GiaPhong, TinhTrang, SucChua, MaLoaiPhong, kh.MaKhachHang, TenKhachHang,\r\n"
//					+ "kh.SoDienThoai, kh.CCCD, kh.GioiTinh, kh.DiaChi, nv.MaNhanVien, TenNhanVien, NgaySinh, nv.SoDienThoai, nv.CCCD, nv.GioiTinh, nv.DiaChi, nv.ChucVu, nv.TrangThai\r\n"
//					+ "from ((tbl_HoaDonThuePhong hd JOIN tbl_PhongHat  ph on ph.MaPhongHat = hd.MaPhongHat)\r\n"
//					+ "join tbl_KhachHang kh on hd.MaKhachHang = kh.MaKhachHang)\r\n"
//					+ "join tbl_NhanVien nv on nv.MaNhanVien = hd.MaNhanVien";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String mahd = rs.getString(1);
//				Date ngayTaoHoaDon = rs.getDate(2);
//				Time gioVao = rs.getTime(3);
//				Time gioRa = rs.getTime(4);
//				PhongHat ph = new PhongHat(rs.getString(5), rs.getString(6), new LoaiPhong(rs.getString(10)), rs.getFloat(7), rs.getString(8), rs.getInt(9));
//				KhachHang kh = new KhachHang(rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16));
//				NhanVien nv = new NhanVien(rs.getString(17), rs.getString(18), rs.getDate(19), rs.getString(20), rs.getString(21), rs.getInt(22), rs.getString(23), rs.getString(24), rs.getString(25));
//				
//				HoaDonThuePhong ctdv = new HoaDonThuePhong(mahd,ngayTaoHoaDon,gioVao,gioRa,kh,nv,ph);
//				dsHoaDonThuePhong.add(ctdv);
//			}
//		
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsHoaDonThuePhong;
//	}
//	// thêm hóa đơn thuê phòng
//	public  void addHoaDon(HoaDonThuePhong hd) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//				statement = con.prepareStatement("insert into tbl_HoaDonThuePhong values(?,?,?,?,?,?,?)");
//				statement.setString(1, hd.getMaHoaDon());
//				statement.setDate(2, hd.getNgayTaoHoaDon());
//				statement.setTime(3, hd.getGioVao());
//				statement.setTime(4, hd.getGioRa());
//				statement.setString(5, hd.getKhachHang().getMaKhachHang());
//				statement.setString(6, hd.getNhanVien().getMaNhanVien());
//				statement.setString(7, hd.getPhongHat().getMaPhongHat());
//
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
//
//	public ArrayList<HoaDonThuePhong> getHDTheoNgay(Date ngay) {
//	    ArrayList<HoaDonThuePhong> dsHD = new ArrayList<HoaDonThuePhong>();
//	    Connection con = null;
//	    PreparedStatement statement = null;
//	    ResultSet rs = null;
//
//	    try {
//	        con = ConnectDB.getConnection();
//	        String sql = "SELECT hdtp.MaHoaDon, hdtp.NgayTaoHoaDon, hdtp.MaNhanVien, nv.TenNhanVien, hdtp.MaKhachHang, kh.TenKhachHang, kh.SoDienThoai, hdtp.MaPhongHat, ph.TenPhongHat, hdtp.GioVao, hdtp.GioRa\r\n"
//	        		+ "FROM tbl_HoaDonThuePhong hdtp INNER JOIN tbl_KhachHang kh ON hdtp.MaKhachHang = kh.MaKhachHang \r\n"
//	        		+ "INNER JOIN tbl_NhanVien nv ON nv.MaNhanVien = hdtp.MaNhanVien \r\n"
//	        		+ "INNER JOIN tbl_PhongHat ph ON hdtp.MaPhongHat = ph.MaPhongHat \r\n"
//	        		+ "WHERE hdtp.NgayTaoHoaDon = ?"; // Thay Ä‘á»•i pháº§n Ä‘iá»u kiá»‡n láº¥y theo ngĂ y
//
//	        statement = con.prepareStatement(sql);
//	        statement.setDate(1, ngay);
//	        rs = statement.executeQuery();
//
//	        while (rs.next()) {
//	            HoaDonThuePhong hd = new HoaDonThuePhong(rs.getString("MaHoaDon"), rs.getDate("NgayTaoHoaDon"), rs.getTime("GioVao"), rs.getTime("GioRa"),
//	                    new KhachHang(rs.getString("MaKhachHang"), rs.getString("TenKhachHang") , rs.getString("SoDienThoai")),
//	                    new NhanVien(rs.getString("MaNhanVien")),
//	                    new PhongHat(rs.getString("MaPhongHat"), rs.getString("TenPhongHat"))
//	            );
//	            dsHD.add(hd);
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
////	    } finally {
////	        try {
//////	            if (rs != null) rs.close();
//////	            if (statement != null) statement.close();
//////	            if (con != null) con.close();
////	        } catch (SQLException e) {
////	            e.printStackTrace();
////	        }
//	    }
//	    return dsHD;
//	}
//	
//	public ArrayList<HoaDonThuePhong> getHDTheoThang(int thang) {
//	    ArrayList<HoaDonThuePhong> dsHD = new ArrayList<HoaDonThuePhong>();
//	    Connection con = null;
//	    PreparedStatement statement = null;
//	    ResultSet rs = null;
//
//	    try {
//	        con = ConnectDB.getConnection();
//	        String sql = "SELECT hdtp.MaHoaDon, hdtp.NgayTaoHoaDon, hdtp.MaNhanVien, nv.TenNhanVien, hdtp.MaKhachHang, kh.TenKhachHang, kh.SoDienThoai, hdtp.MaPhongHat, ph.TenPhongHat, hdtp.GioVao, hdtp.GioRa\r\n"
//	        		+ "FROM tbl_HoaDonThuePhong hdtp \r\n"
//	        		+ "INNER JOIN tbl_KhachHang kh ON hdtp.MaKhachHang = kh.MaKhachHang \r\n"
//	        		+ "INNER JOIN tbl_NhanVien nv ON nv.MaNhanVien = hdtp.MaNhanVien \r\n"
//	        		+ "INNER JOIN tbl_PhongHat ph ON hdtp.MaPhongHat = ph.MaPhongHat \r\n"
//	        		+ "WHERE MONTH(hdtp.NgayTaoHoaDon) = ?"; // Thay Ä‘á»•i pháº§n Ä‘iá»u kiá»‡n láº¥y theo thang
//
//	        statement = con.prepareStatement(sql);
//	        statement.setInt(1, thang);
//	        rs = statement.executeQuery();
//
//	        while (rs.next()) {
//	            HoaDonThuePhong hd = new HoaDonThuePhong(rs.getString("MaHoaDon"), rs.getDate("NgayTaoHoaDon"), rs.getTime("GioVao"), rs.getTime("GioRa"),
//	                    new KhachHang(rs.getString("MaKhachHang"), rs.getString("TenKhachHang") , rs.getString("SoDienThoai")),
//	                    new NhanVien(rs.getString("MaNhanVien")),
//	                    new PhongHat(rs.getString("MaPhongHat"), rs.getString("TenPhongHat"))
//	            );
//	            dsHD.add(hd);
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return dsHD;
//	}
//
//
//	
//	public double getTongTienThanhToanTheoNgay(Date ngay) {
//	    double tongTien = 0;
//	    String sql = "SELECT SUM(TongTien) AS totalTongTien FROM tbl_HoaDonTT " +
//	                 "INNER JOIN tbl_HoaDonThuePhong ON tbl_HoaDonTT.MaHoaDon = tbl_HoaDonThuePhong.MaHoaDon " +
//	                 "WHERE tbl_HoaDonThuePhong.NgayTaoHoaDon = ?";
//	    
//	    PreparedStatement statement = null;
//	    try {
//	        statement = ConnectDB.getConnection().prepareStatement(sql);
//	        statement.setDate(1, ngay);
//	        ResultSet resultSet = statement.executeQuery();
//	        
//	        if (resultSet.next()) {
//	            tongTien = resultSet.getDouble("totalTongTien");
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        try {
//	            if (statement != null) {
//	                statement.close();
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    return tongTien;
//	}
//	
//	
//	// tinh tong doanh thu theo thangs
//	public double getTongTienThanhToanTheoThang(Date thang ) {
//	    double tongTien = 0;
//	    String sql = "SELECT SUM(TongTien) AS totalTongTien FROM tbl_HoaDonTT " +
//	                 "INNER JOIN tbl_HoaDonThuePhong ON tbl_HoaDonTT.MaHoaDon = tbl_HoaDonThuePhong.MaHoaDon " +
//	                 "WHERE tbl_HoaDonThuePhong.NgayTaoHoaDon = ?";
//	    
//	    PreparedStatement statement = null;
//	    try {
//	        statement = ConnectDB.getConnection().prepareStatement(sql);
//	        statement.setDate(1, thang);
//	        ResultSet resultSet = statement.executeQuery();
//	        
//	        if (resultSet.next()) {
//	            tongTien = resultSet.getDouble("totalTongTien");
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        try {
//	            if (statement != null) {
//	                statement.close();
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    return tongTien;
//	}
//
//	
//	public  ArrayList<HoaDonThuePhong> getHDTheoMaKH(String maKH) {
//	
//		ArrayList<HoaDonThuePhong> dsHD = new ArrayList<HoaDonThuePhong>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//		
//			String sql = "SELECT HoaDonThuePhong.maHoaDon, HoaDonThuePhong.ngayLapHD, HoaDonThuePhong.maNhanVien, NhanVien.tenNhanVien, "
//					+ "HoaDonThuePhong.maKhachHang, KhachHang.tenKhachHang, HoaDonThuephong.maPhong, PhongHat.tenPhong, "
//					+ "HoaDonThuePhong.gioVao, HoaDonThuePhong.gioRa, HoaDonThuePhong.tongTienPhong FROM HoaDon "
//					+ "INNER JOIN KhachHang ON HoaDonThuePhong.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien "
//					+ "ON HoaDonThuePhong.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDonThuephong.maPhong = PhongHat.maPhong "
//					+ "WHERE KhachHang.maKhachHang ='"+maKH+"'";
//			statement=con.prepareStatement(sql);
//			ResultSet rs = statement.executeQuery();
//			
//			while(rs.next()){
//				HoaDonThuePhong hd = new HoaDonThuePhong(rs.getString("MaHoaDon"), rs.getDate("NgayTaoHoaDon"),rs.getTime("gioVao"), rs.getTime("gioRa"),
//						new KhachHang(rs.getString("maKhachHang")),
//						new NhanVien(rs.getString("MaNhanVien")),
//						new PhongHat(rs.getString("MaPhongHat"), rs.getString("TenPhongHat"))
//						);
//				dsHD.add(hd);
//			}
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
//		return dsHD;
//	}
//
//}

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
//import entity.HoaDonThanhToan;
//import entity.HoaDonThuePhong;
//import entity.KhachHang;
//import entity.LoaiPhong;
//import entity.NhanVien;
//import entity.PhongHat;
//
//public class HoaDonThanhToan_DAO {
//	public ArrayList<HoaDonThanhToan> getAllHoaDonThanhToan() {
//		ArrayList<HoaDonThanhToan> dsHoaDonThanhToan = new ArrayList<HoaDonThanhToan>();
//		
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "Select MaHoaDonTT,NgayThanhToan,TongThoiGianSuDung,TienPhong,TienDichVu,TienNhan,TongTien,hd.MaHoaDon,kh.MaKhachHang,TenKhachHang,ph.MaPhongHat,TenPhongHat,GioVao,GioRa,TongTien\n"
//					+ "					from tbl_HoaDonTT hd\n"
//					+ "                    Join tbl_HoaDonThuePhong hdtp on hd.MaHoaDon = hdtp.MaHoaDon\n"
//					+ "                    JOIN tbl_PhongHat ph on hdtp.MaPhongHat = ph.MaPhongHat\n"
//					+ "                    join tbl_KhachHang kh on kh.MaKhachHang = hdtp.MaKhachHang ";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String mahdtt = rs.getString(1);
//				Date ngayTaoHoaDon = rs.getDate(2);
//				int thoigiansd = rs.getInt(3);
//				float tienPhong = rs.getFloat(4);
//				float tienDichVu = rs.getFloat(5);
//				float tienNhan = rs.getFloat(6);
//				float tongTien = rs.getFloat(7);
//				String mahd = rs.getString(8);
//				String makh = rs.getString(9);
//				String tenkh = rs.getString(10);
//				String maph = rs.getString(11);
//				String tenph = rs.getString(12);
//				Time giovao = rs.getTime(13);
//				Time giora = rs.getTime(14);
//				KhachHang kh = new KhachHang(makh,tenkh);
//				PhongHat ph = new PhongHat(maph,tenph);
//				HoaDonThuePhong hd = new HoaDonThuePhong(mahd,giovao,giora,kh,ph);
//				HoaDonThanhToan ctdv = new HoaDonThanhToan(mahdtt,ngayTaoHoaDon,thoigiansd,tienPhong,tienDichVu,tienNhan,tongTien,hd);
//				dsHoaDonThanhToan.add(ctdv);
//			}
//		
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsHoaDonThanhToan;
//	}
//	
//	public  void addHoaDon(HoaDonThanhToan hd) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//				statement = con.prepareStatement("insert into tbl_HoaDonTT values(?,?,?,?,?,?,?,?)");
//				statement.setString(1, hd.getMaHoaDonTT());
//				statement.setDate(2, hd.getNgayThanhToan());
//				statement.setInt(3, hd.getTongThoiGianSuDung());
//				statement.setFloat(4, hd.getTienPhong());
//				statement.setFloat(5, hd.getTienDichVu());
//				statement.setFloat(6, hd.getTienNhan());
//				statement.setFloat(7, hd.getTongTien());
//				statement.setNString(8, hd.getHoaDonThuePhong().getMaHoaDon());
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
//		public ArrayList<HoaDonThanhToan> getAllHoaDonThanhToan_1() {
//			ArrayList<HoaDonThanhToan> dsHoaDonThanhToan = new ArrayList<HoaDonThanhToan>();
//			
//			try {
//				ConnectDB.getInstance();
//				Connection con = ConnectDB.getConnection();
//				String sql = "SELECT * from tbl_HoaDonTT";
//				Statement statement = con.createStatement();
//				ResultSet rs = statement.executeQuery(sql);
//				while(rs.next()) {
//					String mahdtt = rs.getString(1);
//					Date ngayTaoHoaDon = rs.getDate(2);
//					int thoigiansd = rs.getInt(3);
//					float tienPhong = rs.getFloat(4);
//					float tienDichVu = rs.getFloat(5);
//					float tienNhan = rs.getFloat(6);
//					float tongTien = rs.getFloat(7);
//					String mahd = rs.getString(8);
//					HoaDonThuePhong hd = new HoaDonThuePhong(mahd);
//					HoaDonThanhToan ctdv = new HoaDonThanhToan(mahdtt,ngayTaoHoaDon,thoigiansd,tienPhong,tienDichVu,tienNhan,tongTien,hd);
//					dsHoaDonThanhToan.add(ctdv);
//				}
//			
//			} catch (SQLException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//			return dsHoaDonThanhToan;
//		}
//		
//		public double getTongTienThanhToanTheoPhong(String maPhongHat, Date ngay) {
//	        double tongTien = 0;
//	        String sql = "SELECT MaPhongHat, SUM(TongTien) AS TongTienThanhToan FROM tbl_HoaDonTT hdtt\n"
//	        		+ "Join tbl_HoaDonThuePhong hdtp On hdtt.MaHoaDon = hdtp.MaHoaDon\n"
//	        		+ "where hdtp.MaPhongHat = ? and hdtp.NgayTaoHoaDon = ? \n"
//	        		+ "GROUP BY MaPhongHat";
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setString(1, maPhongHat);
//	            statement.setDate(2, ngay);
//	            ResultSet resultSet = statement.executeQuery();
//	            if (resultSet.next()) {
//	                tongTien = resultSet.getDouble("TongTienThanhToan");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if (statement != null) {
//	                    statement.close();
//	                }
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return tongTien;
//	    }
//	    
//	    public double getTongTienDichVuTheoNgay(Date ngay) {
//	        double tongTien = 0;
//	        String sql = "SELECT SUM(TienDichVu) AS TongTienDichVu FROM tbl_HoaDonTT hdtt\n"
//	        		+ "join tbl_HoaDonThuePhong hdtp on hdtp.MaHoaDon = hdtt.MaHoaDon\n"
//	        		+ "WHERE NgayTaoHoaDon = ?";
//	     
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setDate(1, ngay);
//	            ResultSet resultSet = statement.executeQuery();
//	            if (resultSet.next()) {
//	                tongTien = resultSet.getDouble("TongTienDichVu");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if (statement != null) {
//	                    statement.close();
//	                }
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return tongTien;
//	    }
//
//	    
//	    
//	    
//	    public double getTongTienDichVuTheoPhong(String maPhongHat, Date ngay) {
//	        double tongTien = 0;
//	        String sql = "SELECT SUM(TienDichVu) AS TongTienDV FROM tbl_HoaDonTT hdtt\n"
//	        		+ "Join tbl_HoaDonThuePhong hdtp On hdtt.MaHoaDon = hdtp.MaHoaDon\n"
//	        		+ "where hdtp.MaPhongHat = ? and hdtp.NgayTaoHoaDon = ?";
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setString(1, maPhongHat);
//	            statement.setDate(2, ngay);
//	            ResultSet resultSet = statement.executeQuery();
//	            if (resultSet.next()) {
//	                tongTien = resultSet.getDouble("TongTienDV");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if (statement != null) {
//	                    statement.close();
//	                }
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return tongTien;
//	    }
//	    
//	    public int getTongThoiGianSuDungTheoPhong(String maPhongHat, Date ngay) {
//	        int tongThoiGian = 0;
//	        String sql = "SELECT MaPhongHat, SUM(TongThoiGianSuDung) AS TongThoiGian FROM tbl_HoaDonTT hdtt\n"
//	        		+ "Join tbl_HoaDonThuePhong hdtp On hdtt.MaHoaDon = hdtp.MaHoaDon\n"
//	        		+ "where hdtp.MaPhongHat = ? and hdtp.NgayTaoHoaDon = ? \n"
//	        		+ "GROUP BY MaPhongHat";
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setString(1, maPhongHat);
//	            statement.setDate(2, ngay);
//	            ResultSet resultSet = statement.executeQuery();
//	            if (resultSet.next()) {
//	                tongThoiGian = resultSet.getInt("TongThoiGian");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if (statement != null) {
//	                    statement.close();
//	                }
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return tongThoiGian;
//	    }
//	    
//	    public double getTongTienTheoNgay(Date ngay) {
//	        double tongTien = 0;
//	        String sql = "SELECT SUM(TongTien) AS TongTienThanhToan FROM tbl_HoaDonTT hdtt\n"
//	        		+ "Join tbl_HoaDonThuePhong hdtp On hdtt.MaHoaDon = hdtp.MaHoaDon\n"
//	        		+ "where hdtp.NgayTaoHoaDon = ? \n";
//	     
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setDate(1, ngay);
//	            ResultSet resultSet = statement.executeQuery();
//	            if (resultSet.next()) {
//	                tongTien = resultSet.getDouble("TongTienThanhToan");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if (statement != null) {
//	                    statement.close();
//	                }
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return tongTien;
//	    }
//	    
//	    // tinh tong tien theo thang
//	    public double getTongTienTheoThang(int thang) {
//	        double tongTien = 0;
//	        String sql = "SELECT SUM(TongTien) AS TongTienThanhToan FROM tbl_HoaDonTT hdtt\n"
//	        		+ "Join tbl_HoaDonThuePhong hdtp On hdtt.MaHoaDon = hdtp.MaHoaDon\n"
//	        		+ "where MONTH(hdtp.NgayTaoHoaDon) = ? \n";
//	     
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setInt(1, thang);
//	            ResultSet resultSet = statement.executeQuery();
//	            if (resultSet.next()) {
//	                tongTien = resultSet.getDouble("TongTienThanhToan");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if (statement != null) {
//	                    statement.close();
//	                }
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return tongTien;
//	    }
//	    
//	    public int getSoLanSuDungPhong(int ngay, int thang) {
//	        int soLan = 0;
//	        String sql = "SELECT Count(hdtp.MaPhongHat) AS TongSoLan FROM tbl_HoaDonTT hdtt\n"
//	        		+ "Join tbl_HoaDonThuePhong hdtp On hdtt.MaHoaDon = hdtp.MaHoaDon\n"
//	        		+ "where MONTH(hdtp.NgayTaoHoaDon) = ? AND DAY(hdtp.NgayTaoHoaDon) = ?";
//	     
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setInt(1, thang);
//	            statement.setInt(2, ngay);
//	            ResultSet resultSet = statement.executeQuery();
//	            if (resultSet.next()) {
//	                soLan = resultSet.getInt("TongSoLan");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if (statement != null) {
//	                    statement.close();
//	                }
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return soLan;
//	    }
//
//		
//
//}

//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import connectDB.ConnectDB;
//import entity.ChiTietDichVu;
//import entity.DichVu;
//import entity.HoaDonThuePhong;
//
//public class ChiTietDichVu_DAO {
//	public ArrayList<ChiTietDichVu> getAllChiTietDichVu() {
//		ArrayList<ChiTietDichVu> dsChiTietDichVu = new ArrayList<ChiTietDichVu>();
//		
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "select hd.MaHoaDon, ct.MaDichVu, ct.SoLuong, dv.TenDichVu, dv.GiaDichVu, dv.SoLuong, dv.DonVi, dv.TrangThai\n"
//					+ "from (tbl_ChiTietHoaDon ct join tbl_HoaDonThuePhong hd on ct.MaHoaDon = hd.MaHoaDon)\n"
//					+ "join tbl_DichVu dv on ct.MaDichVu = dv.MaDichVu";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String mahd = rs.getString(1);
//				HoaDonThuePhong maHD = new HoaDonThuePhong(mahd);
//				String madv = rs.getString(2);
//				DichVu maDV = new DichVu(madv);
//				int soLuong = rs.getInt(3);
//				
//				ChiTietDichVu ctdv = new ChiTietDichVu(maHD,maDV,soLuong);
//				dsChiTietDichVu.add(ctdv);
//			}
//		
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsChiTietDichVu;
//	}
//	// thêm chi tiết dịch vụ mới
//		public void addChiTietDichVu(ChiTietDichVu dv) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement statement = null;
//			try {
//				statement = con.prepareStatement("insert into tbl_ChiTietHoaDon values(?,?,?)");
//				statement.setString(1, dv.getHoaDonThuePhong().getMaHoaDon());
//				statement.setString(2, dv.getDichVu().getMaDichVu());
//				statement.setInt(3, dv.getSoLuong());
//				statement.executeUpdate();
//			} catch (SQLException e) {
//					e.printStackTrace();
//			}
//			finally {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//						e.printStackTrace();
//						// TODO: handle exception
//					}
//				}
//			}
//		//xoá chi tiết dịch vụ 
//		public boolean delete_ChiTietDichVu(String madv,String mahd ) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement stmt = null;
//			int n = 0;
//			try {
//				stmt = con.prepareStatement("DELETE FROM tbl_ChiTietHoaDon WHERE  MaDichVu=? and MaHoaDon=?");
//				stmt.setString(1, madv);
//				stmt.setString(2, mahd);
//				n = stmt.executeUpdate();
//			} catch (SQLException e) {
//								
//			} finally {
//				try {
//					stmt.close();
//			} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			return n > 0;
//		}
//		
//		public void capNhat_ChiTietDichVu(ChiTietDichVu dv) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement stmt = null;
//			try {
//				stmt = con.prepareStatement("UPDATE tbl_ChiTietHoaDon SET  SoLuong=? WHERE MaDichVu=? and MaHoaDon=?");
//				stmt.setInt(1, dv.getSoLuong());
//				stmt.setString(2,dv.getDichVu().getMaDichVu());
//				stmt.setString(3, dv.getHoaDonThuePhong().getMaHoaDon());
//				stmt.executeUpdate();
//			} catch (SQLException e) {
//				// TODO: handle exception
//			} finally {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
//			}
//		}
//		public DichVu getCTDVtheoMa(String maDV) {
//			DichVu dv = null;
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement stmt = null;
//			try {
//				
//				String sql = "select dv.MaDichVu,TenDichVu,dv.GiaDichVu,dv.SoLuong,DonVi,TrangThai from tbl_ChiTietHoaDon ct join tbl_DichVu dv on ct.MaDichVu = dv.MaDichVu WHERE dv.MaDichVu = ?";
//				stmt=con.prepareStatement(sql);
//				stmt.setString(1, maDV);
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
//}

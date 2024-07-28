//package dao;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import connectDB.ConnectDB;
//import entity.KhachHang;
//import entity.PhongHat;
//
//public class KhachHang_DAO {
//	public ArrayList<KhachHang> getAllKhachHang() {
//		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
//		
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT * from tbl_KhachHang";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while(rs.next()) {
//				String ma = rs.getString(1);
//				String ten = rs.getString(2);
//				String soDienThoai = rs.getString(3);
//				String cCCD = rs.getString(4);
//				int gioiTinh = rs.getInt(5);
//				String diaChi = rs.getString(6);
////				int soLanSuDung = rs.getInt(7);
//				KhachHang kh = new KhachHang(ma, ten, soDienThoai, cCCD, gioiTinh, diaChi);
//				dsKhachHang.add(kh);
//			}
//		
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dsKhachHang;
//	}
//	
//	// thêm khách hàng mới
//		public void addKhachHang(KhachHang kh) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement statement = null;
//			try {
//					statement = con.prepareStatement("insert into tbl_KhachHang values(?,?,?,?,?,?)");
//					statement.setString(1, kh.getMaKhachHang());
//					statement.setString(2, kh.getTenKhachHang());
//					statement.setString(3, kh.getSoDienThoai());
//					statement.setString(4, kh.getCCCD());
//					statement.setInt(5, kh.getGioiTinh());
//					statement.setString(6, kh.getDiaChi());
////					statement.setInt(7, kh.getSoLanSuDung());
//					statement.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			finally {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//					// TODO: handle exception
//				}
//			}
//		}
//		// kiểm tra mã có trùng không
//		public int kiemTraMa(String ma) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement statement = null;
//			try {
//				statement = con.prepareStatement("SELECT COUNT(*) FROM tbl_KhachHang WHERE MaKhachHang = ?");
//				statement.setString(1, ma);
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
//		//Xóa khách hàng trên SQL
//		public boolean delete_KhachHang(String ma) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement stmt = null;
//			int n = 0;
//			try {
//				stmt = con.prepareStatement("DELETE FROM tbl_KhachHang WHERE MaKhachHang =?");
//				stmt.setString(1, ma);
//				n = stmt.executeUpdate();
//			} catch (SQLException e) {
//						
//			} finally {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			return n > 0;
//		}
//		//Cập nhật thông tin khách hàng
//		public void capNhat_KhachHang(KhachHang kh) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement stmt = null;
//			try {
//				stmt = con.prepareStatement("UPDATE tbl_KhachHang SET TenKhachHang=? , SoDienThoai=? , CCCD=? , GioiTinh=? , DiaChi=? WHERE MaKhachHang=?");
//				stmt.setString(1, kh.getTenKhachHang());
//				stmt.setString(2, kh.getSoDienThoai());
//				stmt.setString(3, kh.getCCCD());
//				stmt.setInt(4, kh.getGioiTinh());
//				stmt.setString(5, kh.getDiaChi());
//				stmt.setString(6, kh.getMaKhachHang());
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
//		//tim khach hang sdt
//		public KhachHang getKHtheoSDT(String sdt) {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getConnection();
//			PreparedStatement statement = null;
//			KhachHang kh = null;
//			try {
//				statement = con.prepareStatement("SELECT * FROM tbl_KhachHang WHERE SoDienThoai = ?");
//				statement.setString(1, sdt);
//				 ResultSet rs = statement.executeQuery();
//				 while(rs.next()) {
//						String ma = rs.getString(1);
//						String ten = rs.getString(2);
//						String soDienThoai = rs.getString(3);
//						String cCCD = rs.getString(4);
//						int gioiTinh = rs.getInt(5);
//						String diaChi = rs.getString(6);
//						kh = new KhachHang(ma, ten, soDienThoai, cCCD, gioiTinh, diaChi);
//					}
//			    
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
//			return kh;
//		}
//		// tìm kiếm thông tin khách hàng
//	 	public List<KhachHang> searchKhachHangByTen(String ten) {
//	        return searchKhachHang(ten, null, -1);
//	    }
//
//	    public List<KhachHang> searchKhachHangBySoDienThoai(String soDienThoai) {
//	        return searchKhachHang(null, soDienThoai, -1);
//	    }
//
//	    public List<KhachHang> searchKhachHangByGioiTinh(int gioiTinh) {
//	        return searchKhachHang(null, null, gioiTinh);
//	    }
//
//	    public List<KhachHang> searchKhachHang(String ten, String soDienThoai, int gioiTinh) {
//	        List<KhachHang> result = new ArrayList<>();
//
//	        Connection con = null;
//	        PreparedStatement stmt = null;
//	        ResultSet rs = null;
//
//	        try {
//	            con = ConnectDB.getConnection();
//
//	            // Bắt đầu xây dựng câu truy vấn SQL dựa trên các thông tin đầu vào
//	            String sql = "SELECT * FROM tbl_KhachHang WHERE 1=1"; // 1=1 để tạo điều kiện AND dễ dàng
//
//	            if (ten != null && !ten.isEmpty()) {
//	                sql += " AND (TenKhachHang LIKE ?)";
//	            }
//	            if (soDienThoai != null && !soDienThoai.isEmpty()) {
//	                sql += " AND (SoDienThoai LIKE ?)";
//	            }
//	            if (gioiTinh >= 0) {
//	                sql += " AND GioiTinh = ?";
//	            }
//
//	            stmt = con.prepareStatement(sql);
//	            int parameterIndex = 1; // Số thứ tự của tham số
//
//	            if (ten != null && !ten.isEmpty()) {
//	            	  stmt.setString(parameterIndex, "%" + ten + "%");
//	                  parameterIndex++;
//	            }
//	            if (soDienThoai != null && !soDienThoai.isEmpty()) {
//	            	 stmt.setString(parameterIndex, "%" + soDienThoai + "%");
//	                parameterIndex++;
//	            }
//	            if (gioiTinh >= 0) {
//	                stmt.setInt(parameterIndex, gioiTinh);
//	            }
//
//	            rs = stmt.executeQuery();
//
//	            while (rs.next()) {
//	                // Xử lý dữ liệu từ ResultSet và thêm vào danh sách kết quả
//	                KhachHang kh = new KhachHang(rs.getString("MaKhachHang"), rs.getString("TenKhachHang"), rs.getString("SoDienThoai"), rs.getString("CCCD"), rs.getInt("GioiTinh"), rs.getString("DiaChi"));
//	                result.add(kh);
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	        }
//
//	        return result;
//	    }
//	    
//	    public List<KhachHang> getKhachHangTiemNang() {
//	        String sql = "SELECT tbl_KhachHang.MaKhachHang, tbl_KhachHang.TenKhachHang, tbl_KhachHang.SoDienThoai, " +
//	                     "COUNT(tbl_HoaDonTT.MaHoaDonTT) AS soLan, " +
//	                     "SUM(tbl_HoaDonTT.TongThoiGianSuDung) AS tongThoiGian, " +
//	                     "SUM(tbl_HoaDonTT.TongTien) AS tongHoaDon " +
//	                     "FROM tbl_KhachHang " +
//	                     "LEFT JOIN tbl_DonDatPhong ON tbl_KhachHang.MaKhachHang = tbl_DonDatPhong.MaKhachHang " +
//	                     "LEFT JOIN tbl_HoaDonThuePhong ON tbl_DonDatPhong.MaDonDatPhong = tbl_HoaDonThuePhong.MaHoaDon " +
//	                     "LEFT JOIN tbl_HoaDonTT ON tbl_HoaDonThuePhong.MaHoaDon = tbl_HoaDonTT.MaHoaDon " +
//	                     "GROUP BY tbl_KhachHang.MaKhachHang, tbl_KhachHang.TenKhachHang, tbl_KhachHang.SoDienThoai " +
//	                     "ORDER BY tongHoaDon DESC";
//	        PreparedStatement statement = null;
//	        List<KhachHang> list = new ArrayList<KhachHang>();
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            ResultSet rs = statement.executeQuery();
//	            while (rs.next()) {
//	                KhachHang kh = new KhachHang(rs.getString("MaKhachHang"), rs.getString("TenKhachHang"), rs.getString("SoDienThoai"));
//	                list.add(kh);
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
//	        return list;
//	    }
//
//	    
//	    // láº¥y sá»‘ láº§n Ä‘áº¿n theo mĂ£ khĂ¡ch hĂ ng
//	    public int getSoLanDenTheoMa(String ma) {
//	        int soLan = 0;
//	        String sql = "SELECT COUNT(*) AS soLan FROM tbl_HoaDonThuePhong WHERE MaKhachHang = ?";
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setString(1, ma);
//	            ResultSet r = statement.executeQuery();
//	            if (r.next()) {
//	                soLan = r.getInt("soLan");
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
//	    // tĂ­nh thĂ nh tiá»n theo mĂ£ khĂ¡ch hĂ ng
//	    public double getTongHoaDonTheoMa(String ma) {
//	        double tongHoaDon = 0;
//	        String sql = "SELECT SUM(TongTien) AS TongTienDaThanhToan " +
//	                     "FROM tbl_HoaDonTT HDTT " +
//	                     "JOIN tbl_HoaDonThuePhong HDTP ON HDTT.MaHoaDon = HDTP.MaHoaDon " +
//	                     "WHERE HDTP.MaKhachHang = ?";
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setString(1, ma);
//	            ResultSet r = statement.executeQuery();
//	            if (r.next()) {
//	                tongHoaDon = r.getDouble("TongTienDaThanhToan");
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
//	        return tongHoaDon;
//	    }
//
//
//	    
//	    // láº¥y sá»‘ thá»i gian sá»­ dá»¥ng theo mĂ£
//	    public int getThoiGianSuDungTheoMa(String ma) {
//	        int thoiGianSuDung = 0;
//	        String sql = "SELECT TongThoiGianSuDung " +
//	        		"FROM tbl_HoaDonTT HDTT " +
//                    "JOIN tbl_HoaDonThuePhong HDTP ON HDTT.MaHoaDon = HDTP.MaHoaDon " +
//                    "WHERE HDTP.MaKhachHang = ?";
//	        
//	        PreparedStatement statement = null;
//	        try {
//	            statement = ConnectDB.getConnection().prepareStatement(sql);
//	            statement.setString(1, ma);
//	            ResultSet r = statement.executeQuery();
//	            while (r.next()) {
//	                thoiGianSuDung += r.getInt("TongThoiGianSuDung");
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
//	        return thoiGianSuDung;
//	    }
//
//}
//
//
//

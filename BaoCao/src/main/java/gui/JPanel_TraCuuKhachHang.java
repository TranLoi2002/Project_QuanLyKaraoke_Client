/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import entity.KhachHang;

/**
 *
 * @author ADMIN
 */
public class JPanel_TraCuuKhachHang extends javax.swing.JPanel {

//	private KhachHang_DAO khachHang_dao;
	private ArrayList<KhachHang> listKhachHang;
	private DefaultTableModel model_KhachHang;
    /**
     * Creates new form traCuuKH
     */
    public JPanel_TraCuuKhachHang() {
//    	try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		khachHang_dao = new KhachHang_DAO();
        initComponents();
        // tooltip các nút chức năng
        btnTimKiem.setToolTipText("Atl + S");
        btnLamMoi.setToolTipText("Atl + C");

        // sử dụng phím tắt
        btnTimKiem.setMnemonic(KeyEvent.VK_A);
        btnLamMoi.setMnemonic(KeyEvent.VK_C);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlThongTinTraCuu = new javax.swing.JPanel();
        lblTenKH = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        btnLamMoi = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        pnlDSKhachHang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSKhachHang = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1240, 750));

        pnlThongTinTraCuu.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Tra Cứu"));

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenKH.setText("Tên Khách Hàng");

        lblSoDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSoDienThoai.setText("Số Điện Thoại");

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGioiTinh.setText("Giới Tính");

        buttonGroup1.add(radNam);
        radNam.setSelected(true);
        radNam.setText("Nam");
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                radNamActionPerformed(evt);
//                xuLySuKienTimKiem();
            }
        });

        buttonGroup1.add(radNu);
        radNu.setText("Nữ");
        radNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                radNamActionPerformed(evt);
//                xuLySuKienTimKiem();
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon("item/refresh25.png")); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setToolTipText("Làm mới");
        btnLamMoi.setBorder(null);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clear_KhachHang();
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon("item/search25.png")); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setToolTipText("Tìm kiếm");
        btnTimKiem.setBorder(null);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//            	xuLySuKienTimKiem();
            }
        });

        javax.swing.GroupLayout pnlThongTinTraCuuLayout = new javax.swing.GroupLayout(pnlThongTinTraCuu);
        pnlThongTinTraCuu.setLayout(pnlThongTinTraCuuLayout);
        pnlThongTinTraCuuLayout.setHorizontalGroup(
            pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinTraCuuLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenKH)
                    .addComponent(lblSoDienThoai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinTraCuuLayout.createSequentialGroup()
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lblGioiTinh)
                        .addGap(18, 18, 18)
                        .addComponent(radNam, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radNu, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThongTinTraCuuLayout.setVerticalGroup(
            pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinTraCuuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTenKH))
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinTraCuuLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGioiTinh)
                            .addComponent(radNam)
                            .addComponent(radNu)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlThongTinTraCuuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongTinTraCuuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblSoDienThoai)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pnlDSKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Khách Hàng"));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblDSKhachHang.setAutoCreateRowSorter(true);
        tblDSKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDSKhachHang.setModel(model_KhachHang = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Căn Cước Công Dân", "Giới Tính", "Địa Chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            @Override
			public boolean isCellEditable(int row, int column) {
				return false; // Không cho phép chỉnh sửa bất kỳ ô nào trên bảng
			}
        });
        tblDSKhachHang.setFocusable(false);
        tblDSKhachHang.setShowGrid(true);
        jScrollPane1.setViewportView(tblDSKhachHang);

//        loadKhachHang();

        javax.swing.GroupLayout pnlDSKhachHangLayout = new javax.swing.GroupLayout(pnlDSKhachHang);
        pnlDSKhachHangLayout.setHorizontalGroup(
        	pnlDSKhachHangLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pnlDSKhachHangLayout.createSequentialGroup()
        			.addGap(16)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1143, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(18, Short.MAX_VALUE))
        );
        pnlDSKhachHangLayout.setVerticalGroup(
        	pnlDSKhachHangLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pnlDSKhachHangLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(22, Short.MAX_VALUE))
        );
        pnlDSKhachHang.setLayout(pnlDSKhachHangLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(pnlDSKhachHang, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(pnlThongTinTraCuu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE))
        			.addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(15)
        			.addComponent(pnlThongTinTraCuu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(pnlDSKhachHang, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(51, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed

//    public void loadKhachHang() {
//    	String gioitinh = "";
//    	model_KhachHang.setRowCount(0);
//		listKhachHang = khachHang_dao.getAllKhachHang();
//		for (KhachHang kh : listKhachHang) {
//			if(kh.getGioiTinh() == 1) {
//				gioitinh = "Nam";
//			}else {
//				gioitinh = "Nữ";
//			}
//			model_KhachHang.addRow(new Object[] {
//					kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoDienThoai(), kh.getCCCD(),
//					gioitinh, kh.getDiaChi()});
//		}
//	}

    public void clear_KhachHang() {
		txtTenKH.setText("");
		txtSoDienThoai.setText("");
		buttonGroup1.setSelected(radNam.getModel(), true);

//		loadKhachHang();
		txtTenKH.requestFocus();

    }

//    public List<KhachHang> timKiemKhachHang() {
//        String ten = txtTenKH.getText().trim();
//        String soDienThoai = txtSoDienThoai.getText().trim();
//        int gioiTinh = getSelectedGioiTinh(); // Hàm này phải tự viết để lấy giới tính từ UI
//
//        List<KhachHang> ketQuaTimKiem = new ArrayList<>();
//
//        // Gọi các hàm tìm kiếm trong lớp DAO để tìm kiếm khách hàng
//        if (!ten.isEmpty()) {
//            List<KhachHang> ketQuaTen = khachHang_dao.searchKhachHangByTen(ten);
//            for (KhachHang kh : ketQuaTen) {
//                if (!ketQuaTimKiem.contains(kh)) {
//                    ketQuaTimKiem.add(kh);
//                }
//            }
//        }
//        if (!soDienThoai.isEmpty()) {
//            List<KhachHang> ketQuaSDT = khachHang_dao.searchKhachHangBySoDienThoai(soDienThoai);
//            for (KhachHang kh : ketQuaSDT) {
//                if (!ketQuaTimKiem.contains(kh)) {
//                    ketQuaTimKiem.add(kh);
//                }
//            }
//        }
//        if (gioiTinh == 0 || gioiTinh == 1) {
//            List<KhachHang> ketQuaGioiTinh = khachHang_dao.searchKhachHangByGioiTinh(gioiTinh);
//            for (KhachHang kh : ketQuaGioiTinh) {
//                if (!ketQuaTimKiem.contains(kh)) {
//                    ketQuaTimKiem.add(kh);
//                }
//            }
//        }
//
//        return ketQuaTimKiem;
//    }


    private int getSelectedGioiTinh() {
        int gioiTinh = 1; // Gán giá trị mặc định là Nam khi không chọn button
        if (radNam.isSelected()) {
            gioiTinh = 1; // Giả sử chọn giới tính Nam
        } else if (radNu.isSelected()) {
            gioiTinh = 0; // Giả sử chọn giới tính Nữ
        }
        return gioiTinh;
    }
//    public void capNhatBangHienThi(List<KhachHang> danhSachKetQua) {
//    	String gioitinh = "";
//        DefaultTableModel model = (DefaultTableModel) tblDSKhachHang.getModel();
//        model.setRowCount(0); // Xóa tất cả dữ liệu hiện tại trong bảng
//
//        for (KhachHang kh : danhSachKetQua) {
//        	if(kh.getGioiTinh() == 1) {
//				gioitinh = "Nam";
//			}else {
//				gioitinh = "Nữ";
//			}
//			model_KhachHang.addRow(new Object[] {
//					kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoDienThoai(), kh.getCCCD(),
//					gioitinh, kh.getDiaChi()});
//
//        }
//    }
//    public void xuLySuKienTimKiem() {
//    	if(ValidData()) {
//    		List<KhachHang> ketQuaTimKiem = timKiemKhachHang();
//            capNhatBangHienThi(ketQuaTimKiem);
//    	}
//    }

 // border - thông báo lỗi nhập liệu
    Border bdFalse = BorderFactory.createLineBorder(Color.red);
	Border bdTrue = BorderFactory.createLineBorder(Color.green);
 	public boolean ValidData() {
 		String tenKH = txtTenKH.getText().trim();
 		String sdt = txtSoDienThoai.getText().trim();

 		// Check tên khách hàng
 		if(tenKH.length() > 0) {
 			if(!tenKH.matches("^[\\p{L}]+( [\\p{L}]+)*$")) {
    			JOptionPane.showMessageDialog(this, "Error: Tên Khách hàng không hợp lệ ! Vui lòng nhập lại");
				txtTenKH.requestFocus(true);
				txtTenKH.setBorder(bdFalse);
				return false;
    		}else {
    			txtTenKH.setBorder(bdTrue);
    		}
 		}

 		// check số điện thoại
 		if(sdt.length() > 0) {
 			if(!sdt.matches("^\\d+$")) {
    			JOptionPane.showMessageDialog(this, "Error: Số Điện Thoại của bạn không hợp lệ ! Vui lòng nhập lại");
				txtSoDienThoai.requestFocus(true);
				txtSoDienThoai.setBorder(bdFalse);
				return false;
    		}else {
    			txtSoDienThoai.setBorder(bdTrue);
    		}
 		}
 		return true;
 	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JPanel pnlDSKhachHang;
    private javax.swing.JPanel pnlThongTinTraCuu;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTable tblDSKhachHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}

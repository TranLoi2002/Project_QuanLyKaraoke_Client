
-- nhân viên
insert into tbl_NhanVien values ('NV001',N'Lê Trọng Tấn','1999-08-19 00:00:00','0909777554','097546545454', 1,N'121 Nguyễn Oanh, Gò Vấp, tp.HCM', N'Nhân viên', N'Đang làm việc')
insert into tbl_NhanVien values ('NV002',N'Nguyễn Bảo Kha','2003-09-25 00:00:00','0354689546','074133221546', 1,N'130 Nguyễn Oanh, Gò Vấp, tp.HCM', N'Nhân viên', N'Đang làm việc')
insert into tbl_NhanVien values ('NV003',N'Trần Văn Lợi','2002-05-11 00:00:00','0899626775','074654213215', 1,N'Nguyễn Văn Lượng, Gò Vấp, tp.HCM', N'Nhân viên', N'Đang làm việc')
insert into tbl_NhanVien values ('NV004',N'Nguyễn Trường An','2003-10-06 00:00:00','0964133949','074203444587', 1,N'Nguyễn Văn Lượng, Gò Vấp, tp.HCM', N'Nhân viên', N'Đang làm việc')
insert into tbl_NhanVien values ('NV005',N'Nguyễn Công Hậu','2003-04-04 00:00:00','0955465428','074555647886', 1,N'Nguyễn Văn Lượng, Gò Vấp, tp.HCM', N'Nhân viên', N'Nghỉ việc')
insert into tbl_NhanVien values ('NV006',N'Nguyễn Ngọc Tường Vi','2003-05-01 00:00:00','0888337377','074203546215', 0,N'Thủ Dầu Một, Bình Dương', N'Nhân viên', N'Đang làm việc')
insert into tbl_NhanVien values ('QL001',N'Nguyễn Thái Bảo','2003-02-10 00:00:00','0387776610','074203000973', 1,N'Nguyễn Thái Sơn, Gò Vấp, tp.HCM', N'Quản lý', N'Đang làm việc')

-- tài khoản
insert into tbl_TaiKhoan values ('bao1028', 'bao123', 'QL001')
insert into tbl_TaiKhoan values ('loi123', '123456', 'NV003')
insert into tbl_TaiKhoan values ('an123', '123456', 'NV004')
insert into tbl_TaiKhoan values ('kha123', '123456', 'NV002')

-- loại phòng

insert into tbl_LoaiPhong values ('T001', N'Thường')
insert into tbl_LoaiPhong values ('V001', N'Vip')

-- phòng hát
insert into tbl_PhongHat values ('PHT001', '001', 150000, N'Phòng Đang sử dụng', 6, 'T001')
insert into tbl_PhongHat values ('PHT002', '002', 150000, N'Phòng Đang sử dụng', 6, 'T001')
insert into tbl_PhongHat values ('PHT003', '003', 150000, N'Phòng Trống', 10, 'T001')
insert into tbl_PhongHat values ('PHT004', '004', 150000, N'Phòng Trống', 15, 'T001')
insert into tbl_PhongHat values ('PHT005', '101', 150000, N'Phòng chờ', 15, 'T001')
insert into tbl_PhongHat values ('PHT009', '201', 150000, N'Phòng Trống', 20, 'T001')
insert into tbl_PhongHat values ('PHT010', '202', 150000, N'Phòng Trống', 10, 'T001')
insert into tbl_PhongHat values ('PHV001', '001', 250000, N'Phòng Trống', 10, 'V001')
insert into tbl_PhongHat values ('PHV006', '102', 250000, N'Phòng Trống', 20, 'V001')
insert into tbl_PhongHat values ('PHV007', '103', 250000, N'Phòng Đang sử dụng', 20, 'V001')
insert into tbl_PhongHat values ('PHV008', '104', 250000, N'Phòng chờ', 15, 'V001')
insert into tbl_PhongHat values ('PHV011', '203', 250000, N'Phòng Trống', 15, 'V001')
insert into tbl_PhongHat values ('PHV012', '204', 250000, N'Phòng Trống', 20, 'V001')

-- khách hàng
insert into tbl_KhachHang values ('KH0001',N'Trần Anh Minh','0909123578','024748374745', 1,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0002',N'Nguyễn Thị Hoàng Thơ','0982948744','029488494884', 0,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0003',N'Bùi Trần Thảo Linh','0382744622','092488473847', 0,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0004',N'Nguyễn Thái Bảo','0387776610','074203000973', 1,N'Bình Dương')
insert into tbl_KhachHang values ('KH0005',N'Nguyễn Trường An','0935776768','092487435351', 1,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0006',N'Nguyễn Văn Hậu','0745673575','092834727444', 1,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0007',N'Hồ Văn Tài','0354656218','092867654234', 1,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0008',N'Lê Thái Quý','0923154788','087466546212', 1,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0009',N'Nguyễn Hằng','0955557852','087465433332', 0,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0010',N'Nguyễn Xuân An','0365789555','089777555444', 0,N'Bình Dương')
insert into tbl_KhachHang values ('KH0011',N'Trần Thị Diễm','0974552858','024775566844', 0,N'Bình Phước')
insert into tbl_KhachHang values ('KH0012',N'Hồ Thủy Nhi','0984477568','045552857569', 0,N'Bình Dương')
insert into tbl_KhachHang values ('KH0013',N'Đỗ Duy Mạnh','0994222355','048321534644', 1,N'Thành phố Hồ Chí Minh')

insert into tbl_KhachHang values ('KH0014',N'Trần Trí Anh Khang','0909123578','024748374745', 1,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0015',N'Nguyễn Thị Hoàng','0982948744','029488494884', 0,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0016',N'Bùi Trung Tính','0382744622','092488473847', 1,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0017',N'Nguyễn Đình Huy','0387776093','074203000973', 1,N'Bình Dương')
insert into tbl_KhachHang values ('KH0018',N'Nguyễn Trường Tấn Vinh','0935776768','092487435351', 1,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0019',N'Nguyễn Văn Thái Hiệp','0745673575','092834727444', 1,N'Thành phố Hồ Chí Minh')
insert into tbl_KhachHang values ('KH0020',N'Hồ Văn Trung Nghĩa','0354656218','092867654234', 1,N'Thành phố Hồ Chí Minh')



-- dịch vụ
insert into tbl_DichVu values ('DV001', 'Bia', 340000, 15, N'Thùng', N'Sắp hết')
insert into tbl_DichVu values ('DV002', 'Number One', 20000, 100, N'Chai', N'Cònt')
insert into tbl_DichVu values ('DV003', 'Soda Chanh', 20000, 75, N'Chai', N'Còn')
insert into tbl_DichVu values ('DV004', 'Rượu', 380000, 110, N'Chai', N'Còn')
insert into tbl_DichVu values ('DV005', 'Trái cây', 100000, 22, N'Dĩa', N'Sắp hết')
insert into tbl_DichVu values ('DV006', 'Revive Chanh muối', 20000, 100, N'Chai', N'Còn')
insert into tbl_DichVu values ('DV007', 'Sting Dâu', 20000, 100, N'Chai', N'Còn')
insert into tbl_DichVu values ('DV008', 'Thuốc Lá', 35000, 70, N'Bao', N'Còn')
insert into tbl_DichVu values ('DV009', 'Bò Cụng', 25000, 100, N'Lon', N'Còn')
insert into tbl_DichVu values ('DV010', 'Wake up 247', 20000, 100, N'Chai', N'Còn')
insert into tbl_DichVu values ('DV011', 'Monster', 20000, 75, N'Lon', N'Còn')
insert into tbl_DichVu values ('DV012', 'Warrior', 20000, 60, N'Lon', N'Còn')
insert into tbl_DichVu values ('DV013', 'Nước suối', 10000, 50, N'Chai', N'Còn')
insert into tbl_DichVu values ('DV014', 'Đậu phộng', 30000, 50, N'Dĩa', N'Còn')


--chi tiết hóa đơn
insert into tbl_ChiTietHoaDon values ('HD001','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD001','DV005', 2 )
insert into tbl_ChiTietHoaDon values ('HD002','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD003','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD003','DV004', 1 )
insert into tbl_ChiTietHoaDon values ('HD004','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD004','DV007', 2 )

insert into tbl_ChiTietHoaDon values ('HD005','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD006','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD007','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD008','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD009','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD010','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD010','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD011','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD012','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD013','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD014','DV001', 1 )

insert into tbl_ChiTietHoaDon values ('HD015','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD016','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD017','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD018','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD019','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD020','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD021','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD022','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD023','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD024','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD025','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD026','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD027','DV001', 1 )
insert into tbl_ChiTietHoaDon values ('HD028','DV001', 1 )


-- hóa đơn thuê phòng
insert into tbl_HoaDonThuePhong values ('HD001' , '2023-12-2' , '9:00' , '10:00' , 'KH0001' , 'NV001' , 'PHT001')
insert into tbl_HoaDonThuePhong values ('HD002' , '2023-12-3' , '11:10' , '11:00' , 'KH0002' , 'NV001' , 'PHT002')
insert into tbl_HoaDonThuePhong values ('HD003' , '2023-12-4' , '10:00' , '12:00' , 'KH0003' , 'NV002' , 'PHT002')
insert into tbl_HoaDonThuePhong values ('HD004' , '2023-12-5' , '15:00' , '17:00' , 'KH0004' , 'NV001' , 'PHV001')

insert into tbl_HoaDonThuePhong values ('HD006' , '2023-12-3' , '14:00' , '15:00' , 'KH0006' , 'NV002' , 'PHT004')
insert into tbl_HoaDonThuePhong values ('HD007' , '2023-12-2' , '16:00' , '18:00' , 'KH0007' , 'NV004' , 'PHT004')
insert into tbl_HoaDonThuePhong values ('HD008' , '2023-12-4' , '15:00' , '17:00' , 'KH0008' , 'NV003' , 'PHT009')
insert into tbl_HoaDonThuePhong values ('HD009' , '2023-12-4' , '10:00' , '15:00' , 'KH0009' , 'NV002' , 'PHT010')
insert into tbl_HoaDonThuePhong values ('HD010' , '2023-12-4' , '13:00' , '15:00' , 'KH0010' , 'NV002' , 'PHT001')
insert into tbl_HoaDonThuePhong values ('HD011' , '2023-12-7' , '17:00' , '18:00' , 'KH0011' , 'NV002' , 'PHT003')
insert into tbl_HoaDonThuePhong values ('HD012' , '2023-12-5' , '10:00' , '12:00' , 'KH0012' , 'NV003' , 'PHV008')
insert into tbl_HoaDonThuePhong values ('HD013' , '2023-12-2' , '18:00' , '20:00' , 'KH0013' , 'NV003' , 'PHT003')
insert into tbl_HoaDonThuePhong values ('HD014' , '2023-12-3' , '15:00' , '16:00' , 'KH0005' , 'NV002' , 'PHT004')

insert into tbl_HoaDonThuePhong values ('HD015' , '2023-11-5' , '10:00' , '12:00' , 'KH0012' , 'NV003' , 'PHV008')
insert into tbl_HoaDonThuePhong values ('HD016' , '2023-11-2' , '18:00' , '20:00' , 'KH0013' , 'NV003' , 'PHT003')

insert into tbl_HoaDonThuePhong values ('HD017' , '2023-10-7' , '17:00' , '18:00' , 'KH0011' , 'NV002' , 'PHT003')
insert into tbl_HoaDonThuePhong values ('HD018' , '2023-10-5' , '10:00' , '12:00' , 'KH0012' , 'NV003' , 'PHV008')
insert into tbl_HoaDonThuePhong values ('HD019' , '2023-10-2' , '18:00' , '20:00' , 'KH0013' , 'NV003' , 'PHT003')
insert into tbl_HoaDonThuePhong values ('HD020' , '2023-11-7' , '17:00' , '18:00' , 'KH0011' , 'NV002' , 'PHT003')
insert into tbl_HoaDonThuePhong values ('HD021' , '2023-11-2' , '17:00' , '18:00' , 'KH0010' , 'NV002' , 'PHT004')

insert into tbl_HoaDonThuePhong values ('HD022' , '2023-12-5' , '10:00' , '13:00' , 'KH0015' , 'NV001' , 'PHV011')
insert into tbl_HoaDonThuePhong values ('HD023' , '2023-12-2' , '18:00' , '21:00' , 'KH0016' , 'NV003' , 'PHT003')
insert into tbl_HoaDonThuePhong values ('HD024' , '2023-12-3' , '17:00' , '18:00' , 'KH0017' , 'NV001' , 'PHT003')
insert into tbl_HoaDonThuePhong values ('HD025' , '2023-12-5' , '10:00' , '12:00' , 'KH0018' , 'NV001' , 'PHV012')
insert into tbl_HoaDonThuePhong values ('HD026' , '2023-12-2' , '18:00' , '20:00' , 'KH0019' , 'NV003' , 'PHT003')
insert into tbl_HoaDonThuePhong values ('HD027' , '2023-12-2' , '17:00' , '18:00' , 'KH0020' , 'NV002' , 'PHT003')
insert into tbl_HoaDonThuePhong values ('HD028' , '2023-12-3' , '17:00' , '19:00' , 'KH0014' , 'NV002' , 'PHT003')


-- hóa đơn thanh toán
insert into tbl_HoaDonTT values ('HDTT00001', '2023-12-2' , 1 , 150000 , 540000 , 690000, 690000 , 'HD001')
insert into tbl_HoaDonTT values ('HDTT00002', '2023-12-3' , 1 , 150000 , 340000 , 490000, 490000 , 'HD002')
insert into tbl_HoaDonTT values ('HDTT00003', '2023-12-4' , 2 , 150000 , 720000 , 870000, 870000 , 'HD003')
insert into tbl_HoaDonTT values ('HDTT00004', '2023-12-5' , 2 , 250000 , 380000 , 630000, 630000 , 'HD004')

insert into tbl_HoaDonTT values ('HDTT00005', '2023-12-2' , 2 , 150000 , 340000 , 490000, 490000 , 'HD005')
insert into tbl_HoaDonTT values ('HDTT00006', '2023-12-3' , 1 , 150000 , 340000 , 490000, 490000 , 'HD006')
insert into tbl_HoaDonTT values ('HDTT00007', '2023-12-2' , 2 , 150000 , 340000 , 490000, 490000 , 'HD007')
insert into tbl_HoaDonTT values ('HDTT00008', '2023-12-4' , 2 , 150000 , 340000 , 490000, 490000 , 'HD008')
insert into tbl_HoaDonTT values ('HDTT00009', '2023-12-4' , 3 , 150000 , 340000 , 490000, 490000 , 'HD009')
insert into tbl_HoaDonTT values ('HDTT00010', '2023-12-4' , 2 , 150000 , 340000 , 490000, 490000 , 'HD010')
insert into tbl_HoaDonTT values ('HDTT00011', '2023-12-7' , 1 , 150000 , 340000 , 490000, 490000 , 'HD011')
insert into tbl_HoaDonTT values ('HDTT00012', '2023-12-5' , 2 , 250000 , 340000 , 590000, 590000 , 'HD012')
insert into tbl_HoaDonTT values ('HDTT00013', '2023-12-2' , 2 , 150000 , 340000 , 490000, 490000 , 'HD013')
insert into tbl_HoaDonTT values ('HDTT00014', '2023-12-3' , 1 , 150000 , 340000 , 490000, 490000 , 'HD014')

insert into tbl_HoaDonTT values ('HDTT00015', '2023-11-4' , 2 , 150000 , 340000 , 490000, 490000 , 'HD015')
insert into tbl_HoaDonTT values ('HDTT00016', '2023-11-4' , 3 , 150000 , 340000 , 490000, 490000 , 'HD016')
insert into tbl_HoaDonTT values ('HDTT00017', '2023-10-4' , 2 , 150000 , 340000 , 490000, 490000 , 'HD017')
insert into tbl_HoaDonTT values ('HDTT00018', '2023-10-7' , 1 , 150000 , 340000 , 490000, 490000 , 'HD018')
insert into tbl_HoaDonTT values ('HDTT00019', '2023-10-5' , 2 , 250000 , 340000 , 590000, 590000 , 'HD019')
insert into tbl_HoaDonTT values ('HDTT00020', '2023-11-2' , 2 , 150000 , 340000 , 490000, 490000 , 'HD020')
insert into tbl_HoaDonTT values ('HDTT00021', '2023-11-2' , 2 , 150000 , 340000 , 490000, 490000 , 'HD021')

insert into tbl_HoaDonTT values ('HDTT00022', '2023-12-5' , 2 , 250000 , 340000 , 590000, 590000 , 'HD022')
insert into tbl_HoaDonTT values ('HDTT00023', '2023-12-2' , 3 , 150000 , 340000 , 490000, 490000 , 'HD023')
insert into tbl_HoaDonTT values ('HDTT00024', '2023-12-3' , 2 , 150000 , 340000 , 490000, 490000 , 'HD024')
insert into tbl_HoaDonTT values ('HDTT00025', '2023-12-5' , 1 , 250000 , 340000 , 590000, 590000 , 'HD025')
insert into tbl_HoaDonTT values ('HDTT00026', '2023-12-2' , 2 , 250000 , 340000 , 590000, 590000 , 'HD026')
insert into tbl_HoaDonTT values ('HDTT00027', '2023-12-2' , 2 , 150000 , 340000 , 490000, 490000 , 'HD027')
insert into tbl_HoaDonTT values ('HDTT00028', '2023-12-3' , 2 , 150000 , 340000 , 490000, 490000 , 'HD028')




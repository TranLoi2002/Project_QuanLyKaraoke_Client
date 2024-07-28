package entity;
import java.sql.*;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_KhachHang")
public class KhachHang {
    @Id
    @Column(name = "MaKhachHang")
    private String maKhachHang;
    @Column(name = "TenKhachHang")
    private String tenKhachHang;
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Column(name = "CCCD")
    private String CCCD;
    @Column(name = "GioiTinh")
    private int gioiTinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<HoaDonThuePhong> dsHoaDonThuePhong;
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DonDatPhong> dsDonDatPhong;
}

package entity;
import java.sql.*;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_HoaDonThuePhong")
public class HoaDonThuePhong {
    @Id
    @Column(name = "MaHoaDon")
    private String maHoaDon;
    @Column(name = "NgayTaoHoaDon")
    private Date ngayTaoHoaDon;
    @Column(name = "GioVao")
    private Date gioVao;
    @Column(name  = "GioRa")
    private Date gioRa;
    @ManyToOne
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "MaNhanVien", referencedColumnName = "MaNhanVien")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "MaPhongHat", referencedColumnName = "MaPhongHat")
    private PhongHat phongHat;
    @OneToMany(mappedBy = "hoaDonThuePhong", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<HoaDonTT> dsHoaDonTT;
}

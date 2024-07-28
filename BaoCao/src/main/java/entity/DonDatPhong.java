package entity;

import java.sql.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_DonDatPhong")
public class DonDatPhong {
    @Id
    @Column(name = "MaDonDatPhong")
    private String maDonDatPhong;
    @Column(name = "NgayDat")
    private Date ngayDat;
    @Column(name = "GioDat")
    private Date gioDat;
    @ManyToOne
    @JoinColumn(name = "MaPhongHat", referencedColumnName = "MaPhongHat")
    private PhongHat phongHat;
    @ManyToOne
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;
}

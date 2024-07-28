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
@Table(name="tbl_PhongHat")
public class PhongHat {
    @Id
    @Column(name = "MaPhongHat")
    private String maPhongHat;
    @Column(name = "TenPhongHat")
    private String tenPhongHat;
    @Column(name = "GiaPhong")
    private double giaPhong;
    @Column(name = "TinhTrang")
    private String tinhTrang;
    @Column(name = "SucChua")
    private int sucChua;
    @ManyToOne
    @JoinColumn(name = "MaLoaiPhong", referencedColumnName = "MaLoaiPhong")
    private LoaiPhong loaiPhong;
    @OneToMany(mappedBy = "phongHat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DonDatPhong> dsDonDatPhong;
    @OneToMany(mappedBy = "phongHat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<HoaDonThuePhong> dsHoaDonThuePhong;
    
}

package entity;
import java.sql.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_ChiTietHoaDon")
public class ChiTietDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "MaHoaDon",referencedColumnName = "MaHoaDon")
    private HoaDonThuePhong hoaDonThuePhong;
    @Id
    @ManyToOne
    @JoinColumn(name = "MaDichVu",referencedColumnName = "MaDichVu")
    private DichVu dichVu;
    @Column(name = "SoLuong")
    private int soLuong;
}

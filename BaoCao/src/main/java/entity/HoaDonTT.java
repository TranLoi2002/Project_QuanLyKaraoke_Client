package entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_HoaDonTT")
public class HoaDonTT {
    @Id
    @Column(name = "MaHoaDonTT")
    private String maHoaDonTT;
    @Column(name = "NgayThanhToan")
    private LocalDateTime ngayThanhToan;
    @Column(name = "TongThoiGianSuDung")
    private int tongThoiGianSuDung;
    @Column(name = "TienPhong")
    private int tienPhong;
    @Column(name = "TienDichVu")
    private int tienDichVu;
    @Column(name = "TienNhan")
    private int tienNhan;
    @Column(name = "TongTien")
    private int tongTien;
    @ManyToOne
    @JoinColumn(name = "MaHoaDon", referencedColumnName = "MaHoaDon")
    private HoaDonThuePhong hoaDonThuePhong;
}

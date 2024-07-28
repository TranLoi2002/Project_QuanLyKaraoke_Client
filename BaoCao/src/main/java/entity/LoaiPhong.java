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
@Table(name="tbl_LoaiPhong")
public class LoaiPhong {
    @Id
    @Column(name = "MaLoaiPhong")
    private String maLoaiPhong;
    @Column(name = "TenLoaiPhong")
    private String tenLoaiPhong;
    @OneToMany(mappedBy = "loaiPhong", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PhongHat> dsPhongHat;
}

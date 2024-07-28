package entity;
import java.sql.*;
import java.util.Set;
import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_NhanVien")
//@NamedQueries({ //JPQL 
//	@NamedQuery(name = "NhanVien.findAll", query = "SELECT n from tbl_NhanVien n"),
////	@NamedQuery(name = "Student.findByEnrollmentInYear", query = "SELECT s FROM Student s WHERE year(s.enrollmentDate) = :year") ,
////	@NamedQuery(name = "student.findStudentsEnrolledInCourse", query = "SELECT s FROM Student s inner join s.studentGrades sg WHERE sg.course.title like :title")
//})
public class NhanVien {
    @Id
    @Column(name = "MaNhanVien")
    private String maNhanVien;
    @Column(name = "TenNhanVien")
    private String tenNhanVien;
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Column(name = "CCCD")
    private String CCCD;
    @Column(name = "GioiTinh")
    private int gioiTinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "ChucVu")
    private String chucVu;
    @Column(name = "TrangThai")
    private String trangThai;
    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<HoaDonThuePhong> dsHoaDonThuePhong;
    
    
    
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNhanVien, String tenNhanVien, Date ns, String soDienThoai, String cCCD, int gioiTinh,
			String diaChi, String chucVu, String trangThai) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ns;
		this.soDienThoai = soDienThoai;
		CCCD = cCCD;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Set<HoaDonThuePhong> getDsHoaDonThuePhong() {
		return dsHoaDonThuePhong;
	}
	public void setDsHoaDonThuePhong(Set<HoaDonThuePhong> dsHoaDonThuePhong) {
		this.dsHoaDonThuePhong = dsHoaDonThuePhong;
	}
    
}

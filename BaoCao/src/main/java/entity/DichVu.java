package entity;
import java.sql.*;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_DichVu")
public class DichVu {
    @Id
    @Column(name = "MaDichVu")
    private String maDichVu;
    @Column(name = "TenDichVu")
    private String tenDichVu;
    @Column(name = "GiaDichVu")
    private double giaDichVu;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonVi")
    private String donVi;
    @Column(name = "TrangThai")
    private String trangThai;
    @OneToMany(mappedBy = "dichVu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ChiTietDichVu> dsChiTietDichVu;
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public double getGiaDichVu() {
		return giaDichVu;
	}
	public void setGiaDichVu(double giaDichVu) {
		this.giaDichVu = giaDichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Set<ChiTietDichVu> getDsChiTietDichVu() {
		return dsChiTietDichVu;
	}
	public void setDsChiTietDichVu(Set<ChiTietDichVu> dsChiTietDichVu) {
		this.dsChiTietDichVu = dsChiTietDichVu;
	}
	public DichVu(String maDichVu, String tenDichVu, double giaDichVu, int soLuong, String donVi, String trangThai,
			Set<ChiTietDichVu> dsChiTietDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.giaDichVu = giaDichVu;
		this.soLuong = soLuong;
		this.donVi = donVi;
		this.trangThai = trangThai;
		this.dsChiTietDichVu = dsChiTietDichVu;
	}
	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DichVu(String maDichVu, String tenDichVu, double giaDichVu, int soLuong, String donVi, String trangThai) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.giaDichVu = giaDichVu;
		this.soLuong = soLuong;
		this.donVi = donVi;
		this.trangThai = trangThai;
	}
    
}

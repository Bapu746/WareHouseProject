package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="shippingtab")
public class Shipping {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shpng_seq" )
	@SequenceGenerator(name="shpng_seq", sequenceName = "shpng_seq", allocationSize=1)
	@Column(name="shp_id")
	private Integer shpId;
	@Column(name="shp_code")
	private String shpCode;
	@Column(name="refnum")
	private String shpRefNum;
	@Column(name="cont_details")
	private String shpContDetails;
	@Column(name="sale_code")
	private String shpSaleCode;
	@Column(name="bill_addrs")
	private String shpBillAddrs;
	@Column(name="shippng_addrs")
	private String shpShipAddrs;
	@Column(name="note")
	private String shpDesc;
	public Shipping() {
		super();
	}
	public Shipping(Integer shpId) {
		super();
		this.shpId = shpId;
	}
	public Integer getShpId() {
		return shpId;
	}
	public void setShpId(Integer shpId) {
		this.shpId = shpId;
	}
	public String getShpCode() {
		return shpCode;
	}
	public void setShpCode(String shpCode) {
		this.shpCode = shpCode;
	}
	public String getShpRefNum() {
		return shpRefNum;
	}
	public void setShpRefNum(String shpRefNum) {
		this.shpRefNum = shpRefNum;
	}
	public String getShpContDetails() {
		return shpContDetails;
	}
	public void setShpContDetails(String shpContDetails) {
		this.shpContDetails = shpContDetails;
	}
	public String getShpSaleCode() {
		return shpSaleCode;
	}
	public void setShpSaleCode(String shpSaleCode) {
		this.shpSaleCode = shpSaleCode;
	}
	public String getShpBillAddrs() {
		return shpBillAddrs;
	}
	public void setShpBillAddrs(String shpBillAddrs) {
		this.shpBillAddrs = shpBillAddrs;
	}
	public String getShpShipAddrs() {
		return shpShipAddrs;
	}
	public void setShpShipAddrs(String shpShipAddrs) {
		this.shpShipAddrs = shpShipAddrs;
	}
	public String getShpDesc() {
		return shpDesc;
	}
	public void setShpDesc(String shpDesc) {
		this.shpDesc = shpDesc;
	}
	@Override
	public String toString() {
		return "Shipping [shpId=" + shpId + ", shpCode=" + shpCode + ", shpRefNum=" + shpRefNum + ", shpContDetails="
				+ shpContDetails + ", shpSaleCode=" + shpSaleCode + ", shpBillAddrs=" + shpBillAddrs + ", shpShipAddrs="
				+ shpShipAddrs + ", shpDesc=" + shpDesc + "]";
	}
	
}
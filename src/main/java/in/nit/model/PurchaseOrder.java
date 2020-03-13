package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="p_order_tab")
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pur_ord_seq" )
	@SequenceGenerator(name="pur_ord_seq", sequenceName = "pur_ord_seq", allocationSize=1,initialValue = 78977)
	@Column(name="pId")
	private Integer ordId;	
	@Column(name="purcode")
	private String ordCode;
	@Column(name="refnum")
	private String refNum;
	@Column(name="qualitycheck")
	private String qualityCheck;
	@Column(name="dstatus")
	private String defStatus;
	@Column(name="orddesc")
	private String desc;
	@ManyToOne
	@JoinColumn(name="sidFk")
	private ShipmentType sh;
	
	public PurchaseOrder() {
		super();
	}
	public PurchaseOrder(Integer ordId) {
		super();
		this.ordId = ordId;
	}
	public Integer getOrdId() {
		return ordId;
	}
	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}
	public String getOrdCode() {
		return ordCode;
	}
	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public String getDefStatus() {
		return defStatus;
	}
	public void setDefStatus(String defStatus) {
		this.defStatus = defStatus;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public ShipmentType getSh() {
		return sh;
	}
	public void setSh(ShipmentType sh) {
		this.sh = sh;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [ordId=" + ordId + ", ordCode=" + ordCode + ", refNum=" + refNum + ", qualityCheck="
				+ qualityCheck + ", defStatus=" + defStatus + ", desc=" + desc + ", sh=" + sh + "]";
	}
	


	
}
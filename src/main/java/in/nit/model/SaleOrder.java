package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sale_order_table")
public class SaleOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE_SEQ" )
	@SequenceGenerator(name="SALE_SEQ", sequenceName = "SALE_SEQ", allocationSize=1)
	
	@Column(name="ord_id")
	private Integer ordId;
	@Column(name="ord_code")
	private String    ordCode;
	@Column(name="ref_num")
	private String    refNum;
	@Column(name="stock_mode")
	private String stockMode;
	@Column(name="stock_source")
	private String stockSource;
	@Column(name="def_status")
	private String defStatus;
	@Column(name="ord_desc")
	private String desc;
	public SaleOrder() {
		super();
	}
	public SaleOrder(Integer ordId) {
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
	public String getStockMode() {
		return stockMode;
	}
	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}
	public String getStockSource() {
		return stockSource;
	}
	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
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
	@Override
	public String toString() {
		return "SaleOrder [ordId=" + ordId + ", ordCode=" + ordCode + ", refNum=" + refNum + ", stockMode=" + stockMode
				+ ", stockSource=" + stockSource + ", defStatus=" + defStatus + ", desc=" + desc + "]";
	}

}

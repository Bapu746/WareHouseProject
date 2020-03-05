package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="order_tab")
public class OrderMethod {
	@Id
	@Column(name="ord_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ" )
	@SequenceGenerator(name="ORDER_SEQ", sequenceName = "ORDER_SEQ", allocationSize=1)
	private Integer ordId;
	@Column(name="ord_mode")
	private String ordMode;
	@Column(name="ord_code")
	private String ordCode;
	@Column(name="type")
	private String ordType;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "ordacpttab",joinColumns = @JoinColumn(name="ord_id"))
	@OrderColumn(name="pos")
	@Column(name="ordacpt")
	private List<String> ordAccept;
	@Column(name="ord_desc")
	private String ordDesc;
	public OrderMethod() {
		super();
	}
	public OrderMethod(Integer ordId) {
		super();
		this.ordId = ordId;
	}
	public Integer getOrdId() {
		return ordId;
	}
	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}
	public String getOrdMode() {
		return ordMode;
	}
	public void setOrdMode(String ordMode) {
		this.ordMode = ordMode;
	}
	public String getOrdCode() {
		return ordCode;
	}
	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}
	public String getOrdType() {
		return ordType;
	}
	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}
	public List<String> getOrdAccept() {
		return ordAccept;
	}
	public void setOrdAccept(List<String> ordAccept) {
		this.ordAccept = ordAccept;
	}
	public String getOrdDesc() {
		return ordDesc;
	}
	public void setOrdDesc(String ordDesc) {
		this.ordDesc = ordDesc;
	}
	@Override
	public String toString() {
		return "OrderMethod [ordId=" + ordId + ", ordMode=" + ordMode + ", ordCode=" + ordCode + ", ordType=" + ordType
				+ ", ordAccept=" + ordAccept + ", ordDesc=" + ordDesc + "]";
	}
	
	}

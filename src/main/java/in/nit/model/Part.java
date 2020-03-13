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
@Table(name="part_tab")
public class Part {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PART_SEQ" )
	@SequenceGenerator(name="PART_SEQ", sequenceName = "PART_SEQ", allocationSize=1)
	@Column(name="prtid")
	private Integer partId;
	@Column(name="prtcode")
	private String partCode;
	@Column(name="width")
	private Double width;	
	private Double length;
	private Double height;
	@Column(name="base_currency")
	private String baseCurrency;
	@Column(name="prtdesc")
	private  String desc;
	@ManyToOne
	@JoinColumn(name="uomIdFk")
	private Uom uomOb;
	@ManyToOne
	@JoinColumn(name="ordIdSaleFk")
	private OrderMethod ordSaleOb;
	@ManyToOne
	@JoinColumn(name="ordIdPurFk")
	private OrderMethod ordPurOb;
	public Part() {
		super();
	}
	
	public Part(Integer partId) {
		super();
		this.partId = partId;
	}

	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getHeight() {
		return height;
	}
	
	

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public void setHeight(Double height) {
		this.height = height;
	}	

		public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Uom getUomOb() {
		return uomOb;
	}

	public void setUomOb(Uom uomOb) {
		this.uomOb = uomOb;
	}

	public OrderMethod getOrdSaleOb() {
		return ordSaleOb;
	}

	public void setOrdSaleOb(OrderMethod ordSaleOb) {
		this.ordSaleOb = ordSaleOb;
	}

	public OrderMethod getOrdPurOb() {
		return ordPurOb;
	}

	public void setOrdPurOb(OrderMethod ordPurOb) {
		this.ordPurOb = ordPurOb;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", width=" + width + ", length=" + length
				+ ", height=" + height + ", baseCurrency=" + baseCurrency + ", desc=" + desc + ", uomOb=" + uomOb
				+ ", ordSaleOb=" + ordSaleOb + ", ordPurOb=" + ordPurOb + "]";
	}
	

	
	

	

	

}

package minimarketdemoFactEJB.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the vw_facturas_por_mes database table.
 * 
 */
@Entity
@Table(name="vw_facturas_por_mes")
@NamedQuery(name="VwFacturasPorMes.findAll", query="SELECT v FROM VwFacturasPorMe v")
public class VwFacturasPorMe implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal anio;

	@Column(name="cantidad_facturas")
	private Long cantidadFacturas;

	@Id
	@Column(name="id_factura")
	private String idFactura;

	private BigDecimal mes;

	@Column(name="total_facturado")
	private BigDecimal totalFacturado;

	public VwFacturasPorMe() {
	}

	public BigDecimal getAnio() {
		return this.anio;
	}

	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}

	public Long getCantidadFacturas() {
		return this.cantidadFacturas;
	}

	public void setCantidadFacturas(Long cantidadFacturas) {
		this.cantidadFacturas = cantidadFacturas;
	}

	public String getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public BigDecimal getMes() {
		return this.mes;
	}

	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}

	public BigDecimal getTotalFacturado() {
		return this.totalFacturado;
	}

	public void setTotalFacturado(BigDecimal totalFacturado) {
		this.totalFacturado = totalFacturado;
	}

}
package minimarketdemoFactEJB.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the vw_facturas_por_anio database table.
 * 
 */
@Entity
@Table(name="vw_facturas_por_anio")
@NamedQuery(name="VwFacturasPorAnio.findAll", query="SELECT v FROM VwFacturasPorAnio v")
public class VwFacturasPorAnio implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal anio;

	@Column(name="cantidad_facturas")
	private Long cantidadFacturas;

	@Id
	@Column(name="id_factura")
	private String idFactura;

	@Column(name="total_facturado")
	private BigDecimal totalFacturado;

	public VwFacturasPorAnio() {
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

	public BigDecimal getTotalFacturado() {
		return this.totalFacturado;
	}

	public void setTotalFacturado(BigDecimal totalFacturado) {
		this.totalFacturado = totalFacturado;
	}

}
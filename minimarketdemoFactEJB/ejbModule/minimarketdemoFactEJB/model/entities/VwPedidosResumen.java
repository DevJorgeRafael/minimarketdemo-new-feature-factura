package minimarketdemoFactEJB.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the vw_pedidos_resumen database table.
 * 
 */
@Entity
@Table(name="vw_pedidos_resumen")
@NamedQuery(name="VwPedidosResumen.findAll", query="SELECT v FROM VwPedidosResumen v")
public class VwPedidosResumen implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal anio;

	@Column(name="cantidad_pedidos")
	private Long cantidadPedidos;

	@Column(name="id_estado_pedido")
	private String idEstadoPedido;

	@Id
	@Column(name="id_pedido")
	private Integer idPedido;

	private BigDecimal mes;

	@Column(name="total_pedidos")
	private BigDecimal totalPedidos;

	public VwPedidosResumen() {
	}

	public BigDecimal getAnio() {
		return this.anio;
	}

	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}

	public Long getCantidadPedidos() {
		return this.cantidadPedidos;
	}

	public void setCantidadPedidos(Long cantidadPedidos) {
		this.cantidadPedidos = cantidadPedidos;
	}

	public String getIdEstadoPedido() {
		return this.idEstadoPedido;
	}

	public void setIdEstadoPedido(String idEstadoPedido) {
		this.idEstadoPedido = idEstadoPedido;
	}

	public Integer getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public BigDecimal getMes() {
		return this.mes;
	}

	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}

	public BigDecimal getTotalPedidos() {
		return this.totalPedidos;
	}

	public void setTotalPedidos(BigDecimal totalPedidos) {
		this.totalPedidos = totalPedidos;
	}

}
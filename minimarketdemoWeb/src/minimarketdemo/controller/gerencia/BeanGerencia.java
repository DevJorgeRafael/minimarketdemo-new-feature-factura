package minimarketdemo.controller.gerencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import minimarketdemoFactEJB.model.entities.VwFacturasPorAnio;
import minimarketdemoFactEJB.model.entities.VwFacturasPorMe;
import minimarketdemoFactEJB.model.entities.VwPedidosResumen;
import minimarketdemoFactEJB.model.manager.ManagerGerencia;

@Named
@SessionScoped
public class BeanGerencia implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private ManagerGerencia mg;

    private BarChartModel barChartModel;
    private BarChartModel barChartModelByYear;
    private List<BigDecimal> availableYears;
    private BigDecimal selectedYear;

    private List<VwFacturasPorAnio> listaFacturasPorAnio;
    private List<VwFacturasPorMe> listaFacturasPorMes;
    private List<VwPedidosResumen> listaPedidosResumen;
    
    private boolean listaPedidosCargada = false;

    @PostConstruct
    public void inicializar() {
        try {
            listaFacturasPorAnio = mg.findAllFacturasPorAnio();
            listaFacturasPorMes = mg.findAllFacturasPorMes();
            listaPedidosResumen = mg.findAllPedidosResumen();
            initAvailableYears();
            createBarChartModel();
            createBarChartModelByYear();
        } catch (Exception e) {
            System.out.println("Error during initialization: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<VwFacturasPorAnio> getListaFacturasPorAnio() {
        return listaFacturasPorAnio;
    }

    public List<VwFacturasPorMe> getListaFacturasPorMes() {
        return listaFacturasPorMes;
    }

    public List<VwPedidosResumen> getListaPedidosResumen() {
        if (!listaPedidosCargada && listaPedidosResumen != null) {
            listaPedidosResumen.forEach(pedido -> {
            	System.out.println("---------------------------- " + pedido.getIdEstadoPedido());
            	pedido.setIdEstadoPedido(traducirEstadoPedido(pedido.getIdEstadoPedido()));
                
            });
            listaPedidosCargada = true;
        }
        return listaPedidosResumen;
    }

    private String traducirEstadoPedido(String estado) {
        switch (estado) {
            case "OK":
                return "Despachado";
            case "NV":
                return "Pendiente";
            default:
                return "Desconocido";
        }
    }


    public String actionCargarFacturasPorAnio() {
        return "facturas-anio?faces-redirect=true";
    }

    public String actionCargarFacturasPorMes() {
        return "facturas-mes?faces-redirect=true";
    }

    public String actionCargarPedidosResumen() {
        return "pedidos-resumen?faces-redirect=true";
    }

    public void initAvailableYears() {
        if (listaFacturasPorMes != null) {
            availableYears = listaFacturasPorMes.stream()
                    .map(VwFacturasPorMe::getAnio)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
        } else {
            availableYears = List.of(); 
        }
    }

    public void createBarChartModel() {
        barChartModel = new BarChartModel();
        ChartSeries series = new ChartSeries();
        series.setLabel("Facturación");

        for (int i = 1; i <= 12; i++) {
            String mes = getMonthName(i);
            series.set(mes, 0); 
        }

        listaFacturasPorMes.forEach(factura -> {
            String mes = getMonthName(factura.getMes().intValue());
            series.set(mes, factura.getTotalFacturado());
        });

        barChartModel.addSeries(series);
    }


    public void createBarChartModelByYear() {
        barChartModelByYear = new BarChartModel();
        if (selectedYear != null) {
            ChartSeries series = new ChartSeries();
            series.setLabel("Facturación - Año " + selectedYear);

            listaFacturasPorMes.stream()
                    .filter(factura -> factura.getAnio().equals(selectedYear))
                    .forEach(factura -> {
                        String mes = getMonthName(factura.getMes().intValue());
                        series.set(mes, factura.getTotalFacturado());
                    });

            barChartModelByYear.addSeries(series);
        }
    }

    public void updateChartByYear() {
        if (selectedYear != null) {
            createBarChartModelByYear();
        }
    }

    private String getMonthName(int month) {
    	String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return months[month - 1];
    }

    // Getters and Setters
    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public BarChartModel getBarChartModelByYear() {
        return barChartModelByYear;
    }

    public List<BigDecimal> getAvailableYears() {
        return availableYears;
    }

    public BigDecimal getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(BigDecimal selectedYear) {
        this.selectedYear = selectedYear;
    }
}

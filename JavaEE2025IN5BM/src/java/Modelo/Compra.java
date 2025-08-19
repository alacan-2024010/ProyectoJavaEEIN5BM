package Modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Compra {

    private int codigoCompra;
    private LocalDateTime fechaCompra;
    private BigDecimal total;
    private Proveedor codigoProveedor;
    private Empleado codigoEmpleado;

    public Compra() {
    }

    public Compra(int codigoCompra, LocalDateTime fechaCompra, BigDecimal total, Proveedor codigoProveedor, Empleado codigoEmpleado) {
        this.codigoCompra = codigoCompra;
        this.fechaCompra = fechaCompra;
        this.total = total;
        this.codigoProveedor = codigoProveedor;
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Proveedor getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Proveedor codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public Empleado getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Empleado codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
}
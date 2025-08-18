
package Modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;



@Entity
@Table (name = "Ventas")
public class Venta {
     @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoVenta ;
    @Column
    private LocalDateTime  fecha;
    @Column
    private BigDecimal total;
    @OneToMany
    @JoinColumn(name = "codigoCliente")
    private Cliente codCliente;

    @OneToMany
    @JoinColumn(name = "codigoEmpleado")
    private Empleado codEmpleado;
    
    
    public Venta() {
    }

    public Venta(int codigoVenta, LocalDateTime fecha, BigDecimal total, Cliente codCliente, Empleado codEmpleado) {
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.total = total;
        this.codCliente = codCliente;
        this.codEmpleado = codEmpleado;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }



   
    
}



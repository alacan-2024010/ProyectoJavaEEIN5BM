package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar() {
        String sql = "call sp_listarCompras()";
        List<Compra> listaCompra = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Compra comp = new Compra();
                Proveedor prov = new Proveedor();
                Empleado em = new Empleado();
                
                comp.setCodigoCompra(rs.getInt(1));
                comp.setFechaCompra(rs.getTimestamp(2).toLocalDateTime());
                comp.setTotal(rs.getBigDecimal(3));
                prov.setCodigoProveedor(rs.getInt(4));
                em.setCodigoEmpleado(rs.getInt(5));
                listaCompra.add(comp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCompra;
    }
    
    public int agregar(Compra comp) {
        String sql = "call sp_agregarCompra(?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setTimestamp(1, Timestamp.valueOf(comp.getFechaCompra()));
            ps.setBigDecimal(2, comp.getTotal());
            ps.setInt(3, comp.getCodigoProveedor().getCodigoProveedor());
            ps.setInt(4, comp.getCodigoEmpleado().getCodigoEmpleado());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
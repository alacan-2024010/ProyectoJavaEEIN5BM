package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public Empleado validar(String emailEmpleado, String telefonoEmpleado) {
        Empleado empleado = new Empleado();
        String sql = "SELECT * FROM Empleados WHERE emailEmpleado = ? AND telefonoEmpleado = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emailEmpleado);
            ps.setString(2, telefonoEmpleado);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                empleado.setDireccionEmpleado(rs.getString("direccionEmpleado"));
                empleado.setEmailEmpleado(rs.getString("emailEmpleado"));
                empleado.setTelefonoEmpleado(rs.getString("telefonoEmpleado"));
            }
        } catch (Exception e) {
            System.out.println("El usuario o contraseña son incorrectos");
            e.printStackTrace();
        }
        return empleado;
    }

    //Operacion listar
    public List listar() {
        String sql = "CALL sp_listarEmpleados();";
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setCodigoEmpleado(rs.getInt(1));
                em.setNombreEmpleado(rs.getString(2));
                em.setApellidoEmpleado(rs.getString(3));
                em.setDireccionEmpleado(rs.getString(4));
                em.setTelefonoEmpleado(rs.getString(5));
                em.setEmailEmpleado(rs.getString(6));
                em.setPuestoEmpleado(rs.getString(7));
                listaEmpleados.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }

    // Agregar
    public int agregar(Empleado emp) {
        String sql = "CALL sp_agregarEmpleado(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombreEmpleado());
            ps.setString(2, emp.getApellidoEmpleado());
            ps.setString(3, emp.getDireccionEmpleado());
            ps.setString(4, emp.getTelefonoEmpleado());
            ps.setString(5, emp.getEmailEmpleado());
            ps.setString(6, emp.getPuestoEmpleado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public Empleado listarCodigoEmpleado(int id) {
        Empleado emp = new Empleado();
        String sql =  "Select * from Empleado where codigoEmpleado = " +id;
    
   try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            emp.setNombreEmpleado(rs.getString(2));
            emp.setApellidoEmpleado(rs.getString(3));
            emp.setDireccionEmpleado(rs.getString(4));
            emp.setTelefonoEmpleado(rs.getString(5));
            emp.setEmailEmpleado(rs.getString(6));
            emp.setPuestoEmpleado(rs.getString(7));
        }
    }
    catch(Exception e){
          e.printStackTrace();
    }
    return emp ;
}
    
    public int actualizar (Empleado emp){
        String sql = "Update Empleado set nombreEmpleado = ?, apellidoEmpleado = ?, direccionEmpleado = ?,telefonoEmpleado = ?,puestoEmpleado = ? where codigoEmpleado = ?";
            try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, emp.getNombreEmpleado());
        ps.setString(2, emp.getApellidoEmpleado());
        ps.setString(3, emp.getDireccionEmpleado());
        ps.setString(4, emp.getTelefonoEmpleado());
        ps.setString(5, emp.getEmailEmpleado());
        ps.setString(6, emp.getPuestoEmpleado());
         ps.setInt(7, emp.getCodigoEmpleado());
         ps.executeUpdate();    
        
        } catch (Exception e) {
            e.printStackTrace();
        }
          return resp;    
    }
    
    public void eliminar (int id){
        String sql = "Delete from empleado where codigoEmpleado ="+id;
        try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

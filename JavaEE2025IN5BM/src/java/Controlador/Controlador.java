/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.DetalleVentaDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Factura;
import Modelo.FacturaDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author informatica
 */
public class Controlador extends HttpServlet {

    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    Cliente cliente = new Cliente();
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDao = new ProveedorDAO();
    Producto producto = new Producto();
    ProductoDAO productoDao = new ProductoDAO();
    Categoria categoria = new Categoria();
    Factura factura = new Factura();
    FacturaDAO facturaDAO = new FacturaDAO();
    Venta venta = new Venta();
    VentaDAO ventaDAO = new VentaDAO();
    DetalleVentaDAO detalleventaDAO = new DetalleVentaDAO();
    DetalleVenta detalleVenta = new DetalleVenta();

    int codEmpleado;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }

        if (menu != null) {
            switch (menu) {
                case "Cliente":
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    break;
                case "Proveedor":
                    switch (accion) {
                        case "Listar":
                            List listaProveedores = proveedorDao.listar();
                            request.setAttribute("proveedores", listaProveedores);
                            break;
                        case "Agregar":
                            String nombreProveedor = request.getParameter("txtNombreProveedor");
                            String direccionProveedor = request.getParameter("txtDireccionProveedor");
                            String telefonoProveedor = request.getParameter("txtTelefonoProveedor");
                            String correoProveedor = request.getParameter("txtCorreoProveedor");

                            proveedor.setNombreProveedor(nombreProveedor);
                            proveedor.setDireccionProveedor(direccionProveedor);
                            proveedor.setTelefonoProveedor(telefonoProveedor);
                            proveedor.setCorreoProveedor(correoProveedor);

                            proveedorDao.agregar(proveedor);
                            request.getRequestDispatcher("Controlador?menu?Proveedor&accion=Listar").forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }

                    request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                    break;
                case "Producto":
                    switch (accion) {
                        case "Listar":
                            List listaProducto = productoDao.listar();
                            request.setAttribute("productos", listaProducto);
                            break;
                        case "Agregar":
                            String nombreProducto = request.getParameter("txtNombreProducto");
                            String descripcionProducto = request.getParameter("txtDescripcionProducto");
                            String precioProducto = request.getParameter("txtPrecioProducto");
                            String stock = request.getParameter("txtExistenciasProducto");
                            String idCategoria = request.getParameter("txtIdCategoria");
                            String idMarca = request.getParameter("txtIdMarca");

                            producto.setNombreProducto(nombreProducto);
                            producto.setDescripcionProducto(descripcionProducto);
                            producto.setPrecioProducto(BigDecimal.valueOf(Double.parseDouble(precioProducto)));
                            producto.setStock(Integer.parseInt(stock));

                            categoria.setCodigoCategoria(Integer.parseInt(idCategoria));
                            producto.setCategoria(categoria);

                            proveedor.setCodigoProveedor(Integer.parseInt(idMarca));
                            producto.setProveedor(proveedor);

                            productoDao.agregar(producto);
                            request.getRequestDispatcher("Controlador?menu?Producto&accion=Listar").forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("producto.jsp").forward(request, response);
                    break;
                case "Empleado":
                    switch (accion) {
                        case "Listar":
                            List listaEmpleado = empleadoDAO.listar();
                            request.setAttribute("empleados", listaEmpleado);
                            break;
                        case "Agregar":

                            break;
                        case "Editar":
                            codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                            Empleado e = empleadoDAO.listarCodigoEmpleado(codEmpleado);
                            request.setAttribute("empleado", e);
                            request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                            break;
                        case "Actualizar":
                            String nombreEmpleado = request.getParameter("txtxNombreEmpleado");
                            String apellidoEmpelado = request.getParameter("txtxApellidoEmpelado");
                            String direccionEmpleado = request.getParameter("txtxDireccionEmpleado");
                            String telefonoEmpleado = request.getParameter("txtTelefonoEmpleado");
                            String emailEmpleado = request.getParameter("txtEmailEmpleado");
                            String puestoEmpleado = request.getParameter("txtPuestoEmpleado");

                            empleado.setNombreEmpleado(nombreEmpleado);
                            empleado.setApellidoEmpleado(apellidoEmpelado);
                            empleado.setDireccionEmpleado(direccionEmpleado);
                            empleado.setTelefonoEmpleado(telefonoEmpleado);
                            empleado.setEmailEmpleado(emailEmpleado);
                            empleado.setPuestoEmpleado(puestoEmpleado);
                            empleado.setCodigoEmpleado(codEmpleado);
                            empleadoDAO.actualizar(empleado);
                            request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                            break;
                        case "Eliminar":
                            codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                            empleadoDAO.eliminar(codEmpleado);
                            request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar");
                            break;
                        case "Buscar":
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("empleado.jsp").forward(request, response);
                case "Venta":
                    switch (accion) {
                        case "Listar":
                            List listaVenta = ventaDAO.listar();
                            request.setAttribute("ventas", listaVenta);
                            break;
                        case "Agregar":
                            String fecha = request.getParameter("txtFecha");

                            String total = request.getParameter("txtTotal");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                            LocalDateTime fechaEmision = LocalDateTime.parse(fecha, formatter);

                            String codCliente = request.getParameter("txtCodigoCliente");
                            String codEmpleado = request.getParameter("txtCodigoEmpleado");

                            venta.setFecha(fechaEmision);
                            venta.setTotal(BigDecimal.valueOf(Double.parseDouble(total)));

                            cliente.setCodigoCliente(Integer.parseInt(codCliente));
                            venta.setCodCliente(cliente);
                            empleado.setCodigoEmpleado(Integer.parseInt(codEmpleado));
                            venta.setCodEmpleado(empleado);

                            ventaDAO.agregar(venta);
                            request.getRequestDispatcher("Controlador?menu?Venta&accion=Listar").forward(request, response);
                            break;
                        case "Editar":
                            break;
                        case "Actualizar":
                            break;
                        case "Eliminar":
                            break;
                        case "Buscar":
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("venta.jsp").forward(request, response);
                    break;

                case "DetalleVenta":
                    switch (accion) {
                        case "Listar":
                            List listaDetalleVenta = detalleventaDAO.listar();
                            request.setAttribute("detalleVentas", listaDetalleVenta);
                            break;
                        case "Agregar":
                            String cantidad = request.getParameter("txtCantidad");

                            String precioUnitario = request.getParameter("txtPrecioUnitario");

                            String Codventa = request.getParameter("txtCodigoVenta");

                            String Codproducto = request.getParameter("txtCodigoProducto");

                            detalleVenta.setCantidad(Integer.parseInt(cantidad));
                            detalleVenta.setPrecioUnitario(BigDecimal.valueOf(Double.parseDouble(precioUnitario)));

                            venta.setCodigoVenta(Integer.parseInt(Codventa));
                            detalleVenta.setVenta(venta);

                            producto.setCodigoProducto(Integer.parseInt(Codproducto));
                            detalleVenta.setProducto(producto);

                            detalleventaDAO.agregar(detalleVenta);
                            request.getRequestDispatcher("Controlador?menu=DetalleVenta&accion=Listar").forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("detalleVenta.jsp").forward(request, response);
                    break;

                case "Factura":
                    switch (accion) {
                        case "Listar":
                            List listaFactura = facturaDAO.listar();
                            request.setAttribute("facturas", listaFactura);
                            break;
                        case "Agregar":
                            String numeroFactura = request.getParameter("txtNumeroFactura");

                            String fechaEmisionStr = request.getParameter("txtFechaEmision");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                            LocalDateTime fechaEmision = LocalDateTime.parse(fechaEmisionStr, formatter);

                            String totalFactura = request.getParameter("txtTotal");
                            String codVenta = request.getParameter("txtCodigoVenta");

                            factura.setNumeroFactura(numeroFactura);
                            factura.setFechaEmision(fechaEmision);
                            factura.setTotalFactura(BigDecimal.valueOf(Double.parseDouble(totalFactura)));

                            venta.setCodigoVenta(Integer.parseInt(codVenta));
                            factura.setCodVenta(venta);

                            facturaDAO.agregar(factura);
                            request.getRequestDispatcher("Controlador?menu?Factura&accion=Listar").forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("factura.jsp").forward(request, response);
                    break;
                case "Compra":
                    request.getRequestDispatcher("compras.jsp").forward(request, response);
                    break;
                case "DetalleCompra":
                    request.getRequestDispatcher("detalleCompra.jsp").forward(request, response);
                    break;
                case "Cambiar":
                    request.getRequestDispatcher("principal.jsp").forward(request, response);
                    break;
                case "Cerrar":
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

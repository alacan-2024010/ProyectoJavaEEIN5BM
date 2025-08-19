<%-- 
    Document   : detalleCompras
    Created on : 22/07/2025, 17:57:26
    Author     : danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Essenza | Detalle de Compras</title>
    <link rel="stylesheet" href="Styles/cliente.css">
</head>
<body>

    <div class="contenedor-principal">

        <!-- Panel Formulario -->
        <div class="form-container">
            <h1>Gestión de Detalle de Compras</h1>
            <form action="Controlador?menu=DetalleCompra" method="post" class="formulario">
                <input type="text" name="txtCantidad" placeholder="Cantidad" required>
                <input type="text" name="txtPrecioUnitario" placeholder="Precio Unitario" required>
                <input type="text" name="txtCodigoCompra" placeholder="Código Compra" required>
                <input type="text" name="txtCodigoProducto" placeholder="Código Producto" required>

                <div class="botones">
                    <button type="submit" name="accion" value="Agregar">Agregar</button>
                </div>

                <div class="marca-interna">
                    Essenza & Co.
                </div>
            </form>
        </div>

        <!-- Panel Tabla -->
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Cantidad</th>
                        <th>Precio Unitario</th>
                        <th>Código Compra</th>
                        <th>Código Producto</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="detalle" items="${detalleCompras}">
                        <tr>
                            <td>${detalle.codigoDetalleCompra}</td>
                            <td>${detalle.cantidad}</td>
                            <td>${detalle.precioUnitario}</td>
                            <td>${detalle.codigoCompra}</td>
                            <td>${detalle.codigoProducto}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</body>
</html>

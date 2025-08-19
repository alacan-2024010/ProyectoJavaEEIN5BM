<%--
    Document   : compras
    Created on : 22/07/2025, 17:34:01
    Author     : Titi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Essenza & Co. | Gestión de Compras</title>
    <link rel="stylesheet" href="Styles/cliente.css">
</head>
<body>
    <nav>
    </nav>
    <div class="fondo"></div>
    <div class="contenedor-principal">
        <div class="panel-formulario">
            <h1>Gestión de Compras</h1>
            <form action="Controlador?menu=Compra" method="POST" class="formulario">

                <input type="text" autocomplete="off" value="${compra.getCodigoCompra()}" id="txtCodigoCompra" name="txtCodigoCompra" class="input" placeholder="ID de la Compra" />
                <input type="datetime-local" autocomplete="off" value="${compra.getFechaCompra()}" id="txtFechaCompra" name="txtFechaCompra" class="input" placeholder="Fecha" required/>
                <input type="text" autocomplete="off" value="${compra.getTotal()}" id="txtTotal" name="txtTotal" class="input" placeholder="Total" required/>
                <input type="text" autocomplete="off" value="${compra.getCodigoProveedor()}" id="txtCodigoProveedor" name="txtCodigoProveedor" class="input" placeholder="Código de Proveedor" required/>
                <input type="text" autocomplete="off" value="${compra.getCodigoEmpleado()}" id="txtCodigoEmpleado" name="txtCodigoEmpleado" class="input" placeholder="Código de Empleado" required/>

                <div class="botones">
                    <button>Agregar</button>
                    <button>Actualizar</button>
                    <button>Buscar</button>
                    <button class="eliminar">Eliminar</button>
                </div>
                <div class="marca-interna">
                    Essenza & Co.
                </div>
            </form>
        </div>
        <div class="panel-tabla">
            <div class="tabla-contenedor">
                <table class="tabla">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Fecha</th>
                            <th>Total</th>
                            <th>ID Proveedor</th>
                            <th>ID Empleado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="compra" items="${compras}">
                            <tr>
                                <td>${compra.codigoCompra}</td>
                                <td>${compra.fechaCompra}</td>
                                <td>${compra.total}</td>
                                <td>${compra.codigoProveedor.codigoProveedor}</td>
                                <td>${compra.codigoEmpleado.codigoEmpleado}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
package com.alumnione.ecommerce.enumeration;
// Pendiente: Cuando es creada.
// Aceptada: Cuando el proveedor acepta la solicitud.
// Facturada: Cuando se asocia a una factura enviada por su proveedor.
// Despachada: Cuando los productos son despachados.
// Rechazada: Cuando el proveedor rechaza la orden de compra.
public enum EOrderStatus {
    PENDING,
    ACCEPTED,
    INVOICED,
    SHIPPED,
    REJECTED
}

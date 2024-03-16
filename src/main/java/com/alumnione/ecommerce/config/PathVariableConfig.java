package com.alumnione.ecommerce.config;

/**
 * Esta clase servira como una biblioteca de constantes para la estandarizacion de los endpoints
 * de los controladores del proyecto.
 * <p>
 * Example: http://localhost:8080/GENERIC_RESOURCE/RESOURCE --> http://localhost:8080/ecommerce/orders
 */
public final class PathVariableConfig {
    //////////////////////////////////////// API VERSION ////////////////////////////////////////
    //private static final String API_VERSION = "/v1";
    //////////////////////////////////////// ECOMMERCE PATH'S //////////////////////////////////
    public static final String GENERIC_RESOURCE = "/ecommerce"; // http://localhost:8080/ecommerce
    //////////////////////////////////////// ID'S PATH'S //////////////////////////////////
    public static final String RESOURCE_ID = "/{id}";
    public static final String RESOURCE_ID_ITEM = "/{idItem}";
    //////////////////////////////////////// RESOURCES PATH'S //////////////////////////////////
    public static final String SHIPMENT_RESOURCE = "/shipments"; // http://localhost:8080/ecommerce/shipments
    public static final String ORDER_RESOURCE = "/orders"; // http://localhost:8080/ecommerce/orders
    public static final String INVOICE_RESOURCE = "/invoices"; // http://localhost:8080/ecommerce/invoices
    public static final String USER_RESOURCE = "/users"; // http://localhost:8080/ecommerce/users
    public static final String CELLPHONE_RESOURCE = "/cellphones"; // http://localhost:8080/ecommerce/cellphones
    public static final String CART_RESOURCE = "/carts"; // http://localhost:8080/ecommerce/carts
    public static final String ITEM_RESOURCE = "/items"; // http://localhost:8080/ecommerce/carts/{id}/items
    public static final String PAYMENT_RESOURCE = "/payments"; // http://localhost:8080/ecommerce/payments
    public static final String PRODUCT_RESOURCE = "/products"; // http://localhost:8080/ecommerce/products
    public static final String CATEGORY_RESOURCE = "/categories"; // http://localhost:8080/ecommerce/categories
}

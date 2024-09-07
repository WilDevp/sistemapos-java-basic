package model;

import java.util.ArrayList;
/*
 * Mostrar
 * eliminar
 * Agregar
 * total
 * */
public class Carrito {
    private ArrayList<CarritoItem> items;

    public Carrito() {
        items = new ArrayList<CarritoItem>();
    }
    public void mostarCarrito() {
        for (CarritoItem item : items) {
            System.out.println(item.getProducto().getNombre() + " X " + item.getCantidad() + ": $" + ( item.getProducto().getPrecio() * item.getCantidad()));
        }
    }
    public void eliminarCarrito() {
        items.clear();
    }
    public void agregarProducto(Producto producto){
        for (CarritoItem item: items){
            if (item.getProducto().getNombre().equals(producto.getNombre())){
                item.incrementarCantidad();
                return;
            }
        }
        items.add(new CarritoItem(producto,1));

    }
    public double calcularPrecio(){
        double total = 0;
        for (CarritoItem item: items){
            total += item.getProducto().getPrecio() * item.getCantidad();
        }
        return total;
    }

}

package model;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPOS {
    private ArrayList<Producto> inventario;
    private Carrito carrito;
    private Scanner scanner;

    public SistemaPOS(){
        inventario = new ArrayList<Producto>();
        carrito = new Carrito();
        scanner = new Scanner(System.in);
        inventario.add(new Producto("Coca Cola", 10));
        inventario.add(new Producto("Pepsi", 8));
        inventario.add(new Producto("Fanta", 7));
        inventario.add(new Producto("Sprite", 9));
    }

    public void mostrarMenu(){
        System.out.println("Bienvenido al sistema POS");
        System.out.println("Seleccione una opción: \n");
        System.out.println("1. Ver productos");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Pagar");
        System.out.println("5. Salir");
    }

    public void mostrarProductos(){
        System.out.println("Productos disponibles: ");
        for (Producto producto : inventario){
            System.out.println(producto.getNombre() + " $" + producto.getPrecio());
        }
    }

    public void agregarProducto() {
        System.out.println("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        boolean productoEncontrado = false;
        for (Producto producto : inventario) {
            if (producto.getNombre().equals(nombreProducto)) {
                carrito.agregarProducto(producto);
                System.out.println("Producto " + producto.getNombre() +" agregado al carrito");
                productoEncontrado = true;
                break;
            }
        }
        if (!productoEncontrado){
            System.out.println("Producto no encontrado");
        }
    }

    public void realizarPago(){
        System.out.println("El total a pagar es: $" + carrito.calcularPrecio());
        System.out.println("Gracias por su compra");
        carrito.eliminarCarrito();
    }

    public void ejecutar(){
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    agregarProducto();
                    break;
                case 3:
                    carrito.mostarCarrito();
                    break;
                case 4:
                    realizarPago();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema POS");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }
}

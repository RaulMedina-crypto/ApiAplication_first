package org.generation.api.servicios;

import org.generation.api.modelos.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    private final ArrayList<Producto> lista = new ArrayList<>();
    public ProductoService(){
        lista.add(new Producto("Mochila ergonómica", "Mochila impermeable", "./mochila.png", 649.00));
        lista.add(new Producto("Juego de Geometría", "Paquete con regla, escuadras, transportador y compás de metal.", "./geometria.png", 85.50));
        lista.add(new Producto("Caja de Colores", "Lápices de color redondos, caja con 24 piezas intensas.", "./colores.png", 145.00));
        lista.add(new Producto("Pegamento en Barra", "Lápiz adhesivo de 40 gramos, secado rápido y limpio.", "./pegamento.png", 32.00));
        lista.add(new Producto("Tijeras Escolares", "Tijeras de punta roma de 5 pulgadas con mango de plástico.", "./tijeras.png", 24.50));
        lista.add(new Producto("Calculadora Científica", "Calculadora con 240 funciones y pantalla de dos líneas.", "./calculadora.png", 319.99));
        lista.add(new Producto("Paquete de Plumas", "Bolígrafos de punto mediano, color negro, azul y rojo, 12 piezas.", "./plumas.png", 58.00));
        lista.add(new Producto("Sacapuntas con Depósito", "Sacapuntas doble para lápiz estándar y de dibujo.", "./sacapuntas.png", 18.50));
        lista.add(new Producto("Goma de Borrar", "Borrador de migajón blanco, libre de PVC, 3 piezas.", "./gomas.png", 22.00));
        lista.add(new Producto("Marca-textos Fluorescentes", "Paquete de 4 iluminadores de texto en tonos neón.", "./marcatextos.png", 45.00));

    }//constructor ProductoService

    public List<Producto> getProductos() {
        return lista;
    }//getproductos

    public Producto getProducto(Long id) {
        Producto producto = null;
        for(Producto p: lista){
            if(p.getId().equals(id)){
                producto = p;
                break;
            }//if
        }//foreach
        return producto;
    }//getProducto

    public Producto deleteProducto(Long id) {
        Producto producto = null;
        for(Producto p: lista){
            if(p.getId().equals(id)){
                producto = p;
                lista.remove(producto);
                break;
            }//if
        }//foreach
        return producto;
    }

    public Producto crearProducto(Producto producto) {
        lista.add(producto);
        return producto;
    }

    public Producto actualizarProducto(Long id, String nombre, String descripcion, String imagen, Double precio) {
        Producto producto = null;
        for(Producto p: lista){
            if(p.getId().equals(id)){
                producto = p;
                if(nombre != null) producto.setNombre(nombre);
                if(descripcion != null) producto.setDescripcion(nombre);
                if(imagen != null) producto.setImagen(imagen);
                if(precio != null) producto.setPrecio(precio);
                break;
            }//if
        }//forEach
        return producto;
    }//actualizarProducto
}//class ProductoService

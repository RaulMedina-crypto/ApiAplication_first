package org.generation.api.controladores;

import org.generation.api.modelos.Producto;
import org.generation.api.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/productos/")//http://localhost:8080/api/productos
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService service){
        this.productoService = service;
    }//constructor productoService

    @GetMapping
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }

    @GetMapping("{productoId}")
    public Producto getProducto(@PathVariable("productoId") Long id){
        return productoService.getProducto(id);
    }//getProducto

    @DeleteMapping(path="{productoId}")
    public Producto deleteProducto(@PathVariable("productoId") Long id){
        return productoService.deleteProducto(id);
    }//getProducto

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }//crearProducto

    @PutMapping(path="{productoId}")
    public Producto actualizarProducto(@PathVariable("productoId") Long id,
                                       @RequestParam(value="nombre", required = false) String nombre,
                                       @RequestParam(value="descripcion", required = false) String descripcion,
                                       @RequestParam(value="imagen", required = false) String imagen,
                                       @RequestParam(value="precio", required = false) Double precio) {
        return productoService.actualizarProducto(id, nombre, descripcion, imagen, precio);
    }//actualizarProducto

}//class productocontroller

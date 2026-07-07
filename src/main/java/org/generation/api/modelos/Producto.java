package org.generation.api.modelos;

public class Producto {
    private Long id;
    public static Long total = 0L;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;

    public Producto(String nombre, String descripcion, String imagen, Double precio) {
        Producto.total ++;
        this.id = Producto.total;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
    }//constructor producto

    public Producto(){}//constructor vacío (requisito JPA)

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }//get nombre

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//set nombre

    public String getDescripcion() {
        return descripcion;
    }//get descripcion

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }//set descripcion
    public String getImagen() {
        return imagen;
    }//get imagen

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }//set imagen

    public Double getPrecio() {
        return precio;
    }//get precio

    public void setPrecio(Double precio) {
        this.precio = precio;
    }//set precio

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                '}';
    }
}//class producto


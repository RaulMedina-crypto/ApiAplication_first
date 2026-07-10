package org.generation.api.modelos;

import jakarta.persistence.*;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="productoId", unique=true, nullable = false)
    private Long id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="descripcion", nullable = false)
    private String descripcion;

    @Column(name="imagen", nullable = false)
    private String imagen;

    @Column(name="precio", nullable = false)
    private Double precio;

    public Producto(String nombre, String descripcion, String imagen, Double precio) {
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


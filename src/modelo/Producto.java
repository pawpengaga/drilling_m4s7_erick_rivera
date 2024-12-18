package modelo;

import interfaces.IProductoInterface;

public class Producto implements IProductoInterface {

  private long precio;
  private int stock;

  public Producto(){
  }

  public Producto(long precio){
    this.precio = precio;
  }

  public long getPrecio() {
    return precio;
  }

  public int getStock() {
    return stock;
  } 

  public void setPrecio(long precio) {
    this.precio = precio;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public Producto(long precio, int stock) {
    this.precio = precio;
    this.stock = stock;
  }

  @Override
  public void cambiarPrecio(long precio) {
    this.precio = precio;
  }

  @Override
  public int cantidadDisponible() {
    return stock;
  }
}

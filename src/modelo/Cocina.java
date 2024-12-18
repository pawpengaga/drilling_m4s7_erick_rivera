package modelo;

import excepciones.ProductoInverosimilException;
import interfaces.ICocinaInterface;

public class Cocina extends Producto implements ICocinaInterface{

  private int cantQuemadores;
  private boolean incluyeGas;

  public Cocina(long precio, int stock, int cantQuemadores) throws ProductoInverosimilException {
    super(precio, stock);

    if(cantQuemadores > 0){
      this.cantQuemadores = cantQuemadores;
    } else {
      throw new ProductoInverosimilException("El producto que quiere crear no tiene sentido en la vida real.");
    }

  }

  @Override
  public void cambiarPrecio(long precio) {
    super.cambiarPrecio(precio);
  }

  @Override
  public int cantidadDisponible() {
    return super.cantidadDisponible();
  }

  @Override
  public void incluyeGas(boolean gasSioNo) {
    this.incluyeGas = gasSioNo;
  }

  @Override
  public String toString() {

    String iG = incluyeGas ? "Si" : "No";

    return "COCINA: {" +
      " cantidad_quemadores: '" + cantQuemadores + "'" +
      ", incluye_gas: '" + iG + "'" +
      ", precio: '" + getPrecio() + "'" +
      " }";
  }


  

}

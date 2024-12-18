package modelo;
import java.util.Random;

import excepciones.ProductoInverosimilException;
import interfaces.IProductoInterface;

public class Refrigerador extends Producto implements IProductoInterface {

  // private final char[] TIPOS_GASTO = {'A', 'B', 'C', 'D', 'E'};

  private Random rng = new Random();

  private TipoGasto tipoGasto;
  private int numPuertas;


  public Refrigerador(long precio, int stock, int numPuertas) throws ProductoInverosimilException {

    // super(precio, stock);
    this.tipoGasto = TipoGasto.values()[rng.nextInt(TipoGasto.values().length)];

    if (numPuertas > 0){
      this.numPuertas = numPuertas;
    } else {
      throw new ProductoInverosimilException("El producto que quiere crear no tiene sentido en la vida real.");
    }
    
  }


  @Override
  public String toString() {
    return "REFRIGERADOR: {" +
      " tipo_de_gasto: '" + tipoGasto + "'" +
      ", numero_de_puertas: '" + numPuertas + "'" +
      " }";
  }  
  
  /* METODOS DE INTERFAZ */

  @Override
  public void cambiarPrecio(long precio) {
    super.cambiarPrecio(precio);
  }

  @Override
  public int cantidadDisponible() {
    return super.cantidadDisponible();
  }


  




}

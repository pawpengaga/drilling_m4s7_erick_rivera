package principal;

import java.util.Scanner;

import excepciones.ProductoInverosimilException;
import modelo.Cocina;
import modelo.Producto;
import modelo.Refrigerador;

public class ProductoApp {

  /* GENERALES */
  static boolean enLaApp = true;
  static Scanner myscan = new Scanner(System.in);

  public static void main(String[] args) throws ProductoInverosimilException {

    System.out.println("------------------------------------------\n");

    /* INSTANCIAS DE CLASE */

    /* MENU */
    System.out.println("BIENVENIDO AL SERVICIO DE VENTA DE ELECTRODOMÉSTICOS");
    while (enLaApp) {
      
      System.err.println("Seleccione: ¿Que producto desea comprar?");
      System.out.println("1. Cocina");
      System.out.println("2. Refrigerador");

      int opcion = myscan.nextInt();
      myscan.nextLine(); // Limpieza de buffer

      switch (opcion) {
        case 1 -> rutaCocina();
        case 2 -> rutaRefri();
        default -> System.out.println("Por favor, seleccione una opción valida");
      }

    }
    
    myscan.close();

  }

  /* METODOS PRIVADOS */
  private static void rutaCocina(){
    System.out.println("Caimos en cocina");
    enLaApp = false;

  }
  private static void rutaRefri(){
    System.out.println("Caimos en refri");
    enLaApp = false;

  }
}

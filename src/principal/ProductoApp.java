package principal;

import java.util.Scanner;

import excepciones.ProductoInverosimilException;
import modelo.Cocina;
import modelo.Producto;
import modelo.Refrigerador;
import modelo.TipoGasto;

public class ProductoApp {

  /* GENERALES */
  static boolean enLaApp = true;
  static Scanner myscan = new Scanner(System.in);

  public static void main(String[] args) throws ProductoInverosimilException {

    while (enLaApp) {
      System.out.println("------------------------------------------\n");
  
      /* INSTANCIAS DE CLASE */
  
      /* MENU */
      System.out.println("BIENVENIDO AL SERVICIO DE VENTA DE ELECTRODOMÉSTICOS");
      
      System.err.println("Seleccione: ¿Que producto desea comprar?");
      System.out.println("1. Cocina");
      System.out.println("2. Refrigerador");
      System.out.println("3. Salir");

      int opcion = myscan.nextInt();
      myscan.nextLine(); // Limpieza de buffer

      switch (opcion) {
        case 1 -> rutaCocina();
        case 2 -> rutaRefri();
        case 3 -> enLaApp = false;
        default -> System.out.println("Por favor, seleccione una opción valida");
      }

    }
    
    myscan.close();

  }

  /* METODOS PRIVADOS */
  private static void rutaCocina() throws ProductoInverosimilException {
    
    Cocina cocinaElegida = new Cocina(150000, 10, 4);

    System.out.println("Valor: $" + cocinaElegida.getPrecio());
    System.out.println("Artículos disponibles:" + cocinaElegida.getStock());
    
    System.out.println("Presione Y para continuar. N para cancelar");
    String aceptaFormat = myscan.nextLine();

    if (aceptaFormat.toLowerCase().equals("y")) {
      
      System.out.println("Desea incluir un gas por $5000 pesos? Si o No");
      String ofertaGas = myscan.nextLine().toLowerCase();
      
      if (ofertaGas.equals("si")) {
        cocinaElegida.incluyeGas(true);
        cocinaElegida.setPrecio(cocinaElegida.getPrecio() + 5000);
        System.out.println("Felicidades! Ha comprado su cocina incluyendo un gas por $" + cocinaElegida.getPrecio() + " pesos.");
      } else if (ofertaGas.equals("no")) {
        System.out.println("Felicidades! Ha comprado su cocina.");
      }

      cocinaElegida.setStock(cocinaElegida.cantidadDisponible() - 1);

      System.out.println("Nueva cantidad de artículos disponible: " + cocinaElegida.cantidadDisponible());

      System.out.println("Muchas gracias por usar la app");

      enLaApp = false;
      
    } else if (aceptaFormat.toLowerCase().equals("n")){

      System.out.println("Muchas gracias por su tiempo, saliendo...");
      enLaApp = false;
      
    } else {
      
      System.out.println("Por favor, ingrese una opción valida la próxima vez");
      enLaApp = false;
      
    }    

  }
  private static void rutaRefri() throws ProductoInverosimilException{

    Refrigerador refriElegido = new Refrigerador(250000, 10);

    System.out.println("Valor: $" + refriElegido.getPrecio());
    System.out.println("Artículos disponibles: " + refriElegido.getStock());

    System.out.println("Presione Y para continuar. N para cancelar");
    String aceptaFormat = myscan.nextLine();

    if (aceptaFormat.toLowerCase().equals("y")) {

      System.out.println("Seleccione el tipo de consumo energético");
      int[] precioAumentado = {2500, 2000, 1500, 1000, 0};
      System.out.println("");
      for (int i = 0; i < TipoGasto.values().length; i++) {
        System.out.println("TIPO " + TipoGasto.values()[i] + " (+ $ " + precioAumentado[i] + " pesos)");
      }
      
      String opcionGasto = myscan.nextLine().toLowerCase();

      switch (opcionGasto) {
        case "a" -> {
          refriElegido.setPrecio(refriElegido.getPrecio() + precioAumentado[0]);
          refriElegido.setTipoGasto(TipoGasto.A);
        }
        case "b" -> {
          refriElegido.setPrecio(refriElegido.getPrecio() + precioAumentado[1]);
          refriElegido.setTipoGasto(TipoGasto.B);
        }
        case "c" -> {
          refriElegido.setPrecio(refriElegido.getPrecio() + precioAumentado[2]);
          refriElegido.setTipoGasto(TipoGasto.C);
        }
        case "d" -> {
          refriElegido.setPrecio(refriElegido.getPrecio() + precioAumentado[3]);
          refriElegido.setTipoGasto(TipoGasto.D);
        }
        case "e" -> {
          refriElegido.setPrecio(refriElegido.getPrecio() + precioAumentado[4]);
          refriElegido.setTipoGasto(TipoGasto.E);
        }
        default -> {
          System.out.println("Por favor, ingrese una opción valida la próxima vez");
          enLaApp = false;
        }
      }

      System.out.println();
      System.out.println("Precio aumentó a: $" + refriElegido.getPrecio() + " pesos.");
      System.out.println();

      System.out.println("¿Con cuantas puertas?");
      System.out.println("1. Una");
      System.out.println("2. Dos (+ $ 2000 pesos)");
      System.out.println("3. Tres (+ $ 3000 pesos)");
      int opcionPuertas = myscan.nextInt();

      switch (opcionPuertas) {
        case 1 -> {
          refriElegido.getPrecio();
          refriElegido.setNumPuertas(opcionPuertas);
        }
        case 2 -> {
          refriElegido.setPrecio(refriElegido.getPrecio() + 2000);
          refriElegido.setNumPuertas(opcionPuertas);
        }
        case 3 -> {
          refriElegido.setPrecio(refriElegido.getPrecio() + 3000);
          refriElegido.setNumPuertas(opcionPuertas);
        }
        default -> {
          System.out.println("Por favor, ingrese una opción valida la próxima vez");
          enLaApp = false;
        }
      }

      // System.out.println();
      // System.out.println("Precio aumentó a: $" + refriElegido.getPrecio() + " pesos.");
      // System.out.println();

      refriElegido.setStock(refriElegido.getStock() - 1);
      System.out.println("Felicidades! Ha comprado su refrigerador de " + refriElegido.getNumPuertas() + " puertas y tipo de gasto '" + refriElegido.getTipoGasto().toString() + "' por $" + refriElegido.getPrecio() + " pesos.");
      System.out.println("Nueva cantidad de artículos disponible: " + refriElegido.cantidadDisponible());
      System.out.println("Muchas gracias por usar la app");

      enLaApp = false;
      
    } else if (aceptaFormat.toLowerCase().equals("n")){
      System.out.println("Muchas gracias por su tiempo, saliendo...");
      enLaApp = false;
    } else {
      System.out.println("Por favor, ingrese una opción valida la próxima vez");
      enLaApp = false;
    }

    

    enLaApp = false;

  }
}

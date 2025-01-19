import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        Scanner entrada = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion = 0;

        while (true) {
            System.out.println("********MENU PRINCIPAL-CONVERSOR MONEDAS*********");
            System.out.println(" 1.- DOLAR A SOL PERUANO\n" +
                    "2.- SOL PERUANO A DOLAR\n " +
                    "3.- DOLAR A REAL BRASILEÑO\n" +
                    "4.- REAL BRASILEÑO A DOLAR\n" +
                    "5.- DOLAR A PESO COLOMBIANO\n" +
                    "6.- PESO COLOMBIANO A DOLAR\n" +
                    "7.- SOL PERUANO A EURO\n" +
                    "8.- EURO A SOL PERUANO\n" +
                    "9.- Salir\n");
            System.out.println("*****************************************************");
            System.out.print("Ingrese la opción que desee: ");
            try {
                opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion){
                    case 1:
                            consulta.busquedaDolarSol();
                           break;
                    case 2:
                            consulta.busquedaSolDolar();
                           break;
                    case 3:
                           consulta.busquedaDolarBrasileño();
                           break;
                    case 4:
                            consulta.busquedaBrasileñoDolar();
                           break;
                    case 5:
                            consulta.busquedaDolarColombiano();
                           break;
                    case 6:
                            consulta.busquedaColombianoDolar();
                           break;
                    case 7:
                            consulta.busquedaSolEuro();
                           break;
                    case 8:
                            consulta.busquedaEuroSol();
                           break;
                    case 9:
                        System.out.println("Cerrando aplicación.......");
                        entrada.close();
                        try(FileWriter archivo = new FileWriter("Registro_Consulta.json")){
                            archivo.write(gson.toJson(consulta.getConsultas()));
                            archivo.close();
                        }catch (IOException e){
                            System.out.println("Error al escribir en el archivo:" + e.getMessage());
                        }

                        return;
                    default:
                        System.out.println("Opción inválida, por favor ingrese otro número.");


                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.Por favor, ingrese un número.");
                entrada.next();
            }
        }
        }
    }

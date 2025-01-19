import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaMoneda {
    private Scanner entrada = new Scanner(System.in);
    private List<String> conversiones = new ArrayList<>();

    Monedas  buscaMonedas(String base_code){
        String direccion = "https://v6.exchangerate-api.com/v6/27855af331a42474489ff4e7/latest/" + base_code;

        //Establece la solicitud
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Monedas.class);
        }catch (Exception e){
            throw new RuntimeException("No se encontro modena");
        }
    }
    public void busquedaDolarSol() {

        try {
            System.out.print("Ingrese el valor a convertir: ");
            double valor = Double.parseDouble(entrada.nextLine());
            Monedas modena1 = buscaMonedas("USD");
            if (modena1 != null) {
                Double tasa = modena1.conversion_rates.get("PEN");
                if (tasa != null) {
                    double resultado = valor * tasa;
                    LocalTime HoraHoy = LocalTime.now();
                    System.out.println("El valor del dólares en soles es " + resultado );
                    conversiones.add("dolar a sol: " + resultado + ", HoraConsultada: " + HoraHoy);
                } else {
                    System.out.println("Código de moneda no válido.");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }
    }

    public void busquedaSolDolar(){
        try {
            System.out.print("Ingrese el valor a convertir: ");
            double valor = Double.parseDouble(entrada.nextLine());
            Monedas modena1 = buscaMonedas("PEN");
            Double tasa = modena1.conversion_rates.get("USD");
            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del soles en dolares es " + resultado);
                LocalTime HoraHoy = LocalTime.now();
                conversiones.add("sol a dolar:" +resultado + ", HoraConsultada: " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }


    public void busquedaDolarBrasileño(){

        try {
            System.out.print("Ingrese el valor a convertir: ");
            double valor = Double.parseDouble(entrada.nextLine());
            Monedas modena1 = buscaMonedas("USD");
            Double tasa = modena1.conversion_rates.get("BRL");

            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del Dolar en Real Brasileño es " + resultado);
                LocalTime HoraHoy = LocalTime.now();
                conversiones.add("dolar a real brasileño:" + resultado + ", HoraConsultada: " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }


    public void busquedaBrasileñoDolar(){

        try  {
            System.out.print("Ingrese el valor a convertir: ");
            double valor = Double.parseDouble(entrada.nextLine());
            Monedas modena1 = buscaMonedas("BRL");
            Double tasa = modena1.conversion_rates.get("USD");
            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del Real Brasileño en dolares es " + resultado);
                LocalTime HoraHoy = LocalTime.now();
                conversiones.add("real brasileño a dolar:" +resultado + ", HoraConsultada: " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }


    public void busquedaDolarColombiano(){

        try {
            System.out.print("Ingrese el valor a convertir: ");
            double valor = Double.parseDouble(entrada.nextLine());
            Monedas modena1 = buscaMonedas("USD");
            Double tasa = modena1.conversion_rates.get("COP");
            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del DOlares en Peso Colombinas es " + resultado);
                LocalTime HoraHoy = LocalTime.now();
                conversiones.add("dolar a peso colombiano:" +resultado + ", HoraConsultad: " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }



    public void busquedaColombianoDolar(){

        try {
            System.out.print("Ingrese el valor a convertir: ");
            double valor = Double.parseDouble(entrada.nextLine());
            Monedas modena1 = buscaMonedas("COP");
            Double tasa = modena1.conversion_rates.get("USD");
            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del Peso Colombinas en Dolares es " + resultado);
                LocalTime HoraHoy = LocalTime.now();
                conversiones.add("peso colombinao  a dolar:" +resultado + ", HoraConsultada: " + HoraHoy);

            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }

    public void busquedaSolEuro(){

        try {
            System.out.print("Ingrese el valor a convertir: ");
            double valor = Double.parseDouble(entrada.nextLine());
            Monedas modena1 = buscaMonedas("PEN");
            Double tasa = modena1.conversion_rates.get("EUR");
            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del sol peruano en euros es " + resultado);
                LocalTime HoraHoy = LocalTime.now();
                conversiones.add("sol peruano  a euro:" +resultado + ", HoraConsultada: " + HoraHoy);

            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }

    public void busquedaEuroSol(){

        try {
            System.out.print("Ingrese el valor a convertir: ");
            double valor = Double.parseDouble(entrada.nextLine());
            Monedas modena1 = buscaMonedas("EUR");
            Double tasa = modena1.conversion_rates.get("PEN");
            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del sol peruano en euros es " + resultado);
                LocalTime HoraHoy = LocalTime.now();
                conversiones.add("Euro  a Sol peruano:" +resultado);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }

    public List<String> getConsultas(){
        List<String> consultas =  new ArrayList<>();
        consultas.addAll(conversiones);
        return consultas;
    }

}

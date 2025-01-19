import java.util.Map;

public class Monedas {
    String base_code;
    Map<String,Double> conversion_rates;

    public Monedas(String base_code, Map<String,Double> conversion_rates){
            this.base_code = base_code;
            this.conversion_rates = conversion_rates;
    }
}

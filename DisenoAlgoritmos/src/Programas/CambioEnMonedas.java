package Programas;
import java.util.EnumMap;
import java.util.Map;

// Programa que resuelve el problema del cambio en monedas
public class CambioEnMonedas {
    
    // Definimos los tipos de moneda y sus valores en centavos
    enum Moneda {
        M$1(100), M50¢(50), M25¢(25), M10¢(10), M5¢(5), M1¢(1);

        private final int valor;

        Moneda(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }

    public static Map<Moneda, Integer> cambia(double importeDolares) {
        // Convertimos el importe a centavos para trabajar con enteros
        int importe = (int) Math.round(importeDolares * 100);
        
        // Mapa para almacenar el cambio
        Map<Moneda, Integer> cambio = new EnumMap<>(Moneda.class);

        // Inicializamos cada moneda con 0
        for (Moneda mon : Moneda.values()) {
            cambio.put(mon, 0);
        }

        // Proceso para calcular el cambio
        for (Moneda mon : Moneda.values()) {
            while (mon.getValor() <= importe) {
                cambio.put(mon, cambio.get(mon) + 1);
                importe -= mon.getValor();
            }
        }
        
        return cambio;
    }

    public static void main(String[] args) {
        double importeEnDolares = 40.23; // Ejemplo de importe en dólares
        Map<Moneda, Integer> resultado = cambia(importeEnDolares);

        System.out.println("\n == PROBLEMA DEL CAMBIO EN MONEDAS == \n");
        System.out.println("Cambio en monedas para $" + importeEnDolares + ":\n");
        for (Map.Entry<Moneda, Integer> entry : resultado.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\n ");
    }   
}
public class Banco {
    public Banco() {
    }

    private double derivarMontoCreditos(int monto, int cuotas) {
        if (monto > 1000000) {
            return this.calcularInteresAlto(cuotas);
        } else {
            return this.calcularInteresBajo(cuotas);
        }
    }

    private double calcularInteresBajo(int cuotas) {
        double interes;
        if (cuotas >= 1 && cuotas <= 12) {
            interes = 1.25;
        } else if (cuotas >= 13 && cuotas <= 23) {
            interes = 1.3;
        } else {
            interes = 1.35;
        }
        return interes;
    }
    private double calcularInteresAlto(int cuotas) {
        double interes;
        if (cuotas >= 1 && cuotas <= 12) {
            interes = 1.15;
        } else if (cuotas >= 13 && cuotas <= 23) {
            interes = 1.2;
        } else {
            interes = 1.25;
        }
        return interes;
    }
    // suponiendo que el credito en la posicion 1 es el monto, y en la posicion 2 es el numero de cuotas
    private int calcularMontoTotal(int[] creditos){
        double interes= this.derivarMontoCreditos(creditos[0],creditos[1]);
        int montoTotal= (int)(interes*creditos[0]);
        int aproximarNumero= (int)Math.ceil(interes); //aproxima el numero al entero siguiente
        int redondearNumero= (int)Math.floor(interes); //mantiene el numero en el entero actual
        return montoTotal;
    }
    private int calcularMontoMensual(int[] creditos){
        int montoTotal= this.calcularMontoTotal(creditos);
        int montoMensual= (int)montoTotal/creditos[1]; // segunda posicion de credito es el numero de cuotas
        return montoMensual;

    }
    private String obtenerMontoTotal(int[] creditos){
        String montoTotal="El monto total a pagar del crédito es de "+this.calcularMontoTotal(creditos);
        return montoTotal;
    }
    private String obtenerMontoMensual(int[] creditos){
        String montoMensual="El monto mensual a pagar del crédito es de "+this.calcularMontoMensual(creditos);
        return montoMensual;
    }
    private String[] obtenerInformacionCredito(int[] creditos){
        String[] informacionCredito= new String[2];
        informacionCredito[0]=this.obtenerMontoTotal(creditos);
        informacionCredito[1]=this.obtenerMontoMensual(creditos);
        return informacionCredito;
    }
    public void mostrarInformacionCredito(int[] creditos){
        String[] informacionCredito= this.obtenerInformacionCredito(creditos);
        for(int i=0; i<informacionCredito.length; i++){
            System.out.println(informacionCredito[i]);
        }

    }
}

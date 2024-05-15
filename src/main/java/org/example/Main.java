import java.util.ArrayList;

class Empleado {
    String nombre;
    String apellido;
    String documento;
    int diasTrabajados;
    double subsidioTransporte;

    public Empleado(String nombre, String apellido, String documento, int diasTrabajados, double subsidioTransporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.diasTrabajados = diasTrabajados;
        this.subsidioTransporte = subsidioTransporte;
    }

    public double calcularSalarioBruto(double salarioMinimo) {
        double salarioDiario = salarioMinimo / 30; // Se asume un mes de 30 días 
        return salarioDiario * diasTrabajados;
    }

    public double[] calcularDescuentos(double salarioBruto) {
        double descuentoSalud = salarioBruto * 0.04; // Porcentaje de descuento por salud 
        double descuentoPension = salarioBruto * 0.04; // Porcentaje de descuento por pensión 
        return new double[]{descuentoSalud, descuentoPension};
    }

    public double calcularValorNeto(double salarioBruto, double[] descuentos) {
        double totalDescuentos = descuentos[0] + descuentos[1];
        return salarioBruto + subsidioTransporte - totalDescuentos;
    }

    public void imprimirLiquidacion(double salarioBruto, double[] descuentos, double valorNeto) {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Documento: " + documento);
        System.out.println("Días trabajados: " + diasTrabajados);
        System.out.println("Subsidio de transporte: " + subsidioTransporte);
        System.out.println("Total bruto: " + salarioBruto);
        System.out.println("Descuento por salud: " + descuentos[0]);
        System.out.println("Descuento por pensión: " + descuentos[1]);
        System.out.println("Valor neto a pagar: " + valorNeto);
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {
        double salarioMinimo = 908526;
        double subsidioTransporte = 106454;

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Eric", "Molano", "1013112797", 20, subsidioTransporte));
        empleados.add(new Empleado("Mariana", "Manrique", "102458227", 25, 0)); // Sin subsidio de transporte 

        for (Empleado empleado : empleados) {
            double salarioBruto = empleado.calcularSalarioBruto(salarioMinimo);
            double[] descuentos = empleado.calcularDescuentos(salarioBruto);
            double valorNeto = empleado.calcularValorNeto(salarioBruto, descuentos);
            empleado.imprimirLiquidacion(salarioBruto, descuentos, valorNeto);
        }
    }
} 
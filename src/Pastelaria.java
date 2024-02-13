import java.io.Serializable;

/***
 * Classe filha "Pastelaria" que contém o nMedioBolosVendidosDia e a faturacaoAnualBoloDia
 * @author Cláudia Torres e Tiago Dias
 * @version 8
 */
public class Pastelaria extends Restauracao implements Serializable {
    //Variables
    private int nMedioBolosVendidosDia;
    private double faturacaoAnualBoloDia;

    //Constructor
    /**
     * Construtor principal de "Pastelaria"
     * @param nome nome da empresa (String)
     * @param categoria categoria da empresa (String)
     * @param distrito distrito da empresa (String)
     * @param localizacao localização da empresa (GPS)
     * @param nEmpregadosMesa numero empregados mesa (int)
     * @param custoEmpregadosMesa custo empregados mesa (double)
     * @param nMedioClientesDiario n medio clientes diario (int)
     * @param salarioMedioAnual salario medio anual (double)
     * @param nMedioBolosVendidosDia n medio bolos vendidos por dia (int)
     * @param faturacaoAnualBoloDia faturacao anual de bolo por dia (double)
     */
    public Pastelaria(String nome, String categoria, String distrito, GPS localizacao, int nEmpregadosMesa, double custoEmpregadosMesa, int nMedioClientesDiario, double salarioMedioAnual, int nMedioBolosVendidosDia, double faturacaoAnualBoloDia) {
        super(nome, categoria, distrito, localizacao, nEmpregadosMesa, custoEmpregadosMesa, nMedioClientesDiario, salarioMedioAnual);
        this.nMedioBolosVendidosDia = nMedioBolosVendidosDia;
        this.faturacaoAnualBoloDia = faturacaoAnualBoloDia;
    }

    //Getters
    /**
     * Getter de "Pastelaria" para a variável nMedioBolosVendidosDia
     * @return nMedioBolosVendidosDia
     */
    public int getnMedioBolosVendidosDia() { return nMedioBolosVendidosDia; }
    /**
     * Getter de "Pastelaria" para a variável faturacaoAnualBoloDia
     * @return faturacaoAnualBoloDia
     */
    public double getFaturacaoAnualBoloDia() { return faturacaoAnualBoloDia; }

    //Setters
    /**
     * Setter de "Pastelaria" para a variável nMedioBolosVendidosDia
     * @param nMedioBolosVendidosDia
     */
    public void setnMedioBolosVendidosDia(int nMedioBolosVendidosDia) { this.nMedioBolosVendidosDia = nMedioBolosVendidosDia; }
    /**
     * Setter de "Pastelaria" para a variável faturacaoAnualBoloDia
     * @param faturacaoAnualBoloDia
     */
    public void setFaturacaoAnualBoloDia(double faturacaoAnualBoloDia) { this.faturacaoAnualBoloDia = faturacaoAnualBoloDia; }

    //Methods
    @Override
    public String toString() {
        return  super.toString()
                + ",|Nº médio de bolos vendidos por dia:" + getnMedioBolosVendidosDia()
                + ",|Valor médio de faturação anual por bolo vendido/dia:" + getFaturacaoAnualBoloDia();
    }

    public String tipo() { return "Pastelaria";}
    public double receitaAnual(){
        return getnMedioBolosVendidosDia()*getFaturacaoAnualBoloDia();
    }

    @Override
    public int maxRA(double[] lista, int indice) {
        if (lista[1] < getRA() || lista[1] == 0.0)
            indice= 1;
        return indice;
    }
    @Override
    public int minDA(double[] lista, int indice) {
        if (lista[1] > getDA() || lista[1] == 0.0)
            indice= 1;
        return indice;
    }
    @Override
    public int maxLucro(double[] lista, int indice) {
        if (lista[1] < getLucro() || lista[1] == 0.0)
            indice= 1;
        return indice;
    }
}
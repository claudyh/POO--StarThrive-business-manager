import java.io.Serializable;

/***
 * Classe filha "Cafe" que contém o nMedioCafesVendidosDia e a faturacaoAnualCafeDia
 * @author Cláudia Torres e Tiago Dias
 * @version 19
 */
public class Cafe extends Restauracao implements Serializable {
    //Variables
    private int nMedioCafesVendidosDia;
    private double faturacaoAnualCafeDia;

    //Constructor
    /**
     * Construtor principal de "Cafe"
     * @param nome nome da empresa (String)
     * @param categoria categoria da empresa (String)
     * @param distrito distrito da empresa (String)
     * @param localizacao localização da empresa (GPS)
     * @param nEmpregadosMesa - numero empregados mesa (int)
     * @param custoEmpregadosMesa custo empregados mesa (double)
     * @param nMedioClientesDiario n medio clientes diario (int)
     * @param salarioMedioAnual - salario medio anual (double)
     * @param nMedioCafesVendidosDia n medio cafes vendidos por dia (int)
     * @param faturacaoAnualCafeDia faturacao anual de cafe por dia (double)
     */
    public Cafe(String nome, String categoria, String distrito, GPS localizacao, int nEmpregadosMesa, double custoEmpregadosMesa, int nMedioClientesDiario, double salarioMedioAnual, int nMedioCafesVendidosDia, double faturacaoAnualCafeDia) {
        super(nome, categoria, distrito, localizacao, nEmpregadosMesa, custoEmpregadosMesa, nMedioClientesDiario, salarioMedioAnual);
        this.nMedioCafesVendidosDia = nMedioCafesVendidosDia;
        this.faturacaoAnualCafeDia = faturacaoAnualCafeDia;
    }

    //Getters
    /**
     * Getter de "Cafe" para a variável nMedioCafesVendidosDia
     * @return nMedioCafesVendidosDia
     */
    public int getnMedioCafesVendidosDia() { return nMedioCafesVendidosDia; }
    /**
     * Getter de "Cafe" para a variável faturacaoAnualCafeDia
     * @return faturacaoAnualCafeDia
     */
    public double getFaturacaoAnualCafeDia() { return faturacaoAnualCafeDia; }

    //Setters
    /**
     * Setter de "Cafe" para a variável nMedioCafesVendidosDia
     * @param nMedioCafesVendidosDia
     */
    public void setnMedioCafesVendidosDia(int nMedioCafesVendidosDia) { this.nMedioCafesVendidosDia = nMedioCafesVendidosDia; }
    /**
     * Setter de "Cafe" para a variável faturacaoAnualCafeDia
     * @param faturacaoAnualCafeDia
     */
    public void setFaturacaoAnualCafeDia(double faturacaoAnualCafeDia) { this.faturacaoAnualCafeDia = faturacaoAnualCafeDia; }

    //Methods
    @Override
    public String toString() {
        return  super.toString()
                + ",|Nº médio de cafés vendidos por dia:" + getnMedioCafesVendidosDia()
                + ",|Valor médio de faturação anual por café vendido/dia:" + getFaturacaoAnualCafeDia();
    }

    public String tipo() { return "Cafe";}
    public double receitaAnual(){ return getnMedioCafesVendidosDia()*getFaturacaoAnualCafeDia(); }

    @Override
    public int maxRA(double[] lista, int indice) {
        if (lista[0] < getRA() || lista[0] == 0.0)
            indice= 0;
        return indice;
    }
    @Override
    public int minDA(double[] lista, int indice) {
        if (lista[0] > getDA() || lista[0] == 0.0)
            indice= 0;
        return indice;
    }
    @Override
    public int maxLucro(double[] lista, int indice) {
        if (lista[0] < getLucro() || lista[0] == 0.0)
            indice= 0;
        return indice;
    }
}
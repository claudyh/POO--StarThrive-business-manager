import java.io.Serializable;

/***
 * Classe filha "Local" que contém o nMesasEsplanada e o custoAnualMesaEsplanada
 * @author Cláudia Torres e Tiago Dias
 * @version 2
 */
public class Local extends Restaurante implements Serializable {
    //Variables
    private int nMesasEsplanada;
    private double custoAnualMesaEsplanada;

    //Constructor
    /**
     * Construtor principal de "Local"
     * @param nome nome da empresa (String)
     * @param categoria categoria da empresa (String)
     * @param distrito distrito da empresa (String)
     * @param localizacao localização da empresa (GPS)
     * @param nEmpregadosMesa numero empregados mesa (int)
     * @param custoEmpregadosMesa custo empregados mesa (double)
     * @param nMedioClientesDiario n medio clientes diario (int)
     * @param salarioMedioAnual salario medio anual (double)
     * @param nDiasFuncionamentoAno n dias de funcionamento por ano (int)
     * @param nMesasInteriores n mesas interiores (int)
     * @param faturacaoMediaMesaDia faturacao de mesa por dia (double)
     * @param nMesasEsplanada n mesas esplanada (int)
     * @param custoAnualMesaEsplanada custo anual mesa esplanada (double)
     */
    public Local(String nome, String categoria, String distrito, GPS localizacao, int nEmpregadosMesa, double custoEmpregadosMesa, int nMedioClientesDiario, double salarioMedioAnual, int nDiasFuncionamentoAno, int nMesasInteriores, double faturacaoMediaMesaDia, int nMesasEsplanada, double custoAnualMesaEsplanada) {
        super(nome, categoria, distrito, localizacao, nEmpregadosMesa, custoEmpregadosMesa, nMedioClientesDiario, salarioMedioAnual, nDiasFuncionamentoAno, nMesasInteriores, faturacaoMediaMesaDia);
        this.nMesasEsplanada = nMesasEsplanada;
        this.custoAnualMesaEsplanada = custoAnualMesaEsplanada;
    }

    //Getters
    /**
     * Getter de "Local" para a variável nMesasEsplanada
     * @return nMesasEsplanada
     */
    public int getnMesasEsplanada() { return nMesasEsplanada; }
    /**
     * Getter de "Local" para a variável custoAnualMesaEsplanada
     * @return custoAnualMesaEsplanada
     */
    public double getCustoAnualMesaEsplanada() { return custoAnualMesaEsplanada; }

    //Setters
    /**
     * Setter de "Local" para a variável nMesasEsplanada
     * @param nMesasEsplanada
     */
    public void setnMesasEsplanada(int nMesasEsplanada) { this.nMesasEsplanada = nMesasEsplanada; }
    /**
     * Setter de "Local" para a variável custoAnualMesaEsplanada
     * @param custoAnualMesaEsplanada
     */
    public void setCustoAnualMesaEsplanada(double custoAnualMesaEsplanada) { this.custoAnualMesaEsplanada = custoAnualMesaEsplanada; }

    //Methods
    @Override
    public String toString() {
        return  super.toString()
                + ",|Nº mesas de esplanada:" + getnMesasEsplanada()
                + ",|Custo de licença anual por mesa de esplanada:" + getCustoAnualMesaEsplanada();
    }

    public String tipo() { return "Restaurante Local";}

    @Override
    public double despesaAnual() {
        return (getnEmpregadosMesa()*getSalarioMedioAnual())+(getnMesasEsplanada()*getCustoAnualMesaEsplanada());
    }
    public double receitaAnual(){
        return (getnMesasInteriores()+getnMesasEsplanada())*getFaturacaoMediaMesaDia()*getnDiasFuncionamentoAno();
    }
    @Override
    public int maxRA(double[] lista, int indice) {
        if (lista[2] < getRA() || lista[2] == 0.0)
            indice= 2;
        return indice;
    }
    @Override
    public int minDA(double[] lista, int indice) {
        if (lista[2] > getDA() || lista[2] == 0.0)
            indice= 2;
        return indice;
    }
    @Override
    public int maxLucro(double[] lista, int indice) {
        if (lista[2] < getLucro() || lista[2] == 0.0)
            indice= 2;
        return indice;
    }
}
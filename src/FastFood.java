import java.io.Serializable;

/***
 * Classe filha "FastFood" que contém o nMedioClientesDriveThru e o valorFaturacaoCliente
 * @author Cláudia Torres e Tiago Dias
 * @version 5
 */
public class FastFood extends Restaurante implements Serializable {
    //Variables
    private int nMedioClientesDriveThru;
    private double valorFaturacaoCliente;

    //Constructor
    /**
     * Construtor principal de "FastFood"
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
     * @param nMedioClientesDriveThru n medio clientes drive thru (int)
     * @param valorFaturacaoCliente valor faturacao por cliente (double)
     */
    public FastFood(String nome, String categoria, String distrito, GPS localizacao, int nEmpregadosMesa, double custoEmpregadosMesa, int nMedioClientesDiario, double salarioMedioAnual, int nDiasFuncionamentoAno, int nMesasInteriores, double faturacaoMediaMesaDia, int nMedioClientesDriveThru, double valorFaturacaoCliente) {
        super(nome, categoria, distrito, localizacao, nEmpregadosMesa, custoEmpregadosMesa, nMedioClientesDiario, salarioMedioAnual, nDiasFuncionamentoAno, nMesasInteriores, faturacaoMediaMesaDia);
        this.nMedioClientesDriveThru = nMedioClientesDriveThru;
        this.valorFaturacaoCliente = valorFaturacaoCliente;
    }

    //Getters
    /**
     * Getter de "FastFood" para a variável nMedioClientesDriveThru
     * @return nMedioClientesDriveThru
     */
    public int getnMedioClientesDriveThru() { return nMedioClientesDriveThru; }
    /**
     * Getter de "FastFood" para a variável valorFaturacaoCliente
     * @return valorFaturacaoCliente
     */
    public double getValorFaturacaoCliente() { return valorFaturacaoCliente; }

    //Setters
    /**
     * Setter de "FastFood" para a variável nMedioClientesDriveThru
     * @param nMedioClientesDriveThru obtem nº medio clientes drive thru
     */
    public void setnMedioClientesDriveThru(int nMedioClientesDriveThru) { this.nMedioClientesDriveThru = nMedioClientesDriveThru; }
    /**
     * Setter de "FastFood" para a variável valorFaturacaoCliente
     * @param valorFaturacaoCliente valor faturacao cliente
     */
    public void setValorFaturacaoCliente(double valorFaturacaoCliente) { this.valorFaturacaoCliente = valorFaturacaoCliente; }

    //Methods
    @Override
    public String toString() {
        return  super.toString()
                + ",|Nº médio diário  de clientes drive-thru:" + getnMedioClientesDriveThru()
                + ",|Valor médio diário de faturação por cliente drive-thru:" + getValorFaturacaoCliente();
    }

    public String tipo() { return "Restaurante FastFood";}

    public double receitaAnual(){
        return ((getnMesasInteriores()*getFaturacaoMediaMesaDia())+(getnMedioClientesDriveThru()*getValorFaturacaoCliente()))*getnDiasFuncionamentoAno();
    }
    @Override
    public int maxRA(double[] lista, int indice) {
        if (lista[3] < getRA() || lista[3] == 0.0)
            indice= 3;
        return indice;
    }
    @Override
    public int minDA(double[] lista, int indice) {
        if (lista[3] > getDA() || lista[3] == 0.0)
            indice= 3;
        return indice;
    }
    @Override
    public int maxLucro(double[] lista, int indice) {
        if (lista[3] < getLucro() || lista[3] == 0.0)
            indice= 3;
        return indice;
    }
}
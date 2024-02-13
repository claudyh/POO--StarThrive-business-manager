import java.io.Serializable;

/***
 * Classe filha "Restaurante" que contém o nDiasFuncionamentoAno, o nMesasInteriores e a faturacaoMediaMesaDia
 * @author Cláudia Torres e Tiago Dias
 * @version 3
 */
public abstract class Restaurante extends Restauracao implements Serializable {
    //Variables
    protected int nDiasFuncionamentoAno;
    protected int nMesasInteriores;
    protected double faturacaoMediaMesaDia;

    //Constructor
    /**
     * Construtor principal de "Restaurante"
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
     */
    public Restaurante(String nome, String categoria, String distrito, GPS localizacao, int nEmpregadosMesa, double custoEmpregadosMesa, int nMedioClientesDiario, double salarioMedioAnual, int nDiasFuncionamentoAno, int nMesasInteriores, double faturacaoMediaMesaDia) {
        super(nome, categoria, distrito, localizacao, nEmpregadosMesa, custoEmpregadosMesa, nMedioClientesDiario, salarioMedioAnual);
        this.nDiasFuncionamentoAno = nDiasFuncionamentoAno;
        this.nMesasInteriores = nMesasInteriores;
        this.faturacaoMediaMesaDia = faturacaoMediaMesaDia;
    }

    //Getters
    /**
     * Getter de "Restaurante" para a variável nDiasFuncionamentoAno
     * @return nDiasFuncionamentoAno
     */
    public int getnDiasFuncionamentoAno() { return nDiasFuncionamentoAno; }
    /**
     * Getter de "Restaurante" para a variável nMesasInteriores
     * @return nMesasInteriores
     */
    public int getnMesasInteriores() { return nMesasInteriores; }
    /**
     * Getter de "Restaurante" para a variável faturacaoMediaMesaDia
     * @return faturacaoMediaMesaDia
     */
    public double getFaturacaoMediaMesaDia() { return faturacaoMediaMesaDia; }

    //Setters

    /**
     * Setter de "Restaurante" para a variável nDiasFuncionamentoAno
     * @param nDiasFuncionamentoAno
     */
    public void setnDiasFuncionamentoAno(int nDiasFuncionamentoAno) { this.nDiasFuncionamentoAno = nDiasFuncionamentoAno; }
    /**
     * Setter de "Restaurante" para a variável nMesasInteriores
     * @param nMesasInteriores
     */
    public void setnMesasInteriores(int nMesasInteriores) { this.nMesasInteriores = nMesasInteriores; }
    /**
     * Setter de "Restaurante" para a variável faturacaoMediaMesaDia
     * @param faturacaoMediaMesaDia
     */
    public void setFaturacaoMediaMesaDia(double faturacaoMediaMesaDia) { this.faturacaoMediaMesaDia = faturacaoMediaMesaDia; }

    //Methods
    @Override
    public String toString() {
        return  super.toString()
                + ",|Nº dias de funcionamento por ano:" + getnDiasFuncionamentoAno()
                + ",|Nº de mesas interiores:" + getnMesasInteriores()
                + ",|Valor médio de faturação de cada mesa por dia:" + getFaturacaoMediaMesaDia();
    }
}
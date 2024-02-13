import java.io.Serializable;

/***
 * Classe filha "Frutaria" que contém o nProdutos e o valorFaturacaoProduto
 * @author Cláudia Torres e Tiago Dias
 * @version 6
 */
public class Frutaria extends Mercearia implements Serializable {
    //Variables
    private int nProdutos;
    private double valorFaturacaoProduto;

    //Constructor
    /**
     * Construtor principal de "Frutaria"
     * @param nome nome da empresa (String)
     * @param categoria categoria da empresa (String)
     * @param distrito distrito da empresa (String)
     * @param localizacao localização da empresa (GPS)
     * @param custoLimpezaAnual custo de limpeza anual (double)
     * @param nProdutos n produtos (int)
     * @param valorFaturacaoProduto valor faturacao por produto (double)
     */
    public Frutaria(String nome, String categoria, String distrito, GPS localizacao, double custoLimpezaAnual, int nProdutos, double valorFaturacaoProduto) {
        super(nome, categoria, distrito, localizacao, custoLimpezaAnual);
        this.nProdutos = nProdutos;
        this.valorFaturacaoProduto = valorFaturacaoProduto;
    }

    //Getters
    /**
     * Getter de "Frutaria" para a variável nProdutos
     * @return nProdutos
     */
    public int getnProdutos() { return nProdutos; }
    /**
     * Getter de "Frutaria" para a variável valorFaturacaoProduto
     * @return valorFaturacaoProduto
     */
    public double getValorFaturacaoProduto() { return valorFaturacaoProduto; }

    //Setters
    /**
     * Setter de "Frutaria" para a variável nProdutos
     * @param nProdutos
     */
    public void setnProdutos(int nProdutos) { this.nProdutos = nProdutos; }
    /**
     * Setter de "Frutaria" para a variável valorFaturacaoProduto
     * @param valorFaturacaoProduto
     */
    public void setValorFaturacaoProduto(double valorFaturacaoProduto) { this.valorFaturacaoProduto = valorFaturacaoProduto; }

    //Methods
    @Override
    public String toString() {
        return  super.toString()
                + ",|Nº de produtos:" + getnProdutos()
                + ",|Valor médio de faturação anual por produto:" + getValorFaturacaoProduto();
    }

    public String tipo() { return "Frutaria";}
    public double receitaAnual(){
        return getnProdutos()*getValorFaturacaoProduto();
    }

    @Override
    public int maxRA(double[] lista, int indice) {
        if (lista[4] < getRA() || lista[4] == 0.0)
            indice= 4;
        return indice;
    }
    @Override
    public int minDA(double[] lista, int indice) {
        if (lista[4] > getDA() || lista[4] == 0.0)
            indice= 4;
        return indice;
    }
    @Override
    public int maxLucro(double[] lista, int indice) {
        if (lista[4] < getLucro() || lista[4] == 0.0)
            indice= 4;
        return indice;
    }
}
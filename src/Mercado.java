import java.io.Serializable;

/***
 * Classe filha "Mercado" que contém o tipo, a areaCorredores e o valorFaturacaoMetro2
 * @author Cláudia Torres e Tiago Dias
 * @version 5
 */
public class Mercado extends Mercearia implements Serializable {
    //Variables
    private String tipo;
    private double areaCorredores;
    private double valorFaturacaoMetro2;

    //Constructor
    /**
     * Construtor principal de "Mercado"
     * @param nome nome da empresa (String)
     * @param categoria categoria da empresa (String)
     * @param distrito distrito da empresa (String)
     * @param localizacao localização da empresa (GPS)
     * @param custoLimpezaAnual custo de limpeza anual (double)
     * @param tipo tipo (String)
     * @param areaCorredores area dos corredores (double)
     * @param valorFaturacaoMetro2 valor faturacao por metro^2 (double)
     */
    public Mercado(String nome, String categoria, String distrito, GPS localizacao, double custoLimpezaAnual, String tipo, double areaCorredores, double valorFaturacaoMetro2) {
        super(nome, categoria, distrito, localizacao, custoLimpezaAnual);
        this.tipo = tipo;
        this.areaCorredores = areaCorredores;
        this.valorFaturacaoMetro2 = valorFaturacaoMetro2;
    }

    //Getters
    /**
     * Getter de "Mercearia" para a variável tipo
     * @return tipo
     */
    public String getTipo() { return tipo; }
    /**
     * Getter de "Mercearia" para a variável areaCorredores
     * @return areaCorredores
     */
    public double getAreaCorredores() { return areaCorredores; }
    /**
     * Getter de "Mercearia" para a variável valorFaturacaoMetro2
     * @return valorFaturacaoMetro2
     */
    public double getValorFaturacaoMetro2() { return valorFaturacaoMetro2; }

    //Setters
    /**
     * Setter de "Mercearia" para a variável tipo
     * @param tipo
     */
    public void setTipo(String tipo) { this.tipo = tipo; }
    /**
     * Setter de "Mercearia" para a variável areaCorredores
     * @param areaCorredores
     */
    public void setAreaCorredores(double areaCorredores) { this.areaCorredores = areaCorredores; }
    /**
     * Setter de "Mercearia" para a variável valorFaturacaoMetro2
     * @param valorFaturacaoMetro2
     */
    public void setValorFaturacaoMetro2(double valorFaturacaoMetro2) { this.valorFaturacaoMetro2 = valorFaturacaoMetro2; }

    //Methods
    @Override
    public String toString() {
        return  super.toString()
                + ",|Tipo (Minimercado, Supermercado, Hipermercado):" + getTipo()
                + ",|Área dos corredores (m^2):" + getAreaCorredores()
                + ",|Valor médio de faturação anual por m^2 :" + getValorFaturacaoMetro2();
    }

    public String tipo() { return "Mercado";}
    public double receitaAnual(){
        return getAreaCorredores()*getValorFaturacaoMetro2();
    }

    @Override
    public int maxRA(double[] lista, int indice) {
        if (lista[5] < getRA() || lista[5] == 0.0)
            indice= 5;
        return indice;
    }
    @Override
    public int minDA(double[] lista, int indice) {
        if (lista[5] > getDA() || lista[5] == 0.0)
            indice= 5;
        return indice;
    }
    @Override
    public int maxLucro(double[] lista, int indice) {
        if (lista[5] < getLucro() || lista[5] == 0.0)
            indice= 5;
        return indice;
    }
}
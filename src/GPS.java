import java.io.Serializable;

/***
 * Classe "GPS" que contém a latitude e a longitude
 * @author Cláudia Torres e Tiago Dias
 * @version 1
 */
public class GPS implements Serializable {
    //Variables
    private double latitude;
    private double longitude;

    //Constructor
    /**
     * Construtor principal de "GPS"
     * @param latitude latitude (double)
     * @param longitude longitude (double)
     */
    public GPS(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Getters
    /**
     * Getter de "GPS" para a variável latitude
     * @return latitude
     */
    public double getLatitude() { return latitude; }
    /**
     * Getter de "GPS" para a variável longitude
     * @return longitude
     */
    public double getLongitude() { return longitude; }

    //Setters
    /**
     * Setter de "GPS" para a variável latitude
     * @param latitude
     */
    public void setLatitude(double latitude) { this.latitude = latitude; }
    /**
     * Getter de "GPS" para a variável longitude
     * @param longitude
     */
    public void setLongitude(double longitude) { this.longitude = longitude; }

    //Methods
    /**
     * Método que escreve todas as informações desta classe
     * @return string que contém variáveis
     */
    @Override
    public String toString() { return getLatitude() + "," + getLongitude(); }
}
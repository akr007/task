package teszt.data;

/**
 * User osztály, amely tartalmazza a user adatbázistábla attribútumait.
 * Getterek és setterek szerepelnek az osztályban.
 * @author Antal Krisztián
 *
 */
public class User {
	private String email;
    private String password;

    /**
     * Az email attribútum kiválasztása
     * @return email
     */
    public String getEmail() {
       return email;
    }
    
    /**
     * Az email attribútum tárolása
     * @param email Az adatbázis tábla beli email
     */
    public void setEmail(String email) {
       this.email = email;
    }
    
    /**
     * A password attribútum kiválasztása
     * @return password
     */
    public String getPassword() {
       return password;
    }
    
    /**
     * A password attribútum tárolása
     * @param password Az adatbázis tábla beli password
     */
    public void setPassword(String password) {
       this.password = password;
    }
}

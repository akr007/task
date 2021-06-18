package teszt.data;

/**
 * User oszt�ly, amely tartalmazza a user adatb�zist�bla attrib�tumait.
 * Getterek �s setterek szerepelnek az oszt�lyban.
 * @author Antal Kriszti�n
 *
 */
public class User {
	private String email;
    private String password;

    /**
     * Az email attrib�tum kiv�laszt�sa
     * @return email
     */
    public String getEmail() {
       return email;
    }
    
    /**
     * Az email attrib�tum t�rol�sa
     * @param email Az adatb�zis t�bla beli email
     */
    public void setEmail(String email) {
       this.email = email;
    }
    
    /**
     * A password attrib�tum kiv�laszt�sa
     * @return password
     */
    public String getPassword() {
       return password;
    }
    
    /**
     * A password attrib�tum t�rol�sa
     * @param password Az adatb�zis t�bla beli password
     */
    public void setPassword(String password) {
       this.password = password;
    }
}

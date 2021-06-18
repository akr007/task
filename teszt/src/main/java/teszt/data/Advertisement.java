package teszt.data;

/**
 * Advertisement osztály, amely tartalmazza az advertisement adatbázistábla attribútumait.
 * Getterek és setterek szerepelnek az osztályban.
 * @author Antal Krisztián
 *
 */
public class Advertisement {
	private int id;
	private String title;
    private String description;
    
    /**
     * Az id attribútum kiválasztása
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * Az id attribútum tárolása
     * @param id Az adatbázis tábla beli id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * A title attribútum kiválasztása
     * @return title
     */
    public String getTitle() {
       return title;
    }
    
    /**
     * A title attribútum tárolása
     * @param title Az adatbázis tábla beli title
     */
    public void setTitle(String title) {
       this.title = title;
    }
    
    /**
     * A description attribútum kiválasztása
     * @return description
     */
    public String getDesc() {
       return description;
    }
    
    /**
     * A description attribútum tárolása
     * @param description Az adatbázis tábla beli description
     */
    public void setDesc(String description) {
       this.description = description;
    }
	
}

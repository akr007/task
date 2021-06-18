package teszt.data;

/**
 * Advertisement oszt�ly, amely tartalmazza az advertisement adatb�zist�bla attrib�tumait.
 * Getterek �s setterek szerepelnek az oszt�lyban.
 * @author Antal Kriszti�n
 *
 */
public class Advertisement {
	private int id;
	private String title;
    private String description;
    
    /**
     * Az id attrib�tum kiv�laszt�sa
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * Az id attrib�tum t�rol�sa
     * @param id Az adatb�zis t�bla beli id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * A title attrib�tum kiv�laszt�sa
     * @return title
     */
    public String getTitle() {
       return title;
    }
    
    /**
     * A title attrib�tum t�rol�sa
     * @param title Az adatb�zis t�bla beli title
     */
    public void setTitle(String title) {
       this.title = title;
    }
    
    /**
     * A description attrib�tum kiv�laszt�sa
     * @return description
     */
    public String getDesc() {
       return description;
    }
    
    /**
     * A description attrib�tum t�rol�sa
     * @param description Az adatb�zis t�bla beli description
     */
    public void setDesc(String description) {
       this.description = description;
    }
	
}

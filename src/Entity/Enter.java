package Entity;

public class Enter {
    private int id;
    private int personId;
    private String enterDate;
    
     public Enter() {      
    }

    public Enter(int id, int personId, String enterDate) {
        this.id = id;
        this.personId = personId;
        this.enterDate = enterDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

}


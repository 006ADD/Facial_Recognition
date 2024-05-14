package Entity;

public class Exit{
    private int id;
    private int personId;
    private String exitDate;

    public Exit() {
    }

    public Exit(int id, int personId, String exitDate) {
        this.id = id;
        this.personId = personId;
        this.exitDate = exitDate;
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

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }   
}
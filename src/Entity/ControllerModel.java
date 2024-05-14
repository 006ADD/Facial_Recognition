/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author User
 */
public class ControllerModel {
    private int id;
    private int personId;
    private String enterDate;
    private String exitDate;

    public ControllerModel() {}

    public ControllerModel(int id, int personId, String enterDate, String exitDate) {
        this.id = id;
        this.personId = personId;
        this.enterDate = enterDate;
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

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }
    
    
    
    
}

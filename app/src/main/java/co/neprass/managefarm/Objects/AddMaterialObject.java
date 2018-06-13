package co.neprass.managefarm.Objects;

/**
 * Created by AL-Qema on 04/06/18.
 */

public class AddMaterialObject {
    String name ;
    String type ;
    String number ;
    String note ;

    public AddMaterialObject(String name, String type, String number, String note) {
        this.name = name;
        this.type = type;
        this.number = number;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

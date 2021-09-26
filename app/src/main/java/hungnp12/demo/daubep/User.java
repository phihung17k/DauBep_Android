package hungnp12.demo.daubep;

import java.io.Serializable;

public class User implements Serializable {
    private int image;
    private String name, note, status;

    public User(int image, String name, String note, String status){
        this.image = image;
        this.name = name;
        this.note = note;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

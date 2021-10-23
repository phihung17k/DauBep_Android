package hungnp12.demo.daubep;

import java.io.Serializable;

public class UserContact implements Serializable {
    private String name, location;
    private int avatar, messIcon;

    public UserContact(String name, String location, int avatar, int messIcon){
        this.name = name;
        this.avatar = avatar;
        this.location = location;
        this.messIcon = messIcon;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMessIcon() {
        return messIcon;
    }

    public void setMessIcon(int messIcon) {
        this.messIcon = messIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

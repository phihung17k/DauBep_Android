package hungnp12.demo.daubep;

import java.io.Serializable;

public class UserContact implements Serializable {
    private String name;
    private int avatar, callIcon, messIcon;

    public UserContact(String name, int avatar, int callIcon, int messIcon){
        this.name = name;
        this.avatar = avatar;
        this.callIcon = callIcon;
        this.messIcon = messIcon;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getCallIcon() {
        return callIcon;
    }

    public void setCallIcon(int callIcon) {
        this.callIcon = callIcon;
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

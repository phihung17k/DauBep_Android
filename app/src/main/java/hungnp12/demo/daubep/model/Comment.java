package hungnp12.demo.daubep.model;

public class Comment {
    private String userName;
    private String time;
    private int image;
    private String cmtContent;

    public Comment(String userName, String time, int image, String cmtContent) {
        this.userName = userName;
        this.time = time;
        this.image = image;
        this.cmtContent = cmtContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }
}

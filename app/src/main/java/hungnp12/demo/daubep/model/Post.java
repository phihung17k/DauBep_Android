package hungnp12.demo.daubep.model;

import java.io.Serializable;

public class Post implements Serializable {
    private int id;
    private int img;
    private String title;
    private String name;
    private String numReply;
    private boolean isLike;

    public Post(int id, int img, String title, String name, String numReply, boolean isLike) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.name = name;
        this.numReply = numReply;
        this.isLike = isLike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumReply() {
        return numReply;
    }

    public void setNumReply(String numReply) {
        this.numReply = numReply;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}

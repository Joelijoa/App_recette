package ma.ismagi.ci2.apptest.models;

public class Category {
    private String name;
    private String img;
    private String desc;

    public Category(String name, String img, String desc) {
        this.name = name;
        this.img = img;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

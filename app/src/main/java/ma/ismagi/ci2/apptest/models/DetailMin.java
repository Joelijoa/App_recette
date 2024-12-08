package ma.ismagi.ci2.apptest.models;

public class DetailMin {
    private String name, description, img_recette, time;
    private boolean favoris;
    private int nb_person;

    public DetailMin(String name, String description, String img_recette, String time, boolean favoris, int nb_person) {
        this.name = name;
        this.description = description;
        this.img_recette = img_recette;
        this.time = time;
        this.favoris = favoris;
        this.nb_person = nb_person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_recette() {
        return img_recette;
    }

    public void setImg_recette(String img_recette) {
        this.img_recette = img_recette;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isFavoris() {
        return favoris;
    }

    public void setFavoris(boolean favoris) {
        this.favoris = favoris;
    }

    public int getNb_person() {
        return nb_person;
    }

    public void setNb_person(int nb_person) {
        this.nb_person = nb_person;
    }
}

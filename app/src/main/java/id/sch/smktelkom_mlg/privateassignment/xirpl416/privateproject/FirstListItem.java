package id.sch.smktelkom_mlg.privateassignment.xirpl416.privateproject;

/**
 * Created by Lenovo on 12/05/2017.
 */

public class FirstListItem {
    private String imageUrl;
    private String title;
    private String content;

    public FirstListItem(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

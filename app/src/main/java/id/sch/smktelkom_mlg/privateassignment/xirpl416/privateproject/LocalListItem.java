package id.sch.smktelkom_mlg.privateassignment.xirpl416.privateproject;

/**
 * Created by Lenovo on 12/06/2017.
 */

import java.io.Serializable;

public class LocalListItem implements Serializable {

    public String imageUrl;
    public String head;

    public LocalListItem(String imageUrl, String head) {
        this.imageUrl = imageUrl;
        this.head = head;
    }
}

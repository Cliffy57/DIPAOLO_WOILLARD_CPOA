package javafx;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.util.HashMap;

public class ImageController {

    private final HashMap<String, Image> imageMap = new HashMap<String, Image>();

    protected void addImage(String name, String URL) {

        File file = new File(URL);
        String localUrl = file.toURI().toString();
        Image image = new Image(localUrl);

        imageMap.put(name, image);
    }

    protected void removeImage(String name) {
        imageMap.remove(name);
    }

    protected ObservableList createObservableList(ObservableList<String> list) {
        imageMap.forEach((key, value) -> list.add(key));
        return list;
    }

    protected Image findUrl(String key) {
        return imageMap.get(key);
    }

}

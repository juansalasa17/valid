package entities;

import java.io.Serializable;

public class ListArtist implements Serializable {
    private final String name;
    private final String url;
    private final String imagen;

    public ListArtist(String name, String url, String imagen) {
        this.name = name;
        this.url = url;
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getImagen() {
        return imagen;
    }
}
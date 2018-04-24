package AutoChat.pojo;

public class ImageState {
    private Integer id;

    private Integer state;

    private String image;

    public ImageState(Integer id, Integer state, String image) {
        this.id = id;
        this.state = state;
        this.image = image;
    }

    public ImageState() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}
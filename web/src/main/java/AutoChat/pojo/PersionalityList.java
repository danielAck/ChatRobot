package AutoChat.pojo;

public class PersionalityList {
    private Integer id;

    private String personalityName;

    private String name;

    public PersionalityList(Integer id, String personalityName, String name) {
        this.id = id;
        this.personalityName = personalityName;
        this.name = name;
    }

    public PersionalityList() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonalityName() {
        return personalityName;
    }

    public void setPersonalityName(String personalityName) {
        this.personalityName = personalityName == null ? null : personalityName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
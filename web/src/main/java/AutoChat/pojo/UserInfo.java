package AutoChat.pojo;

public class UserInfo {
    private Integer id;

    private String userid;

    private String firstPriority;

    private String secondPriority;

    private String thirdPriority;

    private Integer personalityId;

    private Integer personalityState;

    private Integer state;

    public UserInfo(Integer id, String userid, String firstPriority, String secondPriority, String thirdPriority, Integer personalityId, Integer personalityState, Integer state) {
        this.id = id;
        this.userid = userid;
        this.firstPriority = firstPriority;
        this.secondPriority = secondPriority;
        this.thirdPriority = thirdPriority;
        this.personalityId = personalityId;
        this.personalityState = personalityState;
        this.state = state;
    }

    public UserInfo() {
        super();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getFirstPriority() {
        return firstPriority;
    }

    public void setFirstPriority(String firstPriority) {
        this.firstPriority = firstPriority == null ? null : firstPriority.trim();
    }

    public String getSecondPriority() {
        return secondPriority;
    }

    public void setSecondPriority(String secondPriority) {
        this.secondPriority = secondPriority == null ? null : secondPriority.trim();
    }

    public String getThirdPriority() {
        return thirdPriority;
    }

    public void setThirdPriority(String thirdPriority) {
        this.thirdPriority = thirdPriority == null ? null : thirdPriority.trim();
    }

    public Integer getPersonalityId() {
        return personalityId;
    }

    public void setPersonalityId(Integer personalityId) {
        this.personalityId = personalityId;
    }

    public Integer getPersonalityState() {
        return personalityState;
    }

    public void setPersonalityState(Integer personalityState) {
        this.personalityState = personalityState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
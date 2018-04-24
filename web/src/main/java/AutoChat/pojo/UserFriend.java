package AutoChat.pojo;

public class UserFriend {

    private Integer id;

    private Integer userid;

    private String userFriendid;

    private String friendName;

    private String friendNote;

    private String sex;

    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }



    public UserFriend(Integer id, Integer userid, String userFriendid, String friendName, String friendNote, String sex,Integer state) {
        this.id = id;
        this.userid = userid;
        this.userFriendid = userFriendid;
        this.friendName = friendName;
        this.friendNote = friendNote;
        this.sex = sex;
        this.state = state;
    }

    public UserFriend() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserFriendid() {
        return userFriendid;
    }

    public void setUserFriendid(String userFriendid) {
        this.userFriendid = userFriendid == null ? null : userFriendid.trim();
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName == null ? null : friendName.trim();
    }

    public String getFriendNote() {
        return friendNote;
    }

    public void setFriendNote(String friendNote) {
        this.friendNote = friendNote == null ? null : friendNote.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}
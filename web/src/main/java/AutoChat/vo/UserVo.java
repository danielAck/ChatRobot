package AutoChat.vo;

import java.util.List;

/**
 * Created by Machenike on 2018/4/6.
 */
public class UserVo {


    private String userId;

    private List<FriendVo> friends;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<FriendVo> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendVo> friends) {
        this.friends = friends;
    }
}

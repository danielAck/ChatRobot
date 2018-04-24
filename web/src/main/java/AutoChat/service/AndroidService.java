package AutoChat.service;

import AutoChat.common.ServerResponse;
import AutoChat.pojo.UserFriend;
import AutoChat.pojo.UserInfo;

import java.util.List;

/**
 * Created by Machenike on 2018/4/6.
 */
public interface AndroidService {

    ServerResponse<List<UserFriend>> getfriends(String userId);

    ServerResponse changeFriendState(Integer Id,Integer state);

    ServerResponse<UserInfo> getUserInfo(String userId);

    ServerResponse changepriority(UserInfo userInfo);

    ServerResponse<String> getUserId();

    ServerResponse addqa(String question,String answer);
}

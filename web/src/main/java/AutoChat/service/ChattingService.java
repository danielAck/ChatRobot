package AutoChat.service;

import AutoChat.common.ServerResponse;

/**
 * Created by Machenike on 2018/4/6.
 */
public interface ChattingService {

    ServerResponse<String> auto(String userID,String friendId,String question);

    ServerResponse login(String json);
}

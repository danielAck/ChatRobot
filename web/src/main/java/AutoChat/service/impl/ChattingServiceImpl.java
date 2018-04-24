package AutoChat.service.impl;

import AutoChat.common.ServerResponse;
import AutoChat.dao.UserFriendMapper;
import AutoChat.dao.UserInfoMapper;
import AutoChat.pojo.UserFriend;
import AutoChat.pojo.UserInfo;
import AutoChat.service.ChattingService;
import AutoChat.service.CommonService;
import AutoChat.util.JsonToObject;
import AutoChat.vo.FriendVo;
import AutoChat.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Machenike on 2018/4/6.
 */
@Service("ChattingService")
public class ChattingServiceImpl implements ChattingService {

    @Autowired
    private UserFriendMapper userFriendMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CommonService commonService;


//    自动回复
    @Override
    public ServerResponse<String> auto(String userId, String friendId,String question) {


        int friendstate = userFriendMapper.selectState(friendId);
        UserInfo userInfo1 = userInfoMapper.selectByUserId(userId);

        if (friendstate == 0){
            return ServerResponse.createByErrorMessage2("此好友已关闭自动聊天");
        }else {
            if (userInfo1.getState() == 1){
                return ServerResponse.creatByErrorMessage3("已开启自动学习模式");
            }else {
                String answer = null;
                UserInfo userInfo = userInfoMapper.selectByUserId(userId);
                if (userInfo.getPersonalityState() != 0 ){
                    answer = commonService.getPerAnswer(userInfo.getPersonalityId(),question);
                    if (answer == null){
                        answer = commonService.getComAnswer(userId,question);
                        if (answer != null){
                            return ServerResponse.createBySuccess(answer);
                        }else {
                            return ServerResponse.createByErrorMessage("语料库没有该回答");
                        }
                    }else {
                        return ServerResponse.createBySuccess(answer);
                    }
                }else {
                    answer = commonService.getComAnswer(userId,question);
                    if (answer != null){
                        return ServerResponse.createBySuccess(answer);
                    }else {
                        return ServerResponse.createByErrorMessage("语料库没有该回答");
                    }
                }
            }

        }

    }



//    第一次登陆
    public ServerResponse login(String json){
        UserVo userVo = JsonToObject.jsonToObject(json);
        UserInfo flag = userInfoMapper.selectByUserId(userVo.getUserId());
        if (flag == null){
            UserInfo userInfo = new UserInfo();
            userInfo.setUserid(userVo.getUserId());
            userInfo.setFirstPriority("common");
            userInfo.setSecondPriority("customize");
            userInfo.setPersonalityId(0);
            userInfo.setThirdPriority("图灵");
            userInfo.setPersonalityState(0);
            userInfo.setState(0);
            userInfoMapper.insertSelective(userInfo);
            for (FriendVo friendVo : userVo.getFriends()){
                UserFriend userFriend = new UserFriend();
                userFriend.setUserid(userInfo.getId());
                userFriend.setUserFriendid(friendVo.getFriendId());
                userFriend.setFriendName(friendVo.getFriendname());
                userFriend.setFriendNote(friendVo.getFriendnote());
                userFriend.setSex(friendVo.getSex());
                userFriend.setState(0);
                userFriendMapper.insertSelective(userFriend);
            }
        }else {
            for (FriendVo friendVo : userVo.getFriends()) {
                UserFriend flag2 = userFriendMapper.selectByFriendId(friendVo.getFriendId());
                if (flag2 == null){
                    UserFriend userFriend = new UserFriend();
                    userFriend.setUserid(flag.getId());
                    userFriend.setUserFriendid(friendVo.getFriendId());
                    userFriend.setFriendName(friendVo.getFriendname());
                    userFriend.setFriendNote(friendVo.getFriendnote());
                    userFriend.setSex(friendVo.getSex());
                    userFriend.setState(0);
                    userFriendMapper.insertSelective(userFriend);
                }
            }
        }

        return ServerResponse.createBySuccess();
    }






}

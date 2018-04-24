package AutoChat.service.impl;

import AutoChat.common.ServerResponse;
import AutoChat.dao.CustomizeMapper;
import AutoChat.dao.UserFriendMapper;
import AutoChat.dao.UserInfoMapper;
import AutoChat.pojo.Customize;
import AutoChat.pojo.UserFriend;
import AutoChat.pojo.UserInfo;
import AutoChat.service.AndroidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Machenike on 2018/4/6.
 */
@Service("AndroidService")
public class AndroidServiceImpl implements AndroidService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserFriendMapper userFriendMapper;

    @Autowired
    private CustomizeMapper customizeMapper;

    @Override
    public ServerResponse<String> getUserId(){
        String userId = userInfoMapper.selectlastuserId();
        return ServerResponse.createBySuccess(userId);
    }

    @Override
    public ServerResponse<List<UserFriend>> getfriends(String userId){
        UserInfo userInfo = userInfoMapper.selectByUserId(userId);

        List<UserFriend> userFriendList = userFriendMapper.selectFriends(userInfo.getId());

        return ServerResponse.createBySuccess(userFriendList);
    }

    @Override
    public ServerResponse changeFriendState(Integer Id,Integer state){

        if (state == 1){
            state = 0;
        }else {
            state =1;
        }
        userFriendMapper.changeState(Id,state);
        return ServerResponse.createBySuccess("更改成功");
    }

    @Override
    public ServerResponse<UserInfo> getUserInfo(String userId){

        UserInfo userInfo = userInfoMapper.selectByUserId(userId);
        return ServerResponse.createBySuccess(userInfo);
    }

    @Override
    public ServerResponse changepriority(UserInfo userInfo){
        int tag = userInfoMapper.updateByPrimaryKey(userInfo);
        if (tag > 0){
            return ServerResponse.createBySuccess("更改成功");
        }else {
            return ServerResponse.createByErrorMessage("更改失败");
        }
    }

    @Override
    public ServerResponse addqa(String question,String answer){
        Customize customize = new Customize();
        customize.setQuestion(question);
        customize.setAnswer(answer);
        customizeMapper.insertSelective(customize);
        return ServerResponse.createBySuccess("插入成功");
    }

}

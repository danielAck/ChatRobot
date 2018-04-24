package AutoChat.controller;

import AutoChat.common.ServerResponse;
import AutoChat.pojo.UserFriend;
import AutoChat.pojo.UserInfo;
import AutoChat.service.AndroidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Machenike on 2018/4/6.
 */

@Controller
@RequestMapping("/Android/")
public class AndriodController {

    @Autowired
    private AndroidService androidService;



//    获取UserId
    @RequestMapping("getUserId.do")
    @ResponseBody
    public ServerResponse<String> getUserId(){
        return androidService.getUserId();
    }

//    获取好友列表
    @RequestMapping(value = "getfriend.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<UserFriend>> getFriendByUserId(@RequestParam(value = "userId") String userId){
        return androidService.getfriends(userId);
    }

//    更改好友回复状态
    @RequestMapping(value = "changefriendstate.do")
    @ResponseBody
    public ServerResponse changeFriendState(@RequestParam(value = "Id") Integer Id,@RequestParam(value = "state") Integer state){
        return androidService.changeFriendState(Id,state);
    }

//    获取用户信息
    @RequestMapping(value = "getpriority.do")
    @ResponseBody
    public ServerResponse<UserInfo> getpriority(@RequestParam(value = "userId") String userId){
        return androidService.getUserInfo(userId);
    }


//    更改优先级状态
    @RequestMapping(value = "changepriority.do")
    @ResponseBody
    public ServerResponse changepriority(@RequestParam(value = "id") String id,@RequestParam(value = "userId") String userId,@RequestParam(value = "first_priority") String first_priority,@RequestParam(value = "second_priority") String second_priority,@RequestParam(value = "third_priority") String third_priority,@RequestParam("persionality_id") String persionality_id,@RequestParam(value = "persionality_state") String persionality_state,@RequestParam(value = "state") String state){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Integer.valueOf(id));
        userInfo.setUserid(userId);
        userInfo.setFirstPriority(first_priority);
        userInfo.setSecondPriority(second_priority);
        userInfo.setThirdPriority(third_priority);
        userInfo.setPersonalityId(Integer.valueOf(persionality_id));
        userInfo.setPersonalityState(Integer.valueOf(persionality_state));
        userInfo.setState(Integer.valueOf(state));
        return androidService.changepriority(userInfo);
    }

//    添加自定义数据库问答
    @RequestMapping(value = "addqa.do")
    @ResponseBody
    public ServerResponse addQA(@RequestParam(value = "question") String question,@RequestParam(value = "answer") String answer){
        return androidService.addqa(question,answer);
    }
}

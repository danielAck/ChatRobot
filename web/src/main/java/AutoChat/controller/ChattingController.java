package AutoChat.controller;

import AutoChat.common.ServerResponse;
import AutoChat.service.ChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Machenike on 2018/4/6.
 */
@Controller
@RequestMapping("/chatting/")
public class ChattingController {

    @Autowired
    private ChattingService chattingService;


    @RequestMapping(value = "auto.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> autochat(@RequestParam(value = "userId") String userId,@RequestParam(value = "friendId") String friendId,@RequestParam(value = "question") String question){
        return chattingService.auto(userId,friendId,question);
    }

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(@RequestParam(value = "json") String json){
        System.out.println(json);
        return chattingService.login(json);
    }

}




package AutoChat.service.impl;

import AutoChat.dao.*;
import AutoChat.pojo.UserInfo;
import AutoChat.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Machenike on 2018/4/6.
 */
@Service("CommonService")
public class CommonServiceImpl implements CommonService{


    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private CustomizeMapper customizeMapper;

    @Autowired
    private PersionalityChattingMapper persionalityChattingMapper;

    @Autowired
    private PersionalitySCMapper persionalitySCMapper;

    @Autowired
    private PersionalityCSMapper persionalityCSMapper;

    @Autowired
    private PersionalityWHMapper persionalityWHMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;



//    返回自定义语料库内容
    @Override
    public String getPerAnswer(int personalityId,String question) {

        if (personalityId == 1){
            String answer = persionalityChattingMapper.selectAnswerByQuestion(question);
            return answer;
        }else if (personalityId == 2){
            String answer = persionalitySCMapper.selectAnswerByQuestion(question);
            return answer;
        }else if (personalityId == 3){
            String answer = persionalityCSMapper.selectAnswerByQuestion(question);
            return answer;
        }else {
            String answer = persionalityWHMapper.selectAnswerByQuestion(question);
            return answer;
        }
    }

//    按照优先级返回三大基本库内容
    @Override
    public String getComAnswer(String userId,String question){

        UserInfo userInfo = userInfoMapper.selectByUserId(userId);
        String firstPriority = userInfo.getFirstPriority();
        String secondPriority = userInfo.getSecondPriority();
        String answer = null;
        if (getAnswer(firstPriority,question) != null){
            answer = getAnswer(firstPriority,question);
        }else if (getAnswer(secondPriority,question) != null){
            answer = getAnswer(secondPriority,question);
        }
        return answer;
    }

    public String getAnswer(String kname,String question){
        String answer = null;
        if (kname.equals("common")){
            answer = commonMapper.selectAnswer(question);
        }else if (kname.equals("customize")){
            answer = customizeMapper.selectAnswer(question);
        }
        return answer;
    }
}

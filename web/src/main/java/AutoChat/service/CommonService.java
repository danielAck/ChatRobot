package AutoChat.service;

/**
 * Created by Machenike on 2018/4/6.
 */
public interface CommonService {

    String getPerAnswer(int personalityId,String question);

    String getComAnswer(String userId,String question);
}

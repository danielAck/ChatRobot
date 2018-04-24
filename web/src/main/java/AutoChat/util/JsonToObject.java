package AutoChat.util;

import AutoChat.vo.FriendVo;
import AutoChat.vo.UserVo;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Machenike on 2018/4/6.
 */
public class JsonToObject {

    public static UserVo jsonToObject(String json){

        String s2 = UniToUTF.decodeUnicode(json);
//        String s2 = json;
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(s2);
        String userId = jsonObject.get("userId").getAsString();
        UserVo userVo = new UserVo();
        userVo.setUserId(userId);
        List<FriendVo> friendVoList = new ArrayList<>();
        JsonArray friends = jsonObject.getAsJsonArray("friends");
        for (JsonElement jsonElement: friends){
            JsonObject jsonObject1 = jsonElement.getAsJsonObject();
            String friendname = jsonObject1.get("friendname").getAsString();
            String friendnote = jsonObject1.get("friendnote").getAsString();
            String friendId = jsonObject1.get("friendId").getAsString();
            int sex = jsonObject1.get("sex").getAsInt();
            FriendVo friendVo = new FriendVo();
            friendVo.setFriendId(friendId);
            friendVo.setFriendname(friendname);
            friendVo.setFriendnote(friendnote);
            if (sex == 0){
                friendVo.setSex("未知");
            }else if (sex == 1){
                friendVo.setSex("男");
            }else {
                friendVo.setSex("女");
            }
            friendVoList.add(friendVo);
        }
        userVo.setFriends(friendVoList);
        return userVo;
    }

}

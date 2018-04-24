package AutoChat.common;


/**
 * Created by Machenike on 2018/4/6.
 */
public class Test {
    public static void main(String[] args) {


//        String a = "{\"userId\": \"@1966c76ea12e4fb7e16bea754d20570538d37edbd9077119f4bcdbe848f713e2\", \"friends\": [{\"friendname\": \"Snorchid\", \"friendnote\": \"\\u5218\\u9521\\u5170\", \"firendId\": \"@464c403fbd67b903032fd63fee5d219c501158e87c5c362286b162bbbadb0a18\", \"sex\": 2}]}\n";
//        UserVo b = JsonToObject.jsonToObject(a);



//        String s1 = "{\"userId\": \"@1966c76ea12e4fb7e16bea754d20570538d37edbd9077119f4bcdbe848f713e2\", \"friends\": [{\"friendname\": \"Snorchid\", \"friendnote\": \"\\u5218\\u9521\\u5170\", \"friendId\": \"@464c403fbd67b903032fd63fee5d219c501158e87c5c362286b162bbbadb0a18\", \"sex\": 2}]}\n";
////        String s2 = decodeUnicode(s1);
////        System.out.println(s2);
//        String s2 = UniToUTF.decodeUnicode(s1);
//
//        JsonParser jsonParser = new JsonParser();
//        JsonObject jsonObject = (JsonObject) jsonParser.parse(s2);
//        String userId = jsonObject.get("userId").getAsString();
//        System.out.println(userId);
//        JsonArray friends = jsonObject.getAsJsonArray("friends");
//        for (JsonElement jsonElement: friends){
//            JsonObject jsonObject1 = jsonElement.getAsJsonObject();
//            String friendname = jsonObject1.get("friendname").getAsString();
//            String friendnote = jsonObject1.get("friendnote").getAsString();
//            String friendId = jsonObject1.get("friendId").getAsString();
//            int sex = jsonObject1.get("sex").getAsInt();
//            System.out.println(friendname);
//            System.out.println(friendnote);
//            System.out.println(friendId);
//            System.out.println(sex);
//        }
//        System.out.println(s2);
//        JSONObject jsonObject = JSONObject.fromObject(s2);
//        UserVo userVo = (UserVo) JSONObject.toBean(jsonObject,UserVo.class);
//        System.out.println(userVo.getUserId());
//        System.out.println(userVo.getFriends());
    }



//    public static String decodeUnicode(String str) {
//        Charset set = Charset.forName("UTF-16");
//        Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
//        Matcher m = p.matcher( str );
//        int start = 0 ;
//        int start2 = 0 ;
//        StringBuffer sb = new StringBuffer();
//        while( m.find( start ) ) {
//            start2 = m.start() ;
//            if( start2 > start ){
//                String seg = str.substring(start, start2) ;
//                sb.append( seg );
//            }
//            String code = m.group( 1 );
//            int i = Integer.valueOf( code , 16 );
//            byte[] bb = new byte[ 4 ] ;
//            bb[ 0 ] = (byte) ((i >> 8) & 0xFF );
//            bb[ 1 ] = (byte) ( i & 0xFF ) ;
//            ByteBuffer b = ByteBuffer.wrap(bb);
//            sb.append( String.valueOf( set.decode(b) ).trim() );
//            start = m.end() ;
//        }
//        start2 = str.length() ;
//        if( start2 > start ){
//            String seg = str.substring(start, start2) ;
//            sb.append( seg );
//        }
//        return sb.toString() ;
//    }
}

package com.ywqf.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;

public class ExportUtil {
    /**
     *
     *              瀵煎嚭鐢熸垚csv鏂囦欢
     * @author      ccg
     * @param       titles       鏍囬澶�
     * @param       propertys    姣忎竴鍒楁爣棰樺ご瀵瑰簲鏁版嵁闆嗗悎閲屽璞＄殑灞炴�
     * @param       list         鏁版嵁闆嗗悎
     * @param       fileName     鏂囦欢鍚嶇О娉ㄦ剰涓嶈兘鏈夌┖鏍间互鍙婂啋鍙�
     * @param       request
     * @param       response
     * @return
     * @throws      IOException
     * @throws      IllegalArgumentException
     * @throws      IllegalAccessException
     * Created      2017骞�鏈�2鏃�涓嬪崍8:35:57
     */
    public static<T> String exportCsv(String[] titles, String[] propertys, List<T> list, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalArgumentException, IllegalAccessException{
        BufferedWriter bw = null;

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment; filename="+ URLEncoder.encode(fileName,"UTF-8"));
        //鏋勫缓杈撳嚭娴侊紝鍚屾椂鎸囧畾缂栫爜
        bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"gbk"));

        //csv鏂囦欢鏄�鍙峰垎闅旓紝闄ょ涓�釜澶栵紝姣忔鍐欏叆涓�釜鍗曞厓鏍兼暟鎹悗闇�杈撳叆閫楀彿
        for(String title : titles){
            bw.write(title);
            bw.write(",");
        }
        //鍐欏畬鏂囦欢澶村悗鎹㈣
        bw.write("\r\n");
        //鍐欏唴瀹�
        for(Object obj :list){
            //鍒╃敤鍙嶅皠鑾峰彇鎵�湁瀛楁
            Field[] fields = obj.getClass().getDeclaredFields();
            for(String property : propertys){
                for(Field field : fields){
                    //璁剧疆瀛楁鍙鎬�
                    field.setAccessible(true);
                    if(property.equals(field.getName())){
                        bw.write(field.get(obj).toString());
                        //濡傛灉鍖呭惈:璇存槑鏄棩鏈熸渶鍚庡啓涓�釜|鍚﹀垯鏃ユ湡涓嶆樉绀虹
                        if((field.get(obj).toString()).indexOf(":") > -1){
                            bw.write("|");
                        }
                        bw.write(",");
                        continue;
                    }
                }
            }
            //鍐欏畬涓�鎹㈣
            bw.write("\r\n");
        }
        bw.flush();
        bw.close();
        return "0";
    }


}

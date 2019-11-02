package article.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobToString {
	
	public static String ClobToString(Clob clob) throws SQLException, IOException {   
        String reString = "";   
        java.io.Reader is = clob.getCharacterStream();// 得到流   
        BufferedReader br = new BufferedReader(is);   
        String s = br.readLine();   
        StringBuffer sb = new StringBuffer();   
        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING   
            sb.append(s);   
            s = br.readLine();   
        }   
        reString = sb.toString();   
        return reString;   
    }   

}

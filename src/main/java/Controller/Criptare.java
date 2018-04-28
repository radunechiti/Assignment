package Controller;

import java.security.MessageDigest;

public class Criptare {

    public static String securePassword(String password)
    {
        StringBuffer sb =  new StringBuffer();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            for(int i=0; i<hash.length; i++)
            {
                String s = Integer.toHexString(0xff & hash[i]);
                if(s.length()==1)
                    sb.append('0');
                sb.append(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

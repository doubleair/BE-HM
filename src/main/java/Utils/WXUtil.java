package Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.alibaba.fastjson.JSON;

import constants.SystemConstant;
import model.AuthTokenModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ��WXUtil.java��ʵ��������΢�Ź���
 * 
 * @author jizhi.qy 2017��11��8�� ����11:31:44
 */
public class WXUtil {
    private static final Log Log = LogFactory.getLog(WXUtil.class);

    /**
     * ΢�ŵ�¼������code��ȡsession_key�ĵ�ַ
     * 
     * @param code
     * @return
     */
    public static AuthTokenModel getAuthToken(String code) {

        AuthTokenModel vo = null;
        InputStream input = null;
        String uri = "https://api.weixin.qq.com/sns/jscode2session?";
        StringBuffer url = new StringBuffer(uri);
        url.append("appid=").append(SystemConstant.APP_ID);
        url.append("&secret=").append(SystemConstant.APP_SECRET);
        url.append("&js_code=").append(code);
        url.append("&grant_type=").append("authorization_code");

        try {
            HttpURLConnection conn = HttpClientUtil.CreatePostHttpConnection(url.toString());
            if (conn.getResponseCode() == 200) {
                input = conn.getInputStream();
            } else {
                input = conn.getErrorStream();
            }
            String wxStringReturn = new String(HttpClientUtil.readInputStream(input), "utf-8");
            vo = JSON.parseObject(wxStringReturn, AuthTokenModel.class);
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return vo;
    }

    /**
     * ��linux�ײ��ȡ168λ�����
     * 
     * @return
     */
    public static String generateLocalRandom() {
        Process process = null;
        String localRandom = null;
        String[] cmds = {"/bin/sh", "-c", "head -n 80 /dev/urandom | LANG=C tr -dc A-Za-z0-9 | head -c 168"};
        String tempRead = null;
        try {
            process = Runtime.getRuntime().exec(cmds);
            process.waitFor();

            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            StringBuffer sb = new StringBuffer();

            while ((tempRead = bufferReader.readLine()) != null) {
                sb.append(tempRead);
            }

            localRandom = sb.toString();
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        } finally {
            if (process != null && process.isAlive()) {
                process.destroy();
            }
        }
        return localRandom;
    }
}

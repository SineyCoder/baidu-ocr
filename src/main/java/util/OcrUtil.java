package util;

import java.io.File;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class OcrUtil {
	// ����APPID/AK/SK  ��Щֵ�Ӱٶ��ƻ�ȡ ��ѵĿ��Ե���5���/��
	private static final String APP_ID = "";
	private static final String API_KEY = "";
	private static final String SECRET_KEY = "";
	// ��ʼ��һ��AipOcr
	private static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

	public static String parseImg(String path) {
		File file = new File(path);
		if(!file.isFile()) {
			System.out.println("log ::: not a file");
			return null;
		}

		// ��ѡ�������������Ӳ���
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
		// client.setHttpProxy("proxy_host", proxy_port); // ����http����
		// client.setSocketProxy("proxy_host", proxy_port); // ����socket����

		// ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
		// Ҳ����ֱ��ͨ��jvm�����������ô˻�������
		// System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

		// ���ýӿ�

		JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
		return res.toString(2);
	}

}

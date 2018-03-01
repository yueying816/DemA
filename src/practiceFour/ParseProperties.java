package practiceFour;
//����properties�ļ�
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties pro = new Properties();
	String value = null ;
	
	public ParseProperties(String propertiesPath) {
		this.loadProperties(propertiesPath);
	}
	
	private void loadProperties(String propertiesPath) {
		try {
			//��������
			InputStream in = new FileInputStream(propertiesPath) ;
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr) ;
			//���ص�������
			pro.load(br); 
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String keyName) {
		value = pro.getProperty(keyName).trim();
		try {
			//ʹ��UTF-8��ʽ����ֵ
			value = new String(value.getBytes("UTF-8"),"UTF-8");
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	//���Դ���
	public static void main(String[] args) {
		ParseProperties a = new ParseProperties("E:\\workspace\\tool\\test.properties");
		System.out.println(a.getValue("url"));
		System.out.println(a.getValue("merchandise"));
		
	}

}

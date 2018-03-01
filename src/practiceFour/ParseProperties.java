package practiceFour;
//解析properties文件
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
			//读到缓存
			InputStream in = new FileInputStream(propertiesPath) ;
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr) ;
			//加载到对象中
			pro.load(br); 
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String keyName) {
		value = pro.getProperty(keyName).trim();
		try {
			//使用UTF-8格式返回值
			value = new String(value.getBytes("UTF-8"),"UTF-8");
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	//测试代码
	public static void main(String[] args) {
		ParseProperties a = new ParseProperties("E:\\workspace\\tool\\test.properties");
		System.out.println(a.getValue("url"));
		System.out.println(a.getValue("merchandise"));
		
	}

}

package WriteInfo;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;

public class WritePrintXml {

	public static String path ="D://demiss.xml";
	public static String key ="size";
	public static float value =0;
	public static boolean half = false;
	public static void writeout(){
		//1.生成一个根节点
		Element rss = new Element("resources");
		//2.为节点添加属性
		//rss.setAttribute("test","it");
		//3.生成一个document对象
		Document document = new Document(rss);
		//添加元素
		float sum = 0;
		for (int i = 0; i < (half?value*2:value); i++) {
			Element element = new Element("dimen");
			if(null!=key&&!"".equals(key)){
				element.setAttribute("name",key+"dp"+sum);
				element.setText(sum+"dp");
				rss.addContent(element);
			}
			if(half){
				sum = sum+0.5f;
			}else{
				sum ++;
			}

		}
		sum = 0;
		//添加元素
		for (int i = 0; i < (half?value*2:value); i++) {
			Element element = new Element("dimen");
			if(null!=key&&!"".equals(key)){
				element.setAttribute("name",key+"sp"+sum);
				element.setText(sum+"sp");
				rss.addContent(element);
			}
			if(half){
				sum = sum+0.5f;
			}else{
				sum ++;
			}

		}
		//格式   换行、编码
		Format format = Format.getCompactFormat();
		format.setIndent("");  
		format.setEncoding("utf-8");
		
		//4.创建XMLOutputter的对象
		XMLOutputter outputer = new XMLOutputter(format);
		try {
			//5.利用outputer将document对象转换成xml文档
			outputer.output(document, new FileOutputStream(new File(path)));
			System.out.println("文件生成成功");
							
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("文件生成失败,请确保文件信息是否正确输入");
		    }
	}

}

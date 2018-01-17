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
		//1.����һ�����ڵ�
		Element rss = new Element("resources");
		//2.Ϊ�ڵ��������
		//rss.setAttribute("test","it");
		//3.����һ��document����
		Document document = new Document(rss);
		//���Ԫ��
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
		//���Ԫ��
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
		//��ʽ   ���С�����
		Format format = Format.getCompactFormat();
		format.setIndent("");  
		format.setEncoding("utf-8");
		
		//4.����XMLOutputter�Ķ���
		XMLOutputter outputer = new XMLOutputter(format);
		try {
			//5.����outputer��document����ת����xml�ĵ�
			outputer.output(document, new FileOutputStream(new File(path)));
			System.out.println("�ļ����ɳɹ�");
							
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�ļ�����ʧ��,��ȷ���ļ���Ϣ�Ƿ���ȷ����");
		    }
	}

}

package Main;

import WriteInfo.WritePrintXml;


public class MainAcitivity {
    public static void main(String[] args) {

/*        //���Բ���
		args = new String[]{
				"productpath = D:\\dimens.xml",
				"key = size",
				"endvalue = 500",
                "half = true",
		};*/
        if (null != args) {
            for (int i = 0; i < args.length; i++) {
                String info = args[i].trim().toString();
                if (info.startsWith("key =")) {
                    System.out.println("key��" + split(info).trim());
                    WritePrintXml.key = split(info).trim();
                } else if (info.startsWith("endvalue =")) {
                    WritePrintXml.value = Integer.parseInt(split(info).trim());
                    System.out.println("value��" + Integer.parseInt(split(info).trim()));
                } else if (info.startsWith("productpath =")) {
                    //�������ļ���ֵ��
                    WritePrintXml.path = split(info).trim();
                    System.out.println("td_config��" + split(info).trim());
                }
                else if (info.startsWith("half =")) {
                    //�������ļ���ֵ��
                    WritePrintXml.half = Boolean.parseBoolean(split(info).trim());
                    System.out.println("td_config��" + split(info).trim());
                }
            }
        }
        WritePrintXml.writeout();

    }

    //��ȡ������Ϣ
    public static String split(String info) {
        String[] infos = info.split("=");
        if (infos != null && infos.length == 2) {
            return infos[1];
        }
        return null;

    }
}

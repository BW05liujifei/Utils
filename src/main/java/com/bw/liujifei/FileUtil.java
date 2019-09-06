package com.bw.liujifei;

import java.io.File;

import org.apache.log4j.Logger;


/**
 * 
 * @author zhuzg
 *
 */
public class FileUtil {
	
	public static Logger log = Logger.getLogger(FileUtil.class); 
	
	/**
	 * �����Ŀ¼����������ļ���������Ŀ¼�е��ļ���Ҫɾ��
	     ʹ�õݹ顣�漰���ݡ��ж�Ŀ¼�Ĵ����ԣ��ж��Ƿ�ΪĿ¼���ļ���ɾ����

	 * @param fileName
	 */
	public static void delFilePath(String fileName) {
		
		File file = new File(fileName);
		// �ļ�������  ��ֱ�ӷ���
		if(!file.exists()) {
			return;
		}
		
		// ������ļ�  ��ɾ���󷵻�
		if(file.isFile()) {
			log.info(" ɾ���ļ� " + fileName);
			file.delete();
			return;
		}
		
		//�����Ŀ¼
		if(file.isDirectory()) {
			// ���г�Ŀ¼�����е���Ŀ¼���ļ�
			 String[] list = file.list();
			 //���ÿһ��
			 for (String subPath : list) {
				 //����ɾ������
				 delFilePath(fileName + "/" + subPath);
			}
			 log.info(" ------------ ɾ���ļ� �� �� " + fileName); 
			file.delete(); 
		}
		
		
	}
	
	//3.5.2��ȡ�ļ���չ��
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		//û����չ��
		if(dotIndex<0) {
			return "";
		}
		//���һλ�� .
		if(dotIndex>=fileName.length()) {
			return "";
		}
		//
		return fileName.substring(dotIndex+1);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getSystemProp(String key) {
		
		String propValue = System.getProperty(key);
		return propValue;
		
	}
	
	/**
	 * �����ļ���ָ����λ��С��ʾ
	 */
	public long  getSize(String fileName,FileUnit fileUnit) {
		File file = new File(fileName);
		
		
		long  size = file.length();
		switch (fileUnit) {
			case B:
				return size;
			case KB:
				return size/1024;
			case MB:
				return size/1024/1024;
			case GB:
				return size/1024/1024/1024;
			case TB:
				return size/1024/1024/1024/1024;
			case PB:
				return size/1024/1024/1024/1024/1024;
			default:
				return 0;
		}
		
	}
	
	
	
	
}

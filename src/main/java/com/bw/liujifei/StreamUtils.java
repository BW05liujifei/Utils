package com.bw.liujifei;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author zhuzg
 *
 */
public class StreamUtils {
	
	/**
	 * 关闭流
	 * @param closeables
	 * @throws IOException 
	 */
	public static void closeStream(Closeable ...closeables) throws IOException {
		for (Closeable closeable : closeables) {
			closeable.close();
		}
		
	}
	
	/**
	 * 
	 * @param is
	 * @param os
	 * @throws IOException 
	 */
	public static void copyStream(InputStream is,OutputStream os) throws IOException {
		
		byte b[] = new byte[1024];
		while(is.read(b)>0) {
			os.write(b);
		}
		//刷新
		os.flush();
		
	}

}

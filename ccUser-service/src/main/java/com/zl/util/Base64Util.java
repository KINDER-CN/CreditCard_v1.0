package com.zl.util;


/**  
* @Title: Base64Util.java  
* @Package com.zl.util  
* @Description: TODO(用一句话描述该文件做什么)  
* @author 张三  
* @date 2019年8月16日  
* @version V1.0  
*/ 


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 *@author 作者
 *@version 创建时间：2019年8月16日上午9:18:02
 */


/**  
* @ClassName: Base64Util  
* @Description: TODO(Base64字符转回图片)  
* @author 张三  
* @date 2019年8月16日上午9:18:02  
*    
*/
public class Base64Util {


	 /**
     * 将图片文件转换成base64字符串，参数为该图片的路径
     *
     * @param imageFile
     * @return java.lang.String
     */
    public String ImageToBase64(String imageFile) {
        InputStream in = null;
        byte[] data = null;


        // 读取图片字节数组
        try {
            in = new FileInputStream(imageFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        
        if (data != null) {
            return "data:image/jpeg;base64," + encoder.encode(data);// 返回Base64编码过的字节数组字符串
        }
        return null;
    }


    /**
     * 将base64解码成图片并保存在传入的路径下
     * 第一个参数为base64 ，第二个参数为路径
     *
     * @param base64, imgFilePath
     * @return boolean
     */
    public static String Base64ToImage(String base64) {
    	String[] str=base64.split(","); 
    	String suffix = base64.substring(11, 14);
    	base64=str[1];
		String Allsuffix=UUID.randomUUID()+"."+ suffix;
		String imgFilePath = "J:/JAVA/git/ccUser-service/src/main/resources/static/img/kapian/"+Allsuffix;
        // 对字节数组字符串进行Base64解码并生成图片
        if (base64 == null) // 图像数据为空
            return "失败";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(base64);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return "../../img/kapian/"+Allsuffix;
        } catch (Exception e) {
            return imgFilePath;
        }


    }
    
    public static boolean GenerateImage(String imgStr)
    {   
    	System.out.print("已经收到了把字节码转化为图片的方法");
    	//对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            String imagePath="c:";
            //System.currentTimeMillis()
            String imgFilePath = "D:/LearningRelatedMaterials/Environment/TomcatProjectimg/aa.PNG";//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


}


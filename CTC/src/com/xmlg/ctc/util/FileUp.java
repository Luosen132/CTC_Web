package com.xmlg.ctc.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

/**
 * @author Administrator
 *文件上传
 */
public class FileUp {
	/**
     * 使用cos组件上传
   * 速度很快，最后选用该组件
   * @param request HttpServletRequest
     * @return String
     * @throws Exception
     */
    public static String uploadfiles(MultipartRequest multi) throws Exception{        
        String name = "";
        try{           
            //输出反馈信息
            Enumeration files = multi.getFileNames();
            while (files.hasMoreElements()){
                name +="/"+  
                       multi.getFilesystemName(
                               (String) files.nextElement());
            }
        } catch (Exception e){
            //超过最大文件限制
            System.out.print(e.toString());
        }
        return name;
    }
}

package com.xmlg.ctc.util;
import java.io.File;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

/** *//**
 * Cos组件的重命名策略
 *
 *
 */
public class RenamePolicyCos implements FileRenamePolicy{

    /** *//**
     * 重载该方法，命名规则为在文件名后面加上"_时间刻度"
     * 用于cos组件
     * @param file File
     * @return File
     */
    public File rename(File file){
        //System.out.println(new String file.getName().getBytes("iso-8859-1"));
        file = new File(file.getParent(), getNewFileName(file.getName()));
        return file;
    }

    /** *//**
     * 防止文件名重复，将文件重命名
     * 用于cos组件
     * @param fileName String
     * @param filerealpath String
     * @return String
     */
    public String getNewFileName(String fileName){
            String fType = getFiletype(fileName); //文件类型
            String ffrontname = getFilefrontname(fileName); //文件名前缀
            //替换前缀名中包含的特殊字符，视具体情况而定
            ffrontname = ffrontname.replace(',','_');
            ffrontname = ffrontname.replace('#','_');
            ffrontname = ffrontname.replace('&','_');
            ffrontname = ffrontname.replace('%','％');
            //System.out.println(ffrontname);
            long tick=new Date().getTime();
            String newFileName = ffrontname + "_" + tick + "." +
                                 fType;

            return newFileName;
    }

    /** *//**
     * 取文件名后缀
     * 用于cos组件
     * @param fileName String
     * @return String
     */
    public static String getFiletype(String fileName){
        String type = "";
        if (fileName == null || fileName.equals("")){
            return type;
        }
        int position = fileName.lastIndexOf(".");
        if (position != -1){
            type = fileName.substring(position + 1, fileName.length());
        }
        return type;
    }

    /** *//**
     * 取文件名前缀
     * 用于cos组件
     * @param fileName String
     * @return String
     */
    public static String getFilefrontname(String fileName){
        String name = "";
        if (fileName == null || fileName.equals("")){
            return name;
        }
        int position = fileName.lastIndexOf(".");
        if (position != -1){
            name = fileName.substring(0, position);
        }
        String newname = "";
        newname = name.trim().replaceAll(" ","");
        newname = newname.replaceAll("%","_");
        newname = newname.replaceAll("/+","_");  // + 模式匹配规则表达式，需要用\转义
        return newname;
    }

}
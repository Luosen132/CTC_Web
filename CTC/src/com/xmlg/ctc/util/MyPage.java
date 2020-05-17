package com.xmlg.ctc.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义的分页标签
 * @author mxt
 * @version1.0
 * @category 
 */
public class MyPage extends TagSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = -731176264076913167L;
	private String url = null;
    private int pageIndex;
    private int pageMax;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageMax(int pageMax) {
        this.pageMax = pageMax;
    }

    public int getPageMax() {
        return this.pageMax;
    }


    @Override
    public int doStartTag() throws JspException {
        StringBuffer str = new StringBuffer();
        if (pageIndex == 1) {
            str.append("首页&nbsp;上一页 ");
        } else {
            str.append(" <a href='" + url + "page=1'>首页</a> "
                    + "<a href='" + url + "page=" + (pageIndex - 1) + "'>上一页</a> ");
        }
        if (pageIndex / 6 < 1.0 || pageMax < 10) {
            for (int i = 1; i <= 9; i++) {
                if (i <= pageMax) {
                    if (pageIndex != i) {
                        str.append("<a href='" + url + "page=" + i + "'>[" + i + "]</a> ");
                    } else {
                        str.append("  " + i + " ");
                    }
                }
            }
        } else if (pageIndex / 6 >= 1.0 && pageMax >= 10) {
            int fri = 0;
            int max = 0;
            if (pageMax - pageIndex > 4) {
                fri = pageIndex - 4;
                max = pageIndex + 4;
            } else {
                fri = pageMax - 8;
                max = pageMax;
            }
            for (int i = fri; i <= max; i++) {
                if (i <= pageMax) {
                    if (pageIndex != i) {
                        str.append("<a href='" + url + "page=" + i + "'>[" + i + "]</a> ");
                    } else {
                        str.append("  " + i + " ");
                    }
                }
            }
        }
        if (pageIndex == pageMax || pageMax < 2) {
            str.append("下一页&nbsp;尾页");
        } else {
            str.append("<a href='" + url + "page=" + (pageIndex + 1) + "'>下一页</a> "
                    + "<a href='" + url + "page=" + pageMax + "'>尾页</a>");
        }
        str.append("&nbsp;跳转至：<select onchange=\"location='"+url+"page='+this.value;\">");
        for(int i=1;i<=pageMax;i++){
        	str.append("<option value='"+i+"' "+(i==pageIndex?"selected":"")+">第"+i+"页</option>");
        }
        str.append("</select>");
        try {
            if (str.length()>0) {
                pageContext.getOut().write(new String(str));
            }
        } catch (Exception e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}
package com.laoma.provider.test;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Map;

/**
 * @program: SpringCloudDemos
 * @description:
 * @author: 老马
 * @create: 2021-06-16 11:44
 **/
public class MainTest {

    //渲染freemarker 字符串
    public static String renderFreeMarkerString(String content, Map<String, Object> dataMap) {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            StringTemplateLoader stl = new StringTemplateLoader();
            stl.putTemplate("stringFormat", content);
            cfg.setTemplateLoader(stl);
            Template template = cfg.getTemplate("stringFormat");

            StringWriter writer = new StringWriter();
            template.process(dataMap, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws InterruptedException {
//        String fileContent = FileUtil.readString("C:\\Users\\mayf\\Desktop\\electricorder_payment0.html", "utf-8");
//        Map<String, Object> eorder = new HashMap<>();
//        eorder.put("date", "2021-06-16");
//        eorder.put("orderid", "123245547578683454675");
//        Map<String, Object> source = new HashMap<>();
//        source.put("state", 1);
//        Map<String, Object> context = new HashMap<>();
//        context.put("eorder", eorder);
//        context.put("source", source);
//        String html = renderFreeMarkerString(fileContent, context);
//        Html2Image html2Image = Html2Image.fromHtml(html);
//        html2Image.getImageRenderer().saveImage("C:\\Users\\mayf\\Desktop\\bbb.png");
//        System.out.println(fileContent);
        String str = "31323334353637383930";
        str = str.replaceAll("3(\\d)", "$1");
        System.out.println(str);
    }
}

package com.rg.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: custom_ioc
 * @Author: RG
 * @CreateTime: 2022/10/10 7:13 下午
 * @Description:
 */
public class BeanFactory {

    private static Map<String,Object> iocMap = new HashMap<>();

    // 程序启动时，初始化对象实例
    static {

        // 1.读取配置文件
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");

        // 2.解析xml(dom4j)
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(resourceAsStream);
            // 3.编写xpath表达式
            String xpath = "//bean";

            // 4.获取到所有的bean标签
            List<Element> list = document.selectNodes(xpath);
            for (Element element : list) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                // 使用反射生成实例对象
                Object o = Class.forName(className).newInstance();
                // 存到map中
                iocMap.put(id,o);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Object getBean(String beanId) {
        Object o = iocMap.get(beanId);
        return o;
    }

}

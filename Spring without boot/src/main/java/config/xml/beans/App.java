package config.xml.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import outsideofyrleague.Repo;

import java.util.Iterator;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        System.out.println("App started");

        //here we are susing xml based bean creation and not annotation based so
        //dont use annotationconfigapplication context, use claspath
        ApplicationContext context = new ClassPathXmlApplicationContext("config/xml/beans/config.xml");
        Student studentBean = context.getBean("student1",Student.class);
        System.out.println(studentBean);

        Map stacks=studentBean.getStacks();
        Iterator it=stacks.entrySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(stacks.getClass().getName());
        //xml based bean creation defalut map implementaion is a linkedHashMap

        //scanning other beans in other pacakges
        Repo repoBean=context.getBean(Repo.class);
        repoBean.hi();
    }
}

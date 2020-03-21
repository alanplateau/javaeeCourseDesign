package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.User;
import service.IOperatorService;
public class SpringEnvTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IOperatorService operatorService = (IOperatorService) ctx.getBean("operatorService");
        User cust = new User();
        cust.setAccount("123");
        cust.setPassword("123");
        cust.setType(1);
        if(operatorService.login(cust)){
            System.out.println("ccc");
        }
        else {
            System.out.println("fff");
        }
    }
}

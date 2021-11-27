package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitinNames = ac.getBeanDefinitionNames();
        for(String beanDefinitinName : beanDefinitinNames){
            Object bean = ac.getBean(beanDefinitinName);
            System.out.println("name = " + beanDefinitinName + " Object  = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitinNames = ac.getBeanDefinitionNames();
        for(String beanDefinitinName : beanDefinitinNames){
            BeanDefinition beanDefinition =  ac.getBeanDefinition(beanDefinitinName);

            // BeanDefinition.ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // BeanDefinition.ROLE_INFRASTRUCTURE : 스프링 내부 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitinName);
                System.out.println("name = " + beanDefinitinName + " Object  = " + bean);
            }
        }
    }
}

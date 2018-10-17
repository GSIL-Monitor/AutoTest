import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//spring boot中使用@SpringBootApplication指定类为应用启动类
//自动扫描于当前类同级以及子包下的相应注解注册为spring beans，
//在类中main方法中通过SpringApplication的run方法启动应用。
//@ComponentScan很有用，可以通过该注解指定扫描某些包下包含如下注解的均自动注册为spring beans：
@SpringBootApplication
@ComponentScan("com.course") //如果只写com.course.server，浏览器中打开是空白的
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

}

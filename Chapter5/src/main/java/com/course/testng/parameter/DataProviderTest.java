package com.course.testng.parameter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class DataProviderTest {
    //传递参数
    @Test(dataProvider = "data")
    public void testDataProviderTest(String name,int age){
        System.out.println("name="+name + "age+"+age);
    }

    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o= new Object[][]{
                {"zhangsan",10},
                {"lisi",20},
                {"wangwu",30}
        };
        return o;
    }
    //通过方法名传递参数
    @Test(dataProvider = "method")
    public void test1(String name,int age){
        System.out.println("test1方法"+"name="+name+"age="+age);
    }
    @Test(dataProvider = "method")
    public void test2(String name,int age){
        System.out.println("test2方法"+"name="+name+"age="+age);
    }
    @DataProvider(name="method")
    //必须加上Method
    public Object[][] methodTest(Method method){
        Object[][] result=null;
        if(method.getName().equals("test1")){
            result=new Object[][]{
                    {"zhangsan",20},
                    {"lisi",25}
            };
        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",50},
                    {"zhaoliu",60}
            };
        }
        return result;
    }
}

package com.yang.fanshe;

/**
 * @Author: yang
 * @Date: 2020-03-14 22:02
 * @Description: 测试反射
 */
public class UserEntity {

    private String name;
    private Integer age;

    public UserEntity() {
        System.out.println("new对象的时候 执行无参数构造函数");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //UserEntity userEntity = new UserEntity();
        //如果在构造函数里面抛异常 那么对象不会创建成功

        //通过反射创建对象
        Class<?> aClass = Class.forName("com.yang.fanshe.UserEntity");
        //aclass相当于class文件
        UserEntity userEntity1 = (UserEntity)aClass.newInstance();

    }
}

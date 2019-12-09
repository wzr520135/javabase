package lambda;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

/**
 * @auther wzr
 * 创建时间: 2019-12-09 21:22
 * @Description:  lamda表示式  函数式接口
 *  一个接口只有一个抽象的方法;
 *  推导lambda
 */

public class TestLambda {
    //2静态内部诶
    static class Like2 implements ILike {
        @Override
        public void show() {
            System.out.println("i like  u  静态内部类");
        }

        public static void main(String[] args) {
            //1传统实现类
            ILike like = new Like();
            like.show();

            //2 静态内部类
            like = new Like2();
            like.show();

            //3 局部内部类
            class Like3 implements ILike {
                @Override
                public void show() {
                    System.out.println("i like  u  局部内部类");
                }
            }
            like = new Like3();
            like.show();


            //4 匿名内部类 没有类的名字 必须借助接扣或者父类

            like = new ILike() {
                @Override
                public void show() {
                    System.out.println("i like u 匿名内部类");
                }
            };

            like.show();

            //5lambdab表达式


            like = () -> {

                System.out.println("i like u lambda表达式");

            };
            like.show();


            System.out.println("**********************");
            //6lambda表达式 简化

            ILove love = null;


            love = (int a) -> {
                System.out.println(a);
                //return a;
            };

            love.love(1);

            //6.1 去掉参数类型

            love = (a) -> {
                System.out.println(a);
                //return a;
            };
            love.love(2);

            // 6.2 去掉括号

            love = a -> {
                System.out.println(a);
            };

            love.love(3);

            //6.3 去掉花括号
            love = a -> System.out.println(a);

            love.love(4);

        }
        /** 总结
         *1.lambda表达式只能 执行一行代码 有多行代码 则必须加上{} 代码块
         * 2. 有多个参数的时候不能去掉括号
         * 3.前提是必须是函数式接口
         * */

    }
}
interface ILike{

  void show();

}

//1 实现类
 class Like implements  ILike{
    @Override
    public void show() {
        System.out.println("i like  u  传统实现类");
    }
}
 interface  ILove {

     void love(int a);

 }

 class  Love implements  ILove{
     @Override
     public void love(int a) {
         System.out.println( a);
        // return a;
     }
 }
package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @auther wzr
 * 创建时间: 2019-12-09 22:54
 * @Description:  输入流 读文件
 */
public class TestInputStream {

    public static void main(String[] args) throws Exception{
          //获取数据源
         File file= new File("e:/a/a.txt");
         //构建流对象
        InputStream is=new FileInputStream(file);

//        int i   = is.read();
//        System.out.println(i);//104

          int i=0;
          byte[] bt=new byte[1024];
           while ((i=is.read(bt))!=-1){
               for (int j = 0; j <i ; j++) {
                   System.out.print((char)bt[j]);
               }
                   System.out.println(i);//13

        }



        is.close();



    }



}

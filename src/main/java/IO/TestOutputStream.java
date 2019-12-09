package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @auther wzr
 * 创建时间: 2019-12-09 22:32
 * @Description:   输出流 字节流
 */
public class TestOutputStream {
      public static void main(String[] args) throws Exception{


            //构建要写入文件路径
            File file = new File("e:/a/a.txt");

          //判断文件是否存在 不存在则创建
             if(!file.exists()){

                  file.getParentFile().mkdirs();
                 // file.createNewFile();


             }
            // 构建输入流对象
            OutputStream os = new FileOutputStream(file);

             String str="hello  world ";


                byte [] b=str.getBytes();

              os.write(b);

              os.close();

      }
}

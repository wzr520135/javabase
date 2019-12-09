package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther wzr
 * 创建时间: 2019-12-08 20:07
 * @Description:
 */
public class SocketServerTest {

    public static void main(String[] args) throws  Exception{

         //初始化服务端socket并且绑定99999端口


            ServerSocket serverSocket = new ServerSocket(9999);

        //等待客户的连接
        Socket socket=serverSocket.accept();
        //获取输入流
        InputStream ina = socket.getInputStream();

        InputStreamReader in= new InputStreamReader(ina,"UTF-8");

        BufferedReader bufferedReader= new BufferedReader(in);
          //读取一行数据
        String s = bufferedReader.readLine();
        System.out.println(s);

    }




}

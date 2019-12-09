package socket;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther wzr
 * 创建时间: 2019-12-08 20:15
 * @Description:
 */
public class ClientSocket {
    public static void main(String[] args)  throws  Exception{
      //建立连节
        Socket socket=new Socket("127.0.0.1", 9999);
      // 构建输出流
        OutputStream os = socket.getOutputStream();
       OutputStreamWriter osw=new OutputStreamWriter(os);
        BufferedWriter bw=new BufferedWriter(osw);
/**
 * java.net.SocketException: Connection reset 会报错
 * socket通信是阻塞的，他会在以下几个地方进行阻塞。
 * 第一个是accept方法，调用这个方法后，服务端一直阻塞在哪里，
 * 直到有客户端连接进来。
 * 第二个是read方法，调用read方法也会进行阻塞。
 * 通过上面的示例我们可以发现，该问题发生在read方法中。
 * 有朋友说是Client没有发送成功，其实不是的，我
 * 们可以通debug跟踪一下，发现客户端发送了，并且没有问题。
 * 而是发生在服务端中，当服务端调用read方法后，
 * 他一直阻塞在哪里，因为客户端没有给他一个标识，
 * 告诉是否消息发送完成，所以服务端还在一直等待接受客户端的数据，结
 * 果客户端此时已经关闭了，
 * 就是在服务端报错：java.net.SocketException: Connection reset
 *那么理解上面的原理后，我们就能明白，客户端发送完消息后，
 * 需要给服务端一个标识，告诉服务端，我已经发送完成了，
 * 服务端就可以将接受的消息打印出来。
 *


 */

     String str="你好 ,这是我的第一个socket";
        //写入字符串
          bw.write(str);


        /**socket.close() 或者调用socket.shutdownOutput();
         * 方法。调用这俩个方法，都会结束客户端socket。但是有本质的区别。
         * socket.close() 将socket关闭连接，那边如果有服务端给客户端反馈信息
         * 此时客户端是收不到的。
         * 而socket.shutdownOutput()是将输出流关闭，
         * 此时，如果服务端有信息返回，则客户端是可以正常接受的。
         * 增加一个标识告诉流已经输出完毕：
         *
         */

        //出错后添加的代码  告诉服务端我已经发送完成了
          bw.flush();//刷新输入流

        socket.shutdownOutput();//关闭输出流




    }
}

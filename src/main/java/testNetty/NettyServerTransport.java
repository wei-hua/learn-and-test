package testNetty;

/**
 * Created by Alina on 2018/7/5.
 */
public class NettyServerTransport {
  public void start() {
    NettyServer nettyServer = new NettyServer();
    nettyServer.startUp(9090, new HttpChannelInboundHandler());
  }

  public static void main() {
    NettyServerTransport nettyServerTransport = new NettyServerTransport();
    nettyServerTransport.start();
    System.out.print("netty started");
  }
}

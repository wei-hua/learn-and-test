package testNetty;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;

/**
 * Created by Alina on 2018/6/11.
 */
public class HttpChannelInitializer extends ChannelInitializer<SocketChannel> {

  private ChannelInboundHandlerAdapter channelInboundHandlerAdapter;

  public HttpChannelInitializer(ChannelInboundHandlerAdapter handlerAdapter) {
    this.channelInboundHandlerAdapter = handlerAdapter;
  }

  @Override

  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipe = ch.pipeline();
    pipe.addLast("readTimeoutHandler",new ReadTimeoutHandler(120))
        .addLast("writeTimeOutHandler", new WriteTimeoutHandler(60))
        .addLast("decoder", new HttpRequestDecoder())
        .addLast("aggregator", new HttpObjectAggregator(65536))
        .addLast("encoder", new HttpResponseEncoder())
        .addLast("streamer", new ChunkedWriteHandler())
        .addLast("handler", channelInboundHandlerAdapter);
  }
}

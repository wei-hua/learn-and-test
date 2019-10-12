package testNetty;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

import java.util.regex.Pattern;

/**
 * Created by Alina on 2018/6/11.
 */
@Sharable
public class HttpChannelInboundHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

    try {
      String path = getPath(msg);
      String uri = getUri(msg);
      String ip = getRemoteIP(ctx, msg);
    } catch (Exception e) {
      NettyResponseHelper.replyBadRequest(ctx);
    }

  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    super.channelReadComplete(ctx);
    try {
      ctx.channel().flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    if (null != cause) {
      cause.printStackTrace();
    }
    if (null != ctx) {
      ctx.channel().close();
    }
  }

  private String parseBody(FullHttpRequest req) {
    //get param content
    String content = null;
    ByteBuf buf = req.content();
    int readable = buf.readableBytes();
    if (0 < readable) {
      byte[] bytes = new byte[readable];
      buf.readBytes(bytes);
      content = new String(bytes, CharsetUtil.UTF_8);
    }

    if (content == null) {
      return null;
    }

    return content;
  }

  /**
   * Get path from http request
   */
  private String getPath(HttpRequest httpRequest) {
    String uri = httpRequest.uri();
    int index = uri.indexOf("?");
    if (0 < index) {
      uri = uri.substring(0, index);
    }
    return uri;
  }

  private String getUri(HttpRequest httpRequest){
    String uri = httpRequest.uri();
    return uri;
  }


  private static boolean isAvailableIP(String ip) {
    return (ip != null) && (ip.length() != 0) && (!"unknown".equalsIgnoreCase(ip));
  }

  /**
   * get remote ip
   */
  public static String getRemoteIP(ChannelHandlerContext ctx, HttpRequest request) {
    final Pattern remotePattern = Pattern.compile("^/[0-9]{1,3}(.[0-9]{1,3}){3}:[0-9]{2,}$");
    final String[] tryHeaders = {"X-Real-IP", "x-forwarded-for", "Proxy-Client-IP"};
    String ip = null;
    // 1. try to get ip address from headers
    HttpHeaders heads = request.headers();
    for (String header : tryHeaders) {
      ip = heads.get(header);

      if (isAvailableIP(ip)) {
        break;
      }
    }
    // 2. if there is no ip info in header, try to get it from channel info
    if (!isAvailableIP(ip)) {
      ip = ctx.channel().remoteAddress().toString();

      if (!StringUtil.isNullOrEmpty(ip) && remotePattern.matcher(ip).matches()) {
        ip = ip.substring(1, ip.indexOf(":"));
      }
    }

    // 3. remove port part from address
    if (null != ip && ip.indexOf(",") > 0) {
      ip = ip.substring(0, ip.indexOf(",")).trim();
    }
    return ip;
  }

}

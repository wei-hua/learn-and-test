package testNetty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;

/**
 * Created by Alina on 2018/6/11.
 */
public class NettyResponseHelper {

  private static AsciiString contentType = new AsciiString("text/html");

  /**
   * 404 response
   * This method mainly react to unexpected http request.
   */
  public static void replyNotFound(ChannelHandlerContext context) {
    DefaultFullHttpResponse response = buildResponse(HttpCode.NOT_FOUND, null);
    context.writeAndFlush(response);
  }

  /**
   * 400 response
   * This method is invoked when application meets expected errors.
   */
  public static void replyBadRequest(ChannelHandlerContext context) {
    DefaultFullHttpResponse response = buildResponse(400, null);
    context.writeAndFlush(response);
  }


  /**
   * Echo OK to ping request from AWS Elastic Load Balance
   * Application will echo ok when it's ready to provide click services.
   */
  public static void replyOK(ChannelHandlerContext context) {
    DefaultFullHttpResponse response = buildResponse(HttpCode.OK, "ok");
    context.writeAndFlush(response);
  }

  public static void reply(ChannelHandlerContext context, String responseBody) {
    DefaultFullHttpResponse response = buildResponse(HttpCode.OK, responseBody);
    context.writeAndFlush(response);
  }

  /**
   * Build response with code
   */
  private static DefaultFullHttpResponse buildResponse(int code, String responseBody) {
    byte[] bytes = null == responseBody ? new byte[0] : responseBody.getBytes();

    DefaultFullHttpResponse response = null;
    switch (code) {
      case HttpCode.OK: {
        response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            Unpooled.wrappedBuffer(bytes));

        response.headers().add(HttpHeaderNames.CONTENT_TYPE, contentType);
        break;
      }
      case HttpCode.BAD_REQUEST: {
        response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
            HttpResponseStatus.BAD_REQUEST,
            Unpooled.wrappedBuffer(bytes));
        break;
      }
      case HttpCode.NOT_FOUND: {
        response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
            HttpResponseStatus.NOT_FOUND,
            Unpooled.wrappedBuffer(bytes));
        break;
      }
      default:
        break;
    }

    if (null != response) {
      response.headers().add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
    }

    return response;
  }
}

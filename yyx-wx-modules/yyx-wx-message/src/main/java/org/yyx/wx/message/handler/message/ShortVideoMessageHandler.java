package org.yyx.wx.message.handler.message;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yyx.wx.commons.bussinessenum.MessageTypeEnum;
import org.yyx.wx.commons.util.WxXmlAndObjectUtil;
import org.yyx.wx.commons.vo.pubnum.reponse.message.VideoMessageResponse;
import org.yyx.wx.commons.vo.pubnum.request.message.VideoMessageRequest;
import org.yyx.wx.message.handler.AbstractMessageHandler;

/**
 * 小视频消息处理器
 * <p>
 *
 * @author 叶云轩 at tdg_yyx@foxmail.com
 * @date 2018/8/25-19:45
 */
public class ShortVideoMessageHandler extends AbstractMessageHandler {
    /**
     * TextMessageHandler日志输出
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ShortVideoMessageHandler.class);
    /**
     * 创建对象
     */
    private static final ShortVideoMessageHandler SHORT_VIDEO_MESSAGE_HANDLER = new ShortVideoMessageHandler();

    /**
     * 私有构造
     */
    private ShortVideoMessageHandler() {
    }

    /**
     * 获取对象
     *
     * @return 返回对象
     */
    public static ShortVideoMessageHandler getInstance() {
        return SHORT_VIDEO_MESSAGE_HANDLER;
    }

    /**
     * 文本消息处理器
     *
     * @param element 实际处理器要处理的数据
     * @return 处理后的消息
     */
    @Override
    protected VideoMessageResponse dealTask(Element element) {
        LOGGER.info("[进入小视频消息处理器]");
        VideoMessageRequest videoMessageRequest = this.modelMethod(element);
        return null;
    }

    /**
     * 获取文本消息处理器级别
     *
     * @return 文本消息处理器级别
     */
    @Override
    protected String getHandlerLevel() {
        return MessageTypeEnum.shortvideo.toString();
    }

    /**
     * 模板方法
     *
     * @param element 微信请求过来的消息:xml
     * @return xml转换之后的实体对象 有可能为空
     */
    @Override
    protected VideoMessageRequest modelMethod(Element element) {
        LOGGER.info("[微信请求过来的消息:xml格式数据] {}", element);
        VideoMessageRequest videoMessageRequest;
        try {
            videoMessageRequest = WxXmlAndObjectUtil.xmlToObject(element, VideoMessageRequest.class);
        } catch (IllegalAccessException | InstantiationException e) {
            return null;
        }
        return videoMessageRequest;
    }
}
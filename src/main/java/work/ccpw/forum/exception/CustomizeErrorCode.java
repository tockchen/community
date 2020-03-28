package work.ccpw.forum.exception;

/**
 * @program: community
 * @description: 枚举实现接口
 * @author: cone
 * @create: 2020-03-16 12:57
 **/
public enum CustomizeErrorCode implements ICustomizeErrorCode{
    /**
     *
     */
    QUESTON_NOT_FOUND(2001,"你找的问题不在了,要不要换个试试?"),
    TARGET_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_lOGIN(2003,"当前操作需要登陆,请登陆后重试"),
    SYS_ERROR(2004,"服务冒烟了,要不然你稍后再试试!!!"),
    TYPE_ERROR_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在了,要不要换个试试?"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空!"),
    READ_NOTIFICATION_FAIL(2008, "兄弟你这是读别人的信息呢？"),
    NOTIFICATION_NOT_FOUND(2009, "消息莫非是不翼而飞了？"),
    FILE_UPLOAD_FAIL(2010, "图片上传失败"),
    INVALID_INPUT(2011, "非法输入"),
    INVALID_OPERATION(2012, "兄弟，是不是走错房间了？"),
    ;

    private String message;
    private Integer code;
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }




    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
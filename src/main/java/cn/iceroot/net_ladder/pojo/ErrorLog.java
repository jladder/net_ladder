package cn.iceroot.net_ladder.pojo;

public class ErrorLog {
    private Integer id;
    private String name;// 日志名称
    private String url;// 访问地址
    private String statusCode;// 状态码
    private String contentType;// 内容类型
    private String contentLength;// 内容长度
    private String contentEncoding;// 内容编码
    private String protocolVersion;// 协议版本
    private String reasonPhrase;// reasonPhrase
    private String createTime;// 创建时间
    private String content;// 返回内容

    public ErrorLog() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ErrorLog [id=" + id + ", name=" + name + ", url=" + url + ", statusCode=" + statusCode
                + ", contentType=" + contentType + ", contentLength=" + contentLength + ", contentEncoding="
                + contentEncoding + ", protocolVersion=" + protocolVersion + ", reasonPhrase=" + reasonPhrase
                + ", createTime=" + createTime + ", content=" + content + "]";
    }
}

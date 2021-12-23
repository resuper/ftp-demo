# 江湖规矩先说结论
文件上传下载其实都是操作 流(输入输出是相对于当前程序来讲的，外界到程序的是输入流，程序到外界的是输出流)
- 浏览器预览图片(输入地址浏览器直接显示图片)
- 下载图片(输入地址，浏览器弹出下载框)
> **其实都是将图片的流放到响应对象的输出流中,不同的是下载时需要设置响应头**


# ftp服务器搭建
搭建ftp服务器很简单，具体参照下方文档
1. Linux(两篇文章结合看,评论区有彩蛋)
- [https://www.cnblogs.com/Sungeek/p/10148656.html](https://www.cnblogs.com/Sungeek/p/10148656.html)
- [https://zhuanlan.zhihu.com/p/126631566](https://zhuanlan.zhihu.com/p/126631566)
2. Windows
- [https://www.cnblogs.com/popfisher/p/7992036.html](https://www.cnblogs.com/popfisher/p/7992036.html)
# Java 操作ftp的客户端
1. hutool工具包
- [https://www.hutool.cn/docs/#/extra/FTP/FTP客户端封装-Ftp](https://www.hutool.cn/docs/#/extra/FTP/FTP客户端封装-Ftp)
# 下载和预览的区别
```java
response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8")); 
response.setContentType("multipart/form-data");
```




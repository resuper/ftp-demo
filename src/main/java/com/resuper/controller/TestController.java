package com.resuper.controller;

import cn.hutool.extra.ftp.Ftp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author sutaotao
 * @date 2021-12-22 18:52
 * @description: TODO
 */
@RestController
@RequestMapping("/file")
public class TestController {


    @Resource
    private Ftp ftp;

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        //匿名登录（无需帐号密码的FTP服务器）
//        Ftp ftp = new Ftp("192.168.3.17", 21, "ftpuser", "!QAZ2wsx");
        //进入远程目录
        ftp.cd("/opt/demo/upload");
        //上传文件
        String fileName = file.getOriginalFilename();
        InputStream is = file.getInputStream();
        ftp.upload("/opt/demo/upload", fileName, is);
        //关闭连接
        ftp.close();
        return "success";
    }

    @RequestMapping("/download")
    public void download(String fileName, HttpServletResponse response) throws IOException {

        //匿名登录（无需帐号密码的FTP服务器）
//        Ftp ftp = new Ftp("192.168.3.17", 21, "ftpuser", "!QAZ2wsx");
        Ftp ftp = new Ftp("192.168.66.60", 21, "ftpuser", "!QAZ2wsx");
        //进入远程目录
        ftp.cd("/opt/demo/upload");
        //下载远程文件  设置响应头和响应类型，浏览器访问可以弹出下载框
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        response.setContentType("multipart/form-data");
        OutputStream out = response.getOutputStream();
        ftp.download("/opt/demo/upload", fileName, out);

        //关闭连接
        ftp.close();
    }

    @RequestMapping("/preview")
    public void preview(String fileName, HttpServletResponse response) throws IOException {
        //匿名登录（无需帐号密码的FTP服务器）
//        Ftp ftp = new Ftp("192.168.3.17", 21, "ftpuser", "!QAZ2wsx");
        Ftp ftp = new Ftp("192.168.66.60", 21, "ftpuser", "!QAZ2wsx");
        //进入远程目录
        ftp.cd("/opt/demo/upload");
        //下载远程文件  设置响应头和响应类型，浏览器访问可以弹出下载框
        OutputStream out = response.getOutputStream();
        ftp.download("/opt/demo/upload", fileName, out);

        //关闭连接
        ftp.close();
    }
}

package com.webmagic;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.downloader.HttpClientGenerator;
import us.codecraft.webmagic.processor.SimplePageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.*;

/**
 * Created by zhu on 2016/11/16.
 */
public class Down {
    public static void main(String[] args){
        Set<Integer> acceptstatcode = new HashSet<Integer>();
        acceptstatcode.add(200);
        acceptstatcode.add(302);
        acceptstatcode.add(500);
        Site site = Site.me()
                .setDomain("http://119.29.110.134:8080/usermange/")
                .setTimeOut(1000 * 60 * 5)
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36")
                .setRetryTimes(8)
                .setAcceptStatCode(acceptstatcode);
        Downloader downloader = new HttpClientDownloader();
        Request request1 = new Request();
        request1.setUrl("http://119.29.110.134:8080/usermange");


        Page page1 = downloader.download(request1,site.toTask());
       // System.out.println(page1.getRawText());

        Request request2 = new Request();
        request2.setUrl("http://119.29.110.134:8080/usermange/user/userLogin");
//        request2.putExtra("username","admin");
//        request2.putExtra("password","admin");
        request2.setMethod("POST");
        site.addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        site.addHeader("Accept-Encoding","gzip, deflate");
        site.addHeader("Accept-Language","zh-CN,zh;q=0.8");
        site.addHeader("Connection","keep-alive");
        Page page2 = downloader.download(request2,site.toTask());

        System.out.println(request2.toString());

    }
}

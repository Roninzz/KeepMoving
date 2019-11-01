package com.keepmoving.fitness.util.qiniu;

import com.qiniu.common.Zone;

import java.io.IOException;
import java.util.Properties;

public class QiniuConfig {
    private String accessKey;
    private String secretKey;
    private String bucket;
    private Zone zone;
    private String domainOfBucket;
    private long expireInSeconds;

    private static Properties prop = new Properties();
    static{
        try {
            prop.load(QiniuConfig.class.getResourceAsStream("/qiniu.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAccessKey(){
       return  (String)prop.get("ACCESS_KEY");
    }
    public static String getSecretKey(){
        return  (String)prop.get("SECRET_KEY");
    }
    public static String getBucket(){
        return  (String)prop.get("bucketName");
    }
    public static String getDomainOfBucket(){
        return  (String)prop.get("domain");
    }

    public static void main(String[] args) {
            System.out.println(getAccessKey());
    }
}

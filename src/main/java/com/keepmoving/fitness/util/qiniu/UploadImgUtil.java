package com.keepmoving.fitness.util.qiniu;

import com.keepmoving.fitness.util.qiniu.QiniuConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.File;
import java.util.UUID;

/**
 * 上传图片到七牛云
 */
public class UploadImgUtil {

    private static String ACCESS_KEY = QiniuConfig.getAccessKey(); // 这两个登录七牛

    private static String SECRET_KEY = QiniuConfig.getSecretKey();

    private static String bucketname = QiniuConfig.getBucket();

    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);// 密钥配置

    private static UploadManager uploadManager = new UploadManager(); // 创建上传对象


    //设置新文件的文件名
    private static String newName(String oldName) {
        String[] datas = oldName.split("\\.");
        String type = datas[datas.length - 1];
        String newName = UUID.randomUUID().toString() + "." + type;
        return newName;
    }

    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了 //
    private static String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    /**
     * 上传图片到七牛云
     * @param bytes 图片文件字节数组
     * @return  返回图片在七牛云服务器的url
     */
    public static String upload(byte[] bytes,String fileName){
        String url = null;
        Response res = null;
        String imgName = null;
        String key = newName(fileName);//七牛云服务器里用来对应唯一上传的文件
        try {
            res = uploadManager.put(bytes, key, getUpToken());
            imgName = (String) res.jsonToMap().get("key");
            url = QiniuConfig.getDomainOfBucket()+imgName;
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return url;

    }
    public static String upload(File file,String fileName){
        String url = null;
        Response res = null;
        String imgName = null;
        try {
            res = uploadManager.put(file, newName(fileName), getUpToken());
            imgName = (String) res.jsonToMap().get("key");
            url = QiniuConfig.getDomainOfBucket()+imgName;
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return url;
    }


}

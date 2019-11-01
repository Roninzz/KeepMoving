package com.keepmoving.fitness.pay.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alipay.api.AlipayConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.keepmoving.fitness.pay.AlipayClient;
import com.keepmoving.fitness.pay.alipay.core.AlipayCore;
import com.keepmoving.fitness.pay.alipay.entity.request.AlipayWebSiteRequest;
import com.keepmoving.fitness.pay.config.AlipayConfig;

/**
 * Created by Administrator on 2019/10/8.
 */
@Controller
@RequestMapping("/alipay")
public class AlipayController {

    private static final Log log= LogFactory.get();

    @Autowired
    private AlipayConfig alipayConfig;

    //  lcalhost:8081/alipay/index
    //这个是网站支付的页面 之后跳转到扫码支付  /pay/web
    @RequestMapping("/index")

    // 支付成功跳转的页面
    public String index(){
        return "abc";
    }

    @RequestMapping("/pay/web")
    public String payInWebSite(@RequestParam(name = "amt",defaultValue = "99.8")String amt,
                               ModelMap modelMap){
        try {
            AlipayCore.ClientBuilder clientBuilder = new AlipayCore.ClientBuilder();
            AlipayCore alipayCore = clientBuilder.setAlipayPublicKey(alipayConfig.getAlipay_public_key())
                    .setAppId(alipayConfig.getAppid())
                    .setPrivateKey(alipayConfig.getPrivate_key())
                    .setSignType(AlipayConstants.SIGN_TYPE_RSA2).build();

            AlipayWebSiteRequest request = new AlipayWebSiteRequest();

            //http://你的异步处理地址/alipay/notify_mobile
            //request.setNotifyUrl("http://你的异步处理地址/alipay/notify_mobile");
            request.setNotifyUrl(null);


            request.setReturnUrl("http://localhost:8081/KeepMovingFiness/person/center");

            AlipayWebSiteRequest.BizContent bizContent = new AlipayWebSiteRequest.BizContent();
            bizContent.setTotalAmount(amt);
            bizContent.setSubject("测试电脑网站支付");
            bizContent.setBody("测试");
            bizContent.setOutTradeNo(System.currentTimeMillis()+"99.8");
            request.setBizContent(bizContent);
            String html = AlipayClient.payInWebSite(request,alipayCore);
            modelMap.addAttribute("form", html);

        } catch (Exception e) {
            log.error("电脑网站支付失败",e);
        }

        return "alipay_web";
    }
}

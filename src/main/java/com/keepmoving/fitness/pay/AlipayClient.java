package com.keepmoving.fitness.pay;

import cn.hutool.core.lang.Assert;
import com.keepmoving.fitness.pay.alipay.core.AlipayCore;
import com.keepmoving.fitness.pay.alipay.entity.request.*;
import com.keepmoving.fitness.pay.alipay.entity.response.*;

import java.util.Objects;

/**
 * 支付宝支付入口Class
 *
 * @author hanley @thlws.com
 *  2018 /11/16
 */
public class AlipayClient {


    /***
     * 普通网站支付
     * {@link AlipayCore#payInWebSite}
     * @param request request
     * @param alipayCore alipayCore
     * @return html string
     * @throws Exception Exception
     */
    public static  String payInWebSite(AlipayWebSiteRequest request, AlipayCore alipayCore) throws Exception{

        Objects.requireNonNull(alipayCore, "alipayCore can not be nul.");
        Objects.requireNonNull(request, "AlipayWebSiteRequest can not be null.");

        return alipayCore.payInWebSite(request);
    }




    /***
     * 支付订单查询
     * {@link AlipayCore#query}
     * @param outTradeNo the out trade no
     * @param alipayCore the alipay core
     * @return alipay query response
     */
    public static AlipayQueryResponse query(String outTradeNo, AlipayCore alipayCore) {

        Objects.requireNonNull(alipayCore, "alipayCore can not be null.");
        Assert.notEmpty(outTradeNo, "outTradeNo can not be null");

        return alipayCore.query(outTradeNo);
    }


    /***
     *
     * 支付订单退款
     * {@link AlipayCore#refund}
     * @param request the request
     * @param alipayCore the alipay core
     * @return alipay refund response
     * @throws Exception the exception
     */
    public static AlipayRefundResponse refund(AlipayRefundRequest request, AlipayCore alipayCore) throws Exception{

        Objects.requireNonNull(alipayCore, "alipayCore can not be null.");
        Objects.requireNonNull(request, "AlipayRefundRequest can not be null.");

        return alipayCore.refund(request);
    }


    /***
     * 订单取消
     * {@link AlipayCore#cancel}
     * @param outTradeNo the out trade no
     * @param alipayCore the alipay core
     * @return alipay cancel response
     */
    public static AlipayCancelResponse cancel(String outTradeNo, AlipayCore alipayCore) {

        Objects.requireNonNull(alipayCore, "alipayCore can not be null.");
        Assert.notEmpty(outTradeNo, "outTradeNo can not be null.");

        return alipayCore.cancel(outTradeNo);
    }
}

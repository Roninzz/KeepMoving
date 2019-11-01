package com.keepmoving.fitness.pay.alipay.core;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import org.apache.commons.lang3.StringUtils;
import com.keepmoving.fitness.pay.alipay.entity.request.AlipayMobileSiteRequest;
import com.keepmoving.fitness.pay.alipay.entity.request.AlipayRefundRequest;
import com.keepmoving.fitness.pay.alipay.entity.request.AlipayWebSiteRequest;
import com.keepmoving.fitness.pay.alipay.entity.response.AlipayCancelResponse;
import com.keepmoving.fitness.pay.alipay.entity.response.AlipayQueryResponse;
import com.keepmoving.fitness.pay.alipay.entity.response.AlipayRefundResponse;
import com.keepmoving.fitness.pay.alipay.trade.model.builder.AlipayTradeCancelRequestBuilder;
import com.keepmoving.fitness.pay.alipay.trade.model.builder.AlipayTradeQueryRequestBuilder;
import com.keepmoving.fitness.pay.alipay.trade.model.builder.AlipayTradeRefundRequestBuilder;
import com.keepmoving.fitness.pay.alipay.trade.model.result.AlipayF2FCancelResult;
import com.keepmoving.fitness.pay.alipay.trade.model.result.AlipayF2FQueryResult;
import com.keepmoving.fitness.pay.alipay.trade.model.result.AlipayF2FRefundResult;
import com.keepmoving.fitness.pay.alipay.trade.service.AlipayTradeService;
import com.keepmoving.fitness.pay.alipay.trade.service.impl.AlipayTradeServiceImpl;
import com.keepmoving.fitness.pay.utils.JsonUtil;

import java.util.Objects;

/**
 * 支付宝支付核心处理入口,封装支付常用API，包括当面付、新版网页支付、退款操作、订单查询;
 * 使用任何方法前,需先行设置ClientBuilder中核心参数,并调用build方法初始化.<br>
 * https://docs.open.alipay.com/api
 *
 * <pre>
 *  AlipayCore.ClientBuilder clientBuilderclientBuilder = new AlipayCore.ClientBuilder();
 *  AlipayCore alipayCore = .setAlipayPublicKey("xxx").setAppId("xxx").setPrivateKey("xxx").build();
 *  AlipayClient.pay(request,alipayCore);
 *  AlipayClient.refund(request,alipayCore);
 *  AlipayClient.preCreate(request,alipayCore);
 *  AlipayClient.query("out_trade_no",alipayCore);
 *  AlipayClient.payInMobileSite(request,alipayCore);
 * </pre>
 *
 * @author hanley @thlws.com
 *  2018 /11/16
 */
public class AlipayCore {

    private static final Log log = LogFactory.get();

    /**
     * 支付交易核心服务,调用API前,调用前API前先行初始化
     */
    private AlipayTradeService tradeService;

    /**
     * 支付宝核心参数构件器,调用前API前先行初始化
     */
    private ClientBuilder builder;


    /***
     * 参数构件第三步,初始化 tradeService,builder
     * @param builder the builder
     */
    private AlipayCore(ClientBuilder builder) {

        Assert.notEmpty(builder.getAppId(), "appId should not be NULL!");
        Assert.notEmpty(builder.getPrivateKey(), "private should not be NULL!");
        this.builder = builder;
        AlipayTradeServiceImpl.ClientBuilder alipayTradebuilder = new AlipayTradeServiceImpl.ClientBuilder();
        alipayTradebuilder.setAlipayPublicKey(builder.getAlipayPublicKey());
        alipayTradebuilder.setAppid(builder.getAppId());
        alipayTradebuilder.setCharset("utf-8");
        alipayTradebuilder.setFormat("json");
        alipayTradebuilder.setGatewayUrl("https://openapi.alipaydev.com/gateway.do");
        alipayTradebuilder.setPrivateKey(builder.getPrivateKey());
        alipayTradebuilder.setSignType(builder.getSignType());
        tradeService = alipayTradebuilder.build();
    }

    /***
     * 参数构件Class,参数构件第一步,请完成所有参数设置后调用build 方法.
     */
    public static class ClientBuilder {

        private String privateKey;
        private String alipayPublicKey;
        private String appId;
        private String signType;

        /***
         * 参数构件第二步,构件supper class instance.
         * Modified by Hanley
         * @return the alipay core
         */
        public AlipayCore build() {

            Assert.notEmpty(appId, "please set appid first!");
            Assert.notEmpty(privateKey, "please set private_key first!");
            Assert.notEmpty(signType, "please set sign_type first!");

            if(signType.equalsIgnoreCase(AlipayConstants.SIGN_TYPE_RSA2)){
                Assert.notEmpty(alipayPublicKey, "please set alipay_public_key first,when the sign_type is RSA2!");
            }

            return new AlipayCore(this);
        }

        private String getPrivateKey() {
            return privateKey;
        }

        /**
         * Sets private key.
         *
         * @param privateKey the private key
         * @return the private key
         */
        public ClientBuilder setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        private String getAlipayPublicKey() {
            return alipayPublicKey;
        }

        /**
         * Sets alipay public key.
         *
         * @param alipayPublicKey the alipay public key
         * @return the alipay public key
         */
        public ClientBuilder setAlipayPublicKey(String alipayPublicKey) {
            this.alipayPublicKey = alipayPublicKey;
            return this;
        }

        /**
         * Gets app id.
         *
         * @return the app id
         */
        public String getAppId() {
            return appId;
        }

        /**
         * Sets app id.
         *
         * @param appId the app id
         * @return the app id
         */
        public ClientBuilder setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        /**
         * Gets sign type.
         *
         * @return the sign type
         */
        String getSignType() {
            return signType;
        }

        /**
         * Sets sign type.
         *
         * @param signType the sign type
         * @return the sign type
         */
        public ClientBuilder setSignType(String signType) {
            this.signType = signType;
            return this;
        }
    }


    /***
     * 支付宝电脑网站支付，该操作会跳转到支付宝的支付页面中完成支付动作，以 异步/同步 的形式告知支付结果
     * @param request 支付参数对象
     * @return 返回支付宝页面, 直接输出在页面中 string
     * @throws Exception 程序异常
     */
    public String payInWebSite(AlipayWebSiteRequest request) throws Exception{

       log.debug("payInWebSite request={}" , request.toString());
        String form = "<font style='color: red'>请求支付宝超时,请稍后再试!</font>";

        try {

            Assert.notNull(builder, "payInWebSite-> Please set AlipayCore.ClientBuider first.");

            String bizContent = JsonUtil.beanToJsontring(request.getBizContent());
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
                    builder.getAppId(), builder.getPrivateKey(), "json", "utf-8", builder.getAlipayPublicKey(),builder.getSignType());
            AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
            alipayTradePagePayRequest.setReturnUrl(request.getReturnUrl());
            alipayTradePagePayRequest.setNotifyUrl(request.getNotifyUrl());
            alipayTradePagePayRequest.setBizContent(bizContent);
            form = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
        } catch (Exception e) {
            log.error(e);
            throw e;
        } finally {
           log.debug("payInWebSite response={}" , form);
        }

        return form;
    }




    /**
     * 查询支付订单.
     *
     * @param outTradeNo the out trade no
     * @return the alipay query response
     */
    public AlipayQueryResponse query(String outTradeNo) {

       log.debug("query outTradeNo={}", outTradeNo);
        AlipayQueryResponse response = new AlipayQueryResponse();

        try {
            Objects.requireNonNull(tradeService, "Please set AlipayCore.ClientBuider first and call build().");

            AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder()
                    .setOutTradeNo(outTradeNo);
            AlipayF2FQueryResult result = tradeService.queryTradeResult(builder);
            response.setSuccess(result.isTradeSuccess());

            response.setSubCode(result.getResponse().getSubCode());
            response.setSubMsg(result.getResponse().getSubMsg());
            response.setCode(result.getResponse().getCode());
            response.setMsg(result.getResponse().getMsg());

            switch (result.getTradeStatus()) {
                case SUCCESS:
                    BeanUtil.copyProperties(result.getResponse(),response);
                    response.setDesc("查询返回该订单信息成功");
                    response.setCode(result.getResponse().getCode());
                    response.setMsg(result.getResponse().getMsg());
                    break;
                case FAILED:
                    response.setDesc("查询返回该订单支付失败或被关闭!");
                    break;
                case UNKNOWN:
                    response.setDesc("系统异常，订单支付状态未知!");
                    break;
                default:
                    response.setDesc("不支持的交易状态，交易返回异常!");
                    break;
            }
        } catch (Exception e) {
            log.error(e);
            throw e;
        } finally {
           log.debug("query response={}" , response.toString());
        }
        return response;
    }


    /**
     * 支付宝退款，商户因业务原因需要退款时，可通过成功交易的商户订单号或支付宝交易号进行退款 ，支持部分退款。
     * 退款接口会根据外部请求号out_request_no幂等返回，因此同一笔需要多次部分退款时，必须使用不同的out_request_no
     *
     * @param request the request 退款参数
     * @return 退款结果 alipay refund response
     * @throws Exception the exception
     * @see <a href="https://docs.open.alipay.com/api_1/alipay.trade.refund">https://docs.open.alipay.com/api_1/alipay.trade.refund</a>
     */
    public AlipayRefundResponse refund(AlipayRefundRequest request) throws Exception{

       log.debug("refund request={}" , request.toString());

        AlipayRefundResponse response = new AlipayRefundResponse();

        try {
            Objects.requireNonNull(tradeService, "Please set AlipayCore.ClientBuider first and call build().");

            AlipayTradeRefundRequestBuilder builder = new AlipayTradeRefundRequestBuilder();

            if (StringUtils.isBlank(request.getOutTradeNo()) && StringUtils.isBlank(request.getTradeNo())){
                throw new Exception("trade_no , out_trade_no 不能同时为空");
            }
            if(StringUtils.isBlank(request.getRefundAmount())){
                throw new Exception("refundAmount 不能为空");
            }
            if (StringUtils.isNotBlank(request.getOutTradeNo())){
                builder.setOutTradeNo(request.getOutTradeNo());
            }
            if (StringUtils.isNotBlank(request.getTradeNo())){
                builder.setTradeNo(request.getTradeNo());
            }
            if (StringUtils.isNotBlank(request.getRefundReason())){
                builder.setRefundReason(request.getRefundReason());
            }
            if (StringUtils.isNotBlank(request.getStoreId())){
                builder.setStoreId(request.getStoreId());
            }
            if (StringUtils.isNotBlank(request.getOutRequestNo())){
                builder.setOutRequestNo(request.getOutRequestNo());
            }

            //trade_no , out_trade_no 不能同时存在,否则支付宝会报错ACQ.TRADE_STATUS_ERROR.交易状态不合法
            if (StringUtils.isNotBlank(builder.getOutTradeNo()) && StringUtils.isNotBlank(builder.getTradeNo())){
                builder.setTradeNo(null);
            }

            builder.setRefundAmount(request.getRefundAmount());
            AlipayF2FRefundResult result = tradeService.tradeRefund(builder);
            response.setSuccess(result.isTradeSuccess());
            response.setSubCode(result.getResponse().getSubCode());
            response.setSubMsg(result.getResponse().getSubMsg());
            response.setCode(result.getResponse().getCode());
            response.setMsg(result.getResponse().getMsg());

            switch (result.getTradeStatus()) {
                case SUCCESS:
                    BeanUtil.copyProperties(result.getResponse(),response);
                    response.setDesc("支付宝退款成功");
                    break;
                case FAILED:
                    response.setDesc("支付宝退款失败");
                    break;
                case UNKNOWN:
                    response.setDesc("系统异常，订单退款状态未知!");
                    break;
                default:
                    response.setDesc("不支持的交易状态，交易返回异常!");
                    break;
            }
        } catch (Exception e) {
            log.error(e);
            throw e;
        } finally {
           log.debug("refund response={}" , response.toString());
        }

        return response;
    }

    /**
     * 撤销订单
     *
     * @param outTradeNo the out trade no
     * @return the alipay cancel response
     */
    public AlipayCancelResponse cancel(String outTradeNo) {
        AlipayCancelResponse response = new AlipayCancelResponse();

        try {

            Objects.requireNonNull(tradeService, "Please set AlipayCore.ClientBuider first and call build().");

            AlipayTradeCancelRequestBuilder builder = new AlipayTradeCancelRequestBuilder();
            builder.setOutTradeNo(outTradeNo);

            AlipayF2FCancelResult result = tradeService.tradeCancel_II(builder);
            response.setSuccess(result.isTradeSuccess());
            switch (result.getTradeStatus()) {
                case SUCCESS:
                    BeanUtil.copyProperties(result.getResponse(),response);
                    response.setDesc("支付宝撤销成功");
                    response.setCode(result.getResponse().getCode());
                    response.setMsg(result.getResponse().getMsg());
                    break;
                case FAILED:
                    response.setDesc("支付宝撤销失败");
                    response.setSubCode(result.getResponse().getSubCode());
                    response.setSubMsg(result.getResponse().getSubMsg());
                    response.setCode(result.getResponse().getCode());
                    response.setMsg(result.getResponse().getMsg());
                    break;
                case UNKNOWN:
                    response.setDesc("系统异常，订单撤销状态未知!");
                    response.setSubCode(result.getResponse().getSubCode());
                    response.setSubMsg(result.getResponse().getSubMsg());
                    response.setCode(result.getResponse().getCode());
                    response.setMsg(result.getResponse().getMsg());
                    break;
                default:
                    response.setDesc("不支持的交易状态，交易返回异常!");
                    response.setSubCode(result.getResponse().getSubCode());
                    response.setSubMsg(result.getResponse().getSubMsg());
                    response.setCode(result.getResponse().getCode());
                    response.setMsg(result.getResponse().getMsg());
                    break;
            }
        } catch (Exception e) {
            log.error(e);
            throw e;
        }finally {
           log.debug("cancel response={}",response.toString());
        }

        return response;

    }

}

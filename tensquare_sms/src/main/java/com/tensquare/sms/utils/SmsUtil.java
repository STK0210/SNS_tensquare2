package com.tensquare.sms.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @auther likeyu
 * @create 2019-09-06-15:01
 **/
@Component
public class SmsUtil {

    //系统规定参数。取值：SendSms
    static final String action = "SendSms";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
    //产品版本
    static final String version = "2017-05-25";

    @Autowired
    private Environment env;

    public CommonResponse send(String mobile, String template_code, String sign_name, String param) throws ClientException {
        String accessKeyId = env.getProperty("aliyun.sms.accessKeyId");
        String accessSecret = env.getProperty("aliyun.sms.accessKeySecret");

        DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion(version);
        request.setAction(action);
        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", sign_name);
        request.putQueryParameter("TemplateCode", template_code);
        request.putQueryParameter("TemplateParam", param);

        CommonResponse response = client.getCommonResponse(request);
        return response;
    }
}
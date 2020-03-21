//package Aamir.utils;
//
///**
// * @author peiyunluo@icloud.com
// * @date 2020/3/19 10:45
// */
//
//import com.tencentcloudapi.common.Credential;
//import com.tencentcloudapi.common.exception.TencentCloudSDKException;
//import com.tencentcloudapi.common.profile.ClientProfile;
//import com.tencentcloudapi.common.profile.HttpProfile;
//import com.tencentcloudapi.nlp.v20190408.NlpClient;
//import com.tencentcloudapi.nlp.v20190408.models.AutoSummarizationRequest;
//import com.tencentcloudapi.nlp.v20190408.models.AutoSummarizationResponse;
//
//public class AutoSummarization
//{
//    public static void main(String [] args) {
//        try{
//
//            Credential cred = new Credential("AKIDEExUUL2F3buxkF4d8Q4YomskLjrisk27", "0B57sNirjMUO2Wt6C91Ys1B67yeE8rOh");
//
//            HttpProfile httpProfile = new HttpProfile();
//            httpProfile.setEndpoint("nlp.tencentcloudapi.com");
//
//            ClientProfile clientProfile = new ClientProfile();
//            clientProfile.setHttpProfile(httpProfile);
//
//            NlpClient client = new NlpClient(cred, "ap-beijing", clientProfile);
//
//            String params = "{\"Length\":200,\"Text\":\"中新经纬客户端4月4日电 中方于3月31日宣布对美国进口汽车及零部件暂停加征关税3个月，商务部发言人高峰4日在例行记者会上表示，3月5日，美方正式宣布再次推迟对中国输美产品加征关税税率提升至25%的期限。双方上述决定有助于为中美经贸磋商创造良好的氛围。发布会上，高峰表示，中美两国元首在G20阿根廷峰会期间举行会晤，就经贸问题达成重要共识。作为两国元首共识的一部分，美方对中国输美产品加征关税税率提升至25%的期限从2019年1月1日推迟到3月2日。之后，为推动磋商，中方宣布对原产于美国的汽车及零部件暂停加征关税3个月，截止日期为3月31日。3月5日，美方正式宣布再次推迟对中国输美产品加征关税税率提升至25%的期限，具体期限另行通知。3月31日，中国国务院关税税则委员会宣布延长对原产于美国的汽车及零部件暂停加征关税措施，截止日期另行通知。高峰指出，双方上述决定无疑有助于为中美经贸磋商创造良好的氛围。\"}";
//            AutoSummarizationRequest req = AutoSummarizationRequest.fromJsonString(params, AutoSummarizationRequest.class);
//
//            AutoSummarizationResponse resp = client.AutoSummarization(req);
//
//            System.out.println(AutoSummarizationRequest.toJsonString(resp));
//        } catch (TencentCloudSDKException e) {
//            System.out.println(e.toString());
//        }
//
//    }
//
//}
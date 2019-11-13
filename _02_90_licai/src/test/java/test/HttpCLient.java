package test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

public class HttpCLient {

    @Test
    public void testHttp() {




        HttpClient httpClient = new DefaultHttpClient();
//        // 连接时间
//        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTimeout);
//        // 数据传输时间
//        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, soTimeout);
        // Get请求
        HttpGet httpget = new HttpGet("https://stock.xueqiu.com/v5/stock/chart/kline.json?symbol=SH510500&begin=1072800000000&end=1573653130085&period=day&type=before&indicator=kline");
        try
        {
            // for version 4.3+ 设置请求和传输超时时间
            // RequestConfig requestConfig =
            // RequestConfig.custom().setSocketTimeout(2000)
            // .setConnectTimeout(2000).build();
            // httpget.setConfig(requestConfig);

            // 设置参数
//            String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
//            httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
            // 发送请求


            httpget.setHeader("Cookie", "device_id=24700f9f1986800ab4fcc880530dd0ed; xq_a_token=5e0d8a38cd3acbc3002589f46fc1572c302aa8a2; xq_a_token.sig=ZvtaY2gpozjtDgM9XQBm-U6v7VE; xq_r_token=670668eda313118d7214487d800c21ad0202e141; xq_r_token.sig=nB5LZeMGKYGGQHzx5fGb8InoJlQ; xqat=5e0d8a38cd3acbc3002589f46fc1572c302aa8a2; xqat.sig=HJXN1BVd98YfFXpmbPKXMmSNL60; u=781573651440801; Hm_lvt_1db88642e346389874251b5a1eded6e3=1573570757,1573653118; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1573653118");


            HttpResponse httpResponse = httpClient.execute(httpget);

            int statusCode = httpResponse.getStatusLine().getStatusCode();

            System.out.println("status->" + statusCode);


            if (statusCode != HttpStatus.SC_OK)
            {
//                LOGGER.error("Method failed:" + httpResponse.getStatusLine());
            }

            // 获取返回数据
            HttpEntity entity = httpResponse.getEntity();
            String body = EntityUtils.toString(entity, Charset.forName("UTF-8"));

            System.out.println("body->" + body);

            if (entity != null)
            {
                EntityUtils.consume(entity);
            }
//            LOGGER.info(String.format("do http get end:%s", System.currentTimeMillis()));
//            LOGGER.debug(String.format("http get response:%s", body));
//            return new MyHttpResponse(statusCode, body, httpget.getURI().toString());
        } catch (ParseException e)
        {

        } catch (UnsupportedEncodingException e)
        {

        } catch (IOException e)
        {

        } finally
        {
            // try
            // {
            // // for 4.3+
            // httpClient.close();
            // } catch (IOException e)
            // {
            // LOGGER.error("close httpclient error!", e);
            // }
            httpget.releaseConnection();
            httpClient.getConnectionManager().shutdown();
        }

    }
}

package com.smhdemo.ticket.standby.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhdemo.common.query.DataGrid;
import com.smhdemo.common.query.DataGridModel;
import com.smhdemo.ticket.standby.vo.TicketInfo;
import com.smhdemo.web.BaseController;

@Controller
@RequestMapping(value = "/ticket/standby")
public class StandbyQueryController extends BaseController{

	@Override
	protected String getPagePath() {
		return "ticket/standby";
	}
	
	@RequestMapping(value = "/index")
	public String index() {
		return getForwardPage("index");
	}
	
	@RequestMapping(value = "/query")
	@ResponseBody
	public Object querty(@ModelAttribute DataGridModel model) {
		Map<String, String> parameters = model.getParameters();
		String flightLineName = parameters.get("flightLineName");
		String flightDate = parameters.get("flightDate");
		CloseableHttpClient httpClient = HttpClients.createDefault();
        //配置超时时间
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(1000).setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000).setRedirectsEnabled(true).build();
         
        HttpPost httpPost = new HttpPost("https://e.xmferry.com/dailyFlightQuery.do");
        //设置超时时间
        httpPost.setConfig(requestConfig);
        //装配post请求参数
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>(); 
        list.add(new BasicNameValuePair("flightLineName", flightLineName));  //请求参数
        list.add(new BasicNameValuePair("flightDate", flightDate)); //请求参数
        List<TicketInfo> resultList = new ArrayList<TicketInfo>();
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8"); 
            //设置post求情参数
            httpPost.setEntity(entity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            String strResult = "";
            if(httpResponse != null){ 
                httpResponse.getStatusLine().getStatusCode();
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    strResult = EntityUtils.toString(httpResponse.getEntity());
                } else if (httpResponse.getStatusLine().getStatusCode() == 400) {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } else if (httpResponse.getStatusLine().getStatusCode() == 500) {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } else {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } 
            }else{
                 
            }
            System.out.println(strResult);
            Document doc = Jsoup.parse(strResult);
            
            
        	// 使用选择器选择该table内所有的<tr> <tr/>
            Elements trs = doc.select("table").select("tr");
        	//遍历该表格内的所有的<tr> <tr/>
        	for (int i = 1; i < trs.size(); i=i+2) {
        		TicketInfo vo = new TicketInfo();
        		// 获取一个tr
        		Element tr = trs.get(i);
        		// 获取该行的所有td节点
        		Elements tds = tr.select("td");
        		// 选择某一个td节点
        		for (int j = 0; j < tds.size(); j++) {
        			if(j==1){
        				vo.setDeparturePier(tds.get(j).text());
        			} else if(j==2){
        				vo.setArrivalPier(tds.get(j).text());
        			}else if(j==3){
        				vo.setFlightNumber(tds.get(j).text());
        			}else if(j==4){
        				vo.setFlightTime(tds.get(j).text());
        			}else if(j==5){
        				vo.setBoatPort(tds.get(j).text());
        			}else if(j==6){
        				vo.setPrice(Double.valueOf(tds.get(j).text()));
        			}else if(j==7){
        				vo.setNumber(Integer.valueOf(tds.get(j).text()));
        			}
        			
        		}
        		resultList.add(vo);
        	}          
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(httpClient != null){
                    httpClient.close(); //释放资源
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new DataGrid(resultList.size(), resultList);
	}
}

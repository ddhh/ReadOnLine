package com.ddhh.readonline.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ddhh.readonline.bean.IndexBean;
import com.ddhh.readonline.bean.SearchResultBean;
import com.ddhh.readonline.common.Constant;

public class JsoupUtil {

	public static List<SearchResultBean> paraseHtmlToResult(String html) {

		List<SearchResultBean> list = new ArrayList<SearchResultBean>();
		Document doc = Jsoup.parse(html);
		Elements items = doc.select("div.result-item");
		for (Element e : items) {
			SearchResultBean ri = new SearchResultBean();
			String src = e.select("img").attr("src");
			if (!src.startsWith("http")) {
				ri.setCrossUrl(Constant.BASE_SEARCH_URL
						+ "/static/img/novel-noimg.jpg");
			} else {
				ri.setCrossUrl(src);
			}
			ri.setName(e.select("h3").text());
			ri.setDesc(e.select("p.result-game-item-desc").text());
			Element item_info = e.select("div.result-game-item-info").first();
			Elements ps = item_info.select("p");

			ri.setAuthor(ps.get(0).text());
			ri.setType(ps.get(1).text());
			ri.setTime(ps.get(2).text());
			ri.setSection(ps.get(3).text());
			String temp_url = e.select("a").attr("href");
			ri.setId(Pattern.compile("[^0-9]").matcher(temp_url).replaceAll(""));
			list.add(ri);
		}
		return list;
	}

	public static List<IndexBean> paraseHtmlToIndex(String html) {
		List<IndexBean> list = new ArrayList<IndexBean>();
		
		Document doc = Jsoup.parse(html);
		Elements es = doc.select("div.bgg");
		for (Element e : es) {
			IndexBean ib = new IndexBean();
			ib.setSection_url(Constant.BASE_URL + e.select("a").attr("href"));
			ib.setSection(e.text());
			list.add(ib);
		}
		return list;
	}

	public static String paraseHtmlToContent(String html){
		String content = "";
		Document doc = Jsoup.parse(html);
		Element e = doc.select("div.nr_nr").first();
		content = e.toString();
		System.out.println(content);
		return content;
	}
	
	
}

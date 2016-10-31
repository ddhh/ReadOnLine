package com.ddhh.readonline.common;

import java.util.ArrayList;
import java.util.List;

public class Constant {

	public static final String BASE_URL = "http://m.qu.la";

	public static final String BASE_SEARCH_URL = "http://zhannei.baidu.com/cse/search";
	public static final String S = "920895234054625192";

	public static final List<String> TV_LIST = new ArrayList<String>();

	public static final String BASE_TV_URL = "http://61.166.153.30:1180/live/";
	public static final String[] TV_NAME = { "CCTV-1综合", "CCTV-2财经", "CCTV-国际",
			"CCTV-5+赛事", "CCTV-7军农", "CCTV-9记录", "CCTV-10科教", "CCTV-14少儿",
			"浙江卫视", "湖南卫视", "东方卫视", "江苏卫视", "北京卫视", "深圳卫视", "天津卫视", "安徽卫视",
			"湖北卫视", "黑龙江卫视", "山东卫视", "辽宁卫视", "云南卫视" };

	static {
		for (int i = 0; i < TV_NAME.length; i++) {
			int index = i+63;
			if(index>=70){
				index++;
			}
			TV_LIST.add(new String(BASE_TV_URL + "live1000" + index+ ".m3u8"));
			System.out.println(TV_LIST.get(i));
		}
	}
	/*
	 * CCTV-1综合,http://61.166.153.30:1180/live/live100063.m3u8
	 * CCTV-2财经,http://61.166.153.30:1180/live/live100064.m3u8
	 * CCTV-国际,http://61.166.153.30:1180/live/live100065.m3u8
	 * CCTV-5+赛事,http://61.166.153.30:1180/live/live100066.m3u8
	 * CCTV-7军农,http://61.166.153.30:1180/live/live100067.m3u8
	 * CCTV-9记录,http://61.166.153.30:1180/live/live100068.m3u8
	 * CCTV-10科教,http://61.166.153.30:1180/live/live100069.m3u8
	 * CCTV-14少儿,http://61.166.153.30:1180/live/live100071.m3u8
	 * 浙江卫视,http://61.166.153.30:1180/live/live100072.m3u8
	 * 湖南卫视,http://61.166.153.30:1180/live/live100073.m3u8
	 * 东方卫视,http://61.166.153.30:1180/live/live100074.m3u8
	 * 江苏卫视,http://61.166.153.30:1180/live/live100075.m3u8
	 * 北京卫视,http://61.166.153.30:1180/live/live100076.m3u8
	 * 深圳卫视,http://61.166.153.30:1180/live/live100077.m3u8
	 * 天津卫视,http://61.166.153.30:1180/live/live100078.m3u8
	 * 安徽卫视,http://61.166.153.30:1180/live/live100079.m3u8
	 * 湖北卫视,http://61.166.153.30:1180/live/live100080.m3u8
	 * 黑龙江卫视,http://61.166.153.30:1180/live/live100081.m3u8
	 * 山东卫视,http://61.166.153.30:1180/live/live100082.m3u8
	 * 辽宁卫视,http://61.166.153.30:1180/live/live100083.m3u8
	 * 云南卫视,http://61.166.153.30:1180/live/live100097.m3u8
	 */
}

package com.sen.netty.study.JsonTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Sen
 * @Date: 2020/5/23 22:28
 * @Description: 解析DIV数据
 */
public class ParseJsonTest {

    @Test
    public void parseJson() {
        String str = "{\"diyPhone\": [\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"\\u641c\\u7d22\\u6846\",\n" +
                "\t\t\t\t\t\t\"type\": \"search\",\n" +
                "\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"placeholder\": \"\\u8bf7\\u8f93\\u5165\\u5173\\u952e\\u5b57\\u8fdb\\u884c\\u641c\\u7d22\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"textAlign\": \"left\",\n" +
                "\t\t\t\t\t\t\t\"searchStyle\": \"square\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"\\u56fe\\u7247\\u8f6e\\u64ad\",\n" +
                "\t\t\t\t\t\t\"type\": \"banner\",\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"btnColor\": \"#ffffff\",\n" +
                "\t\t\t\t\t\t\t\"btnShape\": \"round\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"interval\": \"2800\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/banner\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/banner\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"\\u5355\\u56fe\\u7ec4\",\n" +
                "\t\t\t\t\t\t\"type\": \"imageSingle\",\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"paddingTop\": 0,\n" +
                "\t\t\t\t\t\t\t\"paddingLeft\": 0,\n" +
                "\t\t\t\t\t\t\t\"background\": \"#ffffff\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/banner\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"imgName\": \"image-1.jpg\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/banner\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"imgName\": \"banner-2.jpg\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t},\n" +
                "\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"视频组\",\n" +
                "\t\t\t\t\t\t\"type\": \"video\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"videoUrl\": \"http:\\/\\/wxsnsdy.tc.qq.com\\/105\\/20210\\/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400\",\n" +
                "\t\t\t\t\t\t\t\"poster\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/video_poster.png\",\n" +
                "\t\t\t\t\t\t\t\"autoplay\": \"0\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"paddingTop\": \"0\",\n" +
                "\t\t\t\t\t\t\t\"height\": \"190\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"文章组\",\n" +
                "\t\t\t\t\t\t\"type\": \"article\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"source\": \"auto\",\n" +
                "\t\t\t\t\t\t\t\"auto\": {\n" +
                "\t\t\t\t\t\t\t\t\"category\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"showNum\": 6\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": [],\n" +
                "\t\t\t\t\t\t\"defaultData\": [{\n" +
                "\t\t\t\t\t\t\t\"article_title\": \"此处显示文章标题\",\n" +
                "\t\t\t\t\t\t\t\"show_type\": 10,\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/article\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"views_num\": \"309\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"article_title\": \"此处显示文章标题\",\n" +
                "\t\t\t\t\t\t\t\"show_type\": 10,\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/article\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"views_num\": \"309\"\n" +
                "\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\"data\": []\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"图片橱窗\",\n" +
                "\t\t\t\t\t\t\"type\": \"window\",\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"paddingTop\": \"0\",\n" +
                "\t\t\t\t\t\t\t\"paddingLeft\": \"0\",\n" +
                "\t\t\t\t\t\t\t\"background\": \"#ffffff\",\n" +
                "\t\t\t\t\t\t\t\"layout\": \"2\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/window\\/01.jpg\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/window\\/02.jpg\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/window\\/03.jpg\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/window\\/04.jpg\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\"\n" +
                "\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\"dataNum\": 4\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"头条快报\",\n" +
                "\t\t\t\t\t\t\"type\": \"special\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"source\": \"auto\",\n" +
                "\t\t\t\t\t\t\t\"auto\": {\n" +
                "\t\t\t\t\t\t\t\t\"category\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"showNum\": 6\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"display\": \"1\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/special.png\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"defaultData\": [{\n" +
                "\t\t\t\t\t\t\t\"article_title\": \"张小龙4小时演讲：你和高手之间，隔着“简单”二字\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"article_title\": \"张小龙4小时演讲：你和高手之间，隔着“简单”二字\"\n" +
                "\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\"data\": []\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"公告组\",\n" +
                "\t\t\t\t\t\t\"type\": \"notice\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"text\": \"这里是第一条自定义公告的标题\",\n" +
                "\t\t\t\t\t\t\t\"icon\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/notice.png\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"paddingTop\": \"4\",\n" +
                "\t\t\t\t\t\t\t\"background\": \"#ffffff\",\n" +
                "\t\t\t\t\t\t\t\"textColor\": \"#000000\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"导航组\",\n" +
                "\t\t\t\t\t\t\"type\": \"navBar\",\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"background\": \"#ffffff\",\n" +
                "\t\t\t\t\t\t\t\"rowsNum\": \"4\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/navbar\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"imgName\": \"icon-1.png\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\",\n" +
                "\t\t\t\t\t\t\t\"text\": \"按钮文字1\",\n" +
                "\t\t\t\t\t\t\t\"color\": \"#666666\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/navbar\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"imgName\": \"icon-2.jpg\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\",\n" +
                "\t\t\t\t\t\t\t\"text\": \"按钮文字2\",\n" +
                "\t\t\t\t\t\t\t\"color\": \"#666666\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/navbar\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"imgName\": \"icon-3.jpg\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\",\n" +
                "\t\t\t\t\t\t\t\"text\": \"按钮文字3\",\n" +
                "\t\t\t\t\t\t\t\"color\": \"#666666\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"imgUrl\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/navbar\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"imgName\": \"icon-4.jpg\",\n" +
                "\t\t\t\t\t\t\t\"linkUrl\": \"\",\n" +
                "\t\t\t\t\t\t\t\"text\": \"按钮文字4\",\n" +
                "\t\t\t\t\t\t\t\"color\": \"#666666\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"商品组\",\n" +
                "\t\t\t\t\t\t\"type\": \"goods\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"source\": \"auto\",\n" +
                "\t\t\t\t\t\t\t\"auto\": {\n" +
                "\t\t\t\t\t\t\t\t\"category\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"goodsSort\": \"all\",\n" +
                "\t\t\t\t\t\t\t\t\"showNum\": 6\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"background\": \"#F6F6F6\",\n" +
                "\t\t\t\t\t\t\t\"display\": \"list\",\n" +
                "\t\t\t\t\t\t\t\"column\": \"2\",\n" +
                "\t\t\t\t\t\t\t\"show\": {\n" +
                "\t\t\t\t\t\t\t\t\"goodsName\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"goodsPrice\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"linePrice\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"sellingPoint\": \"0\",\n" +
                "\t\t\t\t\t\t\t\t\"goodsSales\": \"0\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"defaultData\": [\n" +
                "\t\t\t\t\t\t{\"goods_name\": \"此处显示商品名称\"}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处显示商品名称\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"goods_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"goods_sales\": \"100\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处显示商品名称\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"goods_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"goods_sales\": \"100\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处显示商品名称\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"goods_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"goods_sales\": \"100\"\n" +
                "\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处显示商品名称\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"goods_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"goods_sales\": \"100\",\n" +
                "\t\t\t\t\t\t\t\"is_default\": true\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处显示商品名称\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"goods_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"goods_sales\": \"100\",\n" +
                "\t\t\t\t\t\t\t\"is_default\": true\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"优惠券组\",\n" +
                "\t\t\t\t\t\t\"type\": \"coupon\",\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"paddingTop\": \"10\",\n" +
                "\t\t\t\t\t\t\t\"background\": \"#ffffff\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"limit\": \"5\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"color\": \"red\",\n" +
                "\t\t\t\t\t\t\t\"reduce_price\": \"10\",\n" +
                "\t\t\t\t\t\t\t\"min_price\": \"100.00\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"color\": \"violet\",\n" +
                "\t\t\t\t\t\t\t\"reduce_price\": \"10\",\n" +
                "\t\t\t\t\t\t\t\"min_price\": \"100.00\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"拼团商品组\",\n" +
                "\t\t\t\t\t\t\"type\": \"sharingGoods\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"source\": \"auto\",\n" +
                "\t\t\t\t\t\t\t\"auto\": {\n" +
                "\t\t\t\t\t\t\t\t\"category\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"goodsSort\": \"all\",\n" +
                "\t\t\t\t\t\t\t\t\"showNum\": 6\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"background\": \"#F6F6F6\",\n" +
                "\t\t\t\t\t\t\t\"show\": {\n" +
                "\t\t\t\t\t\t\t\t\"goodsName\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"sellingPoint\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"sharingPrice\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"linePrice\": \"1\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"defaultData\": [{\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是拼团商品\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 性价比较高 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"sharing_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是拼团商品\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 性价比较高 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"goods_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是拼团商品\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 性价比较高 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"sharing_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是拼团商品\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 性价比较高 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"sharing_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是拼团商品\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 性价比较高 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"sharing_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\",\n" +
                "\t\t\t\t\t\t\t\"is_default\": true\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是拼团商品\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"selling_point\": \"此款商品美观大方 性价比较高 不容错过\",\n" +
                "\t\t\t\t\t\t\t\"sharing_price\": \"99.00\",\n" +
                "\t\t\t\t\t\t\t\"line_price\": \"139.00\",\n" +
                "\t\t\t\t\t\t\t\"is_default\": true\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"砍价商品组\",\n" +
                "\t\t\t\t\t\t\"type\": \"bargainGoods\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"source\": \"auto\",\n" +
                "\t\t\t\t\t\t\t\"auto\": {\n" +
                "\t\t\t\t\t\t\t\t\"category\": 0,\n" +
                "\t\t\t\t\t\t\t\t\"goodsSort\": \"all\",\n" +
                "\t\t\t\t\t\t\t\t\"showNum\": 6\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"background\": \"#F6F6F6\",\n" +
                "\t\t\t\t\t\t\t\"show\": {\n" +
                "\t\t\t\t\t\t\t\t\"goodsName\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"peoples\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"floorPrice\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"originalPrice\": \"1\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"demo\": {\n" +
                "\t\t\t\t\t\t\t\"helps_count\": 2,\n" +
                "\t\t\t\t\t\t\t\"helps\": [{\n" +
                "\t\t\t\t\t\t\t\t\"avatarUrl\": \"http:\\/\\/tva1.sinaimg.cn\\/large\\/0060lm7Tly1g4c7zrytvvj30dw0dwwes.jpg\"\n" +
                "\t\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\t\"avatarUrl\": \"http:\\/\\/tva1.sinaimg.cn\\/large\\/0060lm7Tly1g4c7zs2u5ej30b40b4dfx.jpg\"\n" +
                "\t\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"defaultData\": [{\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是砍价商品\",\n" +
                "\t\t\t\t\t\t\t\"goods_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"floor_price\": \"0.01\",\n" +
                "\t\t\t\t\t\t\t\"original_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是砍价商品\",\n" +
                "\t\t\t\t\t\t\t\"goods_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"floor_price\": \"0.01\",\n" +
                "\t\t\t\t\t\t\t\"original_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是砍价商品\",\n" +
                "\t\t\t\t\t\t\t\"goods_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"floor_price\": \"0.01\",\n" +
                "\t\t\t\t\t\t\t\"original_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是砍价商品\",\n" +
                "\t\t\t\t\t\t\t\"goods_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"floor_price\": \"0.01\",\n" +
                "\t\t\t\t\t\t\t\"original_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"秒杀商品组\",\n" +
                "\t\t\t\t\t\t\"type\": \"sharpGoods\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"showNum\": 6\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"background\": \"#ffffff\",\n" +
                "\t\t\t\t\t\t\t\"column\": \"3\",\n" +
                "\t\t\t\t\t\t\t\"show\": {\n" +
                "\t\t\t\t\t\t\t\t\"goodsName\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"seckillPrice\": \"1\",\n" +
                "\t\t\t\t\t\t\t\t\"originalPrice\": \"1\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是秒杀商品\",\n" +
                "\t\t\t\t\t\t\t\"goods_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"seckill_price\": \"69.00\",\n" +
                "\t\t\t\t\t\t\t\"original_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是秒杀商品\",\n" +
                "\t\t\t\t\t\t\t\"goods_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"seckill_price\": \"69.00\",\n" +
                "\t\t\t\t\t\t\t\"original_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"goods_name\": \"此处是秒杀商品\",\n" +
                "\t\t\t\t\t\t\t\"goods_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/goods\\/01.png\",\n" +
                "\t\t\t\t\t\t\t\"seckill_price\": \"69.00\",\n" +
                "\t\t\t\t\t\t\t\"original_price\": \"139.00\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"线下门店\",\n" +
                "\t\t\t\t\t\t\"type\": \"shop\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"source\": \"auto\",\n" +
                "\t\t\t\t\t\t\t\"auto\": {\n" +
                "\t\t\t\t\t\t\t\t\"showNum\": 6\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": [],\n" +
                "\t\t\t\t\t\t\"defaultData\": [{\n" +
                "\t\t\t\t\t\t\t\"shop_name\": \"此处显示门店名称\",\n" +
                "\t\t\t\t\t\t\t\"logo_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/circular.png\",\n" +
                "\t\t\t\t\t\t\t\"phone\": \"010-6666666\",\n" +
                "\t\t\t\t\t\t\t\"region\": {\n" +
                "\t\t\t\t\t\t\t\t\"province\": \"xx省\",\n" +
                "\t\t\t\t\t\t\t\t\"city\": \"xx市\",\n" +
                "\t\t\t\t\t\t\t\t\"region\": \"xx区\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"address\": \"xx街道\"\n" +
                "\t\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\t\"shop_name\": \"此处显示门店名称\",\n" +
                "\t\t\t\t\t\t\t\"logo_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/circular.png\",\n" +
                "\t\t\t\t\t\t\t\"phone\": \"010-6666666\",\n" +
                "\t\t\t\t\t\t\t\"region\": {\n" +
                "\t\t\t\t\t\t\t\t\"province\": \"xx省\",\n" +
                "\t\t\t\t\t\t\t\t\"city\": \"xx市\",\n" +
                "\t\t\t\t\t\t\t\t\"region\": \"xx区\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"address\": \"xx街道\"\n" +
                "\t\t\t\t\t\t}],\n" +
                "\t\t\t\t\t\t\"data\": [{\n" +
                "\t\t\t\t\t\t\t\"shop_name\": \"此处显示门店名称\",\n" +
                "\t\t\t\t\t\t\t\"logo_image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/circular.png\",\n" +
                "\t\t\t\t\t\t\t\"phone\": \"010-6666666\",\n" +
                "\t\t\t\t\t\t\t\"region\": {\n" +
                "\t\t\t\t\t\t\t\t\"province\": \"xx省\",\n" +
                "\t\t\t\t\t\t\t\t\"city\": \"xx市\",\n" +
                "\t\t\t\t\t\t\t\t\"region\": \"xx区\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"address\": \"xx街道\"\n" +
                "\t\t\t\t\t\t}]\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"辅助空白\",\n" +
                "\t\t\t\t\t\t\"type\": \"blank\",\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"height\": \"20\",\n" +
                "\t\t\t\t\t\t\t\"background\": \"#ffffff\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"在线客服\",\n" +
                "\t\t\t\t\t\t\"type\": \"service\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"type\": \"chat\",\n" +
                "\t\t\t\t\t\t\t\"image\": \"https:\\/\\/pinying.qhfkj.xyz\\/assets\\/store\\/img\\/diy\\/service.png\",\n" +
                "\t\t\t\t\t\t\t\"phone_num\": \"\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"right\": \"1\",\n" +
                "\t\t\t\t\t\t\t\"bottom\": \"10\",\n" +
                "\t\t\t\t\t\t\t\"opacity\": \"100\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"富文本\",\n" +
                "\t\t\t\t\t\t\"type\": \"richText\",\n" +
                "\t\t\t\t\t\t\"params\": {\n" +
                "\t\t\t\t\t\t\t\"content\": \"<p>这里是文本的内容<\\/p>\"\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"paddingTop\": \"0\",\n" +
                "\t\t\t\t\t\t\t\"paddingLeft\": \"0\",\n" +
                "\t\t\t\t\t\t\t\"background\": \"#ffffff\"\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"name\": \"辅助线\",\n" +
                "\t\t\t\t\t\t\"type\": \"guide\",\n" +
                "\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\"background\": \"#ffffff\",\n" +
                "\t\t\t\t\t\t\t\"lineStyle\": \"solid\",\n" +
                "\t\t\t\t\t\t\t\"lineHeight\": \"1\",\n" +
                "\t\t\t\t\t\t\t\"lineColor\": \"#000000\",\n" +
                "\t\t\t\t\t\t\t\"paddingTop\": 10\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t}\n" +
                "\n" +
                "\t\t\t\t]}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        String jsonObjectString = jsonObject.toString();
        System.out.println(jsonObjectString);
        System.out.println(jsonObjectString.length());
    }

    @Test
    public void objToJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 12);
        map.put("name", "zhangsan");
        List<String> list = new ArrayList<>();
        list.add("asdf");
        list.add("435sadf");
        list.add("cvbf");
        Map<String,Object> property = new HashMap<>();
        property.put("nickname", "haha");
        property.put("sex", "男");
        List<Object> objectList = new ArrayList<>();
        objectList.add(property);
        Map<String,Object> property2 = new HashMap<>();
        property2.put("nickname", "非常咖啡");
        property2.put("sex", "男");
        objectList.add(property2);
        map.put("data", objectList);
        map.put("list", list);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
    }
}

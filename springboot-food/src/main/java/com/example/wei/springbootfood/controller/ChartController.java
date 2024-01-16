package com.example.wei.springbootfood.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wei.springbootfood.model.dto.ProductAnalyze;

@RestController()
@RequestMapping("/chart")
public class ChartController {

	/**
	 * let meals = [
			[ '餐點', '銷售量', {role : 'style'} ],
			[ '漢堡', 300, 'color: #3366cc' ], 
			[ '捲餅', 500, 'color: #dc3912' ],
			[ '炸雞', 400, 'color: #ff9900' ],
			[ '炒飯', 600, 'color: #109618' ],
			[ '薯條', 250, 'color: #990099' ]
		];
	 * 
	 * 撈資料：
	 *  select p.PRODUCT_NAME as "產品名稱", sum(m.TOTAL) as "銷售金額"
		from trx_main m, trx_detail d, product p
		where m.TRX_ID = d.TRX_ID and p.PRODUCT_ID = d.PRODUCT_ID
		group by p.PRODUCT_NAME;
	 * 
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object[]> getChart() {
		
		// 統計欄位所需要的Header資訊
		LinkedHashMap<String, String> role = new LinkedHashMap<>();
		role.put("role", "style");
		Object[] header = new Object[] {
			"餐點", "銷售量", role
		};
		
		List<Object[]> data = new ArrayList<Object[]>();
		data.add(header);
		
		// 現在是寫死的，這邊要去資料庫動態取得
		ProductAnalyze p1 = ProductAnalyze.builder().name("漢堡").amount(300).color("color: #3366cc").build();
		ProductAnalyze p2 = ProductAnalyze.builder().name("捲餅").amount(500).color("color: #dc3912").build();
		ProductAnalyze p3 = ProductAnalyze.builder().name("炸雞").amount(400).color("color: #ff9900").build();
		ProductAnalyze p4 = ProductAnalyze.builder().name("炒飯").amount(600).color("color: #109618").build();
		ProductAnalyze p5 = ProductAnalyze.builder().name("薯條").amount(250).color("color: #990099").build();
		
		data.add(p1.getData());
		data.add(p2.getData());
		data.add(p3.getData());
		data.add(p4.getData());
		data.add(p5.getData());
		
		return data;
	}
}

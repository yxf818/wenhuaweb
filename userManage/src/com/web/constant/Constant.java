package com.web.constant;

public interface Constant {
	/*
	 * 用户未激活
	 */
	int USER_IS_NOT_ACTIVE = 0;
	
	/*
	 * 用户已激活
	 */
	int USER_IS_ACTIVE = 1;
	
	/*
	 * 记住用户名
	 */
	String SAVA_NAME = "remb";
	
	/*
	 * 是否热门
	 */
	int PRODUCT_IS_HAO = 1;
	
	/*
	 * 商品已下架
	 */
	int PRODUCT_IS_UP = 0;
	/*
	 * 商品未下架
	 */
	int PRODUCT_IS_DOWM = 1;
	/*
	 * 付款状态
	 */
	int ORDER_WEIFUKUAN = 0;
	int ORDER_YIFUKUAN = 1;
	int ORDER_YIFAHUO = 2;
	int ORDER_YIWANCHENG = 3;
}

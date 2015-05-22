package com.liuchsh.lab;

import org.junit.Test;

/**
 * 微信红包的算法实现探讨：
 * 1、每个人都要能够领取到红包；
 * 2、每个人领取到的红包金额总和=总金额；
 * 3、每个人领取到的红包金额不等，但也不能差的太离谱，不然就没趣味；
 * 4、算法一定要简单，不然对不起腾讯这个招牌；
 * @author lcs
 * 参考：http://www.zhihu.com/question/22625187
 */
public class WechatMoney {
	
	@Test
	public void luckyRed() {
		double total_money = 10.0; // 红包总金额
		int total_people = 8; // 抢红包总人数
		double min_money = 0.01; // 每个人最少能收到0.01元

		for (int i = 0; i < total_people - 1; i++) {
			int j = i + 1;
			double safe_money = (total_money - (total_people - j) * min_money)
					/ (total_people - j);
			double tmp_money = (Math.random()
					* (safe_money * 100 - min_money * 100) + min_money * 100) / 100;
			total_money = total_money - tmp_money;
			System.out.format("第 %d 个红包： %.2f 元，剩下： %.2f 元\n", j, tmp_money, total_money);
		}
		System.out.format("第 %d 个红包： %.2f 元，剩下： 0 元\n", total_people, total_money);
	}
}
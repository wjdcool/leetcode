package com.overall.common.data;

import java.util.List;

import lombok.Data;

@Data
public class GetEhcacheUserOutData {

	// 登录名
	private String loginAccount;

	// 用户id
	private Long id;

	// 登录者姓名
	private String loginName;

	// 令牌
	private String token;
}

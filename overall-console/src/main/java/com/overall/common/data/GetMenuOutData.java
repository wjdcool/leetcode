package com.overall.common.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.overall.common.util.Util;

/**
 * 获取权限返回结果
 * 
 * @author 作者 GXS
 * @date 创建时间 2018年7月10日 下午7:33:46
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMenuOutData implements Serializable {
	private static final long serialVersionUID = 1L;

	// 权限id
	private Long id;

	// 权限名称
	private String name;

	// 权限url
	private String url;

	// 资源类型（1模块 2页面 3按钮）
	private String type;

	// 父节点（0最高节点）
	private Long pid;

	// 父节点名称
	private String pname;

	// 父节点类型
	private String ptype;

	// 描述
	private String description;

	// 状态（0无效 1有效）
	private String status;

	// 是否选中
	private boolean checked = false;

	// 是否展开
	private boolean open = false;

	// 子节点
	private List<GetMenuOutData> nodes;

	// 增加child
	public void addChild(GetMenuOutData child) {
		if (Util.isEmptyList(this.nodes)) {
			this.nodes = new ArrayList<GetMenuOutData>();
		}
		this.nodes.add(child);
	}
}

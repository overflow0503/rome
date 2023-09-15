package com.weelfly.manage.service;

import com.weelfly.manage.bean.domain.User;

public interface AggregationService {


	/**
	 * {@link com.weelfly.config.TransactionalConfig#DEFAULT_REQUIRED_METHOD_RULE_TRANSACTION_ATTRIBUTES}
	 * 这里是受到事务管理的
	 */
	void saveUser( User user );

	/**
	 * 这里没有受到事务管理的,除非配置了into*的规则
	 */
	void intoUser( User user );

}

package com.psit.constant;

public class QueryConstant {
	public static final String FIND_ALL_USERS="select u.id,u.first_name,u.last_name,u.email,t.report_generated from user u join assessmenttrigger t where t.user_id=u.id and u.is_active=true";

}

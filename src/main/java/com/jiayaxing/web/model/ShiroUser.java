package com.jiayaxing.web.model;

public class ShiroUser {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shiro_user.id
	 * @mbg.generated  Wed Jun 13 09:31:47 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shiro_user.user_name
	 * @mbg.generated  Wed Jun 13 09:31:47 CST 2018
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shiro_user.password
	 * @mbg.generated  Wed Jun 13 09:31:47 CST 2018
	 */
	private String password;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shiro_user.id
	 * @return  the value of shiro_user.id
	 * @mbg.generated  Wed Jun 13 09:31:47 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shiro_user.id
	 * @param id  the value for shiro_user.id
	 * @mbg.generated  Wed Jun 13 09:31:47 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shiro_user.user_name
	 * @return  the value of shiro_user.user_name
	 * @mbg.generated  Wed Jun 13 09:31:47 CST 2018
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shiro_user.user_name
	 * @param userName  the value for shiro_user.user_name
	 * @mbg.generated  Wed Jun 13 09:31:47 CST 2018
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shiro_user.password
	 * @return  the value of shiro_user.password
	 * @mbg.generated  Wed Jun 13 09:31:47 CST 2018
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shiro_user.password
	 * @param password  the value for shiro_user.password
	 * @mbg.generated  Wed Jun 13 09:31:47 CST 2018
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
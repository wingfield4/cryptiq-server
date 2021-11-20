package io.cryptiq.cryptiqserver.web;

public class Routes {
	private static final String V1_BASE = "/api/v1";
	
	private static final String MESSAGE_BASE = "/messages";
	private static final String USER_BASE = "/users";
	
	/* MESSAGE ROUTES */
	public static final String SEND_MESSAGE = V1_BASE + MESSAGE_BASE + "/send";
	public static final String GET_NEW_MESSAGES = V1_BASE + MESSAGE_BASE + "/newMessages";
	
	/* USER ROUTES */
	public static final String GET_USER = V1_BASE + USER_BASE + "/{userId}";
	public static final String CREATE_USER = V1_BASE + USER_BASE + "/create";
	public static final String SEARCH_USERS = V1_BASE + USER_BASE + "/search";
	public static final String SET_DEVICE_TOKEN = V1_BASE + USER_BASE + "/setDeviceToken";
}

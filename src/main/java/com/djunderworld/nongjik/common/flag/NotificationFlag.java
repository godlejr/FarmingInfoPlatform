package com.djunderworld.nongjik.common.flag;

public class NotificationFlag {
	/**
	 * 수신자 유형 정보
	 * 
	 * 1:자신, 2:작성자
	 * 
	 * @author dongjooKim
	 */
	public static final long TO_ME = 1;
	public static final long TO_WRITER = 2;


	/**
	 * 발신자 행위 정보
	 * 
	 * 1:스토리 작성, 2:댓글 작성, 3:스토리 좋아요, 4:팔로잉
	 * 
	 * @author dongjooKim
	 */
	public static final long WRITING_THE_STORY = 1;
	public static final long WRITING_THE_COMMENT = 2;
	public static final long LIKE_THE_STORY = 3;
	public static final long FOLLOWING_THE_USER = 4;
	public static final long SCRAP_THE_STORY = 5;


	/**
	 * 메시지 페이지 이동 경로 정보
	 * 
	 * 1:스토리 페이지, 2:유저 페이지
	 * 
	 * @author dongjooKim
	 */
	public static final long NAVIGATE_TO_THE_PAGE_OF_STORY = 1;
	public static final long NAVIGATE_TO_THE_PAGE_OF_USER = 2;

	/**
	 * 메시지 내용 목적어 정보
	 * 
	 * ex.) 스토리, 회원님의 게시글
	 * 
	 * @author dongjooKim
	 */
	public static final String CONTENT_OBJECT_OF_WRITING_STORY = "스토리";
	public static final String CONTENT_OBJECT_OF_WRITING_COMMENT_OR_LIKE_SCRAP = "회원님의 게시글";
	public static final String CONTENT_OBJECT_OF_WRITING_REPLY_COMMENT = "회원님의 댓글";
	public static final String CONTENT_OBJECT_OF_FOLLOWING_MERCHANT = "회원님";
}

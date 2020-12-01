package com.admin.beans;

import java.util.List;

public interface NoticeDAO {
	List<NoticeDTO> select();
	List<NoticeDTO> selectPage(int pageNum);
	int maxCnt();
	NoticeDTO selectByUid(int num);
	int addViewCnt(int num);
}

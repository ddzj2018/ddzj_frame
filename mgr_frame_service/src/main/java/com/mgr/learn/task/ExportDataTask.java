package com.mgr.learn.task;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mgr.learn.api.ITagsService;
import com.mgr.learn.common.DateUtil;
import com.mgr.learn.domain.TagInfo;
import com.mgr.learn.domain.Tags;

public class ExportDataTask {
	
	private static Logger log = Logger.getLogger(ExportDataTask.class);
	
	@Autowired(required=false)
	private ITagsService tagsServiceImpl;
	
	public void statisticsTags(){
		log.info("==statisticsTags method start");
		try {
		int type0Open=0;
		int type1Open=0;
		int type2Open=0;
		int type3Open=0;
		int type6Open=0;
		int type9Open=0;
		
		int type0Close=0;
		int type1Close=0;
		int type2Close=0;
		int type3Close=0;
		int type6Close=0;
		int type9Close=0;
		
		int pageNum=1;
		while (true) {
			log.info("pageNum:"+pageNum);
			List<Tags> tagsList = tagsServiceImpl.find(pageNum, 5000);
			if(tagsList!=null&&tagsList.size()>0){
				log.info("tagsList size:"+tagsList.size());
				log.info("tagsList 0:"+tagsList.get(0));
				for(Tags tags:tagsList){
					List<TagInfo> tagInfos=tags.getTags();
					for(TagInfo tagInfo:tagInfos){
						switch (tagInfo.getType()) {
						case 0:
							if (tagInfo.getFlag()==0) {
								type0Close++;
							}else if(tagInfo.getFlag()==1){
								type0Open++;
							}
							break;
						case 1:
							if (tagInfo.getFlag()==0) {
								type1Close++;
							}else if(tagInfo.getFlag()==1){
								type1Open++;
							}					
							break;
						case 2:
							if (tagInfo.getFlag()==0) {
								type2Close++;
							}else if(tagInfo.getFlag()==1){
								type2Open++;
							}
							break;
						case 3:
							if (tagInfo.getFlag()==0) {
								type3Close++;
							}else if(tagInfo.getFlag()==1){
								type3Open++;
							}
							break;
						case 6:
							if (tagInfo.getFlag()==0) {
								type6Close++;
							}else if(tagInfo.getFlag()==1){
								type6Open++;
							}	
							break;
						default:
							break;
						}
					}
					List<TagInfo> tagTotalInfos=tags.getTotalList();
					if(tagTotalInfos!=null&&tagTotalInfos.size()>0&&tagTotalInfos.get(0).getType()==9){
						if (tagTotalInfos.get(0).getFlag()==0) {
							type9Close++;
						}else if(tagTotalInfos.get(0).getFlag()==1){
							type9Open++;
						}
					}
				}
				pageNum++;
			}else {
				log.info("error break");
				break;
			}
		}
		log.info("0淇冮攢娲诲姩鎵撳紑鏁帮細"+type0Open+" 鍏抽棴鏁帮細"+type0Close);
		log.info("1鐧芥潯鎻愰啋鎵撳紑鏁帮細"+type1Open+" 鍏抽棴鏁帮細"+type1Close);
		log.info("2鐞嗚储鎻愰啋鎵撳紑鏁帮細"+type2Open+" 鍏抽棴鏁帮細"+type2Close);
		log.info("3浼楃鎻愰啋鎵撳紑鏁帮細"+type3Open+" 鍏抽棴鏁帮細"+type3Close);
		log.info("6绛惧埌鎻愰啋鎵撳紑鏁帮細"+type6Open+" 鍏抽棴鏁帮細"+type6Close);
		log.info("鎬诲紑鍏�鎵撳紑鏁帮細"+type9Open+" 鍏抽棴鏁帮細"+type9Close);
		} catch (Exception e) {
			log.error("eror", e);
		}
	}
	/**
	 * 閲嶅浠诲姟娴嬭瘯鏂规硶
	 */
	public void repeatTest(){
		log.info("current date:"+DateUtil.dateToStr(new Date(), DateUtil.yyyyMMddhhmmssStr));
	}
}

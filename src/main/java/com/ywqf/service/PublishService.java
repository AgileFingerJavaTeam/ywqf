package com.ywqf.service;

import com.ywqf.dto.excution.PublishExcution;
import com.ywqf.dto.in.PublishDto;

public interface PublishService {
    /**
     * 新增信息
     * @param publishDto
     * @return
     */
    public PublishExcution addNews(PublishDto publishDto);
    /**
     * 删除信息
     * @param publishDto
     * @return
     */
    public PublishExcution removeNews(PublishDto publishDto);

    /**
     * 查询发布员工列表
     * @param publishDto
     * @return
     */
    public PublishExcution findPublishWorker(PublishDto publishDto);

}

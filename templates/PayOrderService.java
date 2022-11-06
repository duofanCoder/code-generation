package com.duofan.weichou.service.business;


import com.duofan.weichou.controller.v1.condition.business.DAXIECondition;
import com.duofan.weichou.dto.model.business.DAXIEDto;
import com.duofan.weichou.dto.model.common.PageDto;

/**
 * @author duofan
 * @version 1.0
 * @email 2441051071@qq.com
 * @website duofan.top
 * @date 2022/3/29
 */

public interface DAXIEService {

    void removeByPrimaryKey(Long[] primaryKey);

    DAXIEDto save(DAXIEDto dto);

    DAXIEDto getByPrimaryKey(Long primaryKey);

    PageDto<DAXIEDto> findPageByCondition(DAXIECondition condition);

    DAXIEDto update(DAXIEDto dto);
}

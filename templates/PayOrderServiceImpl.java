package com.duofan.weichou.service.business;


import com.duofan.weichou.controller.v1.condition.business.DAXIECondition;
import com.duofan.weichou.dto.model.business.DAXIEDto;
import com.duofan.weichou.dto.model.common.PageDto;
import com.duofan.weichou.exception.type.OwnerException;
import com.duofan.weichou.model.business.DAXIE;
import com.duofan.weichou.repository.business.DAXIERepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author duofan
 * @version 1.0
 * @email 2441051071@qq.com
 * @website duofan.top
 * @date 2022/3/29
 */
@Service
public class DAXIEServiceImpl implements DAXIEService {
    @Autowired
    private DAXIERepository XIAOXIERepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeByPrimaryKey(Long[] primaryKey) {
        for (int i = 0; i < primaryKey.length; i++) {
            XIAOXIERepository.deleteById(primaryKey[i]);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    // 新增操作
    public DAXIEDto save(DAXIEDto dto) {
        DAXIE model = modelMapper.map(dto, DAXIE.class);
        model.setCreateTime(new Date()).setUpdateTime(new Date());
        return modelMapper.map(XIAOXIERepository.save(model), DAXIEDto.class);
    }

    @Override
    public DAXIEDto getByPrimaryKey(Long primaryKey) {
        return modelMapper.map(XIAOXIERepository.findById(primaryKey), DAXIEDto.class);
    }

    @Override
    public PageDto<DAXIEDto> findPageByCondition(DAXIECondition condition) {
        LinkedList<DAXIEDto> list = new LinkedList<>();
        PageRequest pageable = PageRequest.of(condition.getPageNum(), condition.getPageSize());
        Page<DAXIE> modelPages = XIAOXIERepository.findByNameContaining(condition.getName(), pageable);
        for (DAXIE campaign : modelPages.getContent()) {
            list.add(modelMapper.map(campaign, DAXIEDto.class));
        }
        return new PageDto<DAXIEDto>()
                .setCurrentPage(pageable.getPageNumber())
                .setTotalPage(modelPages.getTotalPages())
                .setData(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DAXIEDto update(DAXIEDto dto) {
        DAXIE model = XIAOXIERepository.findById(dto.getId()).orElseThrow(
                () -> new OwnerException("修改的部门不存在！")
        );
        //model.setName(dto.getName()).setDescription(dto.getDescription()).setUpdateTime(new Date());
        modelMapper.map(dto,model);
        return modelMapper.map(XIAOXIERepository.save(model), DAXIEDto.class);
    }

}

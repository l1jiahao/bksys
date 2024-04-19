package com.t6.bksys.service;
import com.t6.bksys.entity.User;
import com.t6.bksys.mapper.RecordSearchMapper;
import com.t6.bksys.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.t6.bksys.entity.Record;
import java.util.List;


@Service
public class RecordSearchService {
    @Resource
    private RecordSearchMapper recordSearchMapper; // 正确的mapper类型和变量名

    public List<Record> getRecordsByUserId(Integer userId) {
        return recordSearchMapper.getRecordsByUserId(userId);
    }
}

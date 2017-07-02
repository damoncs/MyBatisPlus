package org.aries.mybatis.service.impl;

import com.baomidou.mybatisplus.enums.SqlMethod;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.aries.mybatis.entity.TaskData;
import org.aries.mybatis.mapper.TaskDataDao;
import org.aries.mybatis.service.ITaskDataService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZQQ
 * @since 2017-07-02
 */
@Service
public class TaskDataServiceImpl extends ServiceImpl<TaskDataDao, TaskData> implements ITaskDataService {

}

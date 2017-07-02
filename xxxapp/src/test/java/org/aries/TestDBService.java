package org.aries;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.aries.mybatis.entity.TaskData;
import org.aries.mybatis.service.ITaskDataService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by admin on 2017/6/19.
 */
public class TestDBService {
    private static final RandomSerialNoUtil SERIAL_NO_UTIL_MSG = new RandomSerialNoUtil();
    private static ITaskDataService iTaskDataService;

    static{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:testApplicationContext.xml");
        context.start();

        iTaskDataService = (ITaskDataService) context.getBean("taskDataServiceImpl");
    }

    @Test
    @Ignore
    public void testDBService(){
        TaskData taskData = new TaskData();
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.setEntity(taskData);
        int count = iTaskDataService.selectCount(null);
        System.out.println(count);

        long start = System.currentTimeMillis();

        List<TaskData> dataList = new ArrayList<TaskData>();
        for (int i = 0; i < 1000000; i++) {
            TaskData data = new TaskData();
            data.setId(SERIAL_NO_UTIL_MSG.makeKey(10, true));
            data.setMobile("150" + (11051709 + i));
            data.setMobile2("150" + (11051709 + i));
            data.setStatus(100);
            data.setTaskId(DateFormatUtil.dateTime2.format(new Date()));
            dataList.add(data);
        }


        iTaskDataService.insertBatch(dataList, 1000);
        long end = System.currentTimeMillis();

        System.out.println("耗時：" + (end - start));
        System.out.println("耗時：" + (end - start)/60000.0);
    }

}

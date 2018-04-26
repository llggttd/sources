package top.crazyman.service.web;

import org.springframework.web.bind.annotation.RestController;
import top.crazyman.service.api.DateRemoteService;
import top.crazyman.service.entity.DateEntity;

import java.util.Date;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/4/26
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@RestController
public class DateController implements DateRemoteService {

    @Override
    public DateEntity getCurrentDate() {

        DateEntity result = new DateEntity();
        Date current = new Date();
        result.setDate(current);
        result.setTime(current);
        result.setDatetime(current);
        return result;
    }
}

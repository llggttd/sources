package top.crazyman.service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/4/26
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@Data
public class DateEntity {

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date date;

    @JsonFormat(pattern = "HH:mm:ss")
    Date time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date datetime;
}

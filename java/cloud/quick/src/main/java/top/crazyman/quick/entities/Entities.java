package top.crazyman.quick.entities;

import lombok.Data;
import top.crazyman.quick.enums.EnabledEnum;
import top.crazyman.quick.enums.EntitiesTypeEnum;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/5/29
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@Data
public class Entities {
    
    private Long guid;

    private EntitiesTypeEnum type;

    private Integer subtype;

    private Long ownerGuid;

    private Long siteGuid;

    private Long containerGuid;

    private Integer accessId;

    private Integer timeCreated;

    private Integer timeUpdated;

    private Integer lastAction;

    private EnabledEnum enabled;

}

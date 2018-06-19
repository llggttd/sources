package top.crazyman.quick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.crazyman.quick.entities.Entities;
import top.crazyman.quick.enums.EntitiesTypeEnum;
import top.crazyman.quick.mapper.EntitiesMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/5/31
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@RestController
public class EntitiesController extends BaseController {

    @Autowired
    private EntitiesMapper entitiesMapper;

    @RequestMapping("/api/test")
    public Map<String, Object> test(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("name", "root");
        map.put("pass", "1234");
        map.put("count", getCount(request));
        return map;
    }

    @RequestMapping("/api/entity")
    public Entities getEntities(Long guid) {
        return entitiesMapper.selectEntitiesByGuid(guid);
    }

    @RequestMapping("/api/entities")
    public List<Entities> getEntities(String type) {
        return entitiesMapper.selectEntitiesByType(EntitiesTypeEnum.valueOf(type));
    }

    private Integer getCount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 1;
        }
        session.setAttribute("count", count + 1);
        return count;
    }
}

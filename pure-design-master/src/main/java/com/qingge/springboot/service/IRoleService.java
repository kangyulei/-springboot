package com.qingge.springboot.service;

import cn.hutool.core.collection.CollUtil;
import com.qingge.springboot.entity.Menu;
import com.qingge.springboot.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qingge.springboot.entity.RoleMenu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kyl
 * @since 2022-09-09
 */
public interface IRoleService extends IService<Role> {

    @Transactional
    void setRoleMenu(Integer roleId, List<Integer> menuIds);

    List<Integer> getRoleMenu(Integer roleId);
}

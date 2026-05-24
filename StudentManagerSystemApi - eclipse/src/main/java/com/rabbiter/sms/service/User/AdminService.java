package com.rabbiter.sms.service.User;

import com.rabbiter.sms.dto.User;
import com.rabbiter.sms.utils.PagingResult;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * Description 管理员Service层
 * Author: rabbiter
 * Date: 2020/3/28 11:05
 **/
public interface AdminService {
  /**
   * description: 新增学生账号
   * @param user
   * @return void
   * @author rabbiter
   * @date 2020/3/4 23:05
   */
  void add(User user);

  /**
   * description: 删除学生账号
   *
   * @param ids
   * @return void
   * @author rabbiter
   * @date 2019/8/29 14:55
   */
  void delete(List<Integer> ids);

  /**
   * description: 修改学生账号
   *
   * @param user
   * @return void
   * @author rabbiter
   * @date 2019/8/29 14:55
   */
  void update(User user);

  /**
   * description: 获取学生账号信息列表
   * @param rowBounds
   * @param condition
   * @author rabbiter
   * @return com.jw.zjh.sms.utils.PagingResult
   * @date 2020/3/4 23:05
   */
  PagingResult<User> getAdminList(RowBounds rowBounds, Map<String, Object> condition);
}

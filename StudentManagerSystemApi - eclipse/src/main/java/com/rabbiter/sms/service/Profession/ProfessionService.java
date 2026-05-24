package com.rabbiter.sms.service.Profession;

import com.rabbiter.sms.domain.Profession;

import java.util.List;

/**
 * Description 专业信息Service层
 * Author: rabbiter
 * Date: 2020/3/31 17:31
 **/
public interface ProfessionService {
/**
* description: 获取专业
* return:
* Author: rabbiter
* @Date: 2022/3/31 17:31
*/
  List<Profession> getProfessionList();
}

/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.executor.resultset;

import org.apache.ibatis.cursor.Cursor;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Clinton Begin
 */
public interface ResultSetHandler {

  /**
   * @Author Qiu Rui
   * @Description 获取statement对象中的resultset对象，对resultset对象进行处理，返回包含结果实体的list对象
   * @Date 14:50 2020/7/25
   * @Param [stmt]
   * @return java.util.List<E>
   **/
  <E> List<E> handleResultSets(Statement stmt) throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 将resultset包装为cursor对象，对cursor进行遍历时，能够动态地从数据库查询数据，避免一次性将所有数据加载到内存中
   * @Date 14:51 2020/7/25
   * @Param [stmt]
   * @return org.apache.ibatis.cursor.Cursor<E>
   **/
  <E> Cursor<E> handleCursorResultSets(Statement stmt) throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 处理存储过程调用结果
   * @Date 14:52 2020/7/25
   * @Param [cs]
   * @return void
   **/
  void handleOutputParameters(CallableStatement cs) throws SQLException;

}

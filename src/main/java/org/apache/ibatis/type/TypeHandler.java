/**
 *    Copyright 2009-2020 the original author or authors.
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
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Clinton Begin
 */
public interface TypeHandler<T> {

  /**
   * @Author Qiu Rui
   * @Description 为PreparedStatement对象设置参数
   * @Date 14:34 2020/7/25
   * @Param [ps, i, parameter, jdbcType]
   * @return void
   **/
  void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

  /**
   * Gets the result.
   *
   * 根据列名称获取该列的值
   *
   * @param rs
   *          the rs
   * @param columnName
   *          Colunm name, when configuration <code>useColumnLabel</code> is <code>false</code>
   * @return the result
   * @throws SQLException
   *           the SQL exception
   */
  T getResult(ResultSet rs, String columnName) throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 根据列索引获取该列的值
   * @Date 14:35 2020/7/25
   * @Param [rs, columnIndex]
   * @return T
   **/
  T getResult(ResultSet rs, int columnIndex) throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 根据存储过程调用结果
   * @Date 14:35 2020/7/25
   * @Param [cs, columnIndex]
   * @return T
   **/
  T getResult(CallableStatement cs, int columnIndex) throws SQLException;

}

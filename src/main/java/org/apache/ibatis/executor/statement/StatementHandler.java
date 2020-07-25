/**
 *    Copyright 2009-2016 the original author or authors.
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
package org.apache.ibatis.executor.statement;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Clinton Begin
 */
public interface StatementHandler {

  /**
   * @Author Qiu Rui
   * @Description 用于创建jdbc statement对象，并完成statement对象的属性设置
   * @Date 14:25 2020/7/25
   * @Param [connection, transactionTimeout]
   * @return java.sql.Statement
   **/
  Statement prepare(Connection connection, Integer transactionTimeout)
      throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 该方法使用mybatis中ParameterHandler组件为preparedstatement和callablestatement参数占位符设置值
   * @Date 14:26 2020/7/25
   * @Param [statement]
   * @return void
   **/
  void parameterize(Statement statement)
      throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 将SQL命令添加到批量处理执行列表中
   * @Date 14:26 2020/7/25
   * @Param [statement]
   * @return void
   **/
  void batch(Statement statement)
      throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 调用statement对象的execute方法执行更新语句，例如update、insert、delete语句
   * @Date 14:27 2020/7/25
   * @Param [statement]
   * @return int
   **/
  int update(Statement statement)
      throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 执行查询语句，并使用resultsethandler处理查询结果集
   * @Date 14:28 2020/7/25
   * @Param [statement, resultHandler]
   * @return java.util.List<E>
   **/
  <E> List<E> query(Statement statement, ResultHandler resultHandler)
      throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 带游标的查询，返回cursor对象，能够通过iterator动态地从数据库中加载数据，适用于查询数据量大的情况，避免将所有数据加载到内存中
   * @Date 14:29 2020/7/25
   * @Param [statement]
   * @return org.apache.ibatis.cursor.Cursor<E>
   **/
  <E> Cursor<E> queryCursor(Statement statement)
      throws SQLException;

  /**
   * @Author Qiu Rui
   * @Description 获取Mapper中配置的SQL信息，boundSQL封装了动态SQL解析后的SQL文本和参数映射信息
   * @Date 14:30 2020/7/25
   * @Param []
   * @return org.apache.ibatis.mapping.BoundSql
   **/
  BoundSql getBoundSql();

  /**
   * @Author Qiu Rui
   * @Description 获取ParameterHandler实列
   * @Date 14:31 2020/7/25
   * @Param []
   * @return org.apache.ibatis.executor.parameter.ParameterHandler
   **/
  ParameterHandler getParameterHandler();

}

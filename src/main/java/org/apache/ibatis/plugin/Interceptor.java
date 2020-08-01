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
package org.apache.ibatis.plugin;

import java.util.Properties;

/**
 * @author Clinton Begin
 */
public interface Interceptor {

  /**
   * @Author Qiu Rui
   * @Description 拦截逻辑，在目标方法调用时执行
   * @Date 10:47 2020/8/1
   * @Param [invocation]
   * @return java.lang.Object
   **/
  Object intercept(Invocation invocation) throws Throwable;

  /**
   * @Author Qiu Rui
   * @Description 创建ParameterHandler、ResultSetHandler、StatementHandler和Executor的代理对象，方法参数为组件实列
   * @Date 10:48 2020/8/1
   * @Param [target]
   * @return java.lang.Object
   **/
  default Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  /**
   * @Author Qiu Rui
   * @Description 用于设置插件的属性值
   * @Date 10:49 2020/8/1
   * @Param [properties]
   * @return void
   **/
  default void setProperties(Properties properties) {
    // NOP
  }

}

/**
 * Copyright (C) 2011, 2012 camunda services GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm;

import java.util.List;
import java.util.Set;

import org.activiti.engine.ProcessEngine;

import com.camunda.fox.platform.FoxPlatformException;

/**
 * <p>Returns the process engine service</p>
 * 
 * <p>Users of this class may look up an instance of the service through a lookup strategy
 * appropriate for the platform they are using (Examples: Jndi, OSGi Service Registry ...)</p>
 * 
 * <p>The process engine service can be used to manage {@link ProcessEngine ProcessEngines}.
 * Users may retrieve existing Process Engines using this class as well as start and stop a
 * Process Engine.</p>
 * 
 * @author Daniel Meyer
 */
public interface ProcessEngineService {
  
  /**
   * @throws FoxPlatformException if no such process engine exists.
   * 
   * @return the default process engine.
   */
  public ProcessEngine getDefaultProcessEngine();

  /**
   * @return all {@link ProcessEngine ProcessEngines} managed by the fox platform.
   */
  public List<ProcessEngine> getProcessEngines();

  /**
   * 
   * @return the names of all {@link ProcessEngine ProcessEngines} managed by the fox platform.
   */
  public Set<String> getProcessEngineNames();
  
  /**
   * @throws FoxPlatformException if no such process engine exists.
   * 
   * @return the {@link ProcessEngine} for the given name
   */
  public ProcessEngine getProcessEngine(String name);
  
}
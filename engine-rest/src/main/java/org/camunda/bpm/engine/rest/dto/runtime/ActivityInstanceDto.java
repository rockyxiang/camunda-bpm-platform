/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.rest.dto.runtime;

import org.camunda.bpm.engine.impl.persistence.entity.ActivityInstanceImpl;
import org.camunda.bpm.engine.runtime.ActivityInstance;

/**
 * <p>An activity instance is the instance of an activity</p>
 * 
 * @author roman.smirnov
 *
 */
public class ActivityInstanceDto {
  
  protected String id;
  protected String parentActivityInstanceId;
  protected String activityId;
  protected String processInstanceId;
  protected String processDefinitionId;
  protected ActivityInstanceDto[] childActivityInstances;
  protected TransitionInstanceDto[] childTransitionInstances;
  protected String[] executionIds;
  protected String name;

  /** The id of the activity instance */
  public String getId() {
    return id;
  }

  /** The id of the parent activity instance. If the activity is the process definition, 
  {@link #getId()} and {@link #getParentActivityInstanceId()} return the same value */
  public String getParentActivityInstanceId() {
    return parentActivityInstanceId;
  }

  /** the id of the activity */
  public String getActivityId() {
    return activityId;
  }
  
  /** the process instance id */
  public String getProcessInstanceId() {
    return processInstanceId;
  }
  
  /** the process definition id */
  public String getProcessDefinitionId() {
    return processDefinitionId;
  }
  
  /** Returns the child activity instances.
   * Returns an empty list if there are no child instances. */
  public ActivityInstanceDto[] getChildActivityInstances() {
    return childActivityInstances;
  }
  
  public TransitionInstanceDto[] getChildTransitionInstances() {
    return childTransitionInstances;
  }
  
  /** the list of executions that are currently waiting in this activity instance */
  public String[] getExecutionIds() {
    return executionIds; 
  }

  /** the activity name */
  public String getName() {
    return name; 
  }
  
  public static ActivityInstanceDto fromActivityInstance(ActivityInstance instance) {
    ActivityInstanceDto result = new ActivityInstanceDto();    
    result.id = instance.getId();
    result.parentActivityInstanceId = instance.getParentActivityInstanceId();
    result.activityId = instance.getActivityId();
    result.processInstanceId = instance.getProcessInstanceId();
    result.processDefinitionId = instance.getProcessDefinitionId();
    result.childActivityInstances = fromListOfActivityInstance(instance.getChildActivityInstances());
    result.childTransitionInstances = TransitionInstanceDto.fromListOfTransitionInstance(instance.getChildTransitionInstances());
    result.executionIds = instance.getExecutionIds();
    result.name = instance.getActivityName();
    return result;
  }
  
  public static ActivityInstanceDto[] fromListOfActivityInstance(ActivityInstance[] instances) {
    ActivityInstanceDto[] result = new ActivityInstanceDto[instances.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = fromActivityInstance(instances[i]);      
    }
    return result;
  }

}

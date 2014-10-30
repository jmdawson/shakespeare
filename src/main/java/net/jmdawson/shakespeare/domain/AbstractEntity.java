/*
 * File created on Oct 17, 2014 
 *
 * Copyright (c) 2014 Virginia Polytechnic Institute and State University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package net.jmdawson.shakespeare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Abstract Entity type.
 *
 * @author Jacob Dawson
 * @author Ben Sechrist
 */

public abstract class AbstractEntity implements Serializable {

  private static final long serialVersionUID = 7680266662552690977L;
  
  @Id
  @Column
  protected int id;
  
  /**
   * Constructs a new instance.
   */
  public AbstractEntity() {
  }

  /**
   * Constructs a new instance.
   * @param that
   */
  public AbstractEntity(AbstractEntity that) {
  }

  // TODO: soon we will have version property here
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  

}

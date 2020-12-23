/*
 * Copyright 2000-2020 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intellij.rt.coverage.instrumentation.tracing.data;

import com.intellij.rt.coverage.data.SwitchData;

public class Switch {
  private final int myIndex;
  private final int myLine;
  private final int myKey;
  private final SwitchData myData;
  private int myId;

  public Switch(int index, int line, int key, SwitchData data) {
    myIndex = index;
    myLine = line;
    myKey = key;
    myData = data;
  }

  public int getIndex() {
    return myIndex;
  }

  public int getLine() {
    return myLine;
  }

  public int getKey() {
    return myKey;
  }

  public int getId() {
    return myId;
  }

  void setId(int id) {
    myId = id;
    myData.setId(id, myKey);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Switch aSwitch = (Switch) o;

    return myIndex == aSwitch.myIndex
        && myLine == aSwitch.myLine
        && myKey == aSwitch.myKey;
  }

  @Override
  public int hashCode() {
    int result = myIndex;
    result = 31 * result + myLine;
    result = 31 * result + myKey;
    return result;
  }
}

/*
 *
 *  *  Copyright 2010-2016 OrientDB LTD (http://orientdb.com)
 *  *
 *  *  Licensed under the Apache License, Version 2.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *  Unless required by applicable law or agreed to in writing, software
 *  *  distributed under the License is distributed on an "AS IS" BASIS,
 *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  See the License for the specific language governing permissions and
 *  *  limitations under the License.
 *  *
 *  * For more information: http://orientdb.com
 *
 */

package com.orientechnologies.orient.core.intent;

import com.orientechnologies.orient.core.db.ODatabaseDocumentInternal;

@Deprecated
public class OIntentMassiveRead implements OIntent {
  public void begin(final ODatabaseDocumentInternal iDatabase) {}

  public void end(final ODatabaseDocumentInternal iDatabase) {}

  @Override
  public OIntent copy() {
    final OIntentMassiveRead copy = new OIntentMassiveRead();
    return copy;
  }
}

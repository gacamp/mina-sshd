/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.sshd.common;

import java.util.Objects;

/**
 * @author <a href="mailto:dev@mina.apache.org">Apache MINA SSHD Project</a>
 */
public interface Transformer<I, O> {
    // TODO in JDK-8 replace this with Function
    /**
     * @param input Input value
     * @return Transformed output value
     */
    O transform(I input);

    /**
     * Invokes {@link Objects#toString(Object)} on the argument
     */
    Transformer<Object,String> TOSTRING=new Transformer<Object,String>() {
            @Override
            public String transform(Object input) {
                return Objects.toString(input);
            }
        };

    /**
     * Returns {@link Enum#name()} or {@code null} if argument is {@code null}
     */
    Transformer<Enum<?>,String> ENUM_NAME_EXTRACTOR=new Transformer<Enum<?>,String>() {
            @Override
            public String transform(Enum<?> input) {
                if (input == null) {
                    return null;
                } else {
                    return input.name();
                }
            }
        };
}

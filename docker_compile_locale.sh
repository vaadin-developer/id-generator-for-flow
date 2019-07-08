#!/usr/bin/env bash
#
# Copyright © 2018 Sven Ruppert (sven.ruppert@gmail.com)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#


docker run \
      --rm \
      --name compile \
      -v "$(pwd)":/usr/src/mymaven \
      -w /usr/src/mymaven \
      working/vaadin-id-generator-for-flow:latest \
      mvn clean install -Dmaven.test.skip=true -DactivateNodeJS_NPM=true

#      svenruppert/maven-3.6.1-openjdk:1.11.0-2
#      svenruppert/nodejs-maven-3.6.1-adopt:1.8.212-04 \
#      mvn com.github.eirslett:frontend-maven-plugin:1.7.6:install-node-and-npm \
#      -DnodeVersion="v10.16.0"  \
#      clean install -Dmaven.test.skip=true

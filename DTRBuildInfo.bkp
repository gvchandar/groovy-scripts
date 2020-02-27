//src/com/dcc/DTRBuildInfo.groovy
package com.dcc
import groovy.json.JsonOutput

// DTR Build Information
class DTRBuildInfo 
{
  String environment;
  String version;
  String DTRURL;
  def componentList = []

  void setEnvironment(String pEnvironment) {
    environment = pEnvironment;
  }
	
  String getEnvironment() {
    return this.environment;
  }

  void setVersion(String pVersion) {
    version = pVersion;
  }
	
  String getVersion() {
    return this.version;
  }

  void addComponent(ComponentInfo component){
    componentList.add(component)
  }

  static String getJSON() {
    def output = JsonOutput.toJson([name: 'John', ID: 1])
    return output
  }
  static String getJSON(DTRBuildInfo dtrbuild) {
    def output = JsonOutput.toJson(dtrbuild)
    return output
  }
  
}

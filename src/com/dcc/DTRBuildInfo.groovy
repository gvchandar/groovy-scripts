//src/com/dcc/DTRBuildInfo.groovy
package com.dcc

// DTR Build Information
class DTRBuildInfo {
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

  void addComponent(com.dcc.ComponentInfo component){
    componentList.add(component)
  }

}

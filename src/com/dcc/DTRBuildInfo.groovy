//src/org/dcc/Point.groovy
package com.dcc

// DTR Build Information
class DTRBuildInfo {
  String environment;
  String version;
  String DTRURL;
  ArrayList componentlist = new ArrayList();

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

}

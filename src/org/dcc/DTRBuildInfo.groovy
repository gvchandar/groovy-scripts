//src/org/dcc/Point.groovy
package org.dcc

// DTR Build Information
class DTRBuildInfo {
  String environment;
  String version;
  String DTRURL;
  def componentlist = []

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

package com.dcc

class ComponentInfo {
  String name;
  String shortName;
  String subversion;
  String tag;
  String gitPath;
  String folderPath;
  String dockerRepo;  


  void setName(String pname) {
    name = pname;
  }

  String getName() {
    return this.name;
  }

  void setShortName(String pshortName) {
    shortName = pshortName;
  }

  String getShortName() {
    return this.shortName;
  }

  void setTag(String ptag) {
    tag = ptag;
  }

  String getTag() {
    return this.tag;
  }

  void setGitPath(String pgitPath) {
    gitPath = pgitPath;
  }

  String getGitPath() {
    return this.gitPath;
  }

  void setFolderPath(String pfolderPath) {
    folderPath = pfolderPath;
  }

  String getFolderPath() {
    return this.folderPath;
  }

  void setDockerRepo(String pdockerRepo) {
    dockerRepo = pdockerRepo;
  }

  String getDockerRepo() {
    return this.dockerRepo;
  }


}

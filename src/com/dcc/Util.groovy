package com.dcc

class Util {
  public static String getDTRBuildInfoString(DTRBuildInfo build) {
    StringBuffer buildStringParam = new StringBuffer();
    buildStringParam.append('environment~' + build.environment + '^')
    buildStringParam.append('version~' + build.version + '^')
    buildStringParam.append('DTRURL~' + build.DTRURL + '^')
    buildStringParam.append('£')
    println("build.componentList" + build.componentList)
    build.componentList.eachWithIndex {component,i ->
    assert component instanceof ComponentInfo
    buildStringParam.append(getComponentInfoString(component))
    }
    return buildStringParam.toString()
  }

  public static String getComponentInfoString(ComponentInfo component) {
    StringBuffer componentInfoStringParam = new StringBuffer();
    componentInfoStringParam.append('name~' + component.name + '^')
    componentInfoStringParam.append('shortName~' + component.shortName + '^')
    componentInfoStringParam.append('subversion~' + component.subversion + '^')
    componentInfoStringParam.append('tag~' + component.tag + '^')
    componentInfoStringParam.append('gitPath~' + component.gitPath + '^')
    componentInfoStringParam.append('folderPath~' + component.folderPath + '^')
    componentInfoStringParam.append('dockerRepo~' + component.dockerRepo + '`')
    println(componentInfoStringParam.toString())
    return componentInfoStringParam.toString()
  }


  public static DTRBuildInfo getDTRBuildInfoObject(String buildParam) {
    DTRBuildInfo dtrBuildInfo = new DTRBuildInfo();
    String[] buildParamStringArray = buildParam.split('£')
    String DTRBuildInfoString = buildParamStringArray[0]
    String ComponentInfoString = buildParamStringArray[1]
    println("DTRBuildInfoString" + DTRBuildInfoString)
    println("ComponentInfoString" + ComponentInfoString)
    String[] DTRBuildInfoArray =  DTRBuildInfoString.split('\\^')
    dtrBuildInfo.environment = DTRBuildInfoArray[0].split('~')[1]
    dtrBuildInfo.version = DTRBuildInfoArray[1].split('~')[1]
    dtrBuildInfo.DTRURL = DTRBuildInfoArray[2].split('~')[1]

    println("dtrBuildInfo.environment " + dtrBuildInfo.environment)
    println("dtrBuildInfo.version " + dtrBuildInfo.version)
    println("dtrBuildInfo.DTRURL " + dtrBuildInfo.DTRURL)

    String[] ComponentInfoArray = ComponentInfoString.split('\\`')
    int indexCounter = 0;
    for( String values : ComponentInfoArray ) {
      ComponentInfo component =  getComponentInfoObject(values)
      println("component.name " + component.name)
      println("component.shortName " + component.shortName)
      println("component.subversion " + component.subversion)
      println("component.tag " + component.tag)
      println("component.gitPath " + component.gitPath)
      println("component.folderPath " + component.folderPath)
      println("component.dockerRepo " + component.dockerRepo)
      println("dtrBuildInfo.componentList.getClass()")
      dtrBuildInfo.componentList[indexCounter] = component
      indexCounter++;
    }
    return dtrBuildInfo
  }

  public static ComponentInfo getComponentInfoObject(String buildParams) {
    ComponentInfo buildComponent = new ComponentInfo();
    String[] ComponentInfoArray =  buildParams.split('\\^');
    buildComponent.name = ComponentInfoArray[0].split('~')[1];
    buildComponent.shortName = ComponentInfoArray[1].split('~')[1];
    buildComponent.subversion = ComponentInfoArray[2].split('~')[1];
    buildComponent.tag = ComponentInfoArray[3].split('~')[1];
    buildComponent.gitPath = ComponentInfoArray[4].split('~')[1];
    buildComponent.folderPath = ComponentInfoArray[5].split('~')[1];
    buildComponent.dockerRepo = ComponentInfoArray[6].split('~')[1];
    return buildComponent;
  }
  static void main(String[] args) {
    def cleanup = new ComponentInfo(
    'name': 'dco-cleanup', \
    'shortName': 'cleanup', \
    'subversion': '5.3', \
    'tag': 'auto1', \
    'gitPath': 'cleanuprepo', \
    'folderPath': 'cleanupFolder', \
    'dockerRepo': 'http://cleanupdockerrepo'
    )
    def manager = new ComponentInfo(
    'name': 'dco-manager', \
    'shortName': 'manager', \
    'subversion': '5.6', \
    'tag': 'auto2', \
    'gitPath': 'managerrepo', \
    'folderPath': 'managerFolder', \
    'dockerRepo': 'http://managerdockerrepo'
    )
    def dtrBuildInfo = new DTRBuildInfo(environment: "DEV", version: "5.9", DTRURL: "http://localhost:8080", \
                  componentList: [cleanup, manager])
    String dtrBuildInfoString =  getDTRBuildInfoString(dtrBuildInfo)
    println("dtrBuildInfoString"+ dtrBuildInfoString)
    DTRBuildInfo reconstructDTRBuildInfo = getDTRBuildInfoObject(dtrBuildInfoString)
    println("environment "+ reconstructDTRBuildInfo.environment)
    println("version "+ reconstructDTRBuildInfo.version)
    println("DTRURL "+ reconstructDTRBuildInfo.DTRURL)
    int indexCounter = 0;
    for (int i = 0; i <1; i++) {
      ComponentInfo componentInfo = reconstructDTRBuildInfo.componentList[i]
      println(componentInfo.name);
    }
  }  
}

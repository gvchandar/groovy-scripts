class DTRSerializeManual {
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
  def dtrbuild = new DTRBuildInfo(environment: "DEV", version: "5.9", \
   componentList: [cleanup, manager])



 }

    public String GetBuildStringParam(DTRBuildInfo build)
    {
        String buildStringParam = "";
        buildStringParam + "environment~" + build.environment + "|";
        buildStringParam + "version~" + build.version + "|";
        buildStringParam + "DTRURL~" + build.DTRURL + "|";

        buildStringParam + "£";

        foreach (var item in build.components)
        {
            buildStringParam += getComponentInfoStringParam(item) + "`";
        }
        buildStringParam += "|";


        return buildStringParam;
    }




 public static String  getComponentInfoStringParam(ComponentInfo component) {
   String componentStringParam = "";
   componentStringParam + "name~" + component.name + "|";
   componentStringParam + "shortName~" + component.shortName + "|";
   componentStringParam + "subVersion~" + component.subVersion + "|";
   componentStringParam + "tag~" + component.tag + "|";
   componentStringParam + "gitPath~" + component.gitPath + "|";
   componentStringParam + "folderPath~" + component.folderPath+ "|";
   componentStringParam + "dockerRepo~" + component.dockerRepo+ "|";
   return componentStringParam;
   }

}

class DTRBuildInfo {
 String environment;
 String version;
 String DTRURL;
 def componentList = [];
}

class ComponentInfo {
 String name;
 String shortName;
 String subversion;
 String tag;
 String gitPath;
 String folderPath;
 String dockerRepo;
}


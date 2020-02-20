
class GlobalVars {
  // Defining DTR repository IP for all the environments and the corresponding map
  static final String DCO_DEV_DTR   = "10.0.16.38"
  static final String DCO_EIT_DTR   = "10.1.16.50"
  static final String DCO_SITA_DTR  = "10.0.12.45"
  static final String DCO_SITB_DTR  = "10.1.12.34"
  static final String DCO_UITA_DTR  = "10.0.20.150"
  static final String DCO_UITB_DTR  = "10.1.20.162"
  static final String DCO_PRODA_DTR = "10.0.4.163"
  static final String DCO_PRODB_DTR = "10.1.4.168"
  static final String CP_DEV_DTR    = "10.0.16.38"
  static final String CP_EIT_DTR    = "10.1.16.50"
  static final String CP_SITA_DTR   = "10.0.13.34"
  static final String CP_SITB_DTR   = "10.1.13.43"
  static final String CP_UITA_DTR   = "10.0.21.148"
  static final String CP_UITB_DTR   = "10.1.21.152"
  static final String CP_PRODA_DTR  = "10.0.5.145"
  static final String CP_PRODB_DTR  = "10.1.5.149"
  static final DTR_MAP = [
    "DCO_DEV"   : DCO_DEV_DTR,
    "DCO_EIT"   : DCO_EIT_DTR,
    "DCO_SITA"  : DCO_SITA_DTR,
    "DCO_SITB"  : DCO_SITB_DTR,
    "DCO_UITA"  : DCO_UITA_DTR,
    "DCO_UITB"  : DCO_UITB_DTR,
    "DCO_PRODA" : DCO_UITA_DTR,
    "DCO_PRODB" : DCO_UITB_DTR,
    "CP_DEV"    : CP_DEV_DTR,
    "CP_EIT"    : CP_EIT_DTR,
    "CP_SITA"   : CP_SITA_DTR,
    "CP_SITB"   : CP_SITB_DTR,
    "CP_UITA"   : CP_UITA_DTR,
    "CP_UITB"   : CP_UITB_DTR,
    "CP_PRODA"  : CP_UITA_DTR,
    "CP_PRODB"  : CP_UITB_DTR
  ]
  
  // Initial release file is uploaded to nexus as a single zip file  
  static final String NEXUS_BASE_URL = "https://nexus.k8s.dco.local/repository"

  // Defining sub path within the main release file
  // We get release as a single zip , containing all the application files in it 

  static final String DCO_REQUEST_MANAGER_PATH =  "dco-request-manager"
  static final String DCO_CONFIG_MANAGER_PATH  =  "dco-configuration-manager"
  static final String DCO_CLEANUP_SCHEDULER_PATH = "dco-clean-up-scheduler"
 
  static final SUP_PATH_MAP = [
    "cleanup"   : DCO_CLEANUP_SCHEDULER_PATH,
    "request-manager"  : DCO_REQUEST_MANAGER_PATH
  ]

  // Docker images repository is defined for each application separately
  

  static final String GIT_DOCKERFILES_BASE_URL = "git@DCO-MGTB-NOC01.dco.local:dcc/docker"
  static final String GIT_DOCKERFILES_BRANCH   = "DCCRUN-277"


  static final String GIT_DCO_REQUEST_MANAGER_PATH =  "dco-request-manager.git"
  static final String GIT_DCO_CONFIG_MANAGER_PATH  =  "dco-configuration-manager.git"
  static final String GIT_DCO_CLEANUP_PATH         =  "dco-cleanup.git"

  static final GIT_PATH_MAP = [
    "cleanup"          : GIT_DCO_CLEANUP_PATH,
    "request-manager"  : GIT_DCO_REQUEST_MANAGER_PATH,
    "config-manager"   : GIT_DCO_CONFIG_MANAGER_PATH
  ]



  static String getDTR(String environment) {
    return DTR_MAP.get(environment)
  }

  
  static String getSubPath(String application) {
    return DTR_MAP.get(application)
  }


  static String getGITPath(String application) {
    return GIT_PATH_MAP.get(application)
  }

}

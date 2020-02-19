
class GlobalVars {
  static final String DCO_DEV_DTR    = "10.0.16.38"
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
    "DCO_DEV": DCO_DEV_DTR,
    "DCO_EIT": DCO_EIT_DTR
  ]

  static String getDTR(String environment) {
    return DTR_MAP.get(environment)
  }

}

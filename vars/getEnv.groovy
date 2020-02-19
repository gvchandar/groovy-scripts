#!/usr/bin/env groovy




DCO_DEV_DTR   = "10.0.16.41"
DCO_EIT_DTR   = "10.1.16.50"
DCO_SITA_DTR  = "10.0.12.45"
DCO_SITB_DTR  = "10.1.12.34"
DCO_UITA_DTR  = "10.0.20.150"
DCO_UITB_DTR  = "10.1.20.162"
DCO_PRODA_DTR = "10.0.4.163"
DCO_PRODB_DTR = "10.1.4.168" 

CP_DEV_DTR    = "10.0.16.38"
CP_EIT_DTR    = "10.1.16.50"
CP_SITA_DTR   = "10.0.13.34"
CP_SITB_DTR   = "10.1.13.43"
CP_UITA_DTR   = "10.0.21.148"
CP_UITB_DTR   = "10.1.21.152"
CP_PRODA_DTR  = "10.0.5.145"
CP_PRODB_DTR  = "10.1.5.149"


def call(String name = 'human') {
  static final String DEFAULT = 'default'
  echo "Hello, ${name}."
  echo  DEFAULT
}



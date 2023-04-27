# DFe

The main objective of this project is the issuance of tax documents.
Initially it is intended to implement the documents NF-e, NFC-e, CT-e and MDF-e.
<br>
In the future it will be a feasibility of implementing others such as BP-e,
NF3-e, etc.

## Customize Properties

The following properties can be customized if you choose to use the classes implemented in this project.
Feel free to implement your own classes.

### General

- _com.softart.dfe.ws.timeout_: Timeout in seconds before the connection shutdown. Default value is **30**
- _com.softart.dfe.security.chain.socket.timeout_: Timeout in milliseconds of the build of certificate chain for each
  host. Default value is **5000**
- _com.softart.dfe.security.chain.password_: Password of the certificate chain. A certificate chain is used to verify
  SSL connections to the Sefaz Webservices. Default value is **123456**
- _com.softart.dfe.certificate.path_: The path of default certificate (.pfx file)
- _com.softart.dfe.certificate.password_: The password of the default certificate file
- _com.softart.dfe.handler.log.request_: **true** if you want to log the requests **false** otherwise. The default
  value is **false**
- _com.softart.dfe.handler.log.response_: **true** if you want to log the responses **false** otherwise. The default
  value is **false**
- _com.softart.dfe.security.chain.cache.days_: The days that .jks file must be cached. The default value is **14**

### Process

- _com.softart.dfe.process.nf_: The default process of NF-e / NFC-e. Available values are **default**, **s3**. The
  default value is **default**

- _com.softart.dfe.process.cte_: The default process of CT-e. Available values are **default**, **s3**. The
  default value is **default**

- _com.softart.dfe.process.mdfe_: The default process of MDF-e. Available values are **default**, **s3**. The
  default value is **default**

### DF-e versions

- _com.softart.dfe.nf.version_: Layout version of NF-e. The current and default version is **4.00**
- _com.softart.dfe.nf.event.version_: Layout version of NF-e events. The current and default version is **1.00**
- _com.softart.dfe.nf.gtin.version_: Layout version of NF-e query gtin. The current and default version is **1.00**
- _com.softart.dfe.nf.distribution.version_: Layout version of NF-e distribution. The current version is **1.01**
- _com.softart.dfe.cte.version_: Layout version of CT-e. The current and default version is **3.00**
- _com.softart.dfe.cte.event.version_: Layout version of CT-e events. The current and default version is **3.00**
- _com.softart.dfe.cte.distribution.version_: Layout version of CT-e distribution. The current version is **1.00**
- _com.softart.dfe.mdfe.version_: Layout version of MDF-e. The current and default version is **3.00**
- _com.softart.dfe.mdfe.event.version_: Layout version of MDF-e events. The current and default version is **3.00**
- _com.softart.dfe.mdfe.distribution.version_: Layout version of MDF-e distribution. The current version is **1.00**
- _com.softart.dfe.mdfe.modal.version_: Layout version of MDF-e modal. The current version is **3.00**

### Proxy

- _com.softart.dfe.sefaz.port.proxy.map.capacity.nfce_: The default capacity of the Map of NFC-e WebServices. Default
  value is **100**
- _com.softart.dfe.sefaz.port.proxy.map.capacity.nfe_: The default capacity of the Map of NF-e WebServices. Default
  value is **100**
- _com.softart.dfe.sefaz.port.proxy.map.capacity.cte_: The default capacity of the Map of CT-e WebServices. Default
  value is **100**
- _com.softart.dfe.sefaz.port.proxy.map.capacity.mdfe_: The default capacity of the Map of MDF-e WebServices. Default
  value is **100**

### Storage

- _com.softart.dfe.storage.nf.logxml_: **true** to log xml storage of NF-e in console, **false** otherwise. Default
  value is **false**
- _com.softart.dfe.storage.cte.logxml_: **true** to log xml storage of CT-e in console, **false** otherwise. Default
  value is **false**
- _com.softart.dfe.storage.mdfe.logxml_: **true** to log xml storage of MDF-e in console, **false** otherwise. Default
  value is **false**

### Messages

- _com.softart.dfe.nf.message.cancel_: Default NF-e/NFC-e cancel message. This message will be used if none is
  provided. Default value is **erro de emissao**
- _com.softart.dfe.nf.message.inutilization_: Default NF-e/NFC-e inutilization message. This message will be
  used if none is provided. Default value is **erro de emissao**
- _com.softart.dfe.nf.message.ignorance_: Default NF-e ignorance of the operation message. This message will be
  used if none is provided. Default value is **nota nao reconhecida**
- _com.softart.dfe.nf.message.not_performed_: Default NF-e operation not performed message. This message will be
  used if none is provided. Default value is **operacao nao realizada**
- _com.softart.dfe.cte.message.inutilization_: Default CT-e inutilization message. This message will be used if
  none is provided. Default value is **erro de emissao**
- _com.softart.dfe.cte.message.cancel_: Default CT-e cancel message. This message will be used if none is
  provided. Default value is **erro de emissao**
- _com.softart.dfe.cte.message.epec_: Default CT-e epec message. This message will be used if none is
  provided. Default value is **erro no autorizador de origem**

The following properties refer to the storage of XML messages.
<br>
Under Brazilian law, XML's must be kept for up to five years.

### Storage NF-e/NFC-e

- _com.softart.dfe.storage.key.nf.send_authorization_: Prefix of the path where the NF-e/NFC-e XML message of
  authorization will be saved. Default value is **enviNfe**
- _com.softart.dfe.storage.key.nf.return_send_authorization_: Prefix of the path where the NF-e/NFC-e return XML of
  authorization will be saved. Default value is **retEnviNfe**
- _com.softart.dfe.storage.key.nf.proc_authorization_: Prefix of the path where the NF-e/NFC-e processed XML of
  authorization will be saved. Default value is **procNfe**
- _com.softart.dfe.storage.key.nf.send_event_: Prefix of the path where the NF-e/NFC-e XML message of event will be
  saved. Default value is **envEventoNfe**
- _com.softart.dfe.storage.key.nf.return_send_event_: Prefix of the path where the NF-e/NFC-e return XML of event will
  be saved. Default value is **retEnvEventoNfe**
- _com.softart.dfe.storage.key.nf.proc_event_: Prefix of the path where the NF-e/NFC-e processed XML of event will be
  saved. Default value is **procEventoNfe**
- _com.softart.dfe.storage.key.nf.send_inutilization_: Prefix of the path where the NF-e/NFC-e XML message of
  inutilization will be saved. Default value is **inutNfe**
- _com.softart.dfe.storage.key.nf.return_send_inutilization_: Prefix of the path where the NF-e/NFC-e return XML of
  inutilization will be saved. Default value is **retInutNfe**
- _com.softart.dfe.storage.key.nf.proc_inutilization_: Prefix of the path where the NF-e/NFC-e processed XML of
  inutilization will be saved. Default value is **procInutNfe**
- _com.softart.dfe.storage.key.nf.send_return_authorization_: Prefix of the path where the NF-e/NFC-e receipt query XML
  message will be saved. Default value is **consReciNfe**
- _com.softart.dfe.storage.key.nf.return_send_return_authorization_: Prefix of the path where the NF-e/NFC-e receipt
  query XML return message will be saved. Default value is **retConsReciNfe**
- _com.softart.dfe.storage.key.nf.send_query_protocol_: Prefix of the path where the NF-e/NFC-e query protocol XML
  message will be saved. Default value is **consSitNfe**
- _com.softart.dfe.storage.key.nf.return_send_query_protocol_: Prefix of the path where the NF-e/NFC-e query protocol
  XML return message will be saved. Default value is **retConsSitNfe**
- _com.softart.dfe.storage.key.nf.send_query_status_service_: Prefix of the path where the NF-e/NFC-e query status
  service XML message will be saved. Default value is **consStatServ**
- _com.softart.dfe.storage.key.nf.return_send_query_status_service_: Prefix of the path where the NF-e/NFC-e query
  status service XML return message will be saved. Default value is **retConsStatServ**
- _com.softart.dfe.storage.key.nf.send_query_gtin_: Prefix of the path where the NF-e/NFC-e query GTIN XML message will
  be saved. Default value is **consGTIN**
- _com.softart.dfe.storage.key.nf.return_send_query_gtin_: Prefix of the path where the NF-e/NFC-e query GTIN XML return
  message will be saved. Default value is **retConsGTIN**
- _com.softart.dfe.storage.key.nf.distribution_: Prefix of the path where the NF-e distribution XML message will be
  saved. Default value is **distNfe**
- _com.softart.dfe.storage.key.nf.return_distribution_: Prefix of the path where the NF-e distribution XML return
  message will be saved. Default value is **distNfe**

### Storage CT-e

- _com.softart.dfe.storage.key.cte.distribution_: Prefix of the path where the CT-e distribution XML message will be
  saved. Default value is **distCte**
- _com.softart.dfe.storage.key.cte.return_distribution_: Prefix of the path where the CT-e distribution XML return
  message will be saved. Default value is **retDistCte**
- _com.softart.dfe.storage.key.cte.event_: Prefix of the path where the CT-e XML message of event will be saved. Default
  value is **eventoCte**
- _com.softart.dfe.storage.key.cte.return_event_: Prefix of the path where the CT-e return XML of event will be saved.
  Default value is **retEventoCte**
- _com.softart.dfe.storage.key.cte.proc_event_: Prefix of the path where the CT-e processed XML of event will be saved.
  Default value is **procEventoCte**
- _com.softart.dfe.storage.key.cte.inutilization_: Prefix of the path where the CT-e XML message of inutilization will
  be saved. Default value is **inutCte**
- _com.softart.dfe.storage.key.cte.return_inutilization_: Prefix of the path where the CT-e return XML of inutilization
  will be saved. Default value is **retInutCte**
- _com.softart.dfe.storage.key.cte.proc_inutilization_: Prefix of the path where the CT-e processed XML of inutilization
  will be saved. Default value is **procInutCte**
- _com.softart.dfe.storage.key.cte.query_receipt_: Prefix of the path where the CT-e query receipt XML message will be
  saved. Default value is **consReciCte**
- _com.softart.dfe.storage.key.cte.return_query_receipt_: Prefix of the path where the CT-e query receipt XML return
  message will be saved. Default value is **retConsReciCte**
- _com.softart.dfe.storage.key.cte.query_situation_: Prefix of the path where the CT-e query situation XML message will
  be saved. Default value is **consSitCte**
- _com.softart.dfe.storage.key.cte.return_query_situation_: Prefix of the path where the CT-e query situation XML return
  message will be saved. Default value is **retConsSitCte**
- _com.softart.dfe.storage.key.cte.reception_: Prefix of the path where the CT-e XML message of reception will be saved.
  Default value is **enviCte**
- _com.softart.dfe.storage.key.cte.return_reception_: Prefix of the path where the CT-e return XML of reception will be
  saved. Default value is **retEnviCte**
- _com.softart.dfe.storage.key.cte.proc_: Prefix of the path where the CT-e processed XML will be saved. Default value
  is **procCte**
- _com.softart.dfe.storage.key.cte.reception_gtve_: Prefix of the path where the GTV-e XML message of reception will be
  saved. Default value is **gtve**
- _com.softart.dfe.storage.key.cte.return_reception_gtve_: Prefix of the path where the GTV-e return XML of reception
  will be saved. Default value is **retGtve**
- _com.softart.dfe.storage.key.cte.proc_gtve_: Prefix of the path where the GTV-e processed XML will be saved. Default
  value is **procGtve**
- _com.softart.dfe.storage.key.cte.reception_os_: Prefix of the path where the CT-e OS XML message of reception will be
  saved. Default value is **cteOS**
- _com.softart.dfe.storage.key.cte.return_reception_os_: Prefix of the path where the CT-e OS return XML of reception
  will be saved. Default value is **retCteOS**
- _com.softart.dfe.storage.key.cte.proc_os_: Prefix of the path where the CT-e OS processed XML will be saved. Default
  value is **procCteOS**
- _com.softart.dfe.storage.key.cte.reception_sync_: Prefix of the path where the CT-e XML message of reception sync will
  be saved. Default value is **cte**
- _com.softart.dfe.storage.key.cte.return_reception_sync_: Prefix of the path where the CT-e return XML of reception
  sync will be saved. Default value is **retCte**
- _com.softart.dfe.storage.key.cte.status_service_: Prefix of the path where the CT-e status service XML message will be
  saved. Default value is **consStatServCte**
- _com.softart.dfe.storage.key.cte.return_status_service_: Prefix of the path where the CT-e status service XML return
  message will be saved. Default value is **retConsStatServCte**

### Storage MDF-e

- _com.softart.dfe.storage.key.mdfe.distribution_: Prefix of the path where the MDF-e XML will be saved. Default value
  is **distMdfe**
- _com.softart.dfe.storage.key.mdfe.return_distribution_: Prefix of the path where the MDF-e XML will be saved. Default
  value is **retDistMdfe**
- _com.softart.dfe.storage.key.mdfe.event_: Prefix of the path where the MDF-e XML will be saved.
  Default value is **eventoMdfe**
- _com.softart.dfe.storage.key.mdfe.return_event_: Prefix of the path where the MDF-e XML will be saved. Default value
  is **retEventoMdfe**
- _com.softart.dfe.storage.key.mdfe.proc_event_: Prefix of the path where the MDF-e XML will be saved. Default value
  is **procEventoMdfe**
- _com.softart.dfe.storage.key.mdfe.query_receipt_: Prefix of the path where the MDF-e XML will be saved. Default value
  is **consReciMdfe**
- _com.softart.dfe.storage.key.mdfe.return_query_receipt_: Prefix of the path where the MDF-e XML will be saved. Default
  value is **retConsReciMdfe**
- _com.softart.dfe.storage.key.mdfe.query_unclosed_: Prefix of the path where the MDF-e XML will be saved. Default value
  is **consReciMdfe**
- _com.softart.dfe.storage.key.mdfe.return_query_unclosed_: Prefix of the path where the MDF-e XML will be saved.
  Default value is **retConsReciMdfe**
- _com.softart.dfe.storage.key.mdfe.query_situation_: Prefix of the path where the MDF-e XML will be saved. Default
  value is **consSitMdfe**
- _com.softart.dfe.storage.key.mdfe.return_query_situation_: Prefix of the path where the MDF-e XML will be saved.
  Default value is **retConsSitMdfe**
- _com.softart.dfe.storage.key.mdfe.reception_: Prefix of the path where the MDF-e XML will be saved. Default value
  is **enviMdfe**
- _com.softart.dfe.storage.key.mdfe.return_reception_: Prefix of the path where the MDF-e XML will be saved. Default
  value is **retEnviMdfe**
- _com.softart.dfe.storage.key.mdfe.proc_: Prefix of the path where the MDF-e XML will be saved.
  Default value is **procMdfe**
- _com.softart.dfe.storage.key.mdfe.reception_sync_: Prefix of the path where the MDF-e XML will be saved. Default value
  is **mdfe**
- _com.softart.dfe.storage.key.mdfe.return_reception_sync_: Prefix of the path where the MDF-e XML will be saved.
  Default value is **retMdfe**
- _com.softart.dfe.storage.key.mdfe.status_service_: Prefix of the path where the MDF-e XML will be saved. Default value
  is **consStatServMdfe**
- _com.softart.dfe.storage.key.mdfe.return_status_service_: Prefix of the path where the MDF-e XML will be saved.
  Default value is **retConsStatServMdfe**

## Common Errors

- **can't parse argument number: {0}**: Regenerate WSDL files. This error ocurred to me
  when I was copying and paste ObjectFactories between services, and my IDE imported
  the other factory, besides using the factory of the service (All factories have the name ObjectFactory)

## Motivation

In my spare time I wanted to do something that added value, so I'm
developing this library in order to make a project that is
extensible, flexible, easy to use and doesn't use third-party libraries

## Authors

- **Artur Oliveira** - *Developer* - [artur-oliveira](https://github.com/artur-oliveira)

## License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt)

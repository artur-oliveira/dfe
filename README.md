# DFe

The main objective of this project is the issuance of tax documents.
Initially it is intended to implement the documents NF-e, NFC-e, CT-e and MDF-e.
<br>
In the future it will be a feasibility of implementing others such as BP-e,
NF3-e, etc.

## Customize Properties

The following properties can be customized if you choose to use the classes implemented in this project.
Feel free to implement your own classes.

- _DEFAULT_WEBSERVICE_TIMEOUT_: Timeout before the connection shutdown
- _CERTIFICATE_CHAIN_PASSWORD_: Password of the certificate chain. A certificate chain
  is used to verify SSL connections to the Sefaz Webservices
- _DEFAULT_NFE_VERSION_: Layout version of NF-e. The current version is **4.00**
- _DEFAULT_NFE_EVENT_VERSION_: Layout version of NF-e events. The current version is **1.00**
- _DEFAULT_NFE_GTIN_VERSION_: Layout version of NF-e query gtin. The current version is **1.00**
- _DEFAULT_NFE_DISTRIBUTION_VERSION_: Layout version of NF-e distribution. The current version is **1.01**
- _DEFAULT_NFE_CANCEL_MESSAGE_: Default NF-e/NFC-e cancel message. This message will be used if none is provided
- _DEFAULT_NFE_INUTILIZATION_MESSAGE_: Default NF-e/NFC-e inutilization message. This message will be used if none is
  provided
- _DEFAULT_CTE_INUTILIZATION_MESSAGE_: Default CT-e inutilization message. This message will be used if none is
  provided
- _DEFAULT_NFE_IGNORANCE_OPERATION_MESSAGE_: Default NF-e ignorance of the operation message. This message will be
  used if none is provided
- _DEFAULT_NFE_OPERATION_NOT_PERFORMED_MESSAGE_: Default NF-e operation not performed message. This message will be
  used if none is provided

The following properties refer to the storage of XML messages.
<br>
Under Brazilian law, XML's must be kept for up to five years.

### NF-e/NFC-e

- _STORAGE_KEY_NF_SEND_AUTHORIZATION_: Prefix of the path where the NF-e/NFC-e XML message of authorization will be
  saved
- _STORAGE_KEY_NF_RETURN_SEND_AUTHORIZATION_: Prefix of the path where the NF-e/NFC-e return XML of authorization will
  be saved
- _STORAGE_KEY_NF_PROC_AUTHORIZATION_: Prefix of the path where the NF-e/NFC-e processed XML of authorization will be
  saved
- _STORAGE_KEY_NF_SEND_EVENT_: Prefix of the path where the NF-e/NFC-e XML message of event will be saved
- _STORAGE_KEY_NF_RETURN_SEND_EVENT_: Prefix of the path where the NF-e/NFC-e return XML of event will be saved
- _STORAGE_KEY_NF_PROC_EVENT_: Prefix of the path where the NF-e/NFC-e processed XML of event will be saved
- _STORAGE_KEY_NF_SEND_INUTILIZATION_: Prefix of the path where the NF-e/NFC-e XML message of inutilization will be
  saved
- _STORAGE_KEY_NF_RETURN_SEND_INUTILIZATION_: Prefix of the path where the NF-e/NFC-e return XML of inutilization will
  be saved
- _STORAGE_KEY_NF_PROC_INUTILIZATION_: Prefix of the path where the NF-e/NFC-e processed XML of inutilization will be
  saved
- _STORAGE_KEY_NF_SEND_RETURN_AUTHORIZATION_: Prefix of the path where the NF-e/NFC-e receipt query XML message will be
  saved
- _STORAGE_KEY_NF_RETURN_SEND_RETURN_AUTHORIZATION_: Prefix of the path where the NF-e/NFC-e receipt query XML return
  message will be saved
- _STORAGE_KEY_NF_SEND_QUERY_PROTOCOL_: Prefix of the path where the NF-e/NFC-e query protocol XML message will be
  saved
- _STORAGE_KEY_NF_RETURN_SEND_QUERY_PROTOCOL_: Prefix of the path where the NF-e/NFC-e query protocol XML return
  message will be saved
- _STORAGE_KEY_NF_SEND_QUERY_STATUS_SERVICE_: Prefix of the path where the NF-e/NFC-e query status service XML message
  will be
  saved
- _STORAGE_KEY_NF_RETURN_SEND_QUERY_STATUS_SERVICE_: Prefix of the path where the NF-e/NFC-e query status service XML
  return
  message will be saved
- _STORAGE_KEY_NF_SEND_QUERY_GTIN_: Prefix of the path where the NF-e/NFC-e query GTIN XML message will be
  saved
- _STORAGE_KEY_NF_RETURN_SEND_QUERY_GTIN_: Prefix of the path where the NF-e/NFC-e query GTIN XML return
  message will be saved
- _STORAGE_KEY_NF_DISTRIBUTION_: Prefix of the path where the NF-e distribution XML message will be
  saved
- _STORAGE_KEY_NF_RETURN_DISTRIBUTION_: Prefix of the path where the NF-e distribution XML return
  message will be saved

### CT-e

- _STORAGE_KEY_CTE_DISTRIBUTION_: Prefix of the path where the CT-e distribution XML message will be
  saved
- _STORAGE_KEY_CTE_RETURN_DISTRIBUTION_: Prefix of the path where the CT-e distribution XML return
  message will be saved
- _STORAGE_KEY_CTE_EVENT_: Prefix of the path where the CT-e XML message of event will be saved
- _STORAGE_KEY_CTE_RETURN_EVENT_: Prefix of the path where the CT-e return XML of event will be saved
- _STORAGE_KEY_CTE_PROC_EVENT_: Prefix of the path where the CT-e processed XML of event will be saved
- _STORAGE_KEY_CTE_INUTILIZATION_: Prefix of the path where the CT-e XML message of inutilization will be saved
- _STORAGE_KEY_CTE_RETURN_INUTILIZATION_: Prefix of the path where the CT-e return XML of inutilization will be saved
- _STORAGE_KEY_CTE_PROC_INUTILIZATION_: Prefix of the path where the CT-e processed XML of inutilization will be saved
- _STORAGE_KEY_CTE_QUERY_RECEIPT_: Prefix of the path where the CT-e query receipt XML message will be
  saved
- _STORAGE_KEY_CTE_RETURN_QUERY_RECEIPT_: Prefix of the path where the CT-e query receipt XML return
  message will be saved
- _STORAGE_KEY_CTE_QUERY_SITUATION_: Prefix of the path where the CT-e query situation XML message will be
  saved
- _STORAGE_KEY_CTE_RETURN_QUERY_SITUATION_: Prefix of the path where the CT-e query situation XML return
  message will be saved
- _STORAGE_KEY_CTE_RECEPTION_: Prefix of the path where the CT-e XML message of reception will be saved
- _STORAGE_KEY_CTE_RETURN_RECEPTION_: Prefix of the path where the CT-e return XML of reception will be saved
- _STORAGE_KEY_CTE_PROC_: Prefix of the path where the CT-e processed XML will be saved
- _STORAGE_KEY_CTE_RECEPTION_GTVE_: Prefix of the path where the GTV-e XML message of reception will be saved
- _STORAGE_KEY_CTE_RETURN_RECEPTION_GTVE_: Prefix of the path where the GTV-e return XML of reception will be saved
- _STORAGE_KEY_CTE_PROC_GTVE_: Prefix of the path where the GTV-e processed XML will be saved
- _STORAGE_KEY_CTE_RECEPTION_OS_: Prefix of the path where the CT-e OS XML message of reception will be saved
- _STORAGE_KEY_CTE_RETURN_RECEPTION_OS_: Prefix of the path where the CT-e OS return XML of reception will be saved
- _STORAGE_KEY_CTE_PROC_OS_: Prefix of the path where the CT-e OS processed XML will be saved
- _STORAGE_KEY_CTE_RECEPTION_SYNC_: Prefix of the path where the CT-e XML message of reception sync will be saved
- _STORAGE_KEY_CTE_RETURN_RECEPTION_SYNC_: Prefix of the path where the CT-e return XML of reception sync will be saved
- _STORAGE_KEY_CTE_STATUS_SERVICE_: Prefix of the path where the CT-e status service XML message will be
  saved
- _STORAGE_KEY_CTE_RETURN_STATUS_SERVICE_: Prefix of the path where the CT-e status service XML return
  message will be saved
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

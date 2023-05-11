package com.softart.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.components.storage.common.CommonStorage;
import com.softart.dfe.enums.internal.nf.NFStorageKey;
import com.softart.dfe.enums.nf.NFReturnCode;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.nf.common.NfCommonStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import com.softart.dfe.util.IOUtils;

import java.io.IOException;
import java.util.Objects;

import static java.io.File.separator;

public abstract class GenericNfCommonStorage extends CommonStorage implements NfCommonStorage {

    @Override
    public void storeProcCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getEvento()) && Objects.nonNull(o.data().getRetEvento()) && Objects.nonNull(o.xml()) && NFReturnCode.generateProc(o.data().getRetEvento().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().getInfEvento().getChNFe() + "-" + o.data().getEvento().getInfEvento().getTpEvento() + "-" + o.data().getEvento().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && !o.data().getRetEvento().isEmpty() && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getRetEvento().size(); i++) {
                    getStorageService().writeReturn(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getRetEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getRetEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && !o.data().getEvento().isEmpty() && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getEvento().size(); i++) {
                    getStorageService().writeSend(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcInut(Store<TProcInutNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInutNFe()) && Objects.nonNull(o.data().getRetInutNFe()) && Objects.nonNull(o.xml()) && NFReturnCode.generateProc(o.data().getRetInutNFe().getInfInut().getCStat())) {
                String keyName = String.join("_", o.data().getInutNFe().getInfInut().getMod(), o.data().getInutNFe().getInfInut().getSerie(), o.data().getInutNFe().getInfInut().getNNFIni(), o.data().getInutNFe().getInfInut().getNNFFin());
                getStorageService().writeProc(o.config(), NFStorageKey.NF_INUTILIZATION, xmlNameWithTime(keyName), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetInut(Store<TRetInutNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfInut()) && Objects.nonNull(o.xml())) {
                String keyName = String.join("_", o.data().getInfInut().getMod(), o.data().getInfInut().getSerie(), o.data().getInfInut().getNNFIni(), o.data().getInfInut().getNNFFin());
                getStorageService().writeReturn(o.config(), NFStorageKey.NF_INUTILIZATION, xmlNameWithTime(keyName), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEnvInut(Store<TInutNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfInut()) && Objects.nonNull(o.xml())) {
                String keyName = String.join("_", o.data().getInfInut().getMod(), o.data().getInfInut().getSerie(), o.data().getInfInut().getNNFIni(), o.data().getInfInut().getNNFFin());
                getStorageService().writeSend(o.config(), NFStorageKey.NF_INUTILIZATION, xmlNameWithTime(keyName), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcNfe(Store<TNfeProc> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getNFe()) && Objects.nonNull(o.data().getProtNFe()) && Objects.nonNull(o.data().getProtNFe().getInfProt()) && Objects.nonNull(o.xml()) && NFReturnCode.generateProc(o.data().getProtNFe().getInfProt().getCStat())) {
                getStorageService().writeProc(o, NFStorageKey.NF_AUTHORIZATION, xmlNameWithTime(o.data().getProtNFe().getInfProt().getChNFe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetNfe(Store<TRetEnviNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getProtNFe()) && Objects.nonNull(o.data().getProtNFe().getInfProt()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o.config(), NFStorageKey.NF_AUTHORIZATION, xmlNameWithTime(o.data().getProtNFe().getInfProt().getChNFe()), o.xml());
            } else if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfRec()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o.config(), NFStorageKey.NF_AUTHORIZATION, xmlNameWithTime(o.data().getInfRec().getNRec()), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEnvNfe(Store<TEnviNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getNFe().size(); i++) {
                    getStorageService().writeSend(o.config(), NFStorageKey.NF_AUTHORIZATION, xmlNameWithTime(AccessKeyParserFactory.nfe().fromId(o.data().getNFe().get(i).getInfNFe().getId())), o.xml());
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    protected void storeProcByQueryReceipt(Store<TRetConsReciNFe> o) throws IOException, StorageException {
        if (Objects.isNull(o.data().getProtNFe())) return;

        String xml = null;
        for (TProtNFe protNFe : o.data().getProtNFe()) {
            xml = IOUtils.readFileToString(IOUtils.findLastFileByBasePath(String.join(separator, getStorageService().rootPath(o.config()), NFStorageKey.NF_AUTHORIZATION.getForSend(), protNFe.getInfProt().getChNFe())));
            if (Objects.nonNull(xml)) break;
        }

        if (Objects.isNull(xml)) return;

        TEnviNFe tEnviNFe = NfUnmarshallerFactory.getInstance().enviNfe(xml).getValue();
        String versao = tEnviNFe.getNFe().stream().findFirst().orElseThrow(RuntimeException::new).getInfNFe().getVersao();
        for (TProtNFe protNFe : o.data().getProtNFe()) {
            TNfeProc proc = new ObjectFactory().createTNfeProc();
            proc.setProtNFe(protNFe);
            proc.setNFe(tEnviNFe.getNFe().stream().filter(it -> it.getInfNFe().getId().contains(protNFe.getInfProt().getChNFe())).findFirst().orElse(null));
            proc.setVersao(versao);

            storeProcNfe(new XMLStore<>(proc, o.config(), NfMarshallerFactory.getInstance().procNfe(proc)));
        }
    }

    @Override
    public void storeRetReturnAuthorization(Store<TRetConsReciNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                storeProcByQueryReceipt(o);
                getStorageService().writeReturn(o, NFStorageKey.NF_RETURN_AUTHORIZATION, xmlNameWithTime(o.data().getNRec()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEnvReturnAuthorization(Store<TConsReciNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, NFStorageKey.NF_RETURN_AUTHORIZATION, xmlNameWithTime(o.data().getNRec()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetQueryProtocol(Store<TRetConsSitNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, NFStorageKey.NF_QUERY_PROTOCOL, xmlNameWithTime(o.data().getChNFe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEnvQueryProtocol(Store<TConsSitNFe> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, NFStorageKey.NF_QUERY_PROTOCOL, xmlNameWithTime(o.data().getChNFe()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendQueryStatusService(Store<TConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, NFStorageKey.NF_QUERY_STATUS_SERVICE, System.currentTimeMillis() + ".xml");
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnQueryStatusService(Store<TRetConsStatServ> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, NFStorageKey.NF_QUERY_STATUS_SERVICE, System.currentTimeMillis() + ".xml");
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnQueryGtin(Store<TRetConsGTIN> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, NFStorageKey.NF_QUERY_GTIN, System.currentTimeMillis() + ".xml");
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeQueryGtin(Store<TConsGTIN> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, NFStorageKey.NF_QUERY_GTIN, System.currentTimeMillis() + ".xml");
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }
}
